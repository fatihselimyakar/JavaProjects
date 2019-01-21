/**
 * Holds a Rectangle.
 * @author fatihselimyakar
 * @version 1.0.0
 */
import java.awt.*;

public class Rectangle implements Shape{

    private double pos_x;
    private double pos_y;
    private int rotate;
    private char position;
    private int height;
    private int width;
    /**
     * no parameter constructor that calls other constructor.
     * @exception MyException bring other constructor.
     */
    public Rectangle()throws MyException{
        this(0,0,0,0,0,'c');
    }
    /**
     * base constructor
     * @param newHeight the rectangle's height.
     * @param newWidth the rectangle's width.
     * @param x the rectangle's x coordinate.
     * @param y the rectangle's y coordinate.
     * @param newRotate the rectangle's rotate degree.
     * @param p the rectangle's position 'i' or 'c'.
     * @exception MyException throws exception if parameters are unvalid.
     */
    public Rectangle(int newHeight,int newWidth,double x,double y,int newRotate,char p)throws MyException{
        if(x<0||y<0||newHeight<0||newWidth<0)
            throw new MyException("Pos_x and pos_y are not smaller than 0");
        else{
            pos_x=x;
            pos_y=y;
            height=newHeight;
            width=newWidth;
        }
        if(newRotate>360||newRotate<0)
            throw new MyException("Rotate must be between the 0 and 360");
        else
            rotate=newRotate;
        if(p=='c'||p=='i')
            position=p;
        else
            throw new MyException("Position must be c or i");
    }
    /**
     * three parameter constructor
     * @param heightVal the rectangle's height.
     * @param widthVal the rectangle's width.
     * @param positionVal the rectangle's position 'i' or 'c'.
     * @exception MyException throws exception if parameters are unvalid(bring the other constructor).
     */
    public Rectangle(int heightVal,int widthVal,char positionVal)throws MyException{
        this(heightVal,widthVal,0,0,0,positionVal);
    }

    /**
     * getter
     * @return return height.
     */
    public int getHeight(){ return height; }
    /**
     * getter
     * @return return width.
     */
    public int getWidth(){ return width; }
    /**
     * getter
     * @return return rotate.
     */
    public int getRotate(){ return rotate; }
    /**
     * getter
     * @return return position.
     */
    public char getPosition(){ return position; }
    /**
     * getter
     * @return return coordinate x of rectangle.
     */
    public double getPosX(){ return pos_x; }
    /**
     * getter
     * @return return coordinate y of rectangle.
     */
    public double getPosY(){ return pos_y; }



    /**
     * set the rectangle's values.
     * @param newHeight the rectangle's height.
     * @param newWidth the rectangle's width.
     * @param x the rectangle's x coordinate.
     * @param y the rectangle's y coordinate.
     * @param newRotate the rectangle's rotate degree.
     * @param p the rectangle's position 'i' or 'c'.
     * @exception MyException throws exception if parameters are unvalid.
     */
    public void set(int newHeight,int newWidth,double x,double y,int newRotate,char p)throws MyException{
        if(newHeight<=0)
    		throw new MyException("Program Aborted!(UNVALID HEIGHT VALUE)");
    	else
    		height=newHeight;

    	if(newWidth<=0)
    		throw new MyException("Program Aborted!(UNVALID WIDTH VALUE)");
    	else
    		width=newWidth;

    	if(p!='c'&&p!='i')
    		throw new MyException("Program Aborted!(UNVALID POSITION VALUE)");
    	else
    		position=p;

    	if(x<0||y<0)
    		throw new MyException("Program Aborted!(UNVALID COORD VALUE)");
    	else{
    		pos_x=x;
    		pos_y=y;
    	}

    	rotate=newRotate;
    }

    /**
     * calculate the one rectangle's area.
     * @return double area returning.
     */
    public double area(){
        return height*width;
    }
    /**
     * calculate the one rectangle's perimeter.
     * @return double area returning.
     */
    public double perimeter(){
        return 2*(height+width);
    }
    /**
     * add the rectangle's center coordinates 1.0.
     * @return Shape object.
     */
    public Shape increment(){
        ++pos_x;
        ++pos_y;
        return this;
    }
    /**
     * decrement the circle's center coordinates 1.0.
     * @return Shape object.
     */
    public Shape decrement(){
        --pos_x;
        --pos_y;
        return this;
    }
    /**
     * compare the other Shape object based on areas.
     * @param comp the conparing shape object.
     * @return returns int handled compare value(like the strcmp).
     */
    public int compareTo(Shape comp){
        return Double.compare(area(),comp.area());
    }

    /**
     * drawing method in JPanel.
     * @param shape the drawing shape object.
     * @exception MyException if position is different than 'i' or 'c'.
     */
    public void draw(Graphics shape)throws MyException{
        if(position=='i'){
            shape.setColor(Color.GREEN);
            shape.fillRect((int)pos_x,(int)pos_y,width,height);
        }
        else if(position=='c'){
            shape.setColor(Color.RED);
            shape.fillRect(0,0,width,height);
        }

        else{
            throw new MyException("ERROR IN DRAW");
        }

    }
}
