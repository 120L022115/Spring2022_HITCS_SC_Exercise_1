package exercise_6_6;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HIndexTest {

	/**
	 * Testing Strategy: 
	 * ������ĳ��Ƚ��л��֣�0,1,2,n(>2) 
	 * ��ֵ���֣���������0����ֵ��С�������������ַ�
	 * ���������ֵ��С����1��<1����2��<2����n��<n 
	 * �����ֵ��С�����ֶ�һ����һ����������С��һ��С��������
	 * 
	 * �����ѿ�����ȫ���ǡ�������Ʋ�������
	 * �򰴡�ÿ��ȡֵ���ٸ���һ�Ρ�����
	 */

	@Test
	public void testSameCitationNumbers() {
		assertEquals(0, HIndex.calcHIndex("0,0,0,0,0,0,0"));
		assertEquals(4, HIndex.calcHIndex("5,5,5,5"));
		assertEquals(5, HIndex.calcHIndex("5,5,5,5,5"));
		assertEquals(5, HIndex.calcHIndex("5,5,5,5,5,5"));
	}
	
	@Test
	public void testOneBigCitationNumbers() {
		assertEquals(5, HIndex.calcHIndex("5,5,5,5,5,500"));
	}
	
	@Test
	public void testOneSmallCitationNumbers() {
		assertEquals(5, HIndex.calcHIndex("5,500,500,500,500,500"));
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	// covers ���볤��=0
	//@Test(expected = IllegalArgumentException.class)
	@Test
	public void testEmptyInput() throws IllegalArgumentException {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Empty input");
		HIndex.calcHIndex("");
	}

	// covers ���볤��=1��������/0
	@Test
	public void testOneInput() {
		assertEquals(0, HIndex.calcHIndex("0"));
		assertEquals(1, HIndex.calcHIndex("10"));
	}

	// covers ���볤��=2��������/0
	@Test
	public void testTwoInput() {
		assertEquals(0, HIndex.calcHIndex("0,0"));
		assertEquals(1, HIndex.calcHIndex("1,4"));
		assertEquals(2, HIndex.calcHIndex("2,4"));
	}

	// covers ���볤��>2��������/0
	@Test
	public void testMultipleInput() {
		assertEquals(0, HIndex.calcHIndex("0,0,0"));
		assertEquals(1, HIndex.calcHIndex("1,4,1"));
		assertEquals(2, HIndex.calcHIndex("2,4,4"));
		assertEquals(3, HIndex.calcHIndex("3,4,4"));
	}

	// covers ���������ֵ
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeInput() throws IllegalArgumentException {
		HIndex.calcHIndex("0,-2,0");
	}

	// covers �������С��
	//@Test(expected = IllegalArgumentException.class)
	@Test
	public void testNumberWithDigitalInput() throws IllegalArgumentException {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("2.3 is illegal");
		HIndex.calcHIndex("1,2.3,0");
	}

	// covers ������������ַ�
	//@Test(expected = IllegalArgumentException.class)
	@Test
	public void testIllegalCharacterInput() throws IllegalArgumentException {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("6e8 is illegal");
		HIndex.calcHIndex("1,6e8,3#*");
	}
}
