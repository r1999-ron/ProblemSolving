package interview_specific_prep;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node left, right, next;

    Node(int val) {
        this.val = val;
    }
}

public class ConnectNextRightPointers {
    
    public Node connect(Node root) {
        if (root == null) return null;

        Node leftMost = root;
        while (leftMost.left != null) {
            Node curr = leftMost;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            leftMost = leftMost.left;

        }

        return root;
    }

    // For checking results - prints each level using next pointers
    public void printLevels(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node curr = levelStart;
            while (curr != null) {
                System.out.print(curr.val + " ");
                curr = curr.next;
            }
            System.out.println("#"); // end of level
            levelStart = levelStart.left;
        }
    }

    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \   / \
            4  5  6   7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ConnectNextRightPointers solution = new ConnectNextRightPointers();
        solution.connect(root);
        solution.printLevels(root);
    }
}
