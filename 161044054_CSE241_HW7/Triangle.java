/**
 * Holds a Triangle
 * @author fatihselimyakar
 * @version 1.0.0
 */
import java.awt.*;

public class Triangle implements Shape{
    public static final double SQR3DIV2 = 0.866;
    public static final double SQR3 = 1.7320;

    private int lateral;
    private double triX,triY,tri2X,tri2Y,tri3X,tri3Y;
    private double pos_x;
    private double pos_y;
    private int rotate;
    private char position;

    /**
     * no parameter constructor that calls other constructor.
     * @exception MyException bring other constructor.
     */
    public Triangle()throws MyException{
        this(0,'c',0,0,0,0,0,0,0,0,0);
    }

    /**
     * base constructor
     * @param lateralVal that is the lateral value.
     * @param positionVal 'i' or 'c'(container and inner).
     * @param trixVal x coord of first vertice.
     * @param triyVal y coord of first vertice.
     * @param tri2xVal x coord of second vertice.
     * @param tri2yVal y coord of second vertice.
     * @param tri3xVal x coord of third vertice.
     * @param tri3yVal y coord of third vertice.
     * @param rotateVal rotating degree.
     * @param pos_xVal main coord x.
     * @param pos_yVal main coord y.
     * @exception MyException throws exception if parameters are unvalid.
     */
    public Triangle(int lateralVal,char positionVal,double trixVal,double triyVal,double tri2xVal,double tri2yVal,double tri3xVal,double tri3yVal,int rotateVal,double pos_xVal,double pos_yVal)throws MyException{
        if(trixVal<0||tri2xVal<0||tri3xVal<0||triyVal<0||tri2yVal<0||tri3yVal<0||lateralVal<0||pos_xVal<0||pos_yVal<0)
            throw new MyException("UNVALID TRIANGLE VALUES");
        else{
            triX=trixVal;
            triY=triyVal;
            tri2X=tri2xVal;
            tri2Y=tri2yVal;
            tri3X=tri3xVal;
            tri3Y=tri3yVal;
            lateral=lateralVal;
            pos_x=pos_xVal;
            pos_y=pos_yVal;
        }
        if(rotateVal>360||rotateVal<0)
            throw new MyException("Rotate must be between the 0 and 360");
        else
            rotate=rotateVal;
        if(positionVal=='c'||positionVal=='i')
            position=positionVal;
        else
            throw new MyException("Position must be c or i");
    }
    /**
     * two parameter constructor.
     * @param lateralVal that is the lateral value.
     * @param positionVal 'i' or 'c'(container and inner).
     * @exception MyException throws exception if parameters are unvalid bringing other constructor .
     */
    public Triangle(int lateralVal,char positionVal)throws MyException{
        this(lateralVal,positionVal,0,0,0,0,0,0,0,0,0);
    }
    /**
      * @param trixVal x coord of first vertice.
      * @param triyVal y coord of first vertice.
      * @param tri2xVal x coord of second vertice.
      * @param tri2yVal y coord of second vertice.
      * @param tri3xVal x coord of third vertice.
      * @param tri3yVal y coord of third vertice.
      * @exception MyException throws exception if parameters are unvalid bringing other constructor .
      */
    public Triangle(double trixVal,double triyVal,double tri2xVal,double tri2yVal,double tri3xVal,double tri3yVal)throws MyException{
        this(0,'c',triyVal,triyVal,tri2xVal,tri2yVal,tri3xVal,tri3yVal,0,0,0);
    }
    /**
      * getter.
      * @return return degree of rotate.
      */
    public int getRotate(){ return rotate; }
    /**
      * getter.
      * @return return position.
      */
    public char getPosition(){ return position; }
    /**
      * getter.
      * @return return main x coord.
      */
    public double getPosX(){ return pos_x; }
    /**
      * getter.
      * @return return main y coord.
      */
    public double getPosY(){ return pos_y; }
    /**
      * getter.
      * @return return first vertice's x coord.
      */
    public double getTriX(){ return triX; }
    /**
      * getter.
      * @return return first vertice's y coord.
      */
    public double getTriY(){ return triY; }
    /**
      * getter.
      * @return return second vertice's x coord.
      */
    public double getTri2X(){ return tri2X; }
    /**
      * getter.
      * @return return second vertice's y coord.
      */
    public double getTri2Y(){ return tri2Y; }
    /**
      * getter.
      * @return return third vertice's x coord.
      */
    public double getTri3X(){ return tri3X; }
    /**
      * getter.
      * @return return third vertice's y coord.
      */
    public double getTri3Y(){ return tri3Y; }
    /**
      * getter.
      * @return return triangle's lateral.
      */
    public int getLateral(){ return lateral; }

