package controller;
import model.*;
import view.*;
import java.awt.Point;

/**
 * Controller class for the project
 * @author Yizheng Wang
 *
 */
public class Controller
{
    private Tromino myModel;
    private View myView;
    private Point myFirst;
    private int mySize;
    
    public Controller() {
        myView = new View(this);
        mySize = myView.getMySize();
        myFirst = myView.getMyMissing();
        myModel = new Tromino(mySize, myFirst);
        this.initializeBoard();
        this.changecolor();
    }
    
    
    private void initializeBoard() {
        myView.setSize();
    }
    
    public void changecolor() {
        for(int i = 0; i < mySize; i++) {
            for(int j = 0; j < mySize; j++) {
                myView.visualizeBoard(new Point(i,j), myModel.getGameboard()[i][j]);
            }
        }
    }
    
    
    public static void main(String[] args)
    {
        new Controller();
   }
}
