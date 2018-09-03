package site.izerone.weblearing.javainterview.datastructure;

/**
 * 一个简单的 LinkedList 实现
 *
 * @author Lei Wei
 * @version 1.0
 */
public class SimpleLinkedList<E> {
    private static class Element<E> {
        E value;
        Element<E> next;
    }

    private Element<E> head;

}

