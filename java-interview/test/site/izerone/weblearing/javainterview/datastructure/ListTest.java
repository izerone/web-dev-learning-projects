package site.izerone.weblearing.javainterview.datastructure;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class ListTest {

    /**
     * 数组定义
     */
    @Test
    public void arrayDefinitions() {
        final int[] ints = new int[3];
        final boolean[] booleans = {false, true, true};
        final String[] strings = new String[]{"123", "234"};

        final Random r = new Random();
        final String[] randomArrayLength = new String[r.nextInt(100)];
    }

    /**
     * 扩展数组
     */
    @Test
    public void arrayCopy() {
        int[] ints = {1, 3, 4, 5, 6};
        int[] newInts = new int[ints.length + 1];
        System.arraycopy(ints, 0, newInts, 0, ints.length);
        ints = newInts;
        ints[5] = 5;
        assertEquals(5, ints[5]);
    }

}