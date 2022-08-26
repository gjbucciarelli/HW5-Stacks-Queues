import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CircularArrayQueue<E> implements Queue<E> {

    // Fields
    private E[] myArray;
    private int mFront, mRear;
    private int mSize = 0;

    // Constructor
    public CircularArrayQueue(int capacity)
    {
        mFront = mRear = -1;

        // Type cast generics
        myArray = (E[]) new Object[capacity];
    }

    // Default constructor
    // Default size is 10
    public CircularArrayQueue() { this (10);}

    @Override
    public boolean offer(E input)
    {
        if (isFull())
            resize();
        else if (isEmpty())
            mFront++;
        mRear = (mRear + 1) % myArray.length;
        myArray[mRear] = input;
        mSize++;
        return true;
    }

    @Override
    public E remove(){
        if (isEmpty())
            throw new NoSuchElementException();

        E temp = myArray[mFront];
        if (mFront == mRear)
            clear();
        else
            mFront = (mFront + 1) % myArray.length;
        mSize--;
        return temp;
    }

    @Override
    public E poll() {
        if (isEmpty())
            return null;

        E temp = myArray[mFront];
        if (mFront == mRear)
            clear();
        else
            mFront = (mFront + 1) % myArray.length;
        mSize--;
        return temp;
    }

    @Override
    public E element() {
        if (isEmpty())
            throw new NoSuchElementException();

        return myArray[mFront];
    }

    @Override
    public E peek(){
        if (isEmpty())
            return null;

        return myArray[mFront];
    }

    // Queue  methods
    @Override
    public int size() {return mSize;}

    @Override
    public boolean isEmpty(){return mFront == -1;}

    @Override
    public void clear() {mFront = mRear = -1; }

    // Helper methods
    public boolean isFull() {return (mRear +1) % myArray.length == mFront;}

    public void resize()
    {
        // Type cast for generics
        E[] tempArr = (E[]) new Object[myArray.length * 2];

        // copy over original array
        for (int i =0; i <myArray.length; i++) {
            tempArr[i] = myArray[i];
        }

        mFront = 0;
        mRear = myArray.length -1;
        myArray = tempArr;
    }

    // Unchanged methods
    @Override
    public boolean contains (Object o) {return false;}

    @Override
    public boolean add(E input) {
        if (isFull())
            resize();
        else if (isEmpty())
            mFront++;

        mRear = (mRear + 1) % myArray.length;
        myArray[mRear] = input;
        mSize++;
        return true;
    }
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
