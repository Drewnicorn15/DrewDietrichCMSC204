import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class GradeBookTest {
	GradeBook gb1;
	GradeBook gb2;
	@BeforeEach
	public void setUp() throws Exception {
		gb1 = new GradeBook(5);
		gb1.addScore(100);
		gb1.addScore(75);
		gb1.addScore(80);
		gb2 = new GradeBook(5);
		gb2.addScore(95);
		gb2.addScore(80);
	}

	@AfterEach
	public void tearDown() throws Exception {
		gb1 = null;
		gb2 = null;
	}

	@Test
	public void testAddScore() {
		assertTrue(gb1.toString().equals("100.0 75.0 80.0 "));
	}
	@Test
        @SuppressWarnings("empty-statement")
	public void testSum() {
		assertEquals("test sum",255.0, gb1.sum(),0.0001);
	}

	@Test
	public void testMinimum() {
		assertEquals("test min", 80,gb2.minimum(),0.001);
	}

	@Test
	public void testFinalScore() {
		assertEquals("test final score",180,gb1.finalScore(),0.001);
	}
}
