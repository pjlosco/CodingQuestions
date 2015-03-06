/**
 * Created by patricklosco on 2/3/15.
 */
public class LinkedList {
    int value;
    LinkedList restOfList;

    public LinkedList reverseLinkedList(LinkedList list) {
        LinkedList reversedList = new LinkedList();
        if (list.restOfList == null) {

        } else {
            reverseLinkedList(restOfList);
        }
        return null;
    }

    public void addTop(LinkedList list) {

    }

    public static void main(String[] args) {

    }

}
