/**
 * Hold the one Circle in it(with details).
 * @author fatihselimyakar
 * @version 1.0.0
 */
import java.awt.*;

public class Circle implements Shape{
    private double centerCoordX;//center point's x coordinate
    private double centerCoordY;//center point's y coordinate
    private double radius;
    private double pos_x;
    private double pos_y;
    private int rotate;
    private char position;

    /**
     * Circle() no parameter constructor it uses other constructor
     * @exception MyException bringing other constructor
     */
    public Circle()throws MyException{
        this(0,0,0,'c',0,0,0);
    }
    /**
     * Circle() two parameter constructor it uses other constructor
     * @param radiusValue is hold the radius.
     * @param positionValue is hold the position for ex. inner(i) or container(c).
     * @exception MyException bringing other constructor
     */
    public Circle(int radiusValue,char positionValue)throws MyException{
        this(0,0,0,positionValue,0,0,radiusValue);
    }
    /**
     * Circle()'s main constructor.
     * @param x coord value.
     * @param y second coord value.
     * @param newRotate degree for rotating.
     * @param p position value(if inner 'i' in container 'c').
     * @param centerX center's x coordinate.
     * @param centerY center's y coordinate.
     * @param r radius value.
     * @exception MyException unvalid parameter.
     */
    public Circle(double x,double y,int newRotate,char p,double centerX,double centerY,double r)throws MyException{
        if(centerX<0||centerY<0||r<0||x<0||y<0)
            throw new MyException("Circle's Values are false!");
        else{
            centerCoordX=centerX;
            centerCoordY=centerY;
            radius=r;
            pos_x=x;
            pos_y=y;
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
     * getter.
     * @return center y coordinate.
     */
    public double getCenterCoordX(){ return centerCoordX; }
    /**
     * getter.
     * @return center y coordinate.
     */
    public double getCenterCoordY(){ return centerCoordY; }
    /**
     * getter.
     * @return radius.
     */
    public double getRadius(){ return radius; }
    /**
     * getter.
     * @return rotate.
     */
    public int getRotate(){ return rotate; }
    /**
     * getter.
     * @return position.
     */
    public char getPosition(){ return position; }
    /**
     * getter.
     * @return pos_x.
     */
    public double getPosX(){ return pos_x; }
    /**
     * getter.
     * @return pos_y.
     */
    public double getPosY(){ return pos_y; }

    /**
     * Circle()'s set.
     * @param x coord value.
     * @param y second coord value.
     * @param newRotate degree for rotating.
     * @param p position value(if inner 'i' in container 'c').
     * @param centerX center's x coordinate.
     * @param centerY center's y coordinate.
     * @param r radius value.
     * @exception MyException unvalid parameter.
     */
    public void set(double x,double y,int newRotate,char p,double centerX,double centerY,double r)throws MyException{
        if(r<=0||centerX<0||centerY<0||x<0||y<0)
    		throw new MyException("YOU ENTERED UNVALID RADIUS OR COORDINATE VALUE");
    	else{
    		radius=r;
    		centerCoordX=centerX;
    		centerCoordY=centerY;
    		pos_x=x;
    		pos_y=y;
    	}

    	if(p!='c'||p!='i'){
    		throw new MyException("YOU ENTERED UNVALID POSITION VALUE");
    	}
    	else
    		position=p;

    	rotate=newRotate;
    	return;
    }
    /**
     * calculate the one circle's area.
     * @return double area returning.
     */
    public double area(){ return 3.14*radius*radius; }
    /**
     * calculate the one circle's perimeter.
     * @return double area returning.
     */
    public double perimeter(){ return 2*3.14*radius; }
    /**
     * add the circle's center coordinates 1.0.
     * @return Shape object.
     */
    public Shape increment(){
        ++centerCoordX;
        ++centerCoordY;
        return this;
    }
    /**
     * decrement the circle's center coordinates 1.0.
     * @return Shape object.
     */
    public Shape decrement(){
        --centerCoordX;
        --centerCoordY;
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
            shape.fillOval((int)(centerCoordX-radius),(int)(centerCoordY-radius),2*(int)radius,2*(int)radius);
        }
        else if(position=='c'){
            shape.setColor(Color.RED);
            shape.fillOval(0,0,2*(int)radius,2*(int)radius);
        }
        else{
            throw new MyException("ERROR IN DRAW");
        }
    }
}
