package blind_75;

public class MaxDepthBinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxDepthBinaryTree solution = new MaxDepthBinaryTree();
        int maxDepth = solution.maxDepth(root);
        System.out.println("The maximum depth in the Binary Tree is: " + maxDepth);
    }
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        if(leftMaxDepth > rightMaxDepth){
            return leftMaxDepth + 1;
        } else{
            return rightMaxDepth + 1;
        }

    }
}
