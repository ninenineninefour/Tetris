import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
public class Play extends JPanel implements KeyListener
{
    public Frame frame;
    public static void main()
    {
        Play play = new Play();
    }
    public Play()
    {
        frame = new Frame();
        JFrame f = new JFrame();
        f.addKeyListener(this);
        f.add(frame);
        f.setVisible(true);
        f.setSize (251,523);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Tetris");
    }
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
            if(frame.checkMovement(2))
            {
                frame.currentShape.c--;
                frame.repaint();
            }
            break;
            case KeyEvent.VK_RIGHT:
            if(frame.checkMovement(0))
            {
                frame.currentShape.c++;
                frame.repaint();
            }
            break;
            case KeyEvent.VK_UP:
            if(frame.checkInt(0,0,1))
            {
                if(frame.currentShape.orientation < 3)
                {
                    frame.currentShape.orientation++;
                }
                else
                {
                    frame.currentShape.orientation = 0;
                }
                frame.repaint();
            }
            break;
            case KeyEvent.VK_DOWN:
            if(frame.checkInt(0,0,1))
            {
                if(frame.currentShape.orientation > 0)
                {
                    frame.currentShape.orientation--;
                }
                else
                {
                    frame.currentShape.orientation = 3;
                }
                frame.repaint();
            }
            break;
            case KeyEvent.VK_SPACE:
            frame.timerMax = 5;
            break;
            default:
        }
    }
    public void keyTyped(KeyEvent e)
    {
        
    }
    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_SPACE:
            frame.timerMax = 40;
            break;
            default:
        }
    }
}