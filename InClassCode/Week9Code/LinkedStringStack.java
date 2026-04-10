public class LinkedStringStack {
    private Node top;

    public LinkedStringStack(){
        this.top = null;
    }

    public void push(String str){
        Node newNode = new Node(str);
        newNode.next = top;
        top = newNode;
    }

    public String pop(){
        if(top == null) return null;
        String result = top.data;
        top = top.next;
        return result;
    }

    public boolean isEmpty(){
        if(top == null){
            return true;
        } 
        return false;
    }
    public String toString() {
        Node curr = top;
        String result = "[ ";

        while (curr != null) {
            result += curr.data + " ";
            curr = curr.next;
        }

        return result + "]";
    }
    public static void main(String[] args) {
        LinkedStringStack stack = new LinkedStringStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        System.out.println(stack);      // [ D C B A ]
        System.out.println(stack.pop()); // D
        System.out.println(stack.pop()); // C
        System.out.println(stack);      // [ B A ]
        System.out.println(stack.isEmpty()); // false
        

    }
    
}


class Node {
    String data;
    Node next;

    public Node(String data){
        this.data = data;
        this.next = null;
    }
}



