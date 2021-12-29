package datastructures;

import org.junit.Assert;
import org.junit.Test;

public class BinaryLinkedListToInteger {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder("[" + val);
            ListNode next = this.next;
            while (next != null) {
                output.append(",");
                output.append(next.val);
                next = next.next;
            }
            output.append("]");
            return output.toString();
        }
    }

    public int getDecimalValue(ListNode head) {
        String binary = getBinaryString(head);
        return Integer.parseInt(binary.toString(), 2);
    }

    public String getBinaryString(ListNode head) {
        String binary = "" + head.val;
        if (head.next != null) {
            binary = binary + getBinaryString(head.next);
        }
        return binary;
    }

    @Test
    public void test1() {
        ListNode input = new ListNode(1, new ListNode(0, new ListNode(1)));
        getDecimalValue(input);
        Assert.assertEquals(5, getDecimalValue(input));
    }
}
