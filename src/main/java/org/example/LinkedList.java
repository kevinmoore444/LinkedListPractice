package org.example;

import java.util.NoSuchElementException;

public class LinkedList {

    //Node Class
    private class Node {
        private int value;
        private Node next;

        //Node Constructor
        public Node(int value) {
            this.value = value;
        }
    }

    //Linked List Attributes
    private Node first;
    private Node last;


    //addLast
    public void addLast(int value) {
        var node = new Node(value);
        if (this.isEmpty()) {
            this.first = node;
            this.last = node;
        } else
            last.next = node;
        this.last = node;
    }

    //addFirst
    public void addFirst(int value) {
        var node = new Node(value);
        if (this.isEmpty()) {
            this.first = node;
            this.last = node;
        } else {
            node.next = this.first;
            this.first = node;
        }
    }
    //indexOf
    public int indexOf(int value) {
        int index = 0;
        var current = this.first;
        while (current != null) {
            if (current.value == value) return index;
            else {
                current = current.next;
                index++;
            }
        }
        return -1;
    }

    //contains
    public boolean contains(int value){
        var current = this.first;
        while(current != null) {
            if (current.value == value) return true;
            else current = current.next;
        }
        return false;
    }

    //removeFirst
    public void removeFirst(){
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        if(this.first == this.last){
            this.first = this.last = null;
            return;
        }
        var second = this.first.next;
        this.first.next = null;
        this.first = second;
    }

    //removeLast
    public void removeLast(){
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        if(this.first == this.last) {
            this.first = this.last = null;
            return;
        }
        var current = this.first;
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;
        this.last = current;
    }

    public int getSize(){
        int size = 1;
        var current = this.first;
        if(this.first == null) return 0;
        while(current.next != null){
            size++;
            current = current.next;
        }
        return size;
    }

    public int[] toArray(){
        int[] result = new int[this.getSize()];
        var current = this.first;
        var index = 0;

        while(current != null){
            result[index] = current.value;
            current = current.next;
            index++;
        }
        return result;
    }

    public void reverse() {
        //In case the list is empty
        if(this.isEmpty()) return;

        //Switch the direction of links in the list
        var previous = this.first;
        var current = this.first.next;
        while(current != null){
         var next = current.next;
         current.next = previous;
         previous = current;
         current = next;
        }

        //Redefine the last and first variables
        this.last = this.first;
        this.last.next = null;
        this.first = previous;
    }

    //getKthFromTheEnd(k)

    public void getKthFromTheEnd(int k){
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        //Set two pointers
        var start = this.first;
        var end = this.first;

        //Progress one pointer by k-1 nodes
        var count = 0;
        while(count != (k-1)){
            end = end.next;
            count++;
            if(end == null){
                throw new IllegalArgumentException();
            }
        }

        //Progress both pointers until the end pointer reaches the end of the list.
        while(end != this.last){
            start = start.next;
            end = end.next;
        }
        System.out.println(start.value);
    }
    public void printMiddle(){
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        var start = this.first;
        var end = this.first;

        while(end!= null){
            if(end.next==null){
                System.out.println(start.value);
                break;
            }
            end = end.next;
            if(end.next==null){
                System.out.println(start.value + ", " + start.next.value);
                break;
            }
            end = end.next;
            start = start.next;
        }
    }




    private boolean isEmpty(){
        return first == null;
    }





}
