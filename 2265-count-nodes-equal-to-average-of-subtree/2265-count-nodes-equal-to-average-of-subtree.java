/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int averageOfSubtree(TreeNode root) {
        // Post order traversal
        int res = 0;
        HashMap<TreeNode, List<Integer>> m = new HashMap<>();
        Stack<Object[]> st = new Stack<>();
        
        st.push(new Object[]{root, false});
        m.put(null, Arrays.asList(0,0));
        
        while (!st.isEmpty()) {
            Object[] item = st.pop();
            TreeNode node = (TreeNode) item[0];
            boolean seen = (boolean) item[1];
            
            if (!seen) {
                st.push(new Object[]{node, true});
                
                if (node.right != null)
                    st.push(new Object[]{node.right, false});
                if (node.left != null)
                    st.push(new Object[]{node.left, false});
                
            } else {
                List<Integer> left = m.get(node.left);
                List<Integer> right = m.get(node.right);
                
                int cur_sum = node.val + left.get(0) + right.get(0);
                int cur_nodes = 1 + left.get(1) + right.get(1);
                int cur_avg = cur_sum / cur_nodes;
                
                if (cur_avg == node.val)
                    res++;
                
                m.put(node, Arrays.asList(cur_sum, cur_nodes));
            }
        }
        
        return res;
    }
}