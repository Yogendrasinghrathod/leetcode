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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail=head;

        if(head==null||head.next==null || k==0){
            return head;
        }
        int count=1;
        while(tail.next!=null){
            tail=tail.next;
            count++;
        }
        tail.next=head;  //connect
        if(k>=count){
            k=k%count;      
        }
        tail=head; 
        k=count-k;
        for(int i=1;i<k;i++){
            tail=tail.next;   //reaching n-k node
        }
        head=tail.next; // store kr rha
        tail.next=null;  //disconnect kr rha

        return head;
    }
}