package datastructures;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortList {

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

    
    public ListNode insertionSortList(ListNode head) {
        // if linked list attached to the head, there is something to sort
        if (head == null) {
            return head;
        }
        if (head.next != null) {
            // get to bottom of list before sorting backwards
            ListNode sortedList = insertionSortList(head.next);
            // on first time this part runs it will be position end -1
            if (head.val > sortedList.val) {
                // if going back its out of order resort values
                int temp = head.val;
                head.val = sortedList.val;
                sortedList.val = temp;

                head.next = insertionSortList(head.next);
            }
        }
        return head;
    }


    @Test
    public void test1() {
        ListNode input = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode actual = insertionSortList(input);
        String expected = "[1,2,3,4]";
        Assert.assertEquals(expected, actual.toString());
    }
}
