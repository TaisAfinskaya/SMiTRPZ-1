import java.util.ArrayList;

public class FindUnique {
    public String[] findUniqueWords(String[] words) {
        ArrayList<String> wordWithUniqueChar = new ArrayList<String>();

        for (String word : words) {
            if(findUniqueChars(word)){
                wordWithUniqueChar.add(word);
            }
        }
        return wordWithUniqueChar.toArray(new String[0]);
    }
    public boolean findUniqueChars(String word) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}