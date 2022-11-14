package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<H> {
        Node<H> next;
        Node<H> previous;
        H data;

        public Node(H data) {
            this.data = data;
        }

    }

    public class LinkedListIterator implements Iterator<T> {
        private Node<T> current;


        public LinkedListIterator(){
            this.current = head;
        }

        public boolean hasNext(){
            return current != null;
        }
        public T next(){
            T data = current.data;
            current = current.next;
            return data;
        }
    }





    public void addAtTail(T data){
        Node<T> node = new Node<T>(data);
        node.previous = tail;
        tail = node;

        if( head == null) {
            head = node;
        }else {
            node.previous.next = node;
        }
        size++;
    }
    public void addAtFront(T data){
        Node<T> node = new Node<>(data);
        node.next= head;
        head = node;

        if( tail == null) {
            tail = node;
        }else{
            node.next.previous = node;
        }
        size++;
    }

    public int getSize(){
        return size;
    }

    public boolean remove(int indexToRemove){

        if(indexToRemove < 0 || indexToRemove >= size){
            return false;
        }if(size ==1){      //if this is the last, set null the attributes
            head = null;
            tail = null;
            size = 0;
        } else if(indexToRemove == 0){  //this is the first element
            head = head.next;
            head.previous = null;
        } else if (indexToRemove == size -1) { // if is the last element
            tail = tail.previous;
            tail.next = null;
        } else{
            Node<T> iteratorNode = findNodeByIndex(indexToRemove);

            iteratorNode.previous.next = iteratorNode.next;
            iteratorNode.next.previous = iteratorNode.previous;

        }
        size--;
        return true;
    }

    public void removeAll(){
        head = null;
        tail = null;
        size = 0;
    }
    public void removeAllWithValue(T value){
        Node<T> current = head;

        while(current != null){
            if(current.data.equals(value)){
                if(current == head){
                    head = current.next;
                    if(head == null){
                        tail = null;
                    }else{
                        head.previous = null;
                    }
                }else{
                    current.previous.next = current.next; // se sobreescribe
                    if (current == tail){
                        tail = current.previous;
                    }else{
                        current.next.previous = current.previous;
                    }
                }
                size--;
            }
            current = current.next;
        }
    }

    public boolean setAt(int index,T data){
        if(index < 0 || index >= size){
            return false;
        }
        Node<T> node = findNodeByIndex(index);
        node.data = data;
        return true;
    }

    public T getAt(int index){
        if(index < 0 || index >= size){
            return null;
        }
        Node<T> node = findNodeByIndex(index);
        return node.data;
    }

    private Node<T> findNodeByIndex(int index) {
        Node<T> iteratorNode = head;
        int indexIteratorNode = 0;

        while (indexIteratorNode < index){
            iteratorNode = iteratorNode.next;
            indexIteratorNode++;
        }
        return iteratorNode;
    }

    public LinkedListIterator getIterator(){
        return new LinkedListIterator();
    }
}
