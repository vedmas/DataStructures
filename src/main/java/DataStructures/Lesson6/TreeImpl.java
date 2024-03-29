package DataStructures.Lesson6;

import DataStructures.Lesson2.Array;

import java.util.*;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;
    private int size;
    private List<NodeAndParent> lastValue = new ArrayList<>();
    int maxLevel;

    public TreeImpl(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    @Override
    public boolean find(E value) {
        return doFind(value).current != null;
    }

    @Override
    public void findFull(E value) {
        System.out.println("Current = " + doFind(value).current.getValue() + " Level = " + doFind(value).level);
    }

    @Override
    public boolean add(E value) {
        Node<E> node = new Node<>(value);
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> previous = nodeAndParent.parent;
        if (nodeAndParent.isEmpty()) {
            this.root = node;
            return true;
        }
        else if (nodeAndParent.current != null) {
            return false;
        }
        else if(doFind(previous.getValue()).level == maxLevel) {
            return false;
        }
        else if (previous.shouldBeLeft(value)) {
            previous.setLeftChild(node);
        }
        else {
            previous.setRightChild(node);
        }
        size++;
        return true;
    }

    private NodeAndParent doFind(E value) {
        if (isEmpty()) {
            return new NodeAndParent(null, null, 0);
        }
        Node<E> parent = null;
        Node<E> current = this.root;
        int level = 0;
        do {
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, parent, level);
            }
            parent = current;
            level++;
            if (parent.shouldBeLeft(value)) {
                current = current.getLeftChild();

            } else {
                current = current.getRightChild();
            }
        } while (current != null);
        return new NodeAndParent(null, parent, 0);
    }

    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> parent = nodeAndParent.parent;
        Node<E> removedNode = nodeAndParent.current;
        if (removedNode == null) {
            return false;
        }
        else if(removedNode.isleaf()) {
            removeLeafNode(parent, removedNode);
        }
        else if(removedNode.hasOnlySinglChild()) {
            removeNodeWithSinglChild(parent, removedNode);
        }
        else {
            removeCommonNode(parent, removedNode);
        }
        size--;
        return true;
    }

    private void removeCommonNode(Node<E> parent, Node<E> removedNode) {
        Node<E> successor = getSuccessor(removedNode);
        if(removedNode == root) {
            root = successor;
        }
        else if(parent.getLeftChild() == removedNode) {
            parent.setLeftChild(successor);
        }
        else {
            parent.setRightChild(successor);
        }
        successor.setLeftChild(removedNode.getLeftChild());
    }

    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if(successor != removedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }
        return successor;
    }

    private void removeNodeWithSinglChild(Node<E> parent, Node<E> removedNode) {
        Node<E> childNode = removedNode.getLeftChild() != null
                ? removedNode.getLeftChild()
                : removedNode.getRightChild();
        if(removedNode == root) {
            root = childNode;
        }
        else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(childNode);
        }
        else{
            parent.setRightChild(childNode);
        }
    }

    private void removeLeafNode(Node<E> parent, Node<E> removedNode) {
        if(removedNode == root) {
            root = null;
        }
        else if(parent.getLeftChild() == removedNode) {
            parent.setLeftChild(null);
        }
        else {
            parent.setRightChild(null);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
            Stack<Node> globalStack = new Stack<>();
            globalStack.push(root);
            int nBlanks = 64;

            boolean isRowEmpty = false;
            System.out.println("................................................................");

            while (!isRowEmpty) {
                Stack<Node> localStack = new Stack<>();

                isRowEmpty = true;
                for (int i = 0; i < nBlanks; i++) {
                    System.out.print(" ");
                }

                while (!globalStack.isEmpty()) {
                    Node tempNode = globalStack.pop();
                    if (tempNode != null) {
                        System.out.print(tempNode.getValue());
                        localStack.push(tempNode.getLeftChild());
                        localStack.push(tempNode.getRightChild());
                        if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                            isRowEmpty = false;
                        }
                    } else {
                        System.out.print("--");
                        localStack.push(null);
                        localStack.push(null);
                    }
                    for (int j = 0; j < nBlanks * 2 - 2; j++) {
                        System.out.print(" ");
                    }
                }

                System.out.println();

                while (!localStack.isEmpty()) {
                    globalStack.push(localStack.pop());
                }

                nBlanks /= 2;
            }
            System.out.println("................................................................");
}

    @Override
    public boolean isBalanced() {
        findLastValue(root);
        if(root.getLeftChild() == null || root.getRightChild() == null) {
            return false;
        }
        lastValue.sort(Comparator.comparing(a ->a.level)); //Сортировка массива объектов по параметру level
        return (lastValue.get(lastValue.size() - 1).level - lastValue.get(0).level) <= 1;
    }

    // Выборка значений без потомков в отдельный список
    private void findLastValue( Node<E> current) {
        if (current == null) {
            return;
        }
        if(current.getLeftChild()== null && current.getRightChild() == null) {
           lastValue.add(doFind(current.getValue()));
        }
        findLastValue(current.getLeftChild());
        findLastValue(current.getRightChild());
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void traverse(TraversMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown travers mode: " + mode);
        }
    }

    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }
        inOrder(current.getLeftChild());
        System.out.println(current.getValue());
        inOrder(current.getRightChild());
    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }
        System.out.println(current.getValue());
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }
        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.println(current.getValue());
    }

    public class NodeAndParent {
        Node<E> current;
        Node<E> parent;
        int level;

        private NodeAndParent(Node<E> current, Node<E> parent, int level) {
            this.current = current;
            this.parent = parent;
            this.level = level;
        }

        public boolean isEmpty() {
            return current == null && parent == null;
        }
    }
}
