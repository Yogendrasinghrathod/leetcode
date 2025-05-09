class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int n = list.size();
        int t = list.get(k - 1);
        list.set(k - 1, list.get(n - k));
        list.set(n - k, t);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : list) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }
}
