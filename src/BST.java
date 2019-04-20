/*  Name: William Murray
 *  Class: CECS 274
 *  Project #5
 *  Due: 04/30/2019
 * */
public class BST {
    private class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;
        public Node(int x) {
             value = x;
             left = null;
             right = null;
             parent = null;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Node getParent() {
            return parent;
        }
    }
    private Node root;
    public BST() {root = null;}

    public int getRoot() {
        return (root == null ? 0 : root.getValue());
    }
    public int getCount() {
        return 1 + getCount(root);
    }
    public int getCount(Node N) {
        if (N.getLeft() != null) {
            return 1 + getCount(N.getLeft());
        } else if (N.getRight() == null) {
            return 1 + getCount(N.getRight());
        } else {
            return 0;
        }
    }
}
