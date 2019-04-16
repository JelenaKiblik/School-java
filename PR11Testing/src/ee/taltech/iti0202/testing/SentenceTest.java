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
    public void testToString_RemoveWordTrue() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hei");
        boolean result = sentence.removeWord("Hei");
        assertTrue(result);
    }

    @Test
    public void testToString_RemoveWordFalse() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hei");
        boolean result = sentence.removeWord("He");
        assertFalse(result);
    }

    @Test
    public void testToString_RemoveWord_Empty() {
        Sentence sentence = new Sentence();
        boolean result = sentence.removeWord("He");
        assertFalse(result);
    }

    @Test
    public void testToString_RemoveWordWithPunctuationFalse() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hei");
        sentence.addPunctuation(".");
        boolean result = sentence.removeWord("Hei");
        assertFalse(result);
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
    public void testToString_AddPunctuationAfterPunctuation() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hello");
        sentence.addPunctuation(".");
        boolean result = sentence.addPunctuation(".");
        assertFalse(result);
    }

    @Test
    public void testToString_RemovePunctuationEvenIfNoPunctuation() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hei");
        sentence.addPunctuation(".");
        boolean result = sentence.removePunctuation();
        assertTrue(result);
    }

    @Test
    public void testToString_AddPunctuationAfterPunctuation2() {
        Sentence sentence = new Sentence();
        sentence.addPunctuation(".");
        boolean result = sentence.addPunctuation(".");
        assertFalse(result);
    }

    @Test
    public void testToString_RemovePunctuationDoesNotRemove() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hi");
        boolean result = sentence.removePunctuation();
        assertFalse(result);
    }

    @Test
    public void testToString_RemovePunctuation() {
        Sentence sentence = new Sentence();
        sentence.addWord("Hi");
        sentence.addPunctuation(".");
        boolean result = sentence.removePunctuation();
        assertTrue(result);
    }

    @Test
    public void testToString_AddWordSpace() {
        Sentence sentence = new Sentence();
        boolean result = sentence.addWord(" ");
        assertFalse(result);
    }

    @Test
    public void testToString_AddWordWithSpace() {
        Sentence sentence = new Sentence();
        boolean result = sentence.addWord("Hei ");
        assertFalse(result);
    }

    @Test
    public void testToString_AddPunctuationFirst() {
        Sentence sentence = new Sentence();
        boolean result = sentence.addPunctuation(".");
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
    public void testPunctuation() {
        Sentence sentence = new Sentence("i don't like apple.");
        String actual = sentence.toString();
        assertEquals("I don't like apple.", actual);
    }
}
