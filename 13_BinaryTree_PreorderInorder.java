import java.util.HashMap;
import java.util.Map;
public class BuildTreeFromTraversals {
 static class TreeNode {
 int val;
 TreeNode left, right;
 TreeNode(int val) {
 this.val = val;
 }
 }
 private static Map<Integer, Integer> inorderIndexMap;
 private static int preIndex;
 public static TreeNode buildTree(int[] preorder, int[] inorder) {
 inorderIndexMap = new HashMap<>();
 for (int i = 0; i < inorder.length; i++) {
 inorderIndexMap.put(inorder[i], i);
 }
 preIndex = 0;
 return build(preorder, 0, inorder.length - 1);
 }
 private static TreeNode build(int[] preorder, int inStart, int inEnd) {
 if (inStart > inEnd) return null;
 int rootVal = preorder[preIndex++];
 TreeNode root = new TreeNode(rootVal);
 int inIndex = inorderIndexMap.get(rootVal);
 root.left = build(preorder, inStart, inIndex - 1);
 root.right = build(preorder, inIndex + 1, inEnd);
 return root;
 }
 public static void main(String[] args) {
 int[] preorder = {3, 9, 20, 15, 7};
 int[] inorder = {9, 3, 15, 20, 7};
 TreeNode root = buildTree(preorder, inorder);
 }
}
