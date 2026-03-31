package leetcode.linkedlist;


public class LC206_ReverseList {
    public static void main(String[] args){
        LC206_ReverseList r = new LC206_ReverseList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        ListNode head = n1;
        ListNode newhead = r.reverseList(head);
        while(newhead!=null){
            System.out.println(newhead.val);
            newhead = newhead.next;
        }
    }
    public ListNode reverseList(ListNode head){
        //1.迭代法
//        ListNode pre = null;
//        ListNode cur = head;
//        while(cur!=null){
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
        //2.头插法
        ListNode pre = head;
        ListNode cur = head;
        while(cur.next!=null){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre;
            pre = next;
        }
        return pre;
    }
}
