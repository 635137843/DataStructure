package Stack;

import IList.List;
import LinearTable.ArrayList;

public class Stack<E> {
    private List<E> list = new ArrayList<>();
    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }

    public void clear(){
        list.clear();
    }

    public void push(E element){
        list.add(element);
    }

    public E pop(){
        return list.remove(list.size() - 1);
    }

    public E top(){
        return list.get(list.size() - 1);
    }
}
