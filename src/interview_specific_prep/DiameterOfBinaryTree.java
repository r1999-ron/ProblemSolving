package interview_specific_prep;

class TreeNod {
    int val;
    TreeNod left, right;
    TreeNod(int x) { val = x; }
}

public class DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNod root) {
        height(root);
        return diameter;
    }

    private int height(TreeNod node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        // Update diameter at this node
        diameter = Math.max(diameter, left + right);

        // Return height of this subtree
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNod root = new TreeNod(1);
        root.left = new TreeNod(2);
        root.right = new TreeNod(3);
        root.left.left = new TreeNod(4);
        root.left.right = new TreeNod(5);

        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        System.out.println("Diameter: " + solution.diameterOfBinaryTree(root)); // Output: 3
    }
}
