/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        // 当前节点是head，pre是当前节点的前一节点，next是当前节点的下一节点
        ListNode pre = null;
        ListNode next = null;
        // 循环，让当前节点从指向next到指向pre，可以达到反转链表的效果
        while(head != null) {
            // 先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.next;
            head.next = pre;
            // head指向pre后，就继续依次反转下一个节点
            pre = head;
            head = next;
        }
        // 直接输出pre就是我们要得到的反转后的链表
        return pre;
    }
}