package Blatt_4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BinaryTree<T> {
    private T _value;
    private BinaryTree<T> _left;
    private BinaryTree<T> _right;

    public BinaryTree(T value) {
        this._value = value;
    }

    public BinaryTree<T> getLeft() {
        return this._left;
    }

    public BinaryTree<T> getRight() {
        return this._right;
    }

    public BinaryTree<T> setLeft(BinaryTree<T> node) {
        this._left = node;
        return node;
    }

    public BinaryTree<T> setRight(BinaryTree<T> node) {
        this._right = node;
        return node;
    }

    public T getValue() {
        return this._value;
    }

    public T setValue(T value) {
        this._value = value;
        return value;
    }
}

class InorderIterator<T> implements Iterator<T> {
    private Stack<BinaryTree<T>> stack = new Stack<>();

    public InorderIterator(BinaryTree<T> root) {
        pushLeft(root);
    }

    private void pushLeft(BinaryTree<T> node) {
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        BinaryTree<T> node = stack.pop();
        T result = node.getValue();
        if (node.getRight() != null) {
            pushLeft(node.getRight());
        }
        return result;
    }
}

class InorderIterable<T> implements Iterable<T> {
    private BinaryTree<T> root;

    public InorderIterable(BinaryTree<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<T> iterator() {
        return new InorderIterator<>(root);
    }
}

class LevelOrderIterator<T> implements Iterator<T> {
    private Queue<BinaryTree<T>> queue = new LinkedList<>();

    public LevelOrderIterator(BinaryTree<T> root) {
        if (root != null) {
            queue.add(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        BinaryTree<T> node = queue.poll();
        T result = node.getValue();
        if (node.getLeft() != null) {
            queue.add(node.getLeft());
        }
        if (node.getRight() != null) {
            queue.add(node.getRight());
        }
        return result;
    }
}

class LevelOrderIterable<T> implements Iterable<T> {
    private BinaryTree<T> root;

    public LevelOrderIterable(BinaryTree<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<T> iterator() {
        return new LevelOrderIterator<>(root);
    }
}

class BinTreeTraversal {
    public static void main(String[] args) {
        // Пример бинарного дерева
        BinaryTree<Integer> root = new BinaryTree<Integer>(1);
        root.setLeft(new BinaryTree<Integer>(2));
        root.setRight(new BinaryTree<Integer>(3));
        root.getLeft().setLeft(new BinaryTree<Integer>(4));
        root.getLeft().setRight(new BinaryTree<Integer>(5));
        root.getRight().setLeft(new BinaryTree<Integer>(6));
        root.getRight().setRight(new BinaryTree<Integer>(7));

        // Обход In-order
        System.out.println("In-order traversal:");
        for (int item : new InorderIterable<>(root)) {
            System.out.print(item + " ");
        }
        System.out.println();

        // Обход Level-order
        System.out.println("Level-order traversal:");
        for (int item : new LevelOrderIterable<>(root)) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
