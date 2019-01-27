import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;
import java.util.Arrays;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Frame extends JPanel implements ActionListener
{
    Timer t = new Timer(10,this);
    Graphics2D g2D;
    Graphics g;
    int blockSize = 25;
    int timerMax = 40;
    int timerCount = 0;
    String phase = "playing";
    ShapeGen shapeGen = new ShapeGen();
    public Frame()
    {
        spaces = new int[24][10];
        newShape();
        t.start();
    }
    public void setTimer(int time)
    {
        t.setDelay(time);
    }
    public void iterate()
    {
        if(checkMovement(1))
        {
            currentShape.r++;
        }
        else
        {
            if(checkInt(0,0,0))
            {
                spaces = addShape();
                for(int i = 0;i < 24;i++)
                {
                    if(checkRow(i))
                    {
                        delRow(i);
                    }
                }
                newShape();
            }
            else
            {
                t.stop();
                spaces = addShape();
                phase = "game over";
                currentShape = new Shape("null");
                t.start();
            }
        }
    }
    public void newShape()
    {
        currentShape = shapeGen.pickShape();
    }
    public void print(int[][] arrayToPrint)
    {
        for(int i = 2;i < 22;i++)
        {
            for(int j = 0;j < 10;j++)
            {
                switch(arrayToPrint[i][j])
                {
                    case 0:
                    System.out.print(". ");
                    break;
                    default:
                    System.out.print("██");;
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public int[][] addShape()
    {
        int[][] output = new int[24][10];
        for(int i = 0;i < 24;i++)
        {
            for(int j = 0;j < 10;j++)
            {
                output[i][j] = spaces[i][j];
            }
        }
        for(int i = 0;i < 4;i++)
        {
            for(int j = 0;j < 4;j++)
            {
                if(currentShape.getArray()[i][j] != 0 && currentShape.c + j < 10 && currentShape.c + j >= 0)
                {
                    output[i + currentShape.r][j + currentShape.c] = currentShape.getArray()[i][j];
                }
            }
        }
        return output;
    }
    public boolean checkInt(int dr,int dc,int dtheta)
    {
        boolean output = true;
        Shape tempShape = new Shape(currentShape.type);
        tempShape.r = currentShape.r;
        tempShape.c = currentShape.c;
        tempShape.orientation = currentShape.orientation;
        if(dtheta == 1)
        {
            if(tempShape.orientation < 3)
            {
                tempShape.orientation++;
            }
            else
            {
                tempShape.orientation = 0;
            }
        }
        if(dtheta == -1)
        {
            if(tempShape.orientation > 0)
            {
                tempShape.orientation--;
            }
            else
            {
                tempShape.orientation = 3;
            }
        }
        for(int i = 0;i < 4;i++)
        {
            for(int j = 0;j < 4;j++)
            {
                if(tempShape.getArray()[i][j] != 0)
                {
                    if(tempShape.c + j + dc < 10 && tempShape.c + j + dc >= 0)
                    {
                        if(spaces[tempShape.r + i + dr][tempShape.c + j + dc] != 0)
                        {
                            output = false;
                        }
                    }
                    else
                    {
                        output = false;
                    }
                }
            }
        }
        return output;
    }
    public boolean checkRow(int row)
    {
        boolean output = true;
        for(int j = 0;j < 10;j++)
        {
            if(spaces[row][j] == 0)
            {
                output = false;
            }
        }
        return output;
    }
    public void delRow(int row)
    {
        for(int i = row;i > 0;i--)
        {
            for(int j = 0;j < 10;j++)
            {
                spaces[i][j] = spaces[i - 1][j];
            }
        }
        spaces[0] = new int[10];
    }
    public boolean checkMovement(int direction)
    {
        boolean output = true;
        for(int i = 0;i < 4;i++)
        {
            for(int j = 0;j < 4;j++)
            {
                if(currentShape.getArray()[i][j] != 0)
                {
                    switch(direction)
                    {
                        case 0:
                        if(currentShape.c + j >= 9)
                        {
                            output = false;
                        }
                        else
                        {
                            output = checkInt(0,1,0);
                        }
                        break;
                        case 1:
                        if(currentShape.r + i >= 21)
                        {
                            output = false;
                        }
                        else
                        {
                            output = checkInt(1,0,0);
                        }
                        break;
                        case 2:
                        if(currentShape.c + j <= 0)
                        {
                            output = false;
                        }
                        else
                        {
                            output = checkInt(0,-1,0);
                        }
                        break;
                        default:
                    }
                }
            }
        }
        return output;
    }
    public Shape currentShape;
    public int[][] spaces;
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g2D = (Graphics2D) g;
        for(int i = 2;i < 22;i++)
        {
            for(int j = 0;j < 10;j++)
            {
                Rectangle2D block = new Rectangle2D.Double(j*blockSize,(i - 2)*blockSize,blockSize,blockSize);
                if(addShape()[i][j] != 0)
                {
                    switch(addShape()[i][j])
                    {
                        case 1:
                        g2D.setColor(Color.cyan);
                        break;
                        case 2:
                        g2D.setColor(Color.blue);
                        break;
                        case 3:
                        g2D.setColor(Color.orange);
                        break;
                        case 4:
                        g2D.setColor(Color.yellow);
                        break;
                        case 5:
                        g2D.setColor(Color.green);
                        break;
                        case 6:
                        g2D.setColor(Color.magenta.darker());
                        break;
                        case 7:
                        g2D.setColor(Color.red);
                        break;
                        case 8:
                        g2D.setColor(Color.gray);
                        break;
                    }
                    g2D.fill(block);
                    g2D.setColor(Color.black);
                    g2D.draw(block);
                }
            }
        }
        //g2D.draw(new Rectangle2D.Double(0,0,10*blockSize,20*blockSize));
    }
    public void actionPerformed(ActionEvent e)
    {
        //System.out.println(phase);
        switch(phase)
        {
            case "playing":
            timerCount++;
            if(timerCount > timerMax)
            {
                t.stop();
                iterate();
                t.start();
                repaint();
                timerCount = 0;
            }
            break;
            case "game over":
            if(spaces[0][0] != 8)
            {
                int j = 23;
                for(int i = 23;i >= 0;i--)
                {
                    if(spaces[i][0] == 8)
                    {
                        j = i - 1;
                    }
                }
                Arrays.fill(spaces[j],8);
                repaint();
            }
            else
            {
                t.stop();
            }
            break;
        }
    }
}