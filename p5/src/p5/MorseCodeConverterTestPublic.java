package p5;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;


public class MorseCodeConverterTestPublic {
	
	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ");
		assertEquals("hello world",converter1);
	}
	
	/**
	 * Testing for correct implementation of tree and traversal
	 */
	
	@Test
	public void testPrintTree() {	
		
		assertEquals("h s v i f u e l r a p w j   b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}
	
	/**
	 * Testing for correct conversion of all characters using key phrase to hit all letters
	 */
	
	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		String converter1 = MorseCodeConverter.convertToEnglish("- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --.");
		assertEquals("the quick brown fox jumps over the lazy dog", converter1);

	}
	@Test
	public void testConvertMorseFileToEnglishString() {	
		
		/*Make sure howDoILoveThee.txt is in the src directory for this 
		  test to pass
		*/
		File file = new File("C:\\Users\\drewd\\Downloads\\Assignment 5\\p5\\src\\p5\\howDoILoveThee.txt"); 
		try {
			assertEquals("how do i love thee let me count the ways", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			System.out.println(e);
			assertTrue("An unwanted exception was caught", false);
		}
	}
	

}
