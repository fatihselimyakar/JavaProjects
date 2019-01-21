import java.util.*;
/**
 * The ArrayList class implements the List class.
 * @author fatihselimyakar
 * @version 1.0.0
 */
public class ArrayList<E> implements List<E>{
    private E[]array;
    private int sizeArray;

    /**
     * no parameter constructor.
     * make the array and arraySize.
     */
    public ArrayList(){
        @SuppressWarnings("unchecked")
        E[]temp=(E[])new Object[1000];
        this.array=temp;
        sizeArray=0;
    }

    /**
     * This method is returns a iterator that shows first element in container.
     * @return returns Iterator class'es iterator.
     */
    public Iterator<E> iterator(){
        return new Iterator<E>(array);
    }

    /**
     * This method adds a object in the container.
     * @param e e is a generic object
     * @return if method adds then return 1.
     */
    public boolean add(E e){
        if(sizeArray<array.length-1){
            array[sizeArray]=e;
            ++sizeArray;
        }
        else if(sizeArray==array.length-1){
            int length=array.length;
            @SuppressWarnings("unchecked")
            E[]array2=(E[])new Object[length+1000];
            for(int i=0;i<array.length;++i){
                array2[i]=array[i];
            }
            array=array2;
            array[length-1]=e;
            ++sizeArray;
        }
        return true;

    }

    /**
     * This method adds all objects of other container in the container.
     * @param c c is a generic object container.
     * @return if method adds then return true.
     * @exception MyException if container is empty then throws.
     */
    public boolean addAll(Collection<E> c)throws MyException{
        boolean res;
        if(c.isEmpty()){
            res=false;
            throw new MyException("ADALL METHOD ERROR");
        }//if 'c' is empty
        else{
            //with the for loop I add() the new values then return true
            @SuppressWarnings("unchecked")
            Iterator<E> itTemp=c.iterator();
            for(int i=0;i<c.size();++i){
                add(itTemp.element());
                if(i!=c.size()-1)
                    itTemp.next();
            }
            res=true;
        }
        return res;
    }

    /**
     * This method remove all of the objects in container.
     * @exception MyException if container is empty then throws.
     */
    public void clear()throws MyException{
        if(sizeArray==0){
            throw new MyException("CLEAR METHOD ERROR");
        }
        Iterator<E> it=this.iterator();
        for(int i=0;i<sizeArray;++i){
            it.remove();
        }
        sizeArray=0;
    }

    /**
     * This method check the e is in container or not.
     * @param e controlling parameter.
     * @return if there is e then return true.
     */
    public boolean contains(E e){
        Iterator<E> itTemp=this.iterator();
        for(int i=0;i<this.size();++i){
            if(itTemp.element()==e)
                return true;
            if(i!=this.size()-1){
                try{
                    itTemp.next();
                }
                catch(MyException err){
                    System.out.printf("%s",err);
                }
            }

        }
        return false;
    }

    /**
     * Returns true if this collection contains all of the elements in the specified collection.
     * @param c c is a generic object container.
     * @return if there are elements then return true.
     */
    public boolean containsAll(Collection<E> c){
        @SuppressWarnings("unchecked")
        Iterator<E> it = c.iterator();
        for(int i=0;i<c.size();++i){
            try{
                if(!contains(it.element())){
                    return false;
                }
                it.next();
            }
            catch(MyException err){
                System.out.printf("%s",err);
            }

        }
        return true;
    }

    /**
     * Returns true if this collection contains no elements.
     * @return if the container is empty then returns true.
     */
    public boolean isEmpty(){
        return sizeArray==0;
    }

    /**
     * Removes a single instance of the specified element from this collection, if it is present.
     * @param e the deleting parameter.
     * @exception MyException if there is not e then throws.
     * @return if there is e and method finds it then returns true.
     */
    public boolean remove(E e)throws MyException{
        if(!contains(e))
            throw new MyException("REMOVE ERROR.");
        else{
            Iterator<E> itTemp=this.iterator();
            for(int i=0;i<this.size();++i){
                if(itTemp.element()==e){
                    itTemp.remove();
                    --sizeArray;
                    return true;
                }
                if(i!=this.size())
                    itTemp.next();
            }
        }
        return false;
    }

    /**
     * Removes all of this collection's elements that are also contained in the specified collection.
     * @param c the deleting container that includes generic objects.
     * @exception MyException if c is empty then throws.
     * @return if the container is empty then returns false.
     */
    public boolean removeAll(Collection<E> c)throws MyException{
        boolean res;
        if(c.isEmpty()){
            res=false;
            throw new MyException("REMOVEALL METHOD ERROR");
        }
        else{
            @SuppressWarnings("unchecked")
            Iterator<E> itTemp=c.iterator();
            for(int i=0;i<c.size();++i){
                if(contains(itTemp.element()))
                    remove(itTemp.element());
                if(i!=c.size()-1)
                    itTemp.next();
            }
            res=true;
        }
        return res;
    }

    /**
     * Retains only the elements in this collection that are contained in the specified collection.
     * @param c the container that will compare generic objects.
     * @exception MyException if c is empty then throws.
     * @return if the container is empty then returns false.
     */
    public boolean retainAll(Collection<E> c)throws MyException{
        if(c.isEmpty()==true){
            throw new MyException("RETAINALL METHOD ERROR");
        }
        boolean result=false;
        @SuppressWarnings("unchecked")
        E[] temp=(E[])new Object[array.length];
        @SuppressWarnings("unchecked")
        Iterator<E> itTemp=c.iterator();
        int i=0,count=0;
        while(i<c.size()){
            if(contains(itTemp.element())){
                temp[i]=itTemp.element();
                result=true;
            }
            ++i;
            itTemp.next();
        }
        if(contains(itTemp.element())){
            temp[i]=itTemp.element();
            result=true;
        }
        sizeArray=i;
        array=temp;
        return result;
    }

    /**
     * Returns the container's size.
     * @return Returns the container's size.
     */
    public int size(){
        return sizeArray;
    }

    /**
     * That method provide the random accessing.
     * @param index accessing value's index.
     * @return the E type incontainer value.
     * @exception MyException if index does not in the range then throws.
     */
    public E randomAccess(int index)throws MyException{
        if(index>=0||index<sizeArray)
            return array[index];
        else
            throw new MyException("Random Access Error");
    }

    /**
     * Print the screen all of elements container's in it for the test.
     */
    public void print(){
        for(int i=0;i<size();++i){
            if(array[i]!=null){
                System.out.print(array[i]);
                System.out.printf(" ");
            }
        }
    }

}
