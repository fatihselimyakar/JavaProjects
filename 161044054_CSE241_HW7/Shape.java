import java.awt.Graphics;
/**
 * Shape interface that is all others implements this.
 * @author fatihselimyakar
 * @version 1.0.0
 */

public interface Shape extends Comparable<Shape>{
    /**
     * The area() method returns owned class's shapes's area.
     * @return double returning.
     */
    public double area();
    /**
     * The perimeter() method returns owned class's shapes's perimeter.
     * @return double returning.
     */
    public double perimeter();
    /**
     * The increment() method adds 1.0 all coordinates.
     * @return incremented Shape object returning.
     */
    public Shape increment();
    /**
     * The decrement() method adds 1.0 all coordinates.
     * @return incremented Shape object returning.
     */
    public Shape decrement();
    /**
     * The compareTo() method compares two object handled with areas.
     * @param comp get the second object for comparing.
     * @return the compare value returning.
     */
    public int compareTo(Shape comp);
    /**
     * The draw(); method draw the GUI based the object
     * @param shape object that is printed out.
     * @exception MyException if the user entered unvalid shape than throw the error.
     */
    public void draw(Graphics shape)throws MyException;
}
