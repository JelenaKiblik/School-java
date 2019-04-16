package ee.taltech.iti0202.testing;

import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SentenceTest {

    @Test
    public void testToString_EmptySentence_IsEmptyString() {
        Sentence sentence = new Sentence(); // Arrange
        String actual = sentence.toString(); // Act
        assertEquals("", actual); // Assert
    }

    @Test
    public void testAddWord_EmptySentenceNoPunctuation_IsTrue() {
        Sentence sentence = new Sentence();
        boolean result = sentence.addWord("Hello");
        assertTrue(result);
    }

    @Test
    public void testAddWord_SentenceWithPunctuation_IsFalse() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hello");
        sentence.addPunctuation(".");
        boolean result = sentence.addWord("World");
        assertFalse(result);
    }

    @Test
    public void testToString_ADD_PUNCTUATION_AFTER_PUNCTUATION() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hello");
        sentence.addPunctuation(".");
        boolean result = sentence.addPunctuation(".");
        assertFalse(result);
    }

    @Test
    public void testToString_REMOVE_PUNCTUATION_EVEN_IF_NO_PUNCTUATION() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hello");
        sentence.addPunctuation(".");
        boolean result = sentence.removePunctuation();
        assertTrue(result);

    }

    @Test
    public void testToString_REMOVE_PUNCTUATION_DOES_NOT_REMOVE() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hello");
        boolean result = sentence.removePunctuation();
        assertFalse(result);
    }

    @Test
    public void testToString_ADD_WORD_SPACE() {
        Sentence sentence = new Sentence();
        boolean result = sentence.addWord(" ");
        assertTrue(result);
    }

    @Test
    public void testToString_FORCE_LOWERCASE_FROM_SECOND() {
        Sentence sentence = new Sentence();
    }

    @Test
    public void testToString_EQUALS_PUNCTUATION_IGNORED_SECOND_SENTENCE() {
        Sentence sentence = new Sentence();
    }


    @Test
    public void testToString_ADD_PUNCTUATION_FIRST() {
        Sentence sentence = new Sentence();
        boolean result = sentence.addPunctuation(".");
        assertFalse(result);
    }

    @Test
    public void testToString_CONSTRUCTOR_VERY_SHORT_WORD() {
        Sentence sentence = new Sentence();
    }

    @Test
    public void testToString_CONSTRUCTOR_WORDS_AFTER_PUNCTUATION() {
        Sentence sentence = new Sentence();
    }


    @Test
    public void testToString_SPLIT_MULTIPLE_WHITESPACE() {
        Sentence sentence = new Sentence();
    }

    @Test
    public void testToString_Capital_Letter() {
        Sentence sentence = new Sentence();
    }
}
