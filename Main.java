import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;



class Main  {

  public static void runGameOfLife (Board b) throws InterruptedException {
    
      boolean gameOver = false;
      int turn = 0;

      System.out.println("Starting...");
      
      ///
      final JFrame f = new JFrame("Frame Test");

      JPanel panel = new JPanel(new GridLayout(10, 10, 4, 4));
      
      f.setContentPane(panel);
      f.setSize(200, 200);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
      
      ///
      
      b.printBoard(panel,f);

      while(gameOver == false){
    	  b.step();
        b.printBoard(panel,f);
        
        
        
        turn++;
        
        if(b.checkGameOver()) {
        	gameOver = true;
        }
        Thread.sleep(1000);
      }
      System.out.println("Game Over!");
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");
   
    //read in input 
    int myLength = 10;
    int myHeight = 10;

    //make instance of board
    Board b = new Board(myLength,myHeight);
    
    if(false) {
      String goOn = "n";
      Scanner sc = new Scanner(System.in); 
      
        while(goOn.equals("n")){
          //ask x
          System.out.println("What is your x coordinate for the alive cell?");
          int xValue = sc.nextInt();

          //ask y
          System.out.println("What is your y coordinate for the alive cell?");
          int yValue = sc.nextInt();

          b.setCell(xValue,yValue,true);

          //b.printBoard();

          System.out.println("Would you like to continue?");
          
          int continuing = sc.nextInt();

          if (continuing == 1){
            goOn = "y";
          }
          //ask to continue 
        }
    }
    if(true) {
      b.setCell(2,2,true);
      b.setCell(2,3,true);
      b.setCell(2,4,true);
      b.setCell(1,4,true);
      b.setCell(0,3,true);
    }
    try {
	   runGameOfLife(b);
    } catch (InterruptedException e) {

    }
  }

}
