package interview_specific_prep;
/*### How the Reversal Works
For input list `1 -> 2 -> 3`:
1. **Initial state**:
    - `prev = null`
    - `curr = 1`
    - List: `1 -> 2 -> 3`

2. **First iteration**:
    - Save `temp = 2`
    - Point `1->null`
    - Move to `1` `prev`
    - Move to `2` `curr`

3. **Second iteration**:
    - Save `temp = 3`
    - Point `2->1`
    - Move to `2` `prev`
    - Move to `3` `curr`

4. **Third iteration**:
    - Save `temp = null`
    - Point `3->2`
    - Move to `3` `prev`
    - Move to `null` `curr`

5. **Final result**: `3 -> 2 -> 1 -> null`

### Time & Space Complexity
- Time Complexity: O(n) where n is the number of nodes
- Space Complexity: O(1) as it uses constant extra space
*/
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
