/**
 * Holds a polygon with ArrayList.
 * @author fatihselimyakar
 * @version 1.0.0
 */
import java.awt.*;
import java.util.*;
import java.lang.*;

public class PolygonVect extends Polygon{
    private ArrayList<Point2d>polyvector;

    /**
     * helper function that provide circle's coordinates.
     */
    private double CircleEquationY(double centerX,double centerY,int radius,double yourX){
        return Math.sqrt(Math.pow(radius,2)-Math.pow(yourX-centerX,2))+centerY;
    }

    /**
     * no parameter constructor that construct the arraylist and calls super classe's constructor.
     */
    public PolygonVect(){
        super(0,0,0,'c');
        polyvector=new ArrayList<Point2d>();
        periPoly=0;
        areaPoly=0;
    }
    /**
     * no parameter constructor that construct the arraylist and calls super classe's constructor.
     * @param pointVector the construct based on this ArrayList.
     */
    public PolygonVect(ArrayList<Point2d>pointVector){
        super();
        polyvector=new ArrayList<Point2d>();
        polyvector=pointVector;
        periPoly=0;
        areaPoly=0;
    }
    /**
     * Rectangle constructor that construct based on Rectangle object.
     * @param rec that is Rectangle that will convert.
     * @exception MyException if entered parameter is not valid then throws exception.
     */
    public PolygonVect(Rectangle rec)throws MyException{
        super();
        polyvector=new ArrayList<Point2d>();
        Point2d pt=new Point2d(rec.getPosX(),rec.getPosY());
        polyvector.add(pt);
        Point2d pt2=new Point2d(rec.getPosX()+rec.getWidth(),rec.getPosY());
        polyvector.add(pt2);
        Point2d pt3=new Point2d(rec.getPosX()+rec.getWidth(),rec.getPosY()+rec.getHeight());
        polyvector.add(pt3);
        Point2d pt4=new Point2d(rec.getPosX(),rec.getPosY()+rec.getHeight());
        polyvector.add(pt4);

        rotate=0;
        pos_x=0;
        pos_y=0;
        if(rec.getPosition()=='i'||rec.getPosition()=='c')
            position=rec.getPosition();
        else
            throw new MyException("Position is not true");

        periPoly=rec.perimeter();
        areaPoly=rec.area();
    }
    /**
     * Triangle constructor that construct based on Triangle object.
     * @param tri that is Triangle that will convert.
     * @exception MyException if entered parameter is not valid then throws exception.
     */
    public PolygonVect(Triangle tri)throws MyException{
        super();
        polyvector=new ArrayList<Point2d>();
        Point2d pt=new Point2d(tri.getTriX(),tri.getTriY());
        polyvector.add(pt);
        Point2d pt2=new Point2d(tri.getTri2X(),tri.getTri2Y());
        polyvector.add(pt2);
        Point2d pt3=new Point2d(tri.getTri3X(),tri.getTri3Y());
        polyvector.add(pt3);

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
        periPoly=tri.perimeter();
        areaPoly=tri.area();
    }
    /**
     * Circle constructor that construct based on Circle object.
     * @param cir that is Circle that will convert.
     * @exception MyException if entered parameter is not valid then throws exception.
     */
    public PolygonVect(Circle cir)throws MyException{
        Point2d[]array=new Point2d[100];
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
        polyvector=new ArrayList<Point2d>(Arrays.asList(array));
        periPoly=cir.perimeter();
        areaPoly=cir.area();
    }

    /**
     * return the that indexes showed value.
     * @param index index value.
     * @exception MyException if entered parameter is not valid then throws exception.
     * @return returns in it indexes value.
     */
    public Point2d at(int index)throws MyException{
        if(index<0 || index>=polyvector.size())
            throw new MyException("Your index value isn't true");
        return polyvector.get(index);
    }
    /**
     * Draw the owning parameters.
     * @param shape JFrame that will print out.
     * @exception MyException if entered parameter is not valid then throws exception.
     */
    public void draw(Graphics shape)throws MyException{
        java.awt.Polygon p = new java.awt.Polygon();
        if( getPosition()=='c'){
            for(int i=0;i< polyvector.size();i++){
                p.addPoint((int)polyvector.get(i).getX(),(int)polyvector.get(i).getY());
            }
            shape.setColor(Color.RED);
            shape.fillPolygon(p);

        }
        else if(getPosition()=='i'){
            for(int i=0;i<polyvector.size();i++){

                p.addPoint((int)polyvector.get(i).getX(),(int)polyvector.get(i).getY());
            }
            shape.setColor(Color.GREEN);
            shape.fillPolygon(p);
        }
        else
            throw new MyException("UNVALID POSITION VALUE IN POLYGONVECT DRAW");

    }
}
