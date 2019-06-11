package model;
import java.awt.Point;
/**
 * Model class for project
 * @author Yizheng Wang
 *
 */

public class Tromino
{
    private int     size;
    private Point   missing;
    private int     piece = 1;
    private int[][] gameboard;

    public Tromino(int s, Point p)
    {
        size = s;
        gameboard = new int[size][size];
        missing = p;
        this.solve(size, missing, size / 2, size / 2);
    }

    private void solve(int s, Point p, int central_x, int central_y)
    {
        int x = central_x;
        int y = central_y;

        if(s > 1) {
            if (p.getX() >= size || p.getY() >= size || p.getX() < 0
                    || p.getY() < 0)
            {
                System.out.println("Please choose a valid point!");
            } else
            {
                // first quadrant
                if (p.getX() < x && p.getY() > y - 1)
                {
                    this.placeTromino(new Point(x - 1, y - 1));
                    this.placeTromino(new Point(x, y - 1));
                    this.placeTromino(new Point(x, y));

                    piece++;

                    this.solve(s / 2, new Point(x - 1, y - 1), x - s / 4,
                            y - s / 4);
                    this.solve(s / 2, new Point(x, y - 1), x + s / 4,
                            y - s / 4);
                    this.solve(s / 2, new Point(x, y), x + s / 4, y + s / 4);
                    this.solve(s / 2, p, x - s / 4, y + s / 4);

                }
                // Second
                else if (p.getX() < x && p.getY() < y)
                {
                    this.placeTromino(new Point(x - 1, y));
                    this.placeTromino(new Point(x, y - 1));
                    this.placeTromino(new Point(x, y));

                    piece++;

                    this.solve(s / 2, new Point(x - 1, y), x - s / 4,
                            y + s / 4);
                    this.solve(s / 2, new Point(x, y - 1), x + s / 4,
                            y - s / 4);
                    this.solve(s / 2, new Point(x, y), x + s / 4, y + s / 4);
                    this.solve(s / 2, p, x - s / 4, y - s / 4);

                }
                // Third
                else if (p.getX() > x - 1 && p.getY() < y)
                {
                    this.placeTromino(new Point(x - 1, y - 1));
                    this.placeTromino(new Point(x - 1, y));
                    this.placeTromino(new Point(x, y));

                    piece++;

                    this.solve(s / 2, new Point(x - 1, y - 1), x - s / 4,
                            y - s / 4);
                    this.solve(s / 2, new Point(x - 1, y), x - s / 4,
                            y + s / 4);
                    this.solve(s / 2, new Point(x, y), x + s / 4, y + s / 4);
                    this.solve(s/2, p, x + s / 4, y - s / 4);

                }
                // Fourth
                else if (p.getX() > x - 1 && p.getY() > y - 1)
                {
                    this.placeTromino(new Point(x - 1, y - 1));
                    this.placeTromino(new Point(x - 1, y));
                    this.placeTromino(new Point(x, y - 1));

                    piece++;

                    this.solve(s / 2, new Point(x - 1, y - 1), x - s / 4,
                            y - s / 4);
                    this.solve(s / 2, new Point(x - 1, y), x - s / 4,
                            y + s / 4);
                    this.solve(s / 2, new Point(x, y - 1), x + s / 4,
                            y - s / 4);
                    this.solve(s / 2, p, x + s / 4, y + s / 4);

                }
            }

        }
    }

    public int[][] getGameboard()
    {
        return gameboard;
    }

    private void placeTromino(Point p)
    {
        gameboard[p.x][p.y] = piece;

    }

}
