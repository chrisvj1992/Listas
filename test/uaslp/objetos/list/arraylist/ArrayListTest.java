package uaslp.objetos.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;

public class ArrayListTest {

    // TDD-> Test Driven Development
    // Maven Coordinates

    @Test
    public void givenANewList_thenSizeIsZero(){
        //Given:
        Arraylist<String> lista = new Arraylist<>();
        //When:
        int size = lista.getSize();
        //Then:
        Assertions.assertEquals(0,size);
    }

    @Test
    public void givenANewList_whenAddAtTail_thenSizeIsOne(){
        //Given:
        Arraylist<String> lista = new Arraylist<>();
        //When:
        lista.addAtTail("Uno");

        //Then:
        Assertions.assertEquals(1,lista.getSize());
        Assertions.assertEquals("Uno",lista.getAt(0));

    }



    @Test
    public void givenANonEmptyList_whenAddAtTail_thenSizeIsIncreased(){
        //Given:
        Arraylist<String> lista = new Arraylist<>();
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
        Arraylist<String> lista = new Arraylist<>();
        //When:
        lista.addAtFront("Uno");

        //Then:
        Assertions.assertEquals(1,lista.getSize());
        Assertions.assertEquals("Uno",lista.getAt(0));

    }

    @Test
    public void givenANonEmptyList_whenAddAtFront_thenSizeIsIncreased(){
        //Given:
        Arraylist<String> lista = new Arraylist<>();
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
        Arraylist<String> lista = new Arraylist<>();
        lista.addAtFront("Uno");
        //When:
        boolean result = lista.remove(-1);
        //Then:
        Assertions.assertFalse(result);
    }



    @Test
    public void givenAList_whenRemoveGreaterThanSize_thenReturnFalse(){
        //Given:
        Arraylist<String> lista = new Arraylist<>();
        lista.addAtFront("Uno");
        //When:
        boolean result = lista.remove(1);
        //Then:
        Assertions.assertFalse(result);

    }


    @Test
    public void givenAListWithOneElement_whenRemove0_thenReturnTrue(){
        //Given:
        Arraylist<String> lista = new Arraylist<>();
        lista.addAtFront("Uno");
        //When:
        boolean result = lista.remove(0);
        //Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(0,lista.getSize());

    }


    @Test
    public void givenAListWithTwoElements_whenRemove0_thenReturnTrue(){
        //Given:
        Arraylist<String> lista = new Arraylist<>();
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
        Arraylist<String> lista = new Arraylist<>();
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
        Arraylist<String> lista = new Arraylist<>();
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
        Arraylist<String> lista = new Arraylist<>();
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
        Arraylist<String> lista = new Arraylist<>();
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
        Arraylist<String> lista = new Arraylist<>();
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
        Arraylist<String> lista = new Arraylist<>();
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
        Arraylist<String> lista = new Arraylist<>();
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



    @Test
    public void givenAListWith2Elements_whenAddAtFront_thenArrayIsIncreasedSuccessfully(){
        //Given:
        Arraylist<String> lista = new Arraylist<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        //When:

        lista.addAtFront("Tres");
        //Then:
        Assertions.assertEquals(3,lista.getSize());
        Assertions.assertEquals("Tres",lista.getAt(0));
        Assertions.assertEquals("Dos",lista.getAt(1));
        Assertions.assertEquals("Uno",lista.getAt(2));

    }


    //TODO: copiar a  LinkedList
    @Test
    public void givenAnArray_whenGetAtNegative_thenNullIsReturned(){
        // Given:
        Arraylist<String> lista = new Arraylist<>();
        lista.addAtFront("Algo");

        //When:
        String value = lista.getAt(-1);

        //Then:

        Assertions.assertNull(value);
    }

    //TODO: copiar a  LinkedList
    @Test
    public void givenAnArray_whenGetAtIndexGreaterThanSize_thenNullIsReturned(){
        // Given:
        Arraylist<String> lista = new Arraylist<>();
        lista.addAtFront("Algo");

        //When:
        String value = lista.getAt(1);

        //Then:

        Assertions.assertNull(value);
    }


    //TODO: copiar a  LinkedList
    @Test
    public void givenAnArray_whenRemoveAllWithValue_thenValuesAreRemoved(){
        // Given:
        Arraylist<Integer> lista = new Arraylist<>();
        lista.addAtFront(10);
        lista.addAtFront(20);
        lista.addAtTail(30);
        lista.addAtFront(20);
        lista.addAtTail(40);
        lista.addAtFront(20);
        lista.addAtTail(30); // 7

        //When:


        lista.removeAllWithValue(20);
        //Then:

        Assertions.assertEquals(4,lista.getSize());
        Assertions.assertEquals(10,lista.getAt(0));
        Assertions.assertEquals(30,lista.getAt(1));
        Assertions.assertEquals(40,lista.getAt(2));
        Assertions.assertEquals(30,lista.getAt(3));
    }

    //TODO: copiar a  LinkedList
    @Test
    public void givenAnArrayWithNoCoincidences_whenRemoveAllWithValue_thenValuesAreRemoved(){
        // Given:
        Arraylist<Integer> lista = new Arraylist<>();
        lista.addAtFront(10);
        lista.addAtTail(30);
        lista.addAtTail(40);
        lista.addAtTail(30); // 4

        //When:


        lista.removeAllWithValue(20);
        //Then:

        Assertions.assertEquals(4,lista.getSize());
        Assertions.assertEquals(10,lista.getAt(0));
        Assertions.assertEquals(30,lista.getAt(1));
        Assertions.assertEquals(40,lista.getAt(2));
        Assertions.assertEquals(30,lista.getAt(3));
    }

    //TODO: copiar a  LinkedList
    @Test
    public void givenANonEmptyList_whenIterate_thenIterationIsSuccessfull(){
        // Given:
        Arraylist<Integer> lista = new Arraylist<>();
        lista.addAtFront(10);
        lista.addAtTail(30);
        lista.addAtTail(40);
        lista.addAtTail(30); // 4

        //When:


        Iterator iterator = lista.getIterator();
        //Then:
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(10, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(30, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(40, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(30, iterator.next());

        Assertions.assertFalse(iterator.hasNext());
    }
}
