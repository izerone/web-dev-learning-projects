package site.izerone.weblearing.javainterview.algorithm;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Java 常用算法 —— 列表排序的测试类
 *
 * @author Lei Wei
 * @version 1.0
 */
public class ListSortTest {

    /**
     * 整数数组的自然排序
     */
    @Test
    public void intSorts() {
        final int[] numbers = {1, 3, 26, 3, 2, 343};
        final int[] expected = {1, 2, 3, 3, 26, 343};

        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    /**
     * 对象的自然排序
     */
    @Test
    public void sortObjects() {
        final String[] strings = {"x", "z", "a", "xxx", "zzzz", "sss"};
        final String[] expected = {"a", "sss", "x", "xxx", "z", "zzzz"};

        Arrays.sort(strings);
        assertArrayEquals(expected, strings);
    }

    @Test
    public void sortNotComparable() {
        final List<NotComparable> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(new NotComparable(i));
        }

        try {
            Arrays.sort(objects.toArray());
        } catch (Exception e) {
            return;
        }

        fail();
    }

    /**
     * 自定义排序
     */
    @Test
    public void customSorting() {
        final List<Integer> numbers = Arrays.asList(1, 23, 32, 4, 3, 22, 44);
        final List<Integer> expected = Arrays.asList(44, 32, 23, 22, 4, 3, 1);

        Collections.sort(numbers, new ReverseNumericalOrder());

        assertEquals(numbers, expected);
    }

    @Test
    public void bubbleSort() {
        final int[] numbers = {1, 3, 34, 22, 1, 33, 9};
        final int[] expected = {1, 1, 3, 9, 22, 33, 34};

        ListSort.bubbleSort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void insertSort() {
        final List<Integer> numbers = Arrays.asList(1, 3, 34, 22, 1, 33, 9);
        final List<Integer> expected = Arrays.asList(1, 1, 3, 9, 22, 33, 34);

        List<Integer> newList = ListSort.insertSort(numbers);
        assertEquals(expected, newList);
    }

    @Test
    public void quickSort() {
        final List<Integer> numbers = Arrays.asList(1, 3, 34, 22, 1, 33, 9);
        final List<Integer> expected = Arrays.asList(1, 1, 3, 9, 22, 33, 34);

        List<Integer> newList = ListSort.quickSort(numbers);
        assertEquals(expected, newList);
    }

    @Test
    public void mergeSort() {
        final List<Integer> numbers = Arrays.asList(1, 3, 34, 22, 1, 33, 9);
        final List<Integer> expected = Arrays.asList(1, 1, 3, 9, 22, 33, 34);

        List<Integer> newList = ListSort.mergeSort(numbers);
        assertEquals(expected, newList);
    }

    @Test
    public void binarySearch() {
        final List<Integer> numbers = Arrays.asList(1, 3, 34, 22, 1, 33, 9);
        final boolean expected = true;

        System.out.println(ListSort.binarySearch(numbers, 10));
        assertEquals(expected, ListSort.binarySearch(numbers, 1));
    }
}
