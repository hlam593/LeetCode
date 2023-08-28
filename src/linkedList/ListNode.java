package linkedList;

/**
 * @Description: Definition for singly-linked list
 * @Auther: hlam
 * @Date: 2023/08/06
 */
public class ListNode {
    int val;

    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 打印链表
     * @param head
     * @return
     */
    public static String printLinkedList(ListNode head) {
        if (head == null) {
            return "[]";
        } else if (head.next == null) {
            return "[" + head.val + "]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head.next != null) {
            sb.append(head.val);
            if (head != null) {
                sb.append(",");
            }
            head = head.next;
        }
        sb.append(head.val).append("]");

        return sb.toString();
    }

    /**
     * 创建链表（根据int数组）
     * @param numbers
     * @return
     */
    public static ListNode constructListNode(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode preNode = dummyNode;
        for (int i = 0; i < numbers.length; i++) {
            ListNode currNode = new ListNode(numbers[i]);
            preNode.next = currNode;
            preNode = preNode.next;
        }

        return dummyNode.next;
    }
}
