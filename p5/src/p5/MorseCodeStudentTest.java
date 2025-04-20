package p5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MorseCodeStudentTest {
    @Test
    public void testTpArray()
    {
        MorseCodeTree MCT = new MorseCodeTree();
        String[] howItShouldLook = {"h","s","v","i","f","u","e","l","r","a","p","w","j"," ","b","d","x","n","c","k","y","t","z","g","q","m","o"};
        assertArrayEquals(howItShouldLook,MCT.toArrayList().toArray());
    }
    @Test
    public void testConvertToEnglishString() 
    { 
        String convert = MorseCodeConverter.convertToEnglish(".. -- / .... .- .-.. ..-. / -.-. .-. .- --.. -.-- / .- .-.. .-.. / ..-. --- .-. / - .... . / .-.. --- ...- . / --- ..-. / -.-- --- ..-");
        assertEquals("im half crazy all for the love of you",convert);
    }
}
