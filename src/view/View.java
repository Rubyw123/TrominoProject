package view;
import controller.*;
import java.awt.*;
import javax.swing.*;

/**
 * View class for the project
 * @author Yizheng Wang
 *
 */
public class View
{
    private JPanel            myPanel;
    private JFrame            myF;
    private JLabel[][]        myboard;
    private int               mySize ;
    private Point myMissing;
    
    public View(Controller c)
    {

        myF = new JFrame("Tromino");
        myF.setSize(500, 500);
        myF.setLocation(100, 100);
        myF.setResizable(false);
        myF.setLayout(null);

        myPanel = new JPanel();
        myPanel.setSize(400, 400);
        myPanel.setLocation(40, 40);
        myPanel.setLayout(null);

        myF.add(myPanel);
        mySize = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of 2^n: "));
        int x =  Integer.parseInt(JOptionPane.showInputDialog("Enter the x-axis of the missing piece: "));
        int y =  Integer.parseInt(JOptionPane.showInputDialog("Enter the y-axis of the missing piece: "));
        myMissing = new Point(x,y);

        myF.setVisible(true);
        myF.setDefaultCloseOperation(myF.EXIT_ON_CLOSE);

    }

    public void setSize()
    {
        myboard = new JLabel[mySize][mySize];
        for (int i = 0; i < mySize; i++)
        {
            for (int j = 0; j < mySize; j++)
            {
                myboard[j][i] = new JLabel();
                myboard[j][i].setSize(400 / mySize, 400 / mySize);
                myboard[j][i].setLocation(i * (400 / mySize),
                        j * (400 / mySize));
                myboard[j][i]
                        .setBorder(BorderFactory.createLineBorder(Color.BLACK));
                myboard[j][i].setVisible(true);
                myboard[j][i].setOpaque(true);               
                myPanel.add(myboard[j][i]);
            }
        }
        myboard[2][3].setBackground(Color.BLACK);
    }

    public int getMySize()
    {
        return mySize;
    }

    public Point getMyMissing()
    {
        return myMissing;
    }

    public void visualizeBoard(Point p, int v)
    {
       
        if(v%10 == 0) {
        myboard[p.x][p.y].setBackground(Color.BLUE);

        }else if (v%10 == 1) {
            myboard[p.x][p.y].setBackground(Color.CYAN);
        }else if(v%10 == 2) {
            myboard[p.x][p.y].setBackground(Color.DARK_GRAY);

        }else if(v%10 == 3) {
            myboard[p.x][p.y].setBackground(Color.MAGENTA);

        }else if(v%10 == 4) {
            myboard[p.x][p.y].setBackground(Color.ORANGE);
        }else if(v%10 == 5) {
            myboard[p.x][p.y].setBackground(Color.GREEN);
        }else if(v%10 == 6) {
            myboard[p.x][p.y].setBackground(Color.PINK);
        }else if(v%10 == 7) {
            myboard[p.x][p.y].setBackground(Color.RED);
        }else if(v%10 == 8) {
            myboard[p.x][p.y].setBackground(Color.YELLOW);
        }else if(v%10 == 9) {
            myboard[p.x][p.y].setBackground(Color.LIGHT_GRAY);
        }
        if(v == 0) {
            myboard[p.x][p.y].setBackground(Color.BLACK);
        }

    }

}
