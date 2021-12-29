package datastructures;

import datastructures.MyLinkedList;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Patrick on 6/26/2015.
 */
public class MyLinekdListTest {

    @Test
    public void PopulateLinkedList() {
        MyLinkedList myList = new MyLinkedList(10, null);
        myList.addNewLink(new MyLinkedList(9, null));
        myList.addNewNode(11);
        Assert.assertEquals("11 10 9", myList);
    }

    @Test
    public void ReverseLinkedList() {
        MyLinkedList myList = new MyLinkedList(10, null);
        myList.addNewLink(new MyLinkedList(9, null));
        myList.addNewNode(11);
        myList.reverseList();
        Assert.assertEquals("9 10 11", myList);
    }

    @Test
    public void RemoveNode() {
        MyLinkedList myList = new MyLinkedList(10, null);
        myList.addNewLink(new MyLinkedList(9, null));
        myList.addNewNode(11);
        org.junit.Assert.assertEquals(11, myList.removeNode());
        Assert.assertEquals("10 9", myList.toString().trim());
    }

    @Test
    public void RemoveLink() {
        MyLinkedList myList = new MyLinkedList(10, null);
        myList.addNewLink(new MyLinkedList(9, null));
        myList.addNewNode(11);
        Assert.assertEquals(9, myList.removeEndLink());
        Assert.assertEquals("11 10", myList.toString().trim());
    }
}
