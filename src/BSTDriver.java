import java.util.Random;
import java.util.Scanner;

public class BSTDriver {
    public static void main(String[] args) {
        BST myBst = new BST();
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        char option = 'Z';
        int num = 0;
        treeStats(myBst);
    }
    public static char menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("(A)dd   (B)alanced?   (P)arent (C)hildren   (N)ew Tree   (T)ree display  (R)andomize   (Q)uit");
        char option = in.next().charAt(0);
        option = Character.toUpperCase(option);
        return option;
    }
    public static void treeStats(BST tree) {
        System.out.println("\nWelcome to the Jungle");
        System.out.println("-Tree Stats- Root:"+tree.getRoot());
        System.out.println("");
    }
}