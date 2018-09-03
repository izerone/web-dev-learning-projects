package site.izerone.weblearing.javainterview.datastructure;

/**
 * Java 数据结构 —— 简单树的定义
 *
 * @author Lei Wei
 * @version 1.0
 */
public class SimpleTree<E extends Comparable> {

    private E value;
    private SimpleTree<E> left;
    private SimpleTree<E> right;

    public SimpleTree(E value, SimpleTree<E> left, SimpleTree<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    // 省略构造函数、getter 和 setter 方法等


    /**
     * 在二叉树中查找值
     *
     * @param toFind 需要查找的元素
     * @return 查找结果
     */
    public boolean search(final E toFind) {
        if (toFind.equals(value)) {
            return true;
        }

        if (toFind.compareTo(value) < 0 && left != null) {
            return left.search(toFind);
        }
        return right != null && right.search(toFind);
    }

    /**
     * 在二叉树中插入值
     *
     * @param toInsert 需要插入的元素
     */
    public void insert(final E toInsert) {
        if (toInsert.compareTo(value) < 0) {
            if (left == null) {
                left = new SimpleTree<>(toInsert, null, null);
            } else {
                left.insert(toInsert);
            }
        } else {
            if (right == null) {
                right = new SimpleTree<>(toInsert, null, null);
            } else {
                right.insert(toInsert);
            }
        }
    }
}
