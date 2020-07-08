package BinaryTree;

import java.util.Comparator;

public class BST<E> extends BinaryTree<E>{

    private Comparator<E> comparator;

    public BST() {
        this(null);
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void add(E element) {
        elementNotNullCheck(element);
        //添加第一个节点
        if (root == null) {
            root = createNode(element,null);
            size++;
            afterAdd(root);
            return;
        }
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                return;
            }
        }

        Node<E> newNode = createNode(element,parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
        afterAdd(newNode);
    }

    protected void afterAdd(Node<E> node){}
    protected void afterRemove(Node<E> node){

    }
    public void remove(E element) {
        remove(node(element));
    }

    private void remove(Node<E> node) {
        if(node == null) return;
        size--;
        if(node.hasTowChildren()){
            Node<E> s = successor(node);
            node.element = s.element;
            node = s;
        }

        Node<E> replacement = node.left != null ? node.left : node.right;
        if(replacement != null){//node度为1的节点
            replacement.parent = node.parent;
            if(node.parent == null){
                root = replacement;
            }else if(node == node.parent.left){
                node.parent.left = replacement;
            }else if(node == node.parent.right){
                node.parent.right = replacement;
            }

            //删除结点之后的处理
            afterRemove(replacement);
        }else if(node.parent == null){//node是叶子节点并且是根节点
            root = null;

            //删除结点之后的处理
            afterRemove(node);
        }else{//node是叶子节点，但不是根节点
            if(node == node.parent.left){
                node.parent.left = null ;
            }else{
                node.parent.right = null;
            }

            //删除结点之后的处理
            afterRemove(node);
        }

    }

    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            }else{
                node = node.left;
            }
        }
        return node;
    }

    public boolean contains(E element) {
        return node(element) != null;
    }








//    public boolean isComplete(){
//        if(root == null) return false;
//
//        Queue<Node<E>> queue = new LinkedList<>();
//        queue.offer(root);
//
//        boolean leaf = false;
//        while(!queue.isEmpty()){
//            Node<E> node = queue.poll();
//            if(leaf && !node.isLeaf()) return false;
//            if(node.hasTowChildren()){
//                queue.offer(node.left);
//                queue.offer(node.right);
//            }else if(node.left == null && node.right != null){
//                return false;
//            }else{
//                leaf = true;
//                if(node.left != null){
//                    queue.offer(node.left);
//                }
//            }
//            if(node.right != null){
//                queue.offer(node.right);
//            }
//        }
//        return true;
//    }




    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element不能为null");
        }
    }

}
