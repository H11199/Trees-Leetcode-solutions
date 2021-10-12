import java.util.*;

class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Print(root);
        List<List<Integer>> res = levelorder(root);
        System.out.println(res);
    }

    static void Print(TreeNode root) {
        if (root == null)
            return;
        Print(root.left);
        System.out.println(root.val);
        Print(root.right);
    }

    static List<List<Integer>> levelorder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int s = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < s; i++) {
                TreeNode temp = q.poll();
                if (temp != null) {
                    list.add(temp.val);
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
