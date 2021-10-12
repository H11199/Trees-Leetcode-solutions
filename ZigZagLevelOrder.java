import java.util.*;

public class ZigZagLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = ZigZaglevelorder(root);
        System.out.println(res);
    }

    static List<List<Integer>> ZigZaglevelorder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean ltor = true;
        while (!q.isEmpty()) {
            int s = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                TreeNode t = q.poll();
                if (t != null) {
                    if (ltor) {
                        temp.add(t.val);
                    } else {
                        temp.add(0, t.val);
                    }
                    if (t.left != null) {
                        q.add(t.left);
                    }
                    if (t.right != null) {
                        q.add(t.right);
                    }
                }
            }
            res.add(temp);
            ltor = !ltor;
        }
        return res;
    }
}
