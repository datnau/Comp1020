import java.util.ArrayList;

public class Lab4Ex3 {

  public static void main(String [] args) {
    String[] strings = createStringArray();
    ArrayList<Word> words = stringsToWords(strings);

    printWordList(words);

    System.out.printf("\nNumber of unique words: %d\n", words.size());
    System.out.printf("Total number of words: %d\n", totalWordCount(words));
    System.out.printf("Average word length: %.3f\n", averageWordLength(words));

    System.out.println("\nEnd of processing.");
  }

  public static String[] createStringArray() {
    return new String[] {
      "O my Luve's like a red, red rose, That's newly sprung in June.",
      "O my Luve's like the melodie, That's sweetly play'd in tune.",
      "As fair art thou, my bonie lass, So deep in luve",
      "am I; And I will luve thee still, my dear, Till a' the seas gang dry."
    };
  }

  public static ArrayList<Word> stringsToWords(String[] s) {
    ArrayList<Word> result = new ArrayList<>();
    Word w;
    String[] tokens;

    for (int i = 0; i < s.length; i++) {
      tokens = s[i].split("[ ,;.]+");
      for (int j = 0; j < tokens.length; j++) {
        String word = tokens[j].toLowerCase();
        w = findWord(result, word);
        if (w == null) {
          result.add(new Word(word));
        } else {
          // Exercise 3: increase the count of times w appears
          w.increment();
        }
      }
    }

    return result;
  }

  // Exercise 3: linear search for a word in the array list
  public static Word findWord(ArrayList<Word> words, String word) {
    // return matching Word reference, or null
    for (int i = 0; i < words.size(); i++) {
      if (words.get(i).matches(word)) {
        return words.get(i);
      }
    }
    return null;
  }

  public static void printWordList(ArrayList<Word> words) {
    for (int i = 0; i < words.size(); i++)
      System.out.println(words.get(i));
  }

  public static int totalWordCount(ArrayList<Word> words) {
    int total = 0;

    for (int i = 0; i < words.size(); i++) {
      // Exercise 4: This should sum the number of times each word appears
      // total += ???
    }

    return total; // stays 0 for now
  }

  public static double averageWordLength(ArrayList<Word> words) {
    int total = 0;

    for (int i = 0; i < words.size(); i++) {
      // Exercise 4: This should sum the number of letters in every word
      // total += ???
    }

    return (double)total / totalWordCount(words); // 0/0 -> NaN, as required for ex3
  }
}

class Word {
  private String word;
  private int frequency;

  public Word(String w) {
    word = w;
    frequency = 1;
  }

  // Exercise 3: Add methods to this class
  // (Only 2 instance methods total; not getters/setters)

  // 1) used by findWord to test if this object represents the given word
  public boolean matches(String w) {
    return word.equals(w);
  }

  // 2) used when the word appears again
  public void increment() {
    frequency++;
  }

  public String toString() {
    return "Word: '" + word + "' frequency: " + frequency;
  }
}
