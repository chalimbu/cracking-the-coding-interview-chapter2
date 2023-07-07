package co.com;

public class question28{
    public static void main(String[] args){
        //   A  -> B -> C -> null
        //
        //  A -> B -> C -> D -> C

        Node d=new Node('d',null);
        Node c=new Node('c',d);

        Node b=new Node('b',c);
        c.next=b;
        Node a=new Node('a',b);

        Node result=loopDetection(a);
        if(result==null){
            System.out.println("no loop");
        }else{
            System.out.println("beggining of the loop at "+result.data);
        }
    }

    public static Node loopDetection(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(fast==null||fast.next==null||fast.next.next==null){
            return null;
        }
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}



