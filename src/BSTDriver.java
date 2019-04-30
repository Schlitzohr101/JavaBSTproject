//import java.awt.*;
//import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class BSTDriver {
    public static void main(String[] args) {
        BST myBst = new BST();
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        //For ease of testinf
        //File testTextfile = new File("/home/schlitzohr/Workspace/javaprojects/JavaBSTproject/src/test.txt");

//        try {
//            input = new Scanner(testTextfile);
//        } catch (Exception e) {
//            System.out.println("faled to open test file");
//        }

        char option = 'Z';
        int num = 0;
        treeStats(myBst);

        option = menu(input);
        while (option != 'Q') {
            switch (option)
            {
                case 'A' :
                    System.out.print("Enter a positive integer: ");
                    num = input.nextInt();
                    myBst.add(num);
                    break;

                case 'B' :
                    if (myBst.isBalanced()) {
                        System.out.println("This tree is balanced");
                    } else {
                        System.out.println("This tree is not balanced");
                    }
                    break;

                case 'P' :
                    System.out.print("Enter a number to find the parent:");
                    num = input.nextInt();
                    int parent = myBst.findParent(num);
                    System.out.println();
                    if (parent == -1) {
                        System.out.printf("Number %d does not exist in the tree\n",num);
                    } else if (parent == -2) {
                        System.out.printf("Number %d is the root of the tree\n",num);
                    } else {
                        System.out.printf("Parent of %d is %d\n",num,myBst.findParent(num));
                    }
                    break;

                case 'C' :
                    System.out.print("Enter a number to find the children:");
                    num = input.nextInt();
                    int lc = myBst.findLeftChild(num);
                    int rc = myBst.findRightChild(num);
                    System.out.printf("Number:%d, "+(lc == -1 ? " Left Child Null" : "leftChild:%d")+", "+(rc == -1 ? "Right Child Null" : "RightChild:%d")+"\n",num, lc, rc);
                    break;

                case 'N' :
                    System.out.println("Creating an empty tree:");
                    myBst = new BST();
                    break;

                case 'T' :
                    myBst.displayTree();
                    break;

                case 'R' :
                    System.out.print("How many numbers do you want to add:");
                    num = input.nextInt();
                    System.out.print("Lower Range:");
                    int min = input.nextInt();
                    System.out.print("Upper Range:");
                    int max = input.nextInt();
                    System.out.printf("max %d min %d ",max,min);
                    for (int i = 0; i < num; i++) {
                        myBst.add(rand.nextInt(max-min+1) + min);
                    }
                    break;
                case 'L' :
                    System.out.print("Which number to find level: ");
                    num = input.nextInt();
                    int level = myBst.findLevel(num);
                    System.out.println();
                    if (level == 1) {
                        System.out.printf("The number %d was not found in the tree",num);
                    } else if ( level == -1) {
                        System.out.printf("The number %d is the root of the tree",num);
                    } else {
                        System.out.printf("\nThe number %d was found on level %d", num, level);
                    }

                    break;
            }
            treeStats(myBst);
            option = menu(input);


        }
    }
    public static char menu(Scanner source) {
        System.out.println("(A)dd   (B)alanced?   (P)arent   (C)hildren   (N)ew Tree   (T)ree display  (R)andomize   (Q)uit");
        char option = source.next().charAt(0);
        option = Character.toUpperCase(option);
        return option;
    }
    public static void treeStats(BST tree) {
        System.out.println("\nWelcome to the Jungle");
        System.out.println("-Tree Stats- Root: "+tree.getRoot());
        System.out.println("             Height: "+tree.getHeight());
        System.out.println("             Count: "+tree.getCount());
        tree.display();
        System.out.println();
    }
}