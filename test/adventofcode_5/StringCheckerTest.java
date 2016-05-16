package adventofcode_5;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringCheckerTest {
    
    public StringCheckerTest() {
    }
    
    @Test
    public void testThreeVowelCheck() {
        assertEquals("reports an empty string as true", StringChecker.threeVowelCheck(""), false);
        assertEquals("reports non-vowels true", StringChecker.threeVowelCheck("bcd"), false);
        assertEquals("reports one vowel as true", StringChecker.threeVowelCheck("abc"), false);
        assertEquals("reports two vowels as true", StringChecker.threeVowelCheck("abu"), false);
        assertEquals("reports repeating vowels as false", StringChecker.threeVowelCheck("aaa"), true);
        assertEquals("reports three different vowels as false", StringChecker.threeVowelCheck("aeu"), true);
        assertEquals("reports four vowels as false", StringChecker.threeVowelCheck("ueia"), true);
    }

    @Test
    public void testDoubleLetterCheck() 
    {
        assertEquals("reports double letter as false", StringChecker.doubleLetterCheck("aa"), true);
        assertEquals("reports triple letter as false", StringChecker.doubleLetterCheck("aaa"), true);
        assertEquals("reports double letter at start of line as false", StringChecker.doubleLetterCheck("aabcd"), true);
        assertEquals("reports double letter at end of line as false", StringChecker.doubleLetterCheck("bcdaa"), true);
        assertEquals("reports single letter as true", StringChecker.doubleLetterCheck("a"), false);
        assertEquals("reports non-doubles as true", StringChecker.doubleLetterCheck("ab"), false);
        assertEquals("reports non-consecutative as true", StringChecker.doubleLetterCheck("aba"), false);
        assertEquals("reports an empty string as true", StringChecker.doubleLetterCheck(""), false);
    }

    @Test
    public void testGoodLetterCheck() {
        assertEquals("Empty string reporting false", StringChecker.goodLetterCheck(""), true);
        assertEquals("String with no alpha chars reporting false", StringChecker.goodLetterCheck(" "), true);
        assertEquals("Valid string reporting false", StringChecker.goodLetterCheck("aa"), true);
        assertEquals("String with ab reporting true", StringChecker.goodLetterCheck("ab"), false);
        assertEquals("String with ab at the end reporting true", StringChecker.goodLetterCheck("aab"), false);
        assertEquals("String with ab at the start reporting true", StringChecker.goodLetterCheck("aba"), false);
        assertEquals("String with cd reporting true", StringChecker.goodLetterCheck("cd"), false);
        assertEquals("String with pq reporting true", StringChecker.goodLetterCheck("pq"), false);
        assertEquals("String with xy reporting true", StringChecker.goodLetterCheck("xy"), false);
        assertEquals("String from the example reporting true", StringChecker.goodLetterCheck("haegwjzuvuyypxyu"), false);
    }

    @Test
    public void testPairOfPairsCheck() {
        assertEquals("Empty string reporting true", StringChecker.pairOfPairsCheck(""), false);
        assertEquals("Single character reporting true", StringChecker.pairOfPairsCheck("a"), false);
        assertEquals("Two characters reporting true", StringChecker.pairOfPairsCheck("aa"), false);
        assertEquals("Three characters reporting true", StringChecker.pairOfPairsCheck("aaa"), false);
        assertEquals("Four identical characters reporting false", StringChecker.pairOfPairsCheck("aaaa"), true);
        assertEquals("Two pairs seperated reporting false", StringChecker.pairOfPairsCheck("aabaa"), true);
        assertEquals("Two concecutive pairs at the end reporting false", StringChecker.pairOfPairsCheck("baaaa"), true);
        assertEquals("Two concecutive pairs at the start reporting false", StringChecker.pairOfPairsCheck("aaaab"), true);
        assertEquals("Given sample reporting false", StringChecker.pairOfPairsCheck("qjhvhtzxzqqjkmpb"), true);
    }

    @Test
    public void testRepeatBetweenCheck() {
        assertEquals("Empty string reporting true", StringChecker.repeatBetweenCheck(""), false);
        assertEquals("Single character reporting true", StringChecker.repeatBetweenCheck("a"), false);
        assertEquals("Two characters reporting true", StringChecker.repeatBetweenCheck("aa"), false);
        assertEquals("Repeated same character reporting false", StringChecker.repeatBetweenCheck("aaa"), true);
        assertEquals("Valid repeat reporting false", StringChecker.repeatBetweenCheck("aabaa"), true);
        assertEquals("Valid repeat at start reporting false", StringChecker.repeatBetweenCheck("baaaa"), true);
        assertEquals("Valid repeat at end reporting false", StringChecker.repeatBetweenCheck("aaaab"), true);
        assertEquals("Given sample input reporting false", StringChecker.repeatBetweenCheck("xyx"), true);
        assertEquals("Given sample input reporting false", StringChecker.repeatBetweenCheck("abcdefeghi"), true);
        assertEquals("Given sample input reporting false", StringChecker.repeatBetweenCheck("efe"), true);
    }    
}