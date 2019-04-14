package ee.taltech.iti0202.testing;

import static org.junit.Assert.*;
import ee.taltech.iti0202.sentence.Sentence;
import org.junit.Test;

public class SentenceTest {

    @Test
    public void testToString_EmptySentence_IsEmptyString() {
        Sentence sentence = new Sentence(); // Arrange

        String actual = sentence.toString(); // Act

        assertEquals("", actual); // Assert
    }


}