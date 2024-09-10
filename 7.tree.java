public class BinaryTree<T> {
    private BTNode<T> root;

    // เมธอดนับจำนวนใบไม้ในต้นไม้
    public int numberOfLeaves() {
        return numberOfLeaves(root);
    }

    // เมธอดช่วยเพื่อใช้ในการเดินทางแบบ recursion
    private int numberOfLeaves(BTNode<T> node) {
        if (node == null) {
            return 0;
        }

        // ตรวจสอบว่าโหนดนี้เป็นใบไม้หรือไม่
        if (node.leftChild == null && node.rightChild == null) {
            return 1;
        }

        // เดินทางไปที่ลูกซ้ายและลูกขวา
        return numberOfLeaves(node.leftChild) + numberOfLeaves(node.rightChild);
    }
}
