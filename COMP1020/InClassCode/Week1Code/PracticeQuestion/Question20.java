
public class Question20 {

    public static void main(String[] args) {
        int hour = 9;
        int minute = 30;
        int isWeekend = 0;

        boolean open = (isWeekend == 0 && hour >= 7 && minute >= 0 && minute <= 59 && hour <= 18 && minute >= 0 && minute <= 59) || (isWeekend == 1 && hour >= 8 && minute >= 0 && minute <= 59 && hour <= 16 && minute >= 0 && minute <= 59);

        System.out.println(open);
    }

}
