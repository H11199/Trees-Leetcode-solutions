import java.util.*;

import jdk.nashorn.api.tree.Tree;

public class PreOrderInorderToTree {
    static int preorderindex = 0;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = ArrayToTree(preorder, 0, preorder.length - 1);
        PrintTree(root);
    }

    static TreeNode ArrayToTree(int[] preorder, int l, int r) {
        if (l > r)
            return null;
        int rootval = preorder[preorderindex++];
        TreeNode root = new TreeNode(rootval);
        root.left = ArrayToTree(preorder, l, map.get(rootval) - 1);
        root.right = ArrayToTree(preorder, map.get(rootval) + 1, r);
        return root;
    }

    static void PrintTree(TreeNode root) {
        if (root == null)
            return;
        PrintTree(root.left);
        System.out.print(root.val + " ");
        PrintTree(root.right);
    }
}
