package interview_specific_prep;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBinaryTree {
    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \   \
          4   5   6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.print("Left view of the binary tree: ");
        printLeftView(root);
    }
    private static void printLeftView(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    System.out.print(node.val + " ");
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }


}
