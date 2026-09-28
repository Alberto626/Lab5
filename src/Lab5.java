import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Lab5 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\torta\\OneDrive\\Desktop\\INTELLJ TEST PROJECTS\\Lab5\\lincoln.txt");
        Scanner s = null;
        try {
            s = new Scanner(file);
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
        Set<String> words = new HashSet<>();
        HashMap<Character, Integer> countVowels = new HashMap<>();
        HashMap<String, Integer> countWords = new HashMap<>();
        int totalWords = 0;

        String pattern = "[^a-zA-Z]+";//separater for anything thats NOT a letter in the alphabet
        s.useDelimiter(pattern);

        while(s.hasNext()) {
            String str = s.next().toLowerCase();

            countVowels(countVowels, str);
            countWords(countWords, str);
            words.add(str);
            totalWords++;
        }
        List<String> sortedWords = new ArrayList<>(words);
        Collections.sort(sortedWords);
        printSolutions(countVowels, countWords, sortedWords, totalWords);

    }
    public static void printSolutions(HashMap<Character, Integer> countVowels, HashMap<String, Integer> countWords, List<String> sortedWords, int totalWords) {
        for(char c: countVowels.keySet() ) {
            System.out.println("Vowel " + c + ": " + countVowels.get(c));
        }

        for(String w: countWords.keySet()) {
            System.out.println(w + ": " + countWords.get(w));
        }

        System.out.println("Sorted Words");
        for(String w: sortedWords) {
            System.out.println(w);
        }
        System.out.println("Total number of words: " + totalWords);
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
            char currentWord = word.charAt(x);
            if(isVowel(currentWord)) {
                int vowelCount = countVowels.get(currentWord);
                countVowels.put(currentWord, vowelCount + 1);
            }
        }

    }
    public static boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ) {
            return true;
        }
        return false;

    }
}
