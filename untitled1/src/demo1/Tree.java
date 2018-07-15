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
        int nodeValue = root.getValue();
        Node left = root.getLeft();
        Node right = root.getRight();
        Node newNode = new Node(null, null, value);
        if (nodeValue > value) {
            //插入左子树
            if (left != null) {
                insertNode(left, value);
            } else {
                root.setLeft(newNode);
                newNode.setParent(root);
            }

        } else if (nodeValue < value) {
            //插入右子树
            if (right != null) {
                insertNode(right, value);
            } else {
                root.setRight(newNode);
                newNode.setParent(root);
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
        Node deleteNode = searchNode(root, value);
        //如果是叶子节点的情况下
        if (deleteNode.getLeft() == null && deleteNode.getRight() == null) {

        }
        return false;
    }

    /**
     * 查找节点
     *
     * @param root
     * @param value
     * @return
     */
    private Node searchNode(Node root, int value) {
        Node node = null;
        Node left = root.getLeft();
        Node right = root.getRight();
        int rootValue = root.getValue();
        if (root.getValue() == value) {
            //如果root等于直接返回root
            node = root;
        } else if (rootValue > value && left != null) {
            //如果root大于value 并且left不为空，遍历left子树
            node = searchNode(left, value);
        } else if (rootValue < value && right != null) {
            //如果root小于value 并且right不为空，遍历right子树
            node = searchNode(right, value);
        }
        return node;

    }

    /**
     * 前序遍历
     */
    public void select() {
        if (root != null) {
            printNode(root);
        }

    }

    /**
     * 前序遍历的实现
     */
    private void printNode(Node node) {
        System.out.println(node.getValue());
        Node left = node.getLeft();
        Node right = node.getRight();
        if (left != null) {
            printNode(left);
        }
        if (right != null) {
            printNode(right);
        }
    }

    /**
     * 搜索
     *
     * @param i 搜索的值
     * @return
     */
    public Node searchNode(int i) {
        Node searchNode = searchNode(root, i);
        return searchNode;
    }
}
