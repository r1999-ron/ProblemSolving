package blind_75;

class ListNodes {
    int val;
    ListNodes next;
    ListNodes(int val) { this.val = val; }
}
public class RemoveNthFromEnd {
    public static void printList(ListNodes head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
public static class RemoveNthNodeFromEnd {

        public ListNodes removeNthFromEnd(ListNodes head, int n) {
            ListNodes fast = head;
            ListNodes slow = head;
            for(int i=0; i<n; i++){
                fast = fast.next;
            }
            if(fast == null) return head.next;
            while(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
        }
}

    public static void main(String[] args){
        // Example: [1 → 2 → 3 → 4 → 5], n = 2
        ListNodes head = new ListNodes(1);
        head.next = new ListNodes(2);
        head.next.next = new ListNodes(3);
        head.next.next.next = new ListNodes(4);
        head.next.next.next.next = new ListNodes(5);

        RemoveNthNodeFromEnd sol = new RemoveNthNodeFromEnd();
        ListNodes result = sol.removeNthFromEnd(head, 2); // Should remove 4

        printList(result);  // Output: 1 2 3 5
    }
}
