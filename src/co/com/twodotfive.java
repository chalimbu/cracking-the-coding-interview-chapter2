package co.com;

public class twodotfive {
    /* you have 2 single linked list with the number store in forward order. sum the number in the list
     * without transforming the list back to integers.
     *
     * input (6 -> 1 -> 7) + (2 -> 9 -> 5). That is 617 + 295
     *
     * output( 9 -> 1 -> 2). That is 912
     */

    class PartialSum{
        public Node sum=null;
        public int carry=0;
    }

    public static void main(String[] args){
        SingleLinkedList sl1=new SingleLinkedList();
        sl1.prependArrayToList(new int[]{6, 1, 7});
        sl1.printList();

        SingleLinkedList sl2=new SingleLinkedList();
        sl2.prependArrayToList(new int[]{5,9,5});
        sl2.printList();

        twodotfive sumList=new twodotfive();
        SingleLinkedList result=new SingleLinkedList();
        result.head=sumList.addList(sl1.head,sl2.head);
        result.printList();
    }

    Node addList(Node list1,Node list2){
        int len1=length(list1);
        int len2=length(list2);

        /* pad the shorter list with zeros, so it matches with different lenght number */
        if(len1 < len2){
            list1=padList(list1,len2-len1);
        }else{
            list2=padList(list2,len1-len2);
        }

        /** Add list */
        PartialSum sum = addListHelper(list1,list2);

        /** if there was a carry value left over, insert this at the front of the list
         otherwise, just return the linkedlist
         */
        if(sum.carry==0){
            return sum.sum;
        } else{
            Node newHead=new Node(sum.carry,sum.sum);
            return newHead;
        }
    }

    PartialSum addListHelper(Node list1,Node list2){
        if(list1==null && list2==null){
            PartialSum sum=new PartialSum();
            return sum;
        }
        /**Add smaller digits recursively */
        PartialSum sum= addListHelper(list1.next,list2.next);

        /**Add carry to the current data */
        int val=sum.carry+list1.data+list2.data;

        /** Insert sum of current digits */
        Node full_result=new Node(val%10,sum.sum);

        sum.sum=full_result;
        sum.carry= val/10;
        return sum;
    }

    int length(Node node){
        Node pointer=node;
        int length=0;
        while(pointer!=null){
            length++;
            pointer=pointer.next;
        }
        return length;
    }

    Node padList(Node node,int padding){
        Node newHead=node;
        for(int i=0;i<padding;i++){
            Node temporal=new Node(0,newHead);
            newHead=temporal;
        }
        return newHead;
    }
}
