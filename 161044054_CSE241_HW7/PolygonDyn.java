import java.awt.*;
import java.util.*;
import java.lang.*;

public class PolygonDyn extends Polygon{
    private Point2d[]array;

    /**
     * helper function that provide circle's coordinates.
     */
    private double CircleEquationY(double centerX,double centerY,int radius,double yourX){
        return Math.sqrt(Math.pow(radius,2)-Math.pow(yourX-centerX,2))+centerY;
    }

    /**
     * no parameter constructor that construct the array and calls super classe's constructor.
     */
    public PolygonDyn(){
        super(0,0,0,'c');
        array=new Point2d[1];
        areaPoly=0;
        periPoly=0;
    }
    /**
     * no parameter constructor that construct the array and calls super classe's constructor.
     * @param pointVector the construct based on this Array.
     */
    public PolygonDyn(Point2d[]pointVector){
        super();
        array=new Point2d[pointVector.length];
        array=pointVector;
        areaPoly=0;
        periPoly=0;
    }
    /**
     * Rectangle constructor that construct based on Rectangle object.
     * @param rec that is Rectangle that will convert.
     * @exception MyException if entered parameter is not valid then throws exception.
     */
    public PolygonDyn(Rectangle rec)throws MyException{
        super();
        array=new Point2d[4];
        Point2d pt=new Point2d(rec.getPosX(),rec.getPosY());
        array[0]=pt;
        Point2d pt2=new Point2d(rec.getPosX()+rec.getWidth(),rec.getPosY());
        array[1]=pt2;
        Point2d pt3=new Point2d(rec.getPosX()+rec.getWidth(),rec.getPosY()+rec.getHeight());
        array[2]=pt3;
        Point2d pt4=new Point2d(rec.getPosX(),rec.getPosY()+rec.getHeight());
        array[3]=pt4;

        rotate=0;
        pos_x=0;
        pos_y=0;
        if(rec.getPosition()=='i'||rec.getPosition()=='c')
            position=rec.getPosition();
        else
            throw new MyException("Position is not true");

        areaPoly=rec.area();
        periPoly=rec.perimeter();
    }
    /**
     * Triangle constructor that construct based on Triangle object.
     * @param tri that is Triangle that will convert.
     * @exception MyException if entered parameter is not valid then throws exception.
     */
    public PolygonDyn(Triangle tri)throws MyException{
        super();
        array=new Point2d[3];
        Point2d pt=new Point2d(tri.getTriX(),tri.getTriY());
        array[0]=pt;
        Point2d pt2=new Point2d(tri.getTri2X(),tri.getTri2Y());
        array[1]=pt2;
        Point2d pt3=new Point2d(tri.getTri3X(),tri.getTri3Y());
        array[2]=pt3;

        if(tri.getRotate()<=360&&tri.getRotate()>=0)
            rotate=tri.getRotate();
        else
            throw new MyException("degree is not true");

        if(tri.getPosition()=='i'||tri.getPosition()=='c')
            position=tri.getPosition();
        else
            throw new MyException("Position is not true");

    	pos_x=tri.getPosX();
        pos_y=tri.getPosY();
        areaPoly=tri.area();
        periPoly=tri.perimeter();
    }
    /**
     * Circle constructor that construct based on Circle object.
     * @param cir that is Circle that will convert.
     * @exception MyException if entered parameter is not valid then throws exception.
     */
    public PolygonDyn(Circle cir)throws MyException{
        array=new Point2d[100];
        if(cir.getRotate()<=360&&cir.getRotate()>=0)
            rotate=cir.getRotate();
        else
            throw new MyException("degree is not true");

        if(cir.getPosition()=='i'||cir.getPosition()=='c')
            position=cir.getPosition();
        else
            throw new MyException("Position is not true");

        //I USED THE CIRCLE EQUATION WHILE I AM FINDING THE 100 POINT
        //AND I USED HELPER FUNTION "CircleEquationY()" TOO
        pos_x=cir.getPosX();
        pos_y=cir.getPosY();
        double increase=(2*cir.getRadius())/50.1;
        double startingX=cir.getCenterCoordX()-cir.getRadius();
        double startingY;
        double reverseY;
        //FOR THE BOTTOM SIDE
        for(int i=0;i<50;i+=1,startingX+=increase){
            startingY=CircleEquationY(cir.getCenterCoordX(),cir.getCenterCoordY(),(int)cir.getRadius(),startingX);
            Point2d pt=new Point2d(startingX,startingY);
            array[i]=pt;
        }
        //FOR THE TOP SIDE
        startingX=cir.getCenterCoordX()-cir.getRadius()+increase;
        //auto it = polyvector.end();
        for(int i=0;i<50;i+=1,startingX+=increase){
            startingY=CircleEquationY(cir.getCenterCoordX(),cir.getCenterCoordY(),(int)cir.getRadius(),startingX);
            reverseY=cir.getCenterCoordY()-(startingY-cir.getCenterCoordY());
            Point2d pt=new Point2d(startingX,reverseY);
            //polyvector.insert(it,pt);
            array[99-i]=pt;
        }
        areaPoly=cir.area();
        periPoly=cir.perimeter();
    }
    /**
     * return the that indexes showed value.
     * @param index index value.
     * @exception MyException if entered parameter is not valid then throws exception.
     * @return returns in it indexes value.
     */
    public Point2d at(int index)throws MyException{
        if(index<0 || index>=array.length)
            throw new MyException("Your index value isn't true");
        return array[index];
    }
    /**
     * Draw the owning parameters.
     * @param shape JFrame that will print out.
     * @exception MyException if entered parameter is not valid then throws exception.
     */
    public void draw(Graphics shape)throws MyException{
        java.awt.Polygon p = new java.awt.Polygon();
        if( getPosition()=='c'){
            for(int i=0;i< array.length;i++){
                p.addPoint((int)array[i].getX(),(int)array[i].getY());
            }
            shape.setColor(Color.RED);
            shape.fillPolygon(p);

        }
        else if(getPosition()=='i'){
            for(int i=0;i<array.length;i++){
                p.addPoint((int)array[i].getX(),(int)array[i].getY());
            }
            shape.setColor(Color.GREEN);
            shape.fillPolygon(p);
        }
        else
            throw new MyException("UNVALID POSITION VALUE IN POLYGONVECT DRAW");

    }
}
