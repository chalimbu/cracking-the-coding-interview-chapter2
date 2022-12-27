package co.com;

public class twodotfour {
    //2.4 Partition write code to partition a linked list around a value x such that all nodes less than x come before
    // all nodes greater than or equal to x. (IMPORTANT: the partition element x can appear anywhere in the "right partition"
    // i does not need to appear between the left and right paritions. the aditional spacing in the example below indicates
    // the partition. yes the output below is one of the many valid outputs
    //EXAMPLE
    // input 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [parition=5]
    // output 3 -> 1 -> 2         ->     10 -> 5 -> 5 -> 8

    public static void main(String args[]){
        int[] input={12,3,5,8,5,10,2,1,11};
        twodotfour tdf=new twodotfour();
        tdf.createListFromArray(input);
        tdf.printList();
        tdf.partition(10);
        tdf.printList();
    }

    public Node head=null;
    class Node{
        public int data;
        public Node next;
        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
    }

    public void createListFromArray(int[] input){
        for(int i=input.length-1;i>=0;i--){
            Node temporal=new Node(input[i],head);
            head=temporal;
        }
    }

    public void printList(){
        Node pointer=head;
        System.out.println();
        while(pointer!=null){
            System.out.print(" "+pointer.data);
            pointer=pointer.next;
        }
    }

    public void partition(int partition){
        if(head==null) return;
        Node tail=head;
        Node current=head;
        while(current!=null){
            Node next=current.next;
            if(current.data<partition){
                current.next=head;
                head=current;
            }else{
                tail.next=current;
                tail=current;
            }

            current=next;
        }
        tail.next=null;
    }
}
