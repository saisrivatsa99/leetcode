/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node pointer = head;
        Node curr, nxt, ch;
        while(pointer!= null){
            if(pointer.child!= null){
                Node tail = findTail(pointer.child);
                if(pointer.next != null) pointer.next.prev = tail;
                tail.next = pointer.next;
                pointer.next = pointer.child;
                pointer.child.prev = pointer;
                pointer.child = null;
            }
            pointer = pointer.next;
        }
        return head;
    }

    public Node findTail(Node child){
        while(child.next != null){
            child = child.next;
        }
        return child;
    }
}