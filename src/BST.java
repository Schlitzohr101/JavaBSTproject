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

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }
    private Node root;
    public BST() {root = null;}

    public int getRoot() {
        return (root == null ? -1 : root.getValue());
    }
    public int getCount() {
        //error check for if the tree is empty
        return (getRoot() < 0 ? 0 : 1+getCount(root));
    }
    private int getCount(Node N) {
        if (N.getLeft() != null) {
            return 1 + getCount(N.getLeft());
        } else if (N.getRight() != null) {
            return 1 + getCount(N.getRight());
        } else {
            return 0;
        }
    }
    public int findLevel(int x) {
        return findLevel(root,x,0);
    }
    private int findLevel(Node N, int x, int level) {
        if (N != null) {
            if (N.getValue() == x) {
                return level;
            } else {
                findLevel(N.getLeft(), x, level + 1);
                findLevel(N.getRight(), x, level + 1);
            }
        }
        return -1;
    }
    public Node findNode(int x) {
        return (root == null ? null : findNode(root,x));
    }
    private Node findNode(Node N, int x) {
        if (N != null) {
            if(N.getValue() == x) {
                return N;
            } else {
                findNode(N.getLeft(),x);
                findNode(N.getRight(),x);
            }
        }
        return null;
    }
    public int findParent(int x) {
        //set found node, and check to see if any was found, else return the parent of the node
        Node n = findNode(root,x);
        return (n == null ? -1 : n.getParent().getValue());
    }
    public int findLeftChild(int x) {
        //set found node, and check to see if it it was found. If it is then check to see if left child is null, else
        //return the left child
        Node n = findNode(root,x);
        return (n == null ? -1 : n.getLeft() == null ? -1 : n.getLeft().getValue());
    }
    public int findRightChild(int x) {
        //set found node, and check to see if it it was found. If it is then check to see if right child is null, else
        //return the right child
        Node n = findNode(root,x);
        return (n == null ? -1 : n.getRight() == null ? -1 : n.getRight().getValue());
    }
    public void add(int x) {

    }
    private void add(Node N, int x) {
        //Check to see if the value is less than or equal to the current node
        if (x <= N.getValue()) {
            //Check to see if the current Node has a left child
            if (N.getLeft() != null) {
                //if it exists then continue the recursive step
                add(N.getLeft(),x);
            } else {
                //add to the left child of the current node
                Node newNode = new Node(x);
                N.setLeft(newNode);
                newNode.setParent(N);
            }
        } else {
            //check to see if the current Node has a right child
            if (N.getRight() != null) {
                //if exists then continue recursive step
                add(N.getRight(),x);
            } else {
                //add to the right child of the current node
                Node newNode = new Node(x);
                N.setRight(newNode);
                newNode.setParent(N);
            }
        }
    }
    public boolean isBalanced() {
        return isBalanced(root);
    }
    private boolean isBalanced(Node N) {
        int lh = 0;
        int rh = 0;

        if (N == null) {
            return true;
        }
        lh = getHeight(N.getLeft());
        rh = getHeight(N.getRight());

        if ( Math.abs(lh - rh) <= 1 && isBalanced(N.getLeft()) && isBalanced(N.getRight())) {
            return true;
        }

        return false;
    }
    public int getHeight() {
        return getHeight(root);
    }
    private int getHeight(Node N) {
        int lh = 0; //height of each sub tree
        int rh = 0; //height of each sub tree
        //check to see if the node has a left child, then a right child
        if (N.getLeft() != null) {
            //if the node has a left child return the height of that node plus the height of the current node
            lh = 1+getHeight(N.getLeft());
        } else if (N.getRight() != null) {
            //if the node has a right child return the height of that node plus the height of the current node
            rh = 1+getHeight(N.getRight());
        }
        // check to see which of the subtrees are larger and return it
        return (lh >= rh ? lh : rh);
    }

}
