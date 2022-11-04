package laba8;

import java.util.Arrays;
import java.util.LinkedList;

public class SingleLinkedList<T extends Number> {
    private LinkedList<T> list;


    @SafeVarargs
    public SingleLinkedList(T... items) {
        this.list = new LinkedList<>();
        setList(items);
    }
    public SingleLinkedList(LinkedList<T> list) {
        this.list = new LinkedList<>();
        this.list.addAll(list);
    }
    public SingleLinkedList() {
        this.list=new LinkedList<>();
    }



    public LinkedList<T> getList() {
        return list;
    }

    @SafeVarargs
    public final void setList(T... items) {
        list = new LinkedList<>();
        list.addAll(Arrays.asList(items));
    }
    public void setList(LinkedList<T> list) {
        this.list.addAll(list);
    }
}
