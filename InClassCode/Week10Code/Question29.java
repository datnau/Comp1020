public class Question29 {
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);

        a.setNext(b);
        b.setNext(c);

        Question29 q = new Question29();
        System.out.println(q.totalSum(a)); // 60
    }

    public int totalSum(Node head) {
        int sum = 0;
        Node curr = head;

        while (curr != null) {
            sum += curr.getData();
            curr = curr.getNext();
        }

        return sum;
    }
}

class Node {
    private Node next;
    private int data;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}