package blind_75;
/*### How It Works
1. **Floyd's Algorithm** uses two pointers:
    - pointer moves one step at a time `slow`
    - pointer moves two steps at a time `fast`

2. **Cycle Detection Logic**:
    - If there's a cycle, the fast pointer will eventually catch up to the slow pointer
    - If there's no cycle, the fast pointer will reach the end of the list

3. **Test Cases** in main method:
    - Test Case 1: Creates a linked list with a cycle: 3 → 2 → 0 → -4 → 2 (cycles back)
    - Test Case 2: Creates a linear linked list: 1 → 2 → 3

### Time and Space Complexity
- Time Complexity: O(n), where n is the number of nodes
- Space Complexity: O(1), uses only two pointers regardless of list size

### Example Output
```
Test case 1 - Has cycle: true
Test case 2 - Has cycle: false
```
This algorithm is very efficient for detecting cycles in linked lists as it uses constant extra space and doesn't modify the original list structure
*/
public class DetectCycleLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test case 1: List with cycle
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;  // Create cycle

        System.out.println("Test case 1 - Has cycle: " + hasCycle(node1));

        // Test case 2: List without cycle
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println("Test case 2 - Has cycle: " + hasCycle(head));
    }
}
