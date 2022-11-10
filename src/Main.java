import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.arraylist.Arraylist;
import uaslp.objetos.list.linkedlist.LinkedList;

public class Main {
    public static void main(String[] args) {

        List<String> datos = new Arraylist<>();
        datos.getIterator();

        datos.addAtTail("uno");
        datos.addAtTail("dos");
        datos.addAtTail("tres");

        datos.addAtFront("3");
        datos.addAtFront("2");
        datos.addAtFront("1");

        Iterator<String> iterator = datos.getIterator();

        while (iterator.hasNext()){
            String data = iterator.next();
            System.out.println(data);
        }

        datos.addAtFront("3");
        datos.addAtFront("2");
        datos.addAtFront("1");

        datos.removeAll();


        System.out.println("-------------------");

        iterator = datos.getIterator();

        while (iterator.hasNext()){
            String data = iterator.next();
            System.out.println(data);
        }

    }
}