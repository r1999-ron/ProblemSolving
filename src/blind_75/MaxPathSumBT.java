package blind_75;

public class MaxPathSumBT {
    public static void main(String[] args){
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxPathSumBT solution = new MaxPathSumBT();
        int maxPathSum = solution.maxPathSum(root);
        System.out.println("The maximum path sum in the Binary Tree is: " + maxPathSum);
    }

    private int maxPathSum(TreeNode root) {
        int[] res = {root.val};
        dfs(root, res);
        return res[0];

    }

    private static int dfs(TreeNode node, int[] res){
        if(node == null) return 0;
        int leftSum = Math.max(0, dfs(node.left, res));
        int rightSum = Math.max(0, dfs(node.right, res));
        res[0] = Math.max(res[0], leftSum + rightSum + node.val);
        return Math.max(leftSum,rightSum)+node.val;
    }

}
