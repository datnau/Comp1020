public class Question30 {
    public static void main(String[] args) {
        String line = "ID:1234 Marks:80,90,100";
        int index = line.indexOf("Marks:") + "Marks:".length();
        String mark = line.substring(index);
        String[] marks = mark.split("[\\s,]+");
        double sum = 0;
        for(int i = 0; i < marks.length;i++){
            sum += Double.parseDouble(marks[i]);

        }
        double average = sum/marks.length;
        System.out.println(average);
        
    }


}
