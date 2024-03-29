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
    public void testEmptySentenceNoPunctuation_IsTrue() {
        Sentence sentence = new Sentence();
        boolean result = sentence.addWord("Hello");
        assertTrue(result);
    }

    @Test
    public void testRemoveWordTrue() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hei");
        boolean result = sentence.removeWord("Hei");
        assertTrue(result);
    }

    @Test
    public void testRemoveWordFalse() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hei");
        boolean result = sentence.removeWord("He");
        assertFalse(result);
    }

    @Test
    public void testRemoveWord_Empty() {
        Sentence sentence = new Sentence();
        boolean result = sentence.removeWord("He");
        assertFalse(result);
    }

    @Test
    public void testRemoveWordWithPunctuationFalse() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hei");
        sentence.addPunctuation(".");
        boolean result = sentence.removeWord("Hei");
        assertFalse(result);
    }

    @Test
    public void testSentenceWithPunctuation_IsFalse() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hello");
        sentence.addPunctuation(".");
        boolean result = sentence.addWord("World");
        assertFalse(result);
    }

    @Test
    public void testAddPunctuationAfterPunctuation() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hello");
        sentence.addPunctuation(".");
        boolean result = sentence.addPunctuation(".");
        assertFalse(result);
    }

    @Test
    public void testAddPunctuationIsTrue() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hello");
        boolean result = sentence.addPunctuation(".");
        assertTrue(result);
    }

    @Test
    public void testAddPunctuationFirst() {
        Sentence sentence = new Sentence();
        boolean result = sentence.addPunctuation(".");
        assertFalse(result);
    }

    @Test
    public void testRemovePunctuation() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hei");
        sentence.addPunctuation(".");
        boolean result = sentence.removePunctuation();
        assertTrue(result);
    }

    @Test
    public void testRemovePunctuationDoesNotRemove() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hi");
        boolean result = sentence.removePunctuation();
        assertFalse(result);
    }

    @Test
    public void testRemovePunctuationTwice() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hi");
        sentence.addPunctuation(".");
        sentence.removePunctuation();
        boolean result = sentence.removePunctuation();
        assertFalse(result);
    }

    @Test
    public void testAddEmptyWord() {
        Sentence sentence = new Sentence();
        boolean result = sentence.addWord("");
        assertFalse(result);
    }

    @Test
    public void testAddWordWithSpace() {
        Sentence sentence = new Sentence();
        boolean result = sentence.addWord("Hei ");
        assertFalse(result);
    }

    @Test
    public void SplitMultipleWhitespace() {
        Sentence sentence = new Sentence("i   like       apple");
        String actual = sentence.toString();
        assertEquals("I like apple...", actual);
    }

    @Test
    public void AddUpperCase() {
        Sentence sentence = new Sentence("i don't like apple");
        String actual = sentence.toString();
        assertEquals("I don't like apple...", actual);
    }

    @Test
    public void testConstructorPunctuation() {
        Sentence sentence = new Sentence("i don't like apple.");
        String actual = sentence.toString();
        assertEquals("I don't like apple.", actual);
    }

    @Test
    public void testConstructorPunctuation2() {
        Sentence sentence = new Sentence("i don't like apple???hello???");
        String actual = sentence.toString();
        assertEquals("I don't like apple???hello???", actual);
    }

    @Test
    public void testLowerCase() {
        Sentence sentence = new Sentence("I LIKE ORANGE");
        String actual = sentence.toString();
        assertEquals("I LIKE ORANGE...", actual);
    }

    @Test
    public void testEqualsTwoSentence() {
        Sentence sentence = new Sentence("I LIKE ORANGE...");
        Sentence sentence2 = new Sentence("I LIKE ORANGE");
        boolean result = sentence.equals(sentence2);
        assertTrue(result);
    }

    @Test
    public void testEqualsTwoSentencePunctuationIgnoredFirstSentence() {
        Sentence sentence = new Sentence("I LIKE ORANGE! And don't like apple.");
        Sentence sentence2 = new Sentence("I LIKE ORANGE!");
        boolean result = sentence.equals(sentence2);
        assertTrue(result);
    }

    @Test
    public void testEqualsTwoSentencePunctuationIgnoredFirstSentence2() {
        Sentence sentence = new Sentence("I like orange");
        Sentence sentence2 = new Sentence("I like orange.");
        boolean result = sentence.equals(sentence2);
        assertFalse(result);
    }
}
