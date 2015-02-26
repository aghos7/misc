package misc.liststuff;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyListTest {

    MyList<Integer> myList;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        myList = new MyList<>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testRemoveDuplicatesListOfT() {
        System.out.println("\n testRemoveDuplicatesListOfT");
        List<Integer> myData = new ArrayList<>();
        myData.add(1);
        myData.add(2);
        myData.add(1);
        myData.add(3);
        myData.add(2);
        myData.add(1);
        myData.add(1);
        
        List<Integer> foo1 = myList.removeDuplicates(myData,1);
        System.out.println("\nn=1");
        for(Integer element : foo1) {
            System.out.println(element);
        }
        
        List<Integer> foo2 = myList.removeDuplicates(myData,2);
        System.out.println("\nn=2");
        for(Integer element : foo2) {
            System.out.println(element);
        }
        List<Integer> foo3 = myList.removeDuplicates(myData,3);
        System.out.println("\nn=3");
        for(Integer element : foo3) {
            System.out.println(element);
        }
    }

    @Test
    public void testMergeRecursiveDestructive() throws Exception {
        System.out.println("\n testMergeRecursiveDestructive");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(18);
        
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        
        List<Integer> result = myList.mergeRecursiveDestructive(list1, list2);
        assertEquals(9, result.size());
        for (Integer element : result) {
            System.out.println(element);
        }
        
    }

    @Test
    public void testMergeIterativeDestructive() throws Exception {
        System.out.println("\n testMergeIterativeDestructive");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(18);
        
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        
        List<Integer> result = myList.mergeIterativeDestructive(list1, list2);
        assertEquals(9, result.size());
        for (Integer element : result) {
            System.out.println(element);
        }
    }

    @Test
    public void testMergeIterativeNonDestructive() throws Exception {
        System.out.println("\n testMergeIterativeNonDestructive");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(18);
        
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        
        List<Integer> result = new ArrayList<>();
        myList.mergeIterativeNonDestructive(list1, list2, result);
        assertEquals(9, result.size());
        for (Integer element : result) {
            System.out.println(element);
        }
    }

    @Test
    public void testMergeRecursiveNonDestructive() throws Exception {
        System.out.println("\n testMergeRecursiveNonDestructive");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(18);
        
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        
        List<Integer> result = new ArrayList<>();
        myList.mergeRecursiveNonDestructive(list1, list2, result, 0, 0);
        assertEquals(9, result.size());
        for (Integer element : result) {
            System.out.println(element);
        }
    }

    @Test
    public void testMergeSort() throws Exception {
        System.out.println("\n testMergeSort");
        List<Integer> list1 = new LinkedList<>();
        list1.add(8);
        list1.add(1);
        list1.add(3);
        list1.add(18);
        list1.add(6);
        list1.add(2);
        list1.add(4);
        list1.add(7);
        list1.add(5);
        
        List<Integer> result = myList.mergeSort(list1);
        assertEquals(9, result.size());
        for (Integer element : result) {
            System.out.println(element);
        }
        
    }
    
    @Test
    public void testDutchFlag() throws Exception {
        System.out.println("\n testDutchFlag");
        List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 0,1,0,1,2,0,0,1,0,2);
        
        myList.dutchFlag(list1);
        
        for (Integer element : list1) {
            System.out.println(element);
        }
        
    }
    
    /*
    For example, given array S = {-1 0 1 2 -1 -4},

        A solution set is:
        (-1, 0, 1)
        (-1, -1, 2)
     */
    
    @Test
    public void testThreeSum() throws Exception {
        System.out.println("\n testThreeSum");
        List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, -1, 0, 1, 2, -1, -4);
        
        Set<List<Integer>> result = myList.threeSum(list1, 0);
        
        for (List<Integer> element : result) {
            System.out.println(element);
        }
        
    }
    
    @Test
    public void testThreeSumHashMap() throws Exception {
        System.out.println("\n testThreeSumHashMap");
        List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, -1, 0, 1, 2, -1, -4);
        
        Set<List<Integer>> result = myList.threeSumHashMap(list1, 0);
        
        for (List<Integer> element : result) {
            System.out.println(element);
        }
        
    }
    
    @Test
    public void testTwoSumHashMap() throws Exception {
        System.out.println("\n testTwoSumHashMap");
        List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, -1, 0, 1, 2, -1, -4, 4, 4, 3, -4, 6, 12, -2, -3, 1);
        
        Set<List<Integer>> result = myList.twoSumHashMap(list1, 0);
        
        for (List<Integer> element : result) {
            System.out.println(element);
        }
        
    }
    
    

}
