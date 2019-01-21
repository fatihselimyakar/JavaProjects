/**
 * The Queue interface.
 * @author fatihselimyakar
 * @version 1.0.0
 */
public interface Queue<E> extends Collection<E>{
    /**
     * This method is returns a iterator that shows first element in container.
     * @return returns Iterator class'es iterator.
     */
    public Iterator iterator();
    /**
     * This method adds a object in the container.
     * @param e e is a generic object
     * @return if method adds then return true.
     */
    public boolean add(E e);
    /**
     * This method adds all objects of other container in the container.
     * @param c c is a generic object container.
     * @return if method adds then return true.
     * @exception MyException if container is empty then throws.
     */
    public boolean addAll(Collection<E> c)throws MyException;
    /**
     * This method remove all of the objects in container.
     * @exception MyException if container is empty then throws.
     */
    public void clear()throws MyException;//for the abstract base class
    /**
     * This method check the e is in container or not.
     * @param e controlling parameter.
     * @return if there is e then return true.
     */
    public boolean contains(E e);
    /**
     * Returns true if this collection contains all of the elements in the specified collection.
     * @param c c is a generic object container.
     * @return if there are elements then return true.
     */
    public boolean containsAll(Collection<E> c);
    /**
     * Returns true if this collection contains no elements.
     * @return if the container is empty then returns true.
     */
    public boolean isEmpty();
    /**
     * Removes a single instance of the specified element from this collection, if it is present.
     * @param e the deleting parameter.
     * @exception MyException if there is not e then throws.
     * @return if there is e and method finds it then returns true.
     */
    public boolean remove(E e)throws MyException;
    /**
     * Removes all of this collection's elements that are also contained in the specified collection.
     * @param c the deleting container that includes generic objects.
     * @exception MyException if c is empty then throws.
     * @return if the container is empty then returns false.
     */
    public boolean removeAll(Collection<E> c)throws MyException;
    /**
     * Retains only the elements in this collection that are contained in the specified collection.
     * @param c the container that will compare generic objects.
     * @exception MyException if c is empty then throws.
     * @return if the container is empty then returns false.
     */
    public boolean retainAll(Collection<E> c)throws MyException;
    /**
     * Returns the container's size.
     * @return Returns the container's size.
     */
    public int size();
    /**
     * Retrieves, but does not remove, the head of this queue.
     * @return Returns the head element in queue.
     * @exception MyException if container is empty then throws.
     */
    public E element()throws MyException;
    /**
     * This method adds a object in the container.
     * @param e e is a generic object
     * @return if method adds then return true.
     */
    public boolean offer(E e);
    /**
     * Retrieves and removes the head of this queue, or throws if this queue is empty.
     * @return returns the head of queue.
     * @exception MyException if container empty then return false.
     */
    public E poll()throws MyException;
}
