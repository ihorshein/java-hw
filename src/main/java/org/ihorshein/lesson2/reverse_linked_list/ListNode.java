package org.ihorshein.lesson2.reverse_linked_list;

class ListNode {
  private int val;
  private ListNode next;

  ListNode() {

  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val; this.next = next;
  }

  public int getVal() {
    return val;
  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }
}