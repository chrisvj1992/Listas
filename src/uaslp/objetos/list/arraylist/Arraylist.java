package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class Arraylist<T >implements List<T> {
    private T[] data;
    private int size;

    public Arraylist(){
        data = (T[])(new  Object[2]) ;

    }

    public void addAtTail(T data){
        if(size == this.data.length){
            increaseArraySize();
        }

        this.data[size] = data;
        size++;
    }

    private void increaseArraySize(){
        T []newArray = (T[])(new Object[this.data.length * 2]);

        for (int i= 0; i< data.length; i++){
            newArray[i] = data[i];
        }

        data = newArray;
    }

    public void addAtFront(T data){
        if(size == this.data.length){
            increaseArraySize();
        }

        for(int i = size; i > 0; i--){
            this.data[i] = this.data[i -1];
        }
        this.data[0] = data;
        size++;
    }

    public boolean remove(int indexToRemove){
        if (indexToRemove < 0 || indexToRemove >= size){
            return false;
        }

        for(int i=indexToRemove; i < size-1; i++){
            this.data[i] = this.data[i+1];
        }
        size--;
        this.data[size] = null;

        return true;
    }

    public void removeAll(){
        for (int i = 0; i < size;i++){
            this.data[i] = null;
        }

        size = 0;
    }

    public boolean setAt(int index,T data){
        if (index < 0 || index >= size){
            return false;
        }

        this.data[index] = data;

        return true;
    }

    public T getAt(int index){
        if (index < 0 || index >= size){
            return null;
        }

        return this.data[index];
    }

    public void removeAllWithValue(T value){
        T []newArray = (T[] )(new Object[data.length]);
        int count =0;

        for(int i=0; i< size; i++){
            if( !data[i].equals(value)){
                newArray[count++]=data[i];
            }
        }
        data = newArray;
        size =count;
    }

    public int getSize(){
        return size;
    }


    public Iterator getIterator(){      //clase anonima
        return new Iterator() {

            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                return data[currentIndex++];
            }
        };
    }
}


