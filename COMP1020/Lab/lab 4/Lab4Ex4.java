import java.util.ArrayList;

public class Lab4Ex4 {

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
          w.increment();
        }
      }
    }

    return result;
  }

  public static Word findWord(ArrayList<Word> words, String word) {
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
      // Exercise 4: sum the number of times each word appears
      total += words.get(i).getFrequency();
    }

    return total;
  }

  public static double averageWordLength(ArrayList<Word> words) {
    int totalLetters = 0;

    for (int i = 0; i < words.size(); i++) {
      // Exercise 4: sum letters for every occurrence of each word
      totalLetters += words.get(i).getWordLength() * words.get(i).getFrequency();
    }

    return (double) totalLetters / totalWordCount(words);
  }
}

class Word {
  private String word;
  private int frequency;

  public Word(String w) {
    word = w;
    frequency = 1;
  }

  public boolean matches(String w) {
    return word.equals(w);
  }

  public void increment() {
    frequency++;
  }

  // Exercise 4: Add two getters (not the word itself)
  public int getFrequency() {
    return frequency;
  }

  public int getWordLength() {
    return word.length();
  }

  public String toString() {
    return "Word: '" + word + "' frequency: " + frequency;
  }
}
