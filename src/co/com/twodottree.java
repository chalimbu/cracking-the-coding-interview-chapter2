package co.com;

public class twodottree<A>{

    class Node{
        public A data;
        public Node next;

        public Node(A data,Node next){
            this.data=data;
            this.next=next;
        }
    }

    public Node head=null;

    void prependToList(A[] input){
        Node temporal=null;
        for(int i=input.length-1;i>=0;i--){
            temporal=new Node(input[i],head);
            head=temporal;
        }
    }

    void printList(){
        Node temporal=head;
        if(temporal!=null){
            System.out.print(" ");
            while(temporal!=null){
                System.out.print(" "+temporal.data);
                temporal=temporal.next;
            }
        }
    }

    public static void main(String args[]){
        twodottree ll=new twodottree<Integer>();
        Integer[] initialList={1,2,34,4,5,3};
        ll.prependToList(initialList);
        ll.printList();
        ll.deleteMidle(ll.head.next.next.next.next.next);
        ll.printList();

    }

    public void deleteMidle(Node n){
        Node current=n;
        Node prevToCurrent=current;
        if(current!=null){
            Node next=n.next;
            while(next!=null){
                current.data=next.data;
                prevToCurrent= current;
                current=next;
                next=next.next;
            }
            prevToCurrent.next=null;
        }
    }


}