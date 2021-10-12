import jdk.nashorn.api.tree.Tree;

class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        Print(root);
        System.out.println(isSymmetric(root));
    }

    static void Print(TreeNode root) {
        if (root == null)
            return;
        Print(root.left);
        System.out.println(root.val);
        Print(root.right);
    }

    static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return HelperSymmetric(root.left, root.right);
    }

    static boolean HelperSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null)
            return true;
        if (l == null || r == null)
            return false;
        if (l.val != r.val)
            return false;
        if (!HelperSymmetric(l.left, r.right))
            return false;
        if (!HelperSymmetric(l.right, r.left))
            return false;
        return true;
    }
}
