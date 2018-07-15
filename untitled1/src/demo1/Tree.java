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
     * 如果value小于left
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
     * 删除节点
     * 先搜索节点，找到删除的节点
     * 如果删除的节点没有子节点直接删除
     * 如果有一个子节点把要删除的节点用其非空子节点替换掉
     * 如果左右子节点都不为空都情况下，用右子树的最小值替换掉要删除的节点，然后删掉右子树的最小值
     *
     * @param value
     * @return
     */
    public boolean delete(int value) {
        Node deleteNode = searchNode(root, value);
        Node parent = deleteNode.getParent();

        if (deleteNode.getLeft() == null && deleteNode.getRight() == null) {
            //如果是叶子节点的情况下，直接删去该节点
            deleteNoChildNode(deleteNode, parent);

        } else if (deleteNode.getLeft() != null && deleteNode.getRight() != null) {
            //如果左右节点都不为空的情况
            Node minNode = getNodeMin(deleteNode.getRight());
            int minValue = minNode.getValue();
            deleteNode.setValue(minValue);
            if (minNode.getRight() == null && minNode.getLeft() == null) {
                //左右都为空都情况下
                deleteHavaOneChildNode(minNode, minNode.getParent());
            } else {
                //有一个子节点都情况下
                deleteHavaOneChildNode(minNode, minNode.getParent());
            }
        } else {
            //左右节点都有一个为空的情况
            deleteHavaOneChildNode(deleteNode, parent);

        }
        return false;
    }

    /**
     * 要删除节点有一个子节点的情况下
     *
     * @param deleteNode 要删除的节点
     * @param parent     要删除节点的父节点
     */
    private void deleteHavaOneChildNode(Node deleteNode, Node parent) {
        Node replaceNode = deleteNode.getLeft();
        //如果左右节点其中有一个不为空的情况
        if (deleteNode.getRight() != null) {
            replaceNode = deleteNode.getRight();
        }
        if (parent.getLeft() == deleteNode) {
            parent.setLeft(replaceNode);
        } else {
            parent.setRight(replaceNode);
        }
    }

    /**
     * 是叶子节点情况下的删除
     *
     * @param deleteNode 要删除的节点
     * @param parent     要删除节点的父节点
     */
    private void deleteNoChildNode(Node deleteNode, Node parent) {
        if (parent.getLeft() == deleteNode) {
            parent.setLeft(null);
        } else {
            parent.setRight(null);
        }
    }

    /**
     * 获取树的最小值
     *
     * @param root
     * @return
     */
    private Node getNodeMin(Node root) {
        Node minNode = root;
        Node left = root.getLeft();
        if (left != null) {
            minNode = getNodeMin(left);
        }
        return minNode;
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
