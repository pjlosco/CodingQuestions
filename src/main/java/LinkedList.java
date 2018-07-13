/**
 * Created by patricklosco on 2/3/15.
 */
public class LinkedList {

    private int value;
    private LinkedList restOfList;

    public LinkedList(int value, LinkedList restOfList) {
        this.value = value;
        this.restOfList = restOfList;
    }

    public int getNodeValue() {
        return value;
    }

    public LinkedList getRestOfList() {
        return restOfList;
    }

    public LinkedList reverseList() {
        LinkedList backwardsList = new LinkedList(value, null);
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
        restOfList = new LinkedList(value,restOfList);
        this.value = newValue;
    }

    public void addNewLink(LinkedList list) {
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
