

public class InClassException {
    public static void main(String[] args) {
        String nullVar = null;
        // String realVar = "All the things!";


        try {
            int i = 0;
            System.out.println(nullVar.charAt(0));
            // System.out.println(realVar.charAt(0));
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException");
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
            System.out.println("Exception Message: " + e.getMessage());
            e.printStackTrace();

            throw e;
        } catch (Exception ex) {
            System.out.println("Caught Exception");
            // System.out.println("Exception Message: " + ex.getMessage());
        } finally {
            System.out.println("This always runs");
        }

        throwingMethod();
        // try {
        // } catch (Exception e) {
        //     System.out.println("Catch throwing error");
        // }


        System.out.println("The end");
    }

    public static int throwingMethod() throws ArithmeticException {
        return 1/0;
    }

    public static void otherThrowingMethod() {
        boolean someCondition = true;
        if (someCondition) {
            throw new RuntimeException("Some message");
        }
    }

}
