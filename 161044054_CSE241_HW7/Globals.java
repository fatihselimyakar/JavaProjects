/**
 * Hold the all of global functions.
 * @author fatihselimyakar
 * @version 1.0.0
 */
import java.lang.*;
import java.awt.*;
import java.util.*;

public class Globals{
    /**
     * Draws all of the shapes in Shape array .
     * @param refArr shape array that will be draw.
     * @param shape shape where is the printed out.
     * @exception MyException bringing in the draw methods or array length is 0.
     */
    public static void drawAll(Shape[] refArr,Graphics shape)throws MyException{
        if(refArr.length==0)
            throw new MyException("YOUR LENGTH IS 0");
        for(int i=0;i<refArr.length;++i)
            refArr[i].draw(shape);
    }

    /**
     * Convert all of the shapes in Shape array and return new polygon array.
     * @param convArr shape array that will be converted.
     * @return return a new array that is polygon.
     * @exception MyException if type is unvalid then throws or array length is 0.
     */
    public static Shape[] convertAll(Shape[] convArr)throws MyException{
        if(convArr.length==0)
            throw new MyException("YOUR LENGTH IS 0");
        PolygonVect[]polyvect=new PolygonVect[convArr.length];
        for(int i=0;i<convArr.length;++i){
            if(convArr[i] instanceof Triangle){
                Triangle ref=(Triangle)convArr[i];
                polyvect[i]=new PolygonVect(ref);
            }
            else if(convArr[i] instanceof Rectangle){
                Rectangle ref=(Rectangle)convArr[i];
                polyvect[i]=new PolygonVect(ref);
            }
            else if(convArr[i] instanceof Circle){
                Circle ref=(Circle)convArr[i];
                polyvect[i]=new PolygonVect(ref);
            }
            else{
                throw new MyException("UNVALID CONVERTED TYPE");
            }
        }
        return polyvect;
    }

    /**
     * compare all of the shapes in Shape array and sort them.
     * @param sortArr shape array that will be sort.
     * @exception MyException if array's length is 0 then throws.
     */
    public static void sortShapes(Shape[] sortArr)throws MyException{
        if(sortArr.length==0)
            throw new MyException("YOUR LENGTH IS 0");
        for(int i=0;i<sortArr.length-1;i++){
             for(int j=0;j<sortArr.length-i-1;j++){
                 if(sortArr[j].compareTo(sortArr[j+1])>0){
                     Shape temp=sortArr[j];
                     sortArr[j]=sortArr[j+1];
                     sortArr[j+1]=temp;
                 }
             }
        }
    }
}
