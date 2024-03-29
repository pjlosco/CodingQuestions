package datastructures;

/**
 * Created by patricklosco on 2/3/15.
 */
public class MyLinkedList {

    private int value;
    private MyLinkedList restOfList;

    public MyLinkedList(int value, MyLinkedList restOfList) {
        this.value = value;
        this.restOfList = restOfList;
    }

    public int getNodeValue() {
        return value;
    }

    public MyLinkedList getRestOfList() {
        return restOfList;
    }

    public MyLinkedList reverseList() {
        MyLinkedList backwardsList = new MyLinkedList(value, null);
        if (restOfList != null) {
            restOfList.reverseList();
            restOfList.addNewLink(backwardsList);
        } else {

        }
        return restOfList;

//        LinkedList reversedPart = null;
//        LinkedList current = head;
//        while (restOfList != null) {
//            LinkedList next = current.restOfList;
//            restOfList.restOfList = reversedPart;
//            reversedPart = current;
//            current = next;
//        }
//        head = reversedPart;
    }

    public void addNewNode(int newValue) {
        restOfList = new MyLinkedList(value,restOfList);
        this.value = newValue;
    }

    public void addNewLink(MyLinkedList list) {
        if (restOfList != null) {
            restOfList.addNewLink(list);
        } else {
            restOfList = list;
        }
    }

    public int removeNode(){
        int returnValue = value;
        value = restOfList.getNodeValue();
        restOfList = restOfList.getRestOfList();
        return returnValue;
    }

    public int removeEndLink(){
        if (restOfList != null) {
            if (restOfList.restOfList != null) {
                return restOfList.removeEndLink();
            } else {
                int returnValue = restOfList.value;
                restOfList = null;
                return returnValue;
            }
        } else {
            return value;
        }
    }

    public String toString() {
        if (restOfList != null) {
            return value + " " + restOfList.toString();
        } else {
            return value + "";
        }
    }

}