    /**
     * Setter
     * @param lateralVal that is the lateral value.
     * @param positionVal 'i' or 'c'(container and inner).
     * @param trixVal x coord of first vertice.
     * @param triyVal y coord of first vertice.
     * @param tri2xVal x coord of second vertice.
     * @param tri2yVal y coord of second vertice.
     * @param tri3xVal x coord of third vertice.
     * @param tri3yVal y coord of third vertice.
     * @param rotateVal rotating degree.
     * @param pos_xVal main coord x.
     * @param pos_yVal main coord y.
     * @exception MyException throws exception if parameters are unvalid.
     */
    public void set(int lateralVal,char positionVal,double trixVal,double triyVal,double tri2xVal,double tri2yVal,double tri3xVal,double tri3yVal,int rotateVal,double pos_xVal,double pos_yVal)throws MyException{
        if(lateralVal>0)
    		lateral=lateralVal;
    	else
    		throw new MyException("Program aborted!(UNVALID LATERAL)");

    	if(positionVal=='i'||positionVal=='c')
    		position=positionVal;
    	else
    		throw new MyException("Program aborted!(UNVALID POSITION)");

    	if(trixVal>=0)
    		triX=trixVal;
    	else
    		throw new MyException("Program aborted!(UNVALID COORDINATE)");

    	if(triyVal>=0)
    		triY=triyVal;
    	else
    		throw new MyException("Program aborted!(UNVALID COORDINATE)");

    	if(tri2xVal>=0)
    		tri2X=tri2xVal;
    	else
    		throw new MyException("Program aborted!(UNVALID COORDINATE)");

    	if(tri2yVal>=0)
    		tri2Y=tri2yVal;
    	else
    		throw new MyException("Program aborted!(UNVALID COORDINATE)");

    	if(tri3xVal>=0)
    		tri3X=tri3xVal;
    	else
    		throw new MyException("Program aborted!(UNVALID COORDINATE)");

    	if(tri3yVal>=0)
    		tri3Y=tri3yVal;
    	else
    		throw new MyException("Program aborted!(UNVALID COORDINATE)");

    	rotate=rotateVal;

    }
    /**
     * calculate the one Triangle's area.
     * @return double area returning.
     */
    public double area(){ return (lateral*lateral*1.732)/4.; }
    /**
     * calculate the one Triangle's perimeter.
     * @return double perimeter returning.
     */
    public double perimeter(){ return 3*lateral; }
    /**
     * add the Triangle's center coordinates 1.0.
     * @return Shape object.
     */
    public Shape increment(){
        ++triX;
        ++triY;
        ++tri2Y;
        ++tri2X;
        ++tri3X;
        ++tri3Y;
        return this;
    }
    /**
     * decrement the Triangle's center coordinates 1.0.
     * @return Shape object.
     */
    public Shape decrement(){
        --triX;
        --triY;
        --tri2Y;
        --tri2X;
        --tri3X;
        --tri3Y;
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
        java.awt.Polygon p = new java.awt.Polygon();
        if(position=='i'){
            p.addPoint((int)triX,(int)triY); p.addPoint((int)tri2X,(int)tri2Y); p.addPoint((int)tri3X,(int)tri3Y);
            shape.setColor(Color.GREEN);
            shape.fillPolygon(p);
        }
        else if(position=='c'){
            p.addPoint((int)(lateral/2.0),0); p.addPoint(0,(int)(lateral*SQR3DIV2)); p.addPoint(lateral,(int)(lateral*SQR3DIV2));
            shape.setColor(Color.RED);
            shape.fillPolygon(p);
        }
        else{
            throw new MyException("ERROR IN DRAW");
        }
    }
}
