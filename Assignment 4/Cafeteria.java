//import java.util.ArrayList;
import java.util.Scanner;

public class Cafeteria {
    public static final String WARNING = "Warning: ";
    public static void main(String[] args) {
        processCafeteria();
        System.out.println("\nEnd of processing");
    }
    public static void processCafeteria(){
        Scanner in=new Scanner(System.in);
        String line;
        String[] tokens;
        Tray tray;
        
        /*** TODO: change these constructors to create your linked list queue and stack ***/
        TrayQueue dirtyTrayLine = new TrayQueueLL();
        TrayStack cleanTrayStack = new TrayStackLL();
        

        System.out.println("Enter a command (return x, wash, take, display, peek, top, quit):");
        line=in.nextLine();
        while(line!=null && !line.equals("quit")){
            tokens= line.split(" ");
            if(tokens.length>0){
                if(tokens[0].equals("return") && tokens.length==2){
                    tray=new Tray(tokens[1]);
                    System.out.println("* Returning tray: "+ tokens[1]);
                    dirtyTrayLine.enqueue(tray); //enqueue tray
                }else if (tokens[0].equals("wash") && tokens.length == 1){
                    if(dirtyTrayLine.isEmpty()){//handle empty queue
                        System.out.println(WARNING+"no dirty tray to wash");
                    }else{
                        tray=dirtyTrayLine.dequeue();
                        System.out.println("* Washing dirty tray: "+tray);
                        cleanTrayStack.push(tray);
                    }
                }else if (tokens[0].equals("take") && tokens.length == 1){
                    if(cleanTrayStack.isEmpty()){//handle empty stack
                        System.out.println(WARNING+"no clean tray to take");
                    }else{
                        tray=cleanTrayStack.pop();
                        System.out.println("* Taking tray: "+ tray);
                    }
                }else if (tokens[0].equals("display") && tokens.length==1){
                    displayState(dirtyTrayLine,cleanTrayStack);
                }else if (tokens[0].equals("peek") && tokens.length==1){
                    if(dirtyTrayLine.isEmpty()){
                        System.out.println(WARNING+ "no dirty trays to peek");
                    }else{
                        tray=dirtyTrayLine.peek();
                        System.out.println(" * Front dirty tray: "+tray);
                    }
                }else if (tokens[0].equals("top") && tokens.length==1){
                    if(cleanTrayStack.isEmpty()){
                        System.out.println(WARNING+ "no clean trays on stack");
                    }else{
                        tray=cleanTrayStack.top();
                        System.out.println(" * Top clean tray: "+tray);
                    }
                }else{
                    System.out.println("* Unknown command: "+line);
                }
            }
            System.out.print("\nEnter a command (return x,wash,take,display,quit): ");
            line = in.nextLine();
        }
        in.close();
    }
        public static void displayState(TrayQueue dirtyTrayLine, TrayStack cleanTrayStack){
            System.out.println("============\nDirty Tray Line:");
            System.out.println(dirtyTrayLine);

            System.out.println("============\nClean Tray Stack:");
            System.out.println(cleanTrayStack);
            System.out.println();
    }
}
class Tray{
    private String label;
    public Tray(String label){
        this.label=label;
    }
    public String getLabel(){
        return label;
    }
    public String toString(){
        return "["+ label+ "]";
    }
}
interface TrayQueue{
    void enqueue(Tray t);
    Tray dequeue();
    Tray peek();
    boolean isEmpty();
}
interface TrayStack{
    void push(Tray t);
    Tray pop();
    Tray top();
    boolean isEmpty();
}

/*** TODO: complete this node class for your linked-list implementations ***/
class TrayNode {
    Tray tray;
    TrayNode nextTray;
    public TrayNode(Tray tray){
        this.tray = tray;
        this.nextTray = null;
    }
  
}

/*** TODO: Complete a linked-list queue implementation***/
class TrayQueueLL implements TrayQueue {
    private TrayNode firstTray;
    private TrayNode lastTray;
    

  /***TODO: Add any fields requred ***/
  public void enqueue(Tray t){
    TrayNode newTray = new TrayNode(t);
    if(lastTray == null){
        firstTray = newTray;
        lastTray = newTray;
    }else{
        lastTray.nextTray = newTray;
        lastTray = newTray;
    }
  }

  public Tray dequeue(){
    if(firstTray == null){
        return null;
    }

    Tray curr = firstTray.tray;
    firstTray = firstTray.nextTray;

    if(firstTray == null){
        lastTray = null;
    }

    
    return curr;
    
  }
  public Tray peek(){
    if(firstTray == null){
        return null;
    }
    return firstTray.tray;
  }

  public boolean isEmpty(){
    return firstTray == null;
  }

  /***TODO: Add the Constructor ***/
  public TrayQueueLL(){
    firstTray = null;
    lastTray = null;
  }

  


  public String toString() {
    /*** TODO: Write a toString method based on the example provided in the assignment description ***/
    if (firstTray == null) {
        return "(empty)";
    }

    String result = "Front->";
    TrayNode curr = firstTray;

    while (curr != null) {
        result += curr.tray;
        if (curr.nextTray != null) {
            result += " ";
        }
        curr = curr.nextTray;
    }

    result += "<-Rear";
    return result;
  }
}

/*** TODO: Complete the linked-list stack implementation ***/
class TrayStackLL implements TrayStack {
    /***TODO: Add any fields requred ***/
    private TrayNode first;

    public void push(Tray t){
        TrayNode newTray = new TrayNode(t);
        newTray.nextTray = first;
        first = newTray;
        
    }

    public Tray pop() {
        if (first == null) {
            return null;
        }

        Tray removedTray = first.tray;
        first = first.nextTray;
        return removedTray;
    }

    public Tray top() {
        if (first == null) {
            return null;
        }
        return first.tray;
    }

    public boolean isEmpty(){
        return first == null;
    }
    /***TODO: Add the Constructor ***/
    public TrayStackLL(){
        first = null;
    }

  public String toString() {
    /*** TODO: Write a toString method based on the example provided in the assignment description ***/
    if (first == null) {
        return "(empty)";
    }

    String result = "";
    TrayNode curr = first;

    while (curr != null) {
        result += curr.tray + "\n";
        curr = curr.nextTray;
    }

    result += "---";
    return result;
  }
}