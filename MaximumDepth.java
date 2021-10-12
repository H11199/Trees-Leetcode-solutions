public class MaximumDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int depth = GetMaxDepth(root);
        System.out.println(depth);
    }

    static int GetMaxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int lh = 1;
        int rh = 1;

        lh = 1 + GetMaxDepth(root.left);
        rh = 1 + GetMaxDepth(root.right);
        return Math.max(lh, rh);
    }
}
