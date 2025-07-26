package blind_75;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}
public class KthSmallestBST {
    private int k;
    private int ans;

    public int kthSmallest(TreeNode root, int k){
        this.k = k;
        helper(root);
        return ans;
    }
    private void helper(TreeNode node){
        if(node==null) return;
        helper(node.left);
        k--;
        if(k==0){
            ans = node.val;
            return;
        }
        helper(node.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        KthSmallestBST solution = new KthSmallestBST();
        int k = 3;
        int kthSmallest = solution.kthSmallest(root, k);
        System.out.println("The " + k + "rd smallest element in the BST is: " + kthSmallest);
    }
}
