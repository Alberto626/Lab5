import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\torta\\OneDrive\\Desktop\\INTELLJ TEST PROJECTS\\Lab5\\lincoln.txt");
        Scanner s = null;
        try {
            s = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            System.exit(0);
        }
        HashMap<String, Integer> countWords = new HashMap<>();
        HashMap<Character, Integer> countVowels = new HashMap<>();
        Set<String> words = new HashSet<>();
        s.useDelimiter("[^a-zA-Z]+");
        while(s.hasNext()) {
            String str = s.next().toLowerCase(Locale.ROOT);

            countVowels(countVowels,str);
            countWords(countWords, str);
            words.add(str);
        }
        for(char c: countVowels.keySet()) {
            System.out.println("Vowel " + c + ": " + countVowels.get(c));
        }
        for(String w: countWords.keySet()) {
            System.out.println(w + ": " + countWords.get(w));
        }
        List<String> sortedWords = new ArrayList<>(words);
        Collections.sort(sortedWords);
        System.out.println("Sorted Words:");
        for(String w: sortedWords) {
            System.out.println(w);
        }

    }
    public static boolean isValidWord() {
        return false;
    }
    public static void countWords(HashMap<String, Integer> countWord, String word) {
        if(!countWord.containsKey(word)) {
            countWord.put(word, 0);
        }
        int count = countWord.get(word);
        countWord.put(word, count + 1);

    }
    public static void countVowels(HashMap<Character, Integer> countVowels, String word) {
        if(countVowels.isEmpty()) {
            countVowels.put('a', 0);
            countVowels.put('e', 0);
            countVowels.put('i', 0);
            countVowels.put('o', 0);
            countVowels.put('u', 0);
        }
        for(int x = 0; x < word.length(); x++) {
            char currentChar = word.charAt(x);
            if(isVowel(currentChar)) {
                int vowelCount = countVowels.get(currentChar);
                countVowels.put(currentChar, vowelCount + 1);
            }
        }
    }
    public static boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}