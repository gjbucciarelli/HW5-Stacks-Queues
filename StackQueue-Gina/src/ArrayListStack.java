import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E>{

    private ArrayList<E> myArrayList = new ArrayList<>();
    private int topOfStack = -1;

    @Override
    public boolean empty() {return myArrayList.size() == 0;}

    @Override
    public E peek() {
        if (empty())
        {throw new EmptyStackException();}

        return myArrayList.get(topOfStack);
    }

    @Override
    public E pop() {
        if (empty())
        {throw new EmptyStackException();}
        return myArrayList.remove(topOfStack--);
    }

    @Override
    public E push(E obj)
    {
        myArrayList.add(obj);
        topOfStack++;
        return obj;
    }

}
