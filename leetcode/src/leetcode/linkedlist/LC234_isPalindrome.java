package leetcode.linkedlist;

public class LC234_isPalindrome {
    public static void main(String[] args) {
        LC234_isPalindrome p = new LC234_isPalindrome();
        ListNode head = ListNode.createList(1,2,3,2,1);
        System.out.println(p.isPalindrome(head));
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode st = reverse(slow);
        while(head!=null&&st!=null){
            if(head.val!=st.val){return false;}
            head = head.next;
            st = st.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next= cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
