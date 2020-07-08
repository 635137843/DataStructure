package LinearTable;

import BinaryTree.*;
import printer.BinaryTreeInfo;
import printer.BinaryTrees;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        List<Integer> list = new SingleLinkedList<Integer>();
//        List<Integer> list3 = new ArrayList<>();
//        List<Integer> list2 = new LinkedList<Integer>();
//        testList(list);
//        testList(list3);
//        testList(list2);
//        testList(new CircleLinkedList<Integer>());
        //josephus();
//        Stack<Integer> stack = new Stack<Integer>();
//        stack.push(11);
//        stack.push(12);
//        stack.push(13);
//        stack.push(14);
//        while (!stack.isEmpty()){
//            System.out.println(stack.pop());
//        }

//        Queue<Integer> queue = new Queue<Integer>();
//        queue.enQueue(11);
//        queue.enQueue(12);
//        queue.enQueue(13);
//        while (!queue.isEmpty()){
//            System.out.println(queue.deQueue());
//        }

//        Deque<Integer> queue = new Deque<Integer>();
//        queue.enQueueFront(11);
//        queue.enQueueFront(12);
//        queue.enQueueRear(13);
//        queue.enQueueRear(14);
//        while (!queue.isEmpty()){
//            System.out.println(queue.deQueueRear());
//        }
//        CircleQueue<Integer> queue = new CircleQueue<Integer>();
//        for (int i = 0; i < 10; i++) {
//            queue.enQueue(i);
//        }
//        for (int i = 0; i < 5; i++) {
//            queue.deQueue();
//        }
//        for (int i = 15; i < 23; i++) {
//            queue.enQueue(i);
//        }
//        System.out.println(queue);
//        while (!queue.isEmpty()){
//            System.out.println(queue.deQueue());
//        }
//        List<Person> persons = new SingleLinkedList<Person>();
//        persons.add(new Person(10,"jack"));
//        persons.add(new Person(12,"rose"));
//        persons.add(new Person(13,"gan"));
//        persons.add(new Person(14,"simith"));
//        System.out.println(persons);
//        persons.clear();
//        System.gc();

//        list.add(20);
//        list.add(0,10);
//        list.add(30);

//        list.add(list.size(),40);
//        list.remove(1);
//
//        System.out.println(list);
//        Integer data[] = new Integer[]{
//                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
//        };
//        RBTree<Integer> bst = new RBTree<Integer>();
//        for (int i = 0; i < data.length; i++) {
//            bst.add(data[i]);
//        }
//        BinaryTrees.println(bst);
//        for (int i = 0; i < data.length; i++) {
//            bst.remove(data[i]);
//            System.out.println("[" + data[i] + "]");
//            BinaryTrees.println(bst);
//        }

        SecureRandom r = null;
        try {
            r=SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            r = new SecureRandom();
        }
        byte[] buffer = new byte[16];
        r.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));
//        System.out.println(bst.isComplete());
//        bst.inorderTraversal(new BinarySearchTree.Visitor<Integer>() {
//            @Override
//            public boolean visit(Integer element) {
//                System.out.print(element + "   ");
//                return element == 5 ? true : false;
//            }
//        });
//        System.out.println();
//        bst.postorderTraversal(new BinarySearchTree.Visitor<Integer>() {
//            @Override
//            public boolean visit(Integer element) {
//                System.out.print(element + "   ");
//                return element == 5 ? true : false;
//            }
//        });
//        System.out.println();
//        bst.levelOrderTranversal(new BinarySearchTree.Visitor<Integer>() {
//
//            @Override
//            public boolean visit(Integer element) {
//                System.out.print(element + "   ");
//                return element == 2 ? true : false;
//            }
//        });
//        System.out.println();
//        bst.levelOrderTranversal(new BinarySearchTree.Visitor<Integer>() {
//            @Override
//            public void visit(Integer element) {
//                System.out.print("_"+element+"_");
//            }
//        });
//        System.out.println(bst.height2());

//        BinarySearchTree<Person> bstPerson = new BinarySearchTree<>();
//        bstPerson.add(new Person(7,"aaa"));
//        bstPerson.add(new Person(4,"vvv"));
//        bstPerson.add(new Person(9,"ccc"));
//        bstPerson.add(new Person(2,"sss"));
//        bstPerson.add(new Person(5,"ddd"));
//        bstPerson.add(new Person(8,"qqq"));
//        BinaryTrees.println(bstPerson);
    }

//    static void  testList(List<Integer> list){
//        for (int i = 0; i < 50; i++) {
//            list.add(i);
//        }
//        for (int i = 0; i < 40; i++) {
//            list.remove(0);
//        }
//        list.add(0,55);
//        list.add(2,35);
//        list.add(list.size(),90);
//        list.remove(0);
//        System.out.println(list.contains(35));
//        System.out.println(list);
//    }
//
//    static void josephus(){
//        CircleLinkedList<Integer> list = new CircleLinkedList<Integer>();
//        for (int i = 1; i <= 8; i++) {
//            list.add(i);
//        }
//        list.reset();
//        var n = 2;
//        while (!list.isEmpty()){
//            while(n-- > 0){
//                list.next();
//            }
//            n = 2;
//            System.out.println(list.remove());
//        }
//    }
}
