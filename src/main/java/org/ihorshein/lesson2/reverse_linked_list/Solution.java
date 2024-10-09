package org.ihorshein.lesson2.reverse_linked_list;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
class Solution {
  private ListNode _reverseListIterative(ListNode head) {
    ListNode next = head; // Will move ->
    ListNode prev = null; // Will gather in reverse

    while (next != null) {
      next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }

    return prev;
  }

  private ListNode _reverseListRecursion(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode newHead = _reverseListRecursion(head.next);
    head.next.next = head;
    head.next = null;

    return newHead;
  }

  public static void _print(ListNode o_node) {
    while (o_node != null) {
      System.out.print(o_node.val);
      o_node = o_node.next;
    }

    System.out.println("");
  }

  public static void main(String[] args) {
    example1();
    example2();
    example3();
  }

  public static void example1()
  {
    System.out.println("Example 1");

    ListNode listHead = new ListNode(1,
      new ListNode(2,
        new ListNode(3,
          new ListNode(4,
            new ListNode(5)))));
    _print(listHead);

    Solution solution = new Solution();

    ListNode listRevers = solution._reverseListIterative(listHead);
    _print(listRevers);

    listHead = solution._reverseListRecursion(listRevers);
    _print(listHead);
  }

  public static void example2()
  {
    System.out.println("Example 2");

    ListNode listHead = new ListNode(1, new ListNode(2));
    _print(listHead);

    Solution solution = new Solution();

    ListNode listRevers = solution._reverseListIterative(listHead);
    _print(listRevers);

    listHead = solution._reverseListRecursion(listRevers);
    _print(listHead);
  }

  public static void example3()
  {
    System.out.println("Example 3");

    ListNode listHead = new ListNode();
    _print(listHead);

    Solution solution = new Solution();

    ListNode listRevers = solution._reverseListIterative(listHead);
    _print(listRevers);

    listHead = solution._reverseListRecursion(listRevers);
    _print(listHead);
  }
}