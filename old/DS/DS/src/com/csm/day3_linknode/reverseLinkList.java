package com.csm.day3_linknode;

/**
 * @Author 快乐小柴
 * @Date 2022/10/6 15:31
 * @Version 1.0
 * 单链表反转
 */
public class reverseLinkList {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        Node head =reverseLinkList(n1);
        printNode(head);

    }

    public static Node reverseLinkList(Node head) {
        Node pre = null;
        Node next = null;
        while ( head != null) {
            //记住head的下一个位置
            next=head.next;
            //
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public static void printNode(Node head){
        while (head != null) {
            System.out.print(head.value+" ");
            head=head.next;
        }
    }
}

