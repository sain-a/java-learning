package leetcode.linkedlist;

public class LC876_middleNode {
    public static void main(String[] args){
        LC876_middleNode m = new LC876_middleNode();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        ListNode newhead = m.middleNode1(n1);
        while(newhead!=null){
            System.out.println(newhead.val);
            newhead = newhead.next;
        }
    }
    //单指针法
    public ListNode middelNode(ListNode head){
        ListNode cur = head;
        int n = 0;
        while(cur!=null){
            ++n;
            cur = cur.next;
        }
        int k = 0;
        cur = head;
        while(k<n/2){
            ++k;
            cur = cur.next;
        }
        return cur;
    }
    //
    public ListNode middleNode1(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
