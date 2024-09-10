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

public class BinaryTree {
    // Method to insert nodes in level order
    public static TreeNode insertLevelOrder(int[] arr, TreeNode root, int i) {
        // Base case for recursion
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // Insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

            // Insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    // Method to print tree in level order to visualize it
    public static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.value + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับค่าความสูงของต้นไม้จากผู้ใช้
        System.out.print("กรุณาป้อนค่าความสูงของต้นไม้: ");
        int height = scanner.nextInt();

        // คำนวณจำนวนโหนดสูงสุดที่ต้นไม้สามารถมีได้
        int maxNodes = (int) Math.pow(2, height) - 1;

        // รับค่าของโหนดทั้งหมดจากผู้ใช้
        int[] treeData = new int[maxNodes];
        System.out.println("กรุณาป้อนค่าของโหนดแต่ละตัว:");
        for (int i = 0; i < maxNodes; i++) {
            System.out.print("โหนดที่ " + (i + 1) + ": ");
            treeData[i] = scanner.nextInt();
        }

        // สร้าง Binary Tree จากข้อมูลที่ได้รับ
        TreeNode root = insertLevelOrder(treeData, null, 0);

        // วาด Binary Tree ที่ได้
        System.out.println("ต้นไม้ที่ได้จากข้อมูลที่คุณป้อน:");
        printLevelOrder(root);
    }
}
