package co.com;

public class SingleLinkedList {

    public Node head=null;
    public void prependArrayToList(char[] input){
        for(int i=input.length-1;i>=0;i--){
            Node temporal= new Node(input[i],head);
            head=temporal;
        }
    }

    public void printList(){
        System.out.print("[");
        Node pointer=head;
        while(pointer!=null){
            System.out.print(pointer.data+",");
            pointer=pointer.next;
        }
        System.out.println("]");
    }
}
