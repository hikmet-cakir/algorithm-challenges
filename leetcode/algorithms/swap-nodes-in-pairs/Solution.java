/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = head.next.next;
        ListNode tempHead = head;
        head = head.next;
        head.next = tempHead;
        head.next.next = temp;

        ListNode pre = head.next;
        ListNode first = pre.next;
        ListNode second = first != null ? first.next : null;
        while(first != null && second != null) {
            swapNodes(first, second, pre);
            pre = first;
            first = pre.next;
            second = first != null ? first.next : null;
        }
        return head;
    }

    public void swapNodes(ListNode node1, ListNode node2, ListNode pre) {
        node1.next = node2.next;
        pre.next = node2;
        node2.next = node1;
    }
}