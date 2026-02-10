public class Question27 {
    public static void main(String[] args) {
        String name = "joHN dOe";
        String formatedName = formatName(name);
        System.out.println(formatedName);
        
    }

    public static String formatName(String name){
        name = name.toLowerCase();
        String formatedName = "";
        String[] parts = name.split(" ");
        for(int i = 0; i < parts.length; i++){
            String firstLetter = parts[i].substring(0,1).toUpperCase();
            String newName = firstLetter + parts[i].substring(1) + " ";
            formatedName += newName;
        }
        return formatedName;
    }
}
