import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
//        list.add(6);

        System.out.println(list.get(( list.size() / 2)));

        ListNode node6 = new ListNode(6, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = node1;

        ListNode node = head;
        while (node != null && node.next != null){
            head = head.next;
            node = node.next.next;
        }
        //return head;
        System.out.println(head.val);
    }
}
