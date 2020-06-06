import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class FindUniqueTest {
    @Test
    public void findUniqueWords() {
        FindUnique uniqueFinder = new FindUnique();
        String[] words = {"sun", "cloud", "rain", "nocloud"};
        String[] expectedResult = {"sun","cloud", "rain"};

        String[] actualResult = uniqueFinder.findUniqueWords(words);

        assertArrayEquals(expectedResult, actualResult);

    }
    @Test
    public void findUniqueCharsTrue() {
        FindUnique uniqueFinder = new FindUnique();
        String word = "rain";

        boolean positive = uniqueFinder.findUniqueChars(word);

        assertTrue(positive);
    }

    @Test
    public void findUniqueCharsFalse() {
        FindUnique uniqueFinder = new FindUnique();
        String word = "nocloud";

        boolean negative = uniqueFinder.findUniqueChars(word);

        assertTrue(!negative);
    }
}
