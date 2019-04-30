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
        return (root == null ? 0 : root.getValue());
    }
    public int getCount() {
        //error check for if the tree is empty
        return (getRoot() <= 0 ? 0 : 1+getCount(root));
    }
    private int getCount(Node N) {

        if (N == null) {
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
        if (root == null) {
            Node newNode = new Node(x);
            root = newNode;
        } else {
            add(root, x);
        }
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
        if (N != null) {
            if (N.getLeft() != null) {  //check to see if the node has a left child, then a right child
                //if the node has a left child return the height of that node plus the height of the current node
                lh = 1 + getHeight(N.getLeft());
            } else if (N.getRight() != null) {
                //if the node has a right child return the height of that node plus the height of the current node
                rh = 1 + getHeight(N.getRight());
            }
        }
        // check to see which of the subtrees are larger and return it
        return (lh >= rh ? lh : rh);
    }

    public void display() {
        if (root == null) {
            System.out.println("Empty Tree");
        } else {
            display(root);
        }
    }
    private void display(Node N) {
        if (N == null) {
            return;
        } else {
            display(N.getLeft());
            System.out.print(N.getValue());
            System.out.print(", ");
            display(N.getRight());
        }
    }

    public void displayTree() {
        String [] A = new String[32]; //create array placeholder
        for(int i = 0; i<32; i++) {
            A[i] = " . ";
        }
        String temp;
        if (root == null) {
            temp = " . ";
        } else {
            temp = Integer.toString(root.getValue());
        }
        A[1] = temp;

        buildArray(root, A, 1);
        //System.out.println("         1         2         3         4         5         6         7         8         9         0");
        //System.out.println("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
          System.out.println("                                                                ");
          System.out.println("                                               "+ A[1]+"        ");
          System.out.println("                                                |               ");
          System.out.println("                     "+A[2]+"-------------------------^-----------------------"+A[3]);
          System.out.println("                       |                                         |  ");
          System.out.println("          "+A[4]+"-----------^-----------"+A[5]+"                "+A[6]+"-----------^-----------"+A[7]);
          System.out.println("           |                         |                        |  |       ");
          System.out.println("    "+A[8]+"----^----"+A[9]+"           "+A[10]+"----^----       "+A[11]+"            "+A[12]+" ----^----"+A[13]+"           "+A[14]+"----^----"+A[15]);
          System.out.println("     |            |            |            |            |            |            |            |     ");
          System.out.println(A[16]+"-^-"+A[17]+"    "+A[18]+"-^-"+A[19]+"    "+A[20]+"-^-"+A[21]+"    "+A[22]+"-^-"+A[23]+"    "+A[24]+"-^-"+A[25]+"    "+A[26]+"-^-"+A[27]+"    "+A[28]+"-^-"+A[29]+"    "+A[30]+"-^-"+A[31]);
          System.out.println();
    }

    private void buildArray(Node n, String [] strArray, int parentIndex) {
        if (parentIndex * 2 + 1 > strArray.length) {
            return;
        }
        if (n == null) {
            return;
        } else {
            String temp;
            if (n.getLeft() == null) {
                temp = " . ";
            } else {
                temp = Integer.toString(n.getLeft().getValue());
            }
            strArray[parentIndex*2] = String.format("%3s",temp);
            buildArray(n.getLeft(), strArray, parentIndex*2);

            if (n.getRight() == null) {
                temp = " . ";
            } else {
                temp = Integer.toString(n.getRight().getValue());
            }
            strArray[parentIndex*2+1] = String.format("%3s",temp);
            buildArray(n.getRight(), strArray, parentIndex*2+1);
        }


    }
}
