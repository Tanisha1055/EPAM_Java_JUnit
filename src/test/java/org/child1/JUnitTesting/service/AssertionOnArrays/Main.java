package org.child1.JUnitTesting.service.AssertionOnArrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        int[] expected={2,3,4,5};
        int[] actual={4,3,5,2};
        //this implies the number of elements are equals and the elements individually
        //are equal (so here ans will be true)
        assertArrayEquals(expected,actual);
        //but here , it will check the ref of the variable and expected and actual are
        //pointing to two different loc (so the ans will be false)
        assertEquals(expected,actual);


    }
}
