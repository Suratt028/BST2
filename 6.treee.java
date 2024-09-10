//ข้อ6
public class BinaryTree<T> {
    private BTNode<T> root;

    // เมธอดนับจำนวนจุดยอดที่มีลูกหนึ่งโหนด
    public int countNodesWithOneChild() {
        return countNodesWithOneChild(root);
    }

    // เมธอดช่วยเพื่อใช้ในการเดินทางแบบ recursion
    private int countNodesWithOneChild(BTNode<T> node) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        
        // ตรวจสอบว่าโหนดนี้มีลูกหนึ่งโหนดหรือไม่
        if ((node.leftChild != null && node.rightChild == null) ||
            (node.leftChild == null && node.rightChild != null)) {
            count = 1;
        }

        // เดินทางไปที่ลูกซ้ายและลูกขวา
        count += countNodesWithOneChild(node.leftChild);
        count += countNodesWithOneChild(node.rightChild);

        return count;
    }
}
