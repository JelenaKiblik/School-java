package ee.taltech.iti0202.testing;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SentenceTest {
    

    @Test
    public void testToString_EmptySentence_IsEmptyString() {
        Sentence sentence = new Sentence(); // Arrange

        String actual = sentence.toString(); // Act

        assertEquals("", actual); // Assert
    }
}

