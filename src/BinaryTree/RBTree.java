package BinaryTree;

import java.util.Comparator;

public class RBTree<E> extends BBST<E> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public RBTree() {
        this(null);
    }

    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }

    private Node<E> color(Node<E> node, boolean color) {
        if (node == null) return null;
        ((RBNode<E>) node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node) {
        return color(node, RED);
    }

    private Node<E> black(Node<E> node) {
        return color(node, BLACK);
    }

    private boolean colorOf(Node<E> node) {
        return node == null ? BLACK : ((RBNode<E>) node).color;
    }

    private boolean isRed(Node<E> node) {
        return colorOf(node) == RED;
    }

    private boolean isBlack(Node<E> node) {
        return colorOf(node) == BLACK;
    }

    @Override
    protected void afterRemove(Node<E> node) {
        //if (isRed(node)) return;
        //用于取代node的子节点是红色
        if (isRed(node)) {
            black(node);
            return;
        }

        Node<E> parent = node.parent;
        //删除的是黑色叶子节点
        if (parent == null) return;

        boolean left = parent.left == null || node.isLeftChild();
        Node<E> sibling = left ? parent.right : parent.left;
        if (left) {//被删除节点在左边，兄弟节点在右边
            if (isRed(sibling)) {
                black(sibling);
                red(parent);
                rotateLeft(parent);
                sibling = parent.right;
            }

            //兄弟节点必然为黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                //兄弟节点没有红色节点，需要父节点要向下跟兄弟节点合并
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (parentBlack) {
                    afterRemove(parent);
                }

            } else {//兄弟节点至少有一个红色子节点,向兄弟节点借
                //兄弟节点的左边是黑色，兄弟要先旋转
                if (isBlack(sibling.right)) {
                    rotateRight(sibling);
                    sibling = parent.right;
                }
                color(sibling, colorOf(parent));
                black(sibling.right);
                black(parent);
                rotateLeft(parent);
            }
        } else {//被删除节点在右边，兄弟节点在左边
            if (isRed(sibling)) {
                black(sibling);
                red(parent);
                rotateRight(parent);
                sibling = parent.left;
            }

            //兄弟节点必然为黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                //兄弟节点没有红色节点，需要父节点要向下跟兄弟节点合并
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (parentBlack) {
                    afterRemove(parent);
                }

            } else {//兄弟节点至少有一个红色子节点,向兄弟节点借
                //兄弟节点的左边是黑色，兄弟要先旋转
                if (isBlack(sibling.left)) {
                    rotateLeft(sibling);
                    sibling = parent.left;
                }

                color(sibling, colorOf(parent));
                black(sibling.left);
                black(parent);
                rotateRight(parent);
            }
        }
    }
//    protected void afterRemove(Node<E> node, Node<E> replacement) {
//        if (isRed(node)) return;
//        //用于取代node的子节点是红色
//        if (isRed(replacement)) {
//            black(replacement);
//            return;
//        }
//
//        Node<E> parent = node.parent;
//        //删除的是黑色叶子节点
//        if (parent == null) return;
//
//        boolean left = parent.left == null || node.isLeftChild();
//        Node<E> sibling = left ? parent.right : parent.left;
//        if (left) {//被删除节点在左边，兄弟节点在右边
//            if (isRed(sibling)) {
//                black(sibling);
//                red(parent);
//                rotateLeft(parent);
//                sibling = parent.right;
//            }
//
//            //兄弟节点必然为黑色
//            if (isBlack(sibling.left) && isBlack(sibling.right)) {
//                //兄弟节点没有红色节点，需要父节点要向下跟兄弟节点合并
//                boolean parentBlack = isBlack(parent);
//                black(parent);
//                red(sibling);
//                if (parentBlack) {
//                    afterRemove(parent, null);
//                }
//
//            } else {//兄弟节点至少有一个红色子节点,向兄弟节点借
//                //兄弟节点的左边是黑色，兄弟要先旋转
//                if (isBlack(sibling.right)) {
//                    rotateRight(sibling);
//                    sibling = parent.right;
//                }
//                color(sibling, colorOf(parent));
//                black(sibling.right);
//                black(parent);
//                rotateLeft(parent);
//            }
//        } else {//被删除节点在右边，兄弟节点在左边
//            if (isRed(sibling)) {
//                black(sibling);
//                red(parent);
//                rotateRight(parent);
//                sibling = parent.left;
//            }
//
//            //兄弟节点必然为黑色
//            if (isBlack(sibling.left) && isBlack(sibling.right)) {
//                //兄弟节点没有红色节点，需要父节点要向下跟兄弟节点合并
//                boolean parentBlack = isBlack(parent);
//                black(parent);
//                red(sibling);
//                if (parentBlack) {
//                    afterRemove(parent, null);
//                }
//
//            } else {//兄弟节点至少有一个红色子节点,向兄弟节点借
//                //兄弟节点的左边是黑色，兄弟要先旋转
//                if (isBlack(sibling.left)) {
//                    rotateLeft(sibling);
//                    sibling = parent.left;
//                }
//
//                color(sibling, colorOf(parent));
//                black(sibling.left);
//                black(parent);
//                rotateRight(parent);
//            }
//        }
//    }

    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;
        //添加的是根节点
        if (parent == null) {
            black(node);
            return;
        }

        //如果父节点是黑色 直接返回
        if (isBlack(parent)) return;

        //叔父节点
        Node<E> uncle = parent.sibling();
        //祖父节点
        Node<E> grand = red(parent.parent);
        if (isRed(uncle)) {//叔父节点是红色
            black(parent);
            black(uncle);
            //把祖父节点当作是新添加的节点
            afterAdd(grand);
            return;
        }

        //叔父节点不是红色
        if (parent.isLeftChild()) {//L
            if (node.isLeftChild()) {//LL
                black(parent);
            } else {//LR
                black(node);
                rotateLeft(parent);
            }
            rotateRight(grand);
        } else {//R
            if (node.isRightChild()) {//RR
                black(parent);
            } else {//RL
                black(node);
                rotateRight(parent);
            }
            rotateLeft(grand);
        }
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RBNode<E>(element, parent);
    }

    private static class RBNode<E> extends Node<E> {
        boolean color = RED;//红黑树的颜色

        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            String str = "";
            if (color == RED) {
                str = "R_";
            }
            return str + element.toString();
        }
    }
}
