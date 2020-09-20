import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;


class Board {
  // Cell currentCell;
  public int width;
  public int height;
  public Cell[][] gameBoard;
  
  public Board(int w, int h){
    this.width = w;
    this.height = h;
    //make instances of cells
    this.gameBoard =  new Cell[width][height];
    
    for(int i = 0; i < width; i++){
      for(int j = 0; j < height; j++){
        gameBoard[i][j] = new Cell();
        gameBoard[i][j].alive = false;
      }
    }


  }

  public Board copy(){
    Board newBoard = new Board(width, height);

    for(int i = 0; i< width; i++){
      for(int j = 0; j < height; j++){
        newBoard.setCell(i,j,gameBoard[i][j].alive);
      }
    }
    return newBoard;
  }

  public void setCell(int x,int y, boolean value){
    //sets x y cell to 
    gameBoard[x][y].alive = value;
  }

  public boolean checkCell(int x,int y){
    if(x < 0 || x >= width) return false;  
    if(y < 0 || y >= height) return false;

    return(gameBoard[x][y].alive);
  }


  public int checkNeighbors(int x,int y) {
    int count=0;
    for(int i=x-1; i<=x+1; i++) {
      for(int j=y-1; j<=y+1; j++) {
        if(i==x && j==y) continue;
        if(checkCell(i,j)) count++;
      }
    }
    return(count);
  }

  public boolean checkGameOver() {
    return(aliveCellCounter() == 0);
  }

  public void printBoard(JPanel panel,final JFrame f){
      for(int j = 0; j< height; j++){
        for(int i = 0; i < width; i++){

          if (gameBoard[i][j].alive == true){
            System.out.print("*");
          }
          else{
            System.out.print(".");
          }

          System.out.print(" ");

        }
        System.out.println();
      }
      System.out.println();
      System.out.println();
      
      //////////////////////////////////////////////////////////////
      String statment;
      panel = new JPanel(new GridLayout(10, 10, 4, 4));
      for (int i = 0; i < 10; i++) { // chnage to hei
    	  for (int j = 0; j < 10; j++) {

    	  if(gameBoard[i][j].alive == true) {
    		   statment = "*";
    	  }
    	  else {
    		   statment = "";
    	  }
		  JLabel l = new JLabel("" + statment, JLabel.CENTER);
		  
		  

          //JLabel l = new JLabel(new ImageIcon("image_file.png"), JLabel.CENTER);
          l.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
          l.setFont(l.getFont().deriveFont(20f));
          panel.add(l);
          f.setContentPane(panel);
          f.setVisible(true);
      }
      }
      ///////////////////////////////////////////


  }

  public int aliveCellCounter() {
    int count = 0;
    for(int x = 0; x< width; x++){
      for(int y = 0; y < height; y++){
        //numberAliveCells
        if (gameBoard[x][y].alive == true) {
          count++;
        }
      }
    }
    //numberAliveCells = count;
    return (count);
  }
  
  public void step() {
    Board prevBoard = this.copy();
    
    for(int i = 0; i< width; i++){
        for(int j = 0; j < height; j++){
          int amountOfAliveNeighbors = prevBoard.checkNeighbors(i,j);
          if(prevBoard.checkCell(i,j)) {
            //these are the "rules"
            if(amountOfAliveNeighbors<2) {
              setCell(i,j,false);
            } else if((amountOfAliveNeighbors == 2 || amountOfAliveNeighbors == 3)) {
              setCell(i,j,true);
            } else if (amountOfAliveNeighbors>3) {
              setCell(i,j,false);
            }
          } else {
            if(amountOfAliveNeighbors == 3) setCell(i,j,true);
          }
        }
    }
  }
}
