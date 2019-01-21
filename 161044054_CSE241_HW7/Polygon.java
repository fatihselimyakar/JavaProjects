/**
 * abstract super class then I use that extends in other classes.
 * @author fatihselimyakar
 * @version 1.0.0
 */
import java.awt.*;

public abstract class Polygon implements Shape{
    protected double pos_x;
    protected double pos_y;
    protected int rotate;
    protected char position;
    protected double areaPoly;
    protected double periPoly;

    /**
     * No parameter constructor.Other constructor calling in it.
     */
    public Polygon(){
        this(0,0,0,'c');
    }
    /**
     * Base constructor.
     * @param x coord x.
     * @param y coord y.
     * @param newRotate the degree of rotate.
     * @param p position val('i' or 'c').
     */
    public Polygon(double x,double y,int newRotate,char p){
        pos_x=x;
        pos_y=y;
        rotate=newRotate;
        position=p;
    }
    /**
     * Helper class that hold two point(x and y).
     */
    public class Point2d{
        private double polygonX;
        private double polygonY;
        public Point2d(){/*intentionally empty*/}
        public Point2d(double newX,double newY)throws MyException{
            if(newX>=0&&newY>=0){
                polygonX=newX;
                polygonY=newY;
            }
            else
                throw new MyException("Error your constructor isn't true");
        }
        public void set(double newX,double newY)throws MyException{
            if(newX>=0&&newY>=0){
                polygonX=newX;
                polygonY=newY;
            }
            else
                throw new MyException("Error your set function isn't true");
            return;
        }
        public double getX(){ return polygonX; }
        public double getY(){ return polygonY; }

    }
    /**
     * getter.
     * @return coordinate of x.
     */
    public double getPosX(){ return pos_x; }
    /**
     * getter.
     * @return coordinate of y.
     */
    public double getPosY(){ return pos_y; }
    /**
     * getter.
     * @return degree of rotation.
     */
    public int getRotate(){ return rotate; }
    /**
     * getter.
     * @return 'i' or 'c' issue.
     */
    public char getPosition(){ return position; }

    /**
     * The draw(); method draw the GUI based the object
     * @param shape object that is printed out.
     * @exception MyException throws if there are unvalid values
     */
    abstract public void draw(Graphics shape)throws MyException;
    /**
     * The area() method returns owned class's shapes's area.
     * @return double returning.
     */
    public double area(){
        return areaPoly;
    }
    /**
     * The perimeter() method returns owned class's shapes's perimeter.
     * @return double returning.
     */
    public double perimeter(){
        return periPoly;
    }
    /**
     * The increment() method adds 1.0 all coordinates.
     * @return incremented Shape object returning.
     */
    public Shape increment(){
        ++pos_x;
        ++pos_y;
        return this;
    }
    /**
     * The decrement() method adds 1.0 all coordinates.
     * @return incremented Shape object returning.
     */
    public Shape decrement(){
        --pos_x;
        --pos_y;
        return this;
    }
    /**
     * The compareTo() method compares two object handled with areas.
     * @param comp get the second object for comparing.
     * @return the compare value returning.
     */
    public int compareTo(Shape comp){
        return Double.compare(area(),comp.area());
    }

}
