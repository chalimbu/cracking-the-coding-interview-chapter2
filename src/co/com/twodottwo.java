package co.com;



public class twodottwo<A>{
    //pag 94
    //2.2 return kth to last: implement an algorithm to find the kth to las element of a single linked list.
    class Node{
        A data;
        Node next;
        public Node(A data,Node next){
            this.data=data;
            this.next=next;
        }
    }

    public Node head;

    public void createListFromArray(A[] input){
        for(int i=input.length-1;i>=0;i--){
            Node current=new Node(input[i],head);
            head=current;
        }
    }

    public void printList(){
        Node pointer=head;
        while(pointer!=null){
            if(pointer!=null && pointer.data!=null){
                System.out.println(" "+pointer.data);
                pointer=pointer.next;
            }
        }
    }

    public A getKthToLast(int k){
        Wrapper result= getKthToLastRecursive(k,head);
        if(result.reachedDestination){
            return result.node.data;
        }else{
            return null;
        }
    }

    private  Wrapper getKthToLastRecursive(int k, Node current){
        if(current==null){
            return new Wrapper(0,current,false);
        }
        Wrapper recursiveResult=getKthToLastRecursive(k,current.next);
        if(recursiveResult.reachedDestination){
            return recursiveResult;
        }else{
            int counter=recursiveResult.counter+1;
            if(counter==k){
                return new Wrapper(counter,current,true);
            }else{
                return new Wrapper(counter,current,false);
            }
        }

    }

    class Wrapper{
        int counter;
        Node node;
        boolean reachedDestination;
        public Wrapper(int counter,Node data,boolean reachedDestination){
            this.counter=counter;
            this.node=data;
            this.reachedDestination=reachedDestination;
        }
    }

    public static void main(String[] args){
        twodottwo td=new twodottwo<Integer>();
        Integer[] input={1,34,23,4,5,23,12};
        td.createListFromArray(input);
        td.printList();
        System.out.println("");
        System.out.println(""+td.getKthToLast(1));//12
        System.out.println(""+td.getKthToLast(2));//23
        System.out.println(""+td.getKthToLast(3));//5
        System.out.println(""+td.getKthToLast(100));//null
    }

}


