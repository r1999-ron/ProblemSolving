package blind_75;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}

public class LinkedListReversal {
    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);

      System.out.println("Original List: ");
      printList(head);

      ListNode reversed = reverseList(head);
      System.out.println("Reversed List: ");
      printList(reversed);
    }

    private static void printList(ListNode head) {
        while(head!=null){
            System.out.print(head.val+" -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev= null;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
