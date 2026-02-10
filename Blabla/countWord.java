public class countWord {
    public static void main(String[] args) {
        String word1 = "Hello World";
        String word2 = "Java is fun to learn";
        String word3 = " ";
        String str = "My name is brown";
        System.out.println(countWords(word1));
        System.out.println(countWords(word2));
        System.out.println(countWords(word3));
        String[] splitWord = str.split(" ");
        for(int i = 0; i < splitWord.length;i++){
            System.out.print(splitWord[i]);
        }

    }

    public static int countWords(String word){
        word.trim();
        if(word.length() == 0){
            return 0;
        }
        String[] parts = word.split("\\s+");
        return parts.length;

    }
}
