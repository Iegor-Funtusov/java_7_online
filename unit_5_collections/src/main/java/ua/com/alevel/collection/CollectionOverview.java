package ua.com.alevel.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionOverview {

    private final static int SIZE = 100_000;
    private List<Integer> integerArrayList = new ArrayList<>();
    private List<Integer> integerLinkedList = new LinkedList<>();

    public void start() {
        add();
//        read();
//        update();
        delete();
    }

    private void add() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            integerArrayList.add(i); //O(1)
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("integerArrayList add finish " + end);

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            integerLinkedList.add(i); //O(n)
        }
        end = System.currentTimeMillis() - start;
        System.out.println("integerLinkedList add finish " + end);
    }

    private void read() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            integerArrayList.get(i); //O(1)
        }

//        for (Integer i : integerArrayList) { // for each
//            System.out.println("i = " + i);
//        }

        long end = System.currentTimeMillis() - start;
        System.out.println("integerArrayList get finish " + end);

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            integerLinkedList.get(i); //O(n)
        }

        end = System.currentTimeMillis() - start;
        System.out.println("integerLinkedList get finish " + end);
    }

    private void update() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            integerArrayList.set(i, 100); //O(1)
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("integerArrayList update finish " + end);

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            integerLinkedList.set(i, 100); //O(n)
        }
        end = System.currentTimeMillis() - start;
        System.out.println("integerLinkedList update finish " + end);
    }

    private void delete() {
        long start = System.currentTimeMillis();
        Iterator<Integer> iteratorArrayList = integerArrayList.iterator();
        while (iteratorArrayList.hasNext()) {
            iteratorArrayList.next();
            iteratorArrayList.remove();
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("integerArrayList delete finish " + end);

        start = System.currentTimeMillis();
        Iterator<Integer> iteratorLinkedList = integerLinkedList.iterator();
        while (iteratorLinkedList.hasNext()) {
            Integer i = iteratorLinkedList.next();
            iteratorLinkedList.remove();
        }
        end = System.currentTimeMillis() - start;
        System.out.println("integerLinkedList update finish " + end);
    }
}
