/**
  * Iterator class points the container's any of index.
  * @author fatihselimyakar
  * @version 1.0.0
  */
import java.util.*;

public class Iterator<E>{
    private E[]array;

    private int index;

    /**
      * One parameter constructor.
      * @param arr iterator's pointing array.
      */
    public Iterator(E[]arr){
        array=arr;
        index=0;
    }
    /**
      * Returns true if the iteration has more elements.
      * @return Boolean value of there is or not memory.
      */
    public boolean hasNext(){
        return index!=(array.length-1);

    }

    /**
      * Returns the next element in the iteration and advances the iterator.
      * @return Returns pointing indexe's+1 E type value.
      * @exception MyException If method does not increment index then throws.
      */
    public E next()throws MyException{
        if(hasNext()){
            ++index;
            return array[index];
        }
        else
            throw new MyException("HASNEXT ERROR");

    }
    /**
      * Removes from the underlying collection the last element returned by this iterator.
      */
    public void remove(){
        java.util.ArrayList<E> list = new java.util.ArrayList<E>(Arrays.asList(array));
        list.remove(index);
        array = list.toArray(array);
    }
    /**
      * Returns pointing indexe's value.
      * @return return a E type object.
      */
    public E element(){
        return array[index];
    }
}
