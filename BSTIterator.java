import java.util.Stack;

public class BSTIterator {
    Stack<Node> bstStack;
    public BSTIterator(Node root) {
        bstStack = new Stack<Node>();
        while (root != null) {
            bstStack.push(root);
            root = root.left;
        }
    }
    public boolean hasNext() {
        return bstStack.isEmpty()==false;
    }
    public TreeNode next() {
        Node node = bstStack.pop();
        TreeNode nextNode = node.key;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                bstStack.push(node);
                node = node.left;
            }
        }
        return nextNode;
    }
}