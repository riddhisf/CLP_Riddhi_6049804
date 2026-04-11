package Activity2;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class SinglyLinkedList{
    Node head;

    public void insertAtPosition(int data,int pos){
        Node newNode=new Node(data);
        if(pos==0){
            newNode.next=head;
            head=newNode;
            return;
        }
        Node temp=head;
        for(int i=0;i<pos-1&&temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Invalid position");
            return;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public void deleteByValue(int value){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.data==value){
            head=head.next;
            return;
        }
        Node prev=head;
        Node curr=head.next;
        while(curr!=null&&curr.data!=value){
            prev=curr;
            curr=curr.next;
        }
        if(curr==null){
            System.out.println("Value not found");
            return;
        }
        prev.next=curr.next;
    }

    public int countNodes(){
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    public int findMiddle(){
        if(head==null){
            throw new RuntimeException("List is empty");
        }
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }

    public void reverse(){
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        head=prev;
    }

    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println("null");
    }
}

public class Q3{
    public static void main(String[] args){
        SinglyLinkedList list=new SinglyLinkedList();
        list.insertAtPosition(10,0);
        list.insertAtPosition(20,1);
        list.insertAtPosition(30,2);
        list.insertAtPosition(15,1);
        list.display();
        list.deleteByValue(20);
        list.display();
        System.out.println(list.countNodes());
        System.out.println(list.findMiddle());
        list.reverse();
        list.display();
    }
}
