package site.izerone.weblearing.javainterview.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Java 常用算法 —— 列表排序
 *
 * @author Lei Wei
 * @version 1.0
 */
public class ListSort {

    /**
     * 冒泡排序, 假定使用的是自然排序
     *
     * @param numbers 需要排序的数组
     */
    public static void bubbleSort(int[] numbers) {
        boolean numbersSwitched;
        do {
            numbersSwitched = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i + 1] < numbers[i]) {
                    int tmp = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = tmp;
                    numbersSwitched = true;
                }
            }
        } while (numbersSwitched);
    }

    /**
     * 插入排序
     *
     * @param numbers 需要排序的数组
     * @return 排序结果
     */
    public static List<Integer> insertSort(final List<Integer> numbers) {
        final List<Integer> sortedList = new LinkedList<>();

        originalList:
        for (Integer number : numbers) {
            for (int i = 0; i < sortedList.size(); i++) {
                if (number < sortedList.get(i)) {
                    sortedList.add(i, number);
                    continue originalList;
                }
            }
            sortedList.add(sortedList.size(), number);
        }
        return sortedList;
    }

    /**
     * 快速排序 (quicksort)
     * 算法是递归算法, 基础情形是列表中有 0 或 1 个元素, 直接返回. 从列表中选择任一元素，作为枢轴 (pivot),把剩下的元素分为两组：
     * 一组中的元素比枢轴小，另一组元素大于等于枢轴。然后对分组的列表调用这个方法，返回的结果是两个排好序的列表。最终结果为：已经排
     * 好序的小于枢轴的元素的列表、枢轴以及已经排好序的大于等于枢轴的元素的列表.
     *
     * @param numbers 需要排序的数组
     * @return 排序结果
     */
    public static List<Integer> quickSort(List<Integer> numbers) {
        if (numbers.size() < 2) {
            return numbers;
        }
        int pivot = numbers.get(0);
        List<Integer> lower = new ArrayList<>();
        List<Integer> higher = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < pivot) {
                lower.add(numbers.get(i));
            } else {
                higher.add(numbers.get(i));
            }
        }
        List<Integer> sortedList = quickSort(lower);
        sortedList.add(pivot);
        sortedList.addAll(quickSort(higher));

        return sortedList;
    }

    /**
     * 归并排序
     *
     * @param numbers 需要排序的数组
     * @return 排序结果
     */
    public static List<Integer> mergeSort(final List<Integer> numbers) {
        if (numbers.size() < 2) {
            return numbers;
        }
        final List<Integer> leftHalf = numbers.subList(0, numbers.size() / 2);
        final List<Integer> rightHalf = numbers.subList(numbers.size() / 2, numbers.size());

        return merge(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    /**
     * 合并排序结果
     *
     * @param left  左边已排序列表
     * @param right 右边已排序列表
     * @return 合并之后的排序结果
     */
    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int leftPos = 0;
        int rightPos = 0;

        List<Integer> merged = new ArrayList<>(left.size() + right.size());

        while (leftPos < left.size() && rightPos < right.size()) {
            if (left.get(leftPos) < right.get(rightPos)) {
                merged.add(left.get(leftPos));
                leftPos++;
            } else {
                merged.add(right.get(rightPos));
                rightPos++;
            }
        }

        while (leftPos < left.size()) {
            merged.add(left.get(leftPos));
            leftPos++;
        }

        while (rightPos < right.size()) {
            merged.add(right.get(rightPos));
            rightPos++;
        }

        return merged;
    }

    /**
     * 二分法搜索
     *
     * @param numbers 搜索列表
     * @param value   搜索值
     * @return 是否存在
     */
    public static boolean binarySearch(final List<Integer> numbers, final Integer value) {
        if (numbers == null || numbers.isEmpty()) {
            return false;
        }
        final Integer comparison = numbers.get(numbers.size() / 2);
        if (value.equals(comparison)) {
            return true;
        }

        if (value < comparison) {
            return binarySearch(numbers.subList(0, numbers.size() / 2), value);
        } else {
            return binarySearch(numbers.subList(numbers.size() / 2 + 1, numbers.size()), value);
        }
    }
}
