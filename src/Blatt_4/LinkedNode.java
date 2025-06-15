package Blatt_4;

public class LinkedNode<E extends Comparable<E>> {
    private Node<E> head;
    private int length;


    private class Node<E> {
        private E item;
        private Node<E> next;

        // Constructor for Node
        private Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        // Accessor methods for Node
        public E getElement( ) { return this.item; }
        public Node<E> getNextNode( ) { return this.next; }
        public void setElement (E element) { this.item = element; }
        public void setNextNode(Node<E> Node) { this.next = Node; }
    }


    public LinkedNode() {
        head = null;
        length = 0;
    }


    public void insert(E item) {
        Node<E> newNode = new Node<>(item, null);

        if (head == null || head.getElement().compareTo(item) > 0) {
            // insert at the beginning of the list
            newNode.setNextNode(head);
            head = newNode;
        } else {
            // find the correct position for the new node
            Node<E> current = head;
            while (current.getNextNode() != null && current.getNextNode().getElement().compareTo(item) < 0) {
                current = current.getNextNode();
            }
            // insert the new node after current
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
        }

        length++;
    }


    public boolean contains(E item) {
        Node<E> current = head;
        while (current != null) {
            if (current.getElement().compareTo(item) == 0) {
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }


    public int getLength() {
        return length;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getElement()).append(" ");
            current = current.getNextNode();
        }
        return sb.toString().trim();
    }

    // tests
    public static void main(String[] args) {
        LinkedNode<Integer> list = new LinkedNode<>();

        // Inserting elements
        list.insert(3);
        list.insert(1);
        list.insert(2);
        list.insert(4);
        list.insert(5);

        // Printing the list
        System.out.println("List: " + list.toString());  // sorted list

        // Checking if the list contains an element
        System.out.println("Contains 3: " + list.contains(3));  // true
        System.out.println("Contains 6: " + list.contains(6));  // false

        // Getting the length of the list
        System.out.println("Length: " + list.getLength());  // 5
    }
}
