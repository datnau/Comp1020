public class OrderedLinkedList implements OrderedCollection {
    private Node head;
    private int size = 0;
    public void insert(Song s) {
    Node newNode = new Node(s);

    if (head == null || s.compareTo(head.song) < 0) {
        newNode.nextSong = head;
        head = newNode;
        size++;
        return;
    }

    Node curr = head;

    while (curr.nextSong != null && curr.nextSong.song.compareTo(s) <= 0) {
        curr = curr.nextSong;
    }

    newNode.nextSong = curr.nextSong;
    curr.nextSong = newNode;
    size++;
}

    public void delete(String title){
        if(head == null){
            return;
        }
        if(head.song.getTitle().equals(title)){
            head = head.nextSong;
            size--;
            return;
        }
        Node curr = head;
        while (curr.nextSong != null) {
        if (curr.nextSong.song.getTitle().equals(title)) {
            curr.nextSong = curr.nextSong.nextSong;
            size--;
            return;
        }
        curr = curr.nextSong;
        }
    }

    public Song search(String title){
        Node curr = head;
        while(curr != null){
            if(curr.song.getTitle().equals(title)){
                return curr.song;
            }
            curr = curr.nextSong;
        }
        return null;

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }

    public int getTotalDuration(){
        int totalDuration = 0;
        if(head == null){
            return 0;
        }
        Node curr = head;
        while(curr != null){
            totalDuration += curr.song.getDuration();
            curr = curr.nextSong;
        }
        return totalDuration;

    }

    public void printAll(){
        if(head == null){
            return;
        }
        Node curr = head;
        while(curr != null){
            System.out.println(curr.song.toString());
            curr = curr.nextSong;
        }

    }
}
class Node{
    Song song;
    Node nextSong;
    public Node(Song song){
        this.song= song;
        this.nextSong = null;
    }
}
