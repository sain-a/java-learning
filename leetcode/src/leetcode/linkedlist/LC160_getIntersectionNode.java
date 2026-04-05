package leetcode.linkedlist;

public class LC160_getIntersectionNode {
    public static void main(String[] args){
        LC160_getIntersectionNode g = new LC160_getIntersectionNode();
        ListNode headA = ListNode.createList(4,1,8,4,5);
        ListNode headB = ListNode.createList(3,6);
        ListNode intersectNode = headA.next.next;
        ListNode tailB = headB.next;
        tailB.next = intersectNode;
        ListNode.printList(g.getIntersectionNode(headA,headB));
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA!=pB){
            pA = pA==null?headB:pA.next;
            pB = pB == null?headA:pB.next;
        }
        return pA;
    }
}
