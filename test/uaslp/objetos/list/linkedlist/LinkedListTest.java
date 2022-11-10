package uaslp.objetos.list.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    // TDD-> Test Driven Development
    // Maven Coordinates

    @Test
    public void givenANewList_thenSizeIsZero(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        //When:
        int size = lista.getSize();
        //Then:
        Assertions.assertEquals(0,size);
    }

    @Test
    public void givenANewList_whenAddAtTail_thenSizeIsOne(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        //When:
        lista.addAtTail("Uno");

        //Then:
        Assertions.assertEquals(1,lista.getSize());
        Assertions.assertEquals("Uno",lista.getAt(0));

    }



    @Test
    public void givenANonEmptyList_whenAddAtTail_thenSizeIsIncreased(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        //When:
        lista.addAtTail("Uno");
        lista.addAtTail("Dos");

        //Then:
        Assertions.assertEquals(2,lista.getSize());
        Assertions.assertEquals("Uno",lista.getAt(0));
        Assertions.assertEquals("Dos",lista.getAt(1));

    }

    @Test
    public void givenANewList_whenAddAtFront_thenSizeIsOne(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        //When:
        lista.addAtFront("Uno");

        //Then:
        Assertions.assertEquals(1,lista.getSize());
        Assertions.assertEquals("Uno",lista.getAt(0));

    }

    @Test
    public void givenANonEmptyList_whenAddAtFront_thenSizeIsIncreased(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        //When:
        lista.addAtFront("Dos");
        //Then:
        Assertions.assertEquals(2,lista.getSize());
        Assertions.assertEquals("Dos",lista.getAt(0));
        Assertions.assertEquals("Uno",lista.getAt(1));

    }


    @Test
    public void givenAList_whenRemoveLessThanZero_thenReturnFalse(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        //When:
        boolean result = lista.remove(-1);
        //Then:
        Assertions.assertFalse(result);
    }



    @Test
    public void givenAList_whenRemoveGreaterThanSize_thenReturnFalse(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        //When:
        boolean result = lista.remove(1);
        //Then:
        Assertions.assertFalse(result);

    }


    @Test
    public void givenAListWithOneElement_whenRemove0_thenReturnTrue(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        //When:
        boolean result = lista.remove(0);
        //Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(-1,lista.getSize());

    }


    @Test
    public void givenAListWithTwoElements_whenRemove0_thenReturnTrue(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");
        //When:
        boolean result = lista.remove(0);
        //Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(1,lista.getSize());
        Assertions.assertEquals(lista.getAt(0),"Uno");
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveTail_thenReturnTrue(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtTail("Dos");
        //When:
        boolean result = lista.remove(1);
        //Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(1,lista.getSize());
        Assertions.assertEquals(lista.getAt(0),"Uno");
    }


    @Test
    public void givenAListWithTwoElements_whenRemoveHead_thenReturnTrue(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");
        //When:
        boolean result = lista.remove(0);
        //Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(1,lista.getSize());
        Assertions.assertEquals(lista.getAt(0),"Uno");
    }

    @Test
    public void givenAListWith3Elements_whenRemoveMiddle_thenReturnTrue(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");
        lista.addAtFront("Tres");
        //When:
        boolean result = lista.remove(1);
        //Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(2,lista.getSize());
        Assertions.assertEquals(lista.getAt(0),"Tres");
        Assertions.assertEquals(lista.getAt(1),"Uno");
    }

    @Test
    public void givenAListWith3Elements_whenRemoveAll_thenSizeIsZero(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");
        lista.addAtFront("Tres");
        //When:
        lista.removeAll();
        //Then:
        Assertions.assertEquals(0,lista.getSize());
    }

    @Test
    public void givenAListWith3Elements_whenSetAt1_thenElementIsModified(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");
        lista.addAtFront("Tres");
        //When:
       boolean result = lista.setAt(1,"Cuatro");
        //Then:
        Assertions.assertEquals(3,lista.getSize());
        Assertions.assertEquals("Tres",lista.getAt(0));
        Assertions.assertEquals("Cuatro",lista.getAt(1));
        Assertions.assertEquals("Uno",lista.getAt(2));
        Assertions.assertTrue(result);
    }
    @Test
    public void givenAListWith3Elements_whenSetAtLessThanZero_thenReturnNull(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");
        lista.addAtFront("Tres");
        //When:
       boolean result =   lista.setAt(-1,"Cuatro");

        //Then:
        Assertions.assertEquals(3,lista.getSize());
        Assertions.assertEquals("Tres",lista.getAt(0));
        Assertions.assertEquals("Dos",lista.getAt(1));
        Assertions.assertEquals("Uno",lista.getAt(2));
        Assertions.assertFalse(result);

    }

    @Test
    public void givenAListWith3Elements_whenSetAtIndex3_thenReturnNull(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");
        lista.addAtFront("Tres");
        //When:
        boolean result =   lista.setAt(3,"Cuatro");

        //Then:
        Assertions.assertEquals(3,lista.getSize());
        Assertions.assertEquals("Tres",lista.getAt(0));
        Assertions.assertEquals("Dos",lista.getAt(1));
        Assertions.assertEquals("Uno",lista.getAt(2));
        Assertions.assertFalse(result);

    }
}
