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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = head;

        for(int i=1; i<k; i++){
            fast = fast.next;
            temp = fast;
        }

        while(fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        int val = temp.val;
        temp.val = slow.val;
        slow.val = val;

        
        return head;
    }

}