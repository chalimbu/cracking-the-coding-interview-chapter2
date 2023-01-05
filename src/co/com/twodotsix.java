package co.com;

public class twodotsix{
    public static void main(String [] args){
        SingleLinkedList sl=new SingleLinkedList();
        sl.prependArrayToList(new char[]{'o','n','a','b','b','a','n','o','b'});
        sl.printList();

        twodotsix tds=new twodotsix();
        System.out.println(" "+tds.isPalindrome(sl.head));
        System.out.println('z'=='z');

    }

    class ResultWrapper{
        public boolean isPalindrome;
        public Node head;
        public int countFromEnd;

        public ResultWrapper(boolean isPalindrome,Node head,int countFromEnd){
            this.isPalindrome=isPalindrome;
            this.head=head;
            this.countFromEnd=countFromEnd;
        }
    }
    public int len(Node l){
        int counter=0;
        Node pointer=l;
        while(pointer!=null){
            counter++;
            pointer=pointer.next;
        }
        return counter;
    }

    public boolean isPalindrome(Node l){
        int len=len(l);
        ResultWrapper r=isPalindromeRecursive(l,l,len/2);
        return r.isPalindrome;
    }

    private ResultWrapper isPalindromeRecursive(Node current,Node head,int halfLength){
        if(current==null){
            return new ResultWrapper(true,head,0);
        }
        ResultWrapper rw=isPalindromeRecursive(current.next,head,halfLength);

        /**if a previous call say is not a palindrome or if the center was already reached */
        if(!rw.isPalindrome || rw.countFromEnd>=halfLength){
            return rw;
        }

        if(current.data==rw.head.data){
            return new ResultWrapper(true,rw.head.next,rw.countFromEnd+1);
        }else{
            return new ResultWrapper(false,rw.head.next,rw.countFromEnd+1);
        }
    }


}
