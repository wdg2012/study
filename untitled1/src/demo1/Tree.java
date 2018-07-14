package demo1;

public class Tree {
    private Node root;

    /**
     * 插入节点
     *
     * @param value
     */
    public void insert(int value) {
        Node node = new Node(null, null, value);
        //如果root不存在的话，node为根节点
        if (root == null) {
            root = node;
        } else {
            insertNode(root, value);

        }
    }

    /**
     * 递归遍历插入点
     *
     * @param root
     * @param value
     */
    private void insertNode(Node root, int value) {
        int nodeVlaue = root.getValue();
        Node left = root.getLeft();
        Node right = root.getRight();
        if (nodeVlaue > value) {
            //插入左子树
            if (left != null) {
                insertNode(left, value);
            } else {
                Node newLeftNode = new Node(null, null, value);
                root.setLeft(newLeftNode);
            }

        } else if (nodeVlaue < value) {
            //插入右子树
            if (right != null) {
                insertNode(right, value);
            } else {
                Node newRightNode = new Node(null, null, value);
                root.setRight(newRightNode);
            }
        }
    }

    /**
     * 删除
     *
     * @param value
     * @return
     */
    public boolean delete(int value) {
        return false;
    }

    /**
     * 前序遍历
     */
    public void select() {
        if (root!=null){
            printNode(root);
        }

    }

    private void printNode(Node node) {
        System.out.print(node.getValue());
        Node left = node.getLeft();
        Node right = node.getRight();
        if (left!=null){
            printNode(left);
        }
        if (right!=null){
            printNode(right);
        }
    }
}
