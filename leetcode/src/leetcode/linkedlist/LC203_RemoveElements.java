package leetcode.linkedlist;

public class LC203_RemoveElements {
    public static void main(String[] aargs){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        LC203_RemoveElements r = new LC203_RemoveElements();
        ListNode newhead = r.removeElements(n1,1);
        while(newhead!=null){
            System.out.println(newhead.val);
            newhead = newhead.next;
        }
    }
    public ListNode removeElements(ListNode head,int val){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while(prev.next!=null){
            if(prev.val==val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}
