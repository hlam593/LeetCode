package linkedList;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Description:
 * @Auther: hlam
 * @Date: 2023/08/06
 */
public class Solution {

    /**
     * 23. 合并 K 个升序链表
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }

    @Test
    public void test() {
        int[] head = {1, 2, 3, 4};
        ListNode node = ListNode.constructListNode(head);
        ListNode res = swapPairs(node);
        System.out.println(ListNode.printLinkedList(res));
        System.out.println(ListNode.printLinkedList(
                mergeKLists(
                        new ListNode[]{
                                ListNode.constructListNode(new int[]{1, 4, 5}),
                                ListNode.constructListNode(new int[]{1, 3, 4}),
                                ListNode.constructListNode(new int[]{2, 6})
                        }
                )
                )
        );
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
