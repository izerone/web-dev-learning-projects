package site.izerone.weblearing.javainterview.algorithm;

import java.util.Comparator;

/**
 * List 自定义排序
 *
 * @author Lei Wei
 * @version 1.0
 */
public class ReverseNumericalOrder implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
