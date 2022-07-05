package co.com;
import java.util.Set;
import java.util.HashSet;

public class twodotone<A> {
    //2.1 pag 94 cracking the coding interview.
    // Remove dups Write code to remove duplicates from an unsorted linked list.
    //Follow up.
    //How would you solve this problem if a temporary buffer is not allowed.
    public Node head=null;

    public static void main(String []args){
        twodotone<Integer> exercise=new twodotone<Integer>();
        Integer[] inputList={1,1,2,3,4,1,5,6,3,7,7};
        exercise.head=exercise.createLinkedList(inputList);
        exercise.printLinkedList(exercise.head);
        System.out.println("////////////////////");
        exercise.removeDuplicates();
        exercise.printLinkedList(exercise.head);
    }

    public  Node removeDuplicates(){
        Set<A> alreadyKnown=new HashSet<A>();
        if(head!=null) {
            Node pointer = head;
            Node previous=null;
            alreadyKnown.add(pointer.data);
            do {
                previous=pointer;
                pointer = pointer.next;
                if(!alreadyKnown.contains(pointer.data)){
                    alreadyKnown.add(pointer.data);
                }else{
                    previous.next=pointer.next;
                }
            } while (pointer.next != null);
        }
        return head;
    }

    public Node createLinkedList(A[] data){
        Node tempHead= null;
        for(int i=data.length-1;i>=0;i--){
            Node current= new Node(data[i]);
            current.next=tempHead;
            tempHead=current;
        }
        return tempHead;
    }


    public boolean printLinkedList(Node head){
        if(head==null) return false;
        Node pointer=head;
        System.out.println(pointer.data);
        do{
            pointer=pointer.next;
            System.out.println(pointer.data);
        }while(pointer.next!=null);
        return true;
    }

    class Node{
        public Node next=null;
        public A data=null;
        Node(A data){
            this.data=data;
        }
    }
}
