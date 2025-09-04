package interview_specific_prep;

class TreeNodes {
    int val;
    TreeNodes left;
    TreeNodes right;
    TreeNodes(int x) { val = x; }
}

public class FlattenBinaryTree {
    private TreeNodes prev = null;

    public void flatten(TreeNodes root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    // Helper method to print flattened list
    public void printFlattened(TreeNodes root) {
        TreeNodes curr = root;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNodes root = new TreeNodes(1);
        root.left = new TreeNodes(2);
        root.right = new TreeNodes(5);
        root.left.left = new TreeNodes(3);
        root.left.right = new TreeNodes(4);
        root.right.right = new TreeNodes(6);

        FlattenBinaryTree solution = new FlattenBinaryTree();
        solution.flatten(root);

        // Print result after flattening
        solution.printFlattened(root);
    }
}
