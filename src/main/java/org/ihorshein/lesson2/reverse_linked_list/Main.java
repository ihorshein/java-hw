package org.ihorshein.lesson2.reverse_linked_list;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/description/">
 *   Lesson 2 HW; Reverse Linked List
 * </a>
 */
public final class Main {
  public static void main(String[] args) {
    example1();
    example2();
    example3();
  }

  private ListNode reverseListIterative(ListNode head) {
    ListNode next = head; // Will move ->
    ListNode prev = null; // Will gather in reverse

    while (next != null) {
      next = head.getNext();
      head.setNext(prev);
      prev = head;
      head = next;
    }

    return prev;
  }

  private ListNode reverseListRecursion(ListNode head) {
    if (head == null || head.getNext() == null) {
      return head;
    }

    ListNode newHead = reverseListRecursion(head.getNext());
    head.getNext().setNext(head);
    head.setNext(null);

    return newHead;
  }

  private static void print(ListNode oNode) {
    while (oNode != null) {
      System.out.print(oNode.getVal());
      oNode = oNode.getNext();
    }

    System.out.println("");
  }

  public static void example1() {
    System.out.println("Example 1");

    ListNode listHead = new ListNode(1,
      new ListNode(2,
        new ListNode(3,
          new ListNode(4,
            new ListNode(5)))));
    print(listHead);

    Main solution = new Main();

    ListNode listRevers = solution.reverseListIterative(listHead);
    print(listRevers);

    listHead = solution.reverseListRecursion(listRevers);
    print(listHead);
  }

  public static void example2() {
    System.out.println("Example 2");

    ListNode listHead = new ListNode(1, new ListNode(2));
    print(listHead);

    Main solution = new Main();

    ListNode listRevers = solution.reverseListIterative(listHead);
    print(listRevers);

    listHead = solution.reverseListRecursion(listRevers);
    print(listHead);
  }

  public static void example3() {
    System.out.println("Example 3");

    ListNode listHead = new ListNode();
    print(listHead);

    Main solution = new Main();

    ListNode listRevers = solution.reverseListIterative(listHead);
    print(listRevers);

    listHead = solution.reverseListRecursion(listRevers);
    print(listHead);
  }
}