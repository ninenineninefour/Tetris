import java.util.*;
public class Shape
{
    public Shape(String type_ini)
    {
        type = type_ini;
        orientation = 0;
        r = 0;
        c = 3;
    }
    public int[][] getArray()
    {
        int[][] array = new int[][] {{0,0,0,0},
                                     {0,0,0,0},
                                     {0,0,0,0},
                                     {0,0,0,0}};
        switch(type.toLowerCase())
        {
            case "o":
            array = new int[][] {{0,0,0,0},
                                 {0,1,1,0},
                                 {0,1,1,0},
                                 {0,0,0,0}};
            break;
            case "i":
            switch(orientation)
            {
                case 0:
                case 2:
                array = new int[][] {{0,0,0,0},
                                     {2,2,2,2},
                                     {0,0,0,0},
                                     {0,0,0,0}};
                break;
                case 1:
                case 3:
                array = new int[][] {{0,0,2,0},
                                     {0,0,2,0},
                                     {0,0,2,0},
                                     {0,0,2,0}};
                break;
            }
            break;
            case "s":
            switch(orientation)
            {
                case 0:
                case 2:
                array = new int[][] {{0,0,0,0},
                                     {0,0,3,3},
                                     {0,3,3,0},
                                     {0,0,0,0}};
                break;
                case 1:
                case 3:
                array = new int[][] {{0,0,3,0},
                                     {0,0,3,3},
                                     {0,0,0,3},
                                     {0,0,0,0}};
                break;
            }
            break;
            case "z":
            switch(orientation)
            {
                case 0:
                case 2:
                array = new int[][] {{0,0,0,0},
                                     {0,4,4,0},
                                     {0,0,4,4},
                                     {0,0,0,0}};
                break;
                case 1:
                case 3:
                array = new int[][] {{0,0,0,4},
                                     {0,0,4,4},
                                     {0,0,4,0},
                                     {0,0,0,0}};
                break;
            }
            break;
            case "l":
            switch(orientation)
            {
                case 0:
                array = new int[][] {{0,0,0,0},
                                     {0,5,5,5},
                                     {0,5,0,0},
                                     {0,0,0,0}};
                break;
                case 1:
                array = new int[][] {{0,0,5,0},
                                     {0,0,5,0},
                                     {0,0,5,5},
                                     {0,0,0,0}};
                break;
                case 2:
                array = new int[][] {{0,0,0,5},
                                     {0,5,5,5},
                                     {0,0,0,0},
                                     {0,0,0,0}};
                break;
                case 3:
                array = new int[][] {{0,5,5,0},
                                     {0,0,5,0},
                                     {0,0,5,0},
                                     {0,0,0,0}};
                break;
            }
            break;
            case "j":
            switch(orientation)
            {
                case 0:
                array = new int[][] {{0,0,0,0},
                                     {0,6,6,6},
                                     {0,0,0,6},
                                     {0,0,0,0}};
                break;
                case 1:
                array = new int[][] {{0,0,6,6},
                                     {0,0,6,0},
                                     {0,0,6,0},
                                     {0,0,0,0}};
                break;
                case 2:
                array = new int[][] {{0,6,0,0},
                                     {0,6,6,6},
                                     {0,0,0,0},
                                     {0,0,0,0}};
                break;
                case 3:
                array = new int[][] {{0,0,6,0},
                                     {0,0,6,0},
                                     {0,6,6,0},
                                     {0,0,0,0}};
                break;
            }
            break;
            case "t":
            switch(orientation)
            {
                case 0:
                array = new int[][] {{0,0,0,0},
                                     {0,7,7,7},
                                     {0,0,7,0},
                                     {0,0,0,0}};
                break;
                case 1:
                array = new int[][] {{0,0,7,0},
                                     {0,0,7,7},
                                     {0,0,7,0},
                                     {0,0,0,0}};
                break;
                case 2:
                array = new int[][] {{0,0,7,0},
                                     {0,7,7,7},
                                     {0,0,0,0},
                                     {0,0,0,0}};
                break;
                case 3:
                array = new int[][] {{0,0,7,0},
                                     {0,7,7,0},
                                     {0,0,7,0},
                                     {0,0,0,0}};
                break;
            }
            break;
            default:
        }
        return array;
    }
    public String type;
    public int orientation;
    public int r;
    public int c;
}
