//ข้อ5
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class BinaryTree2D {

    // Method to insert nodes in level order from 2D array
    public static TreeNode insertLevelOrder(int[][] arr, TreeNode root, int i) {
        // Base case for recursion
        if (i < arr.length) {
            if (arr[i].length > 0) {
                TreeNode temp = new TreeNode(arr[i][0]); // Insert the first element of each row as the current node
                root = temp;

                // Insert left child if it exists
                if (arr[i].length > 1) {
                    root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
                }

                // Insert right child if it exists
                if (arr[i].length > 2) {
                    root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
                }
            }
        }
        return root;
    }

    // Method to print tree in 2D
    public static void print2D(TreeNode root, int space) {
        if (root == null) return;

        // Increase distance between levels
        space += 5;

        // Process right child first
        print2D(root.right, space);

        // Print current node after space count
        System.out.println();
        for (int i = 5; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(root.value);

        // Process left child
        print2D(root.left, space);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับค่าความสูงของต้นไม้จากผู้ใช้
        System.out.print("กรุณาป้อนค่าความสูงของต้นไม้: ");
        int height = scanner.nextInt();

        // คำนวณจำนวนโหนดสูงสุดที่ต้นไม้สามารถมีได้
        int maxNodes = (int) Math.pow(2, height) - 1;
        int[][] treeData = new int[height][];

        // รับค่าของโหนดทั้งหมดจากผู้ใช้
        System.out.println("กรุณาป้อนค่าของโหนดแต่ละแถว:");
        for (int i = 0; i < height; i++) {
            System.out.print("จำนวนโหนดที่แถว " + (i + 1) + ": ");
            int numNodes = scanner.nextInt();
            treeData[i] = new int[numNodes];
            for (int j = 0; j < numNodes; j++) {
                System.out.print("โหนดที่ " + (j + 1) + " ของแถว " + (i + 1) + ": ");
                treeData[i][j] = scanner.nextInt();
            }
        }

        // สร้าง Binary Tree จากข้อมูลที่ได้รับ
        TreeNode root = insertLevelOrder(treeData, null, 0);

        // วาด Binary Tree ที่ได้ในรูปแบบ 2 มิติ
        System.out.println("Binary Tree ในรูปแบบ 2 มิติ:");
        print2D(root, 0);
    }
}
