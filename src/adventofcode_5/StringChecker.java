package adventofcode_5;

import java.util.regex.Pattern;

// A collection of helper methods used to verify if given strings match
// the desired patterns

public class StringChecker 
{
    // checks for at least three vowels in any position
    public static boolean threeVowelCheck(String target)
    {
        boolean result = Pattern.matches("^.*[aeiou].*[aeiou].*[aeiou].*$", target);
        return result;
    }

    // checks if any doubled (consecutive) letters exist
    public static boolean doubleLetterCheck(String target)
    {
        boolean result = Pattern.matches("^(.*)([a-z])\\2(.*)$", target);
        return result;
    }

    // checks if any forbidden character pairs exist and if so, returns false
    public static boolean goodLetterCheck(String target)
    {
        boolean result = !(Pattern.matches("^.*(ab|cd|pq|xy).*$", target));
        return result;
    }    

    // checks if any pairs of two-character strings exist
    // ie. aeae is fine (ae repeats)
    // ie. zyabcdefghijzy is fine (zy eventually repeats)
    // they cannot overlap (ie. 'aaaa' is good but 'aaa' is not)
    public static boolean pairOfPairsCheck(String target)
    {
        boolean result = Pattern.matches("^(.*)(..)(.*)(\\2)(.*)$", target);
        return result;
    }    
    
    // checks if any characters repeat after one interposing character
    // for example, 'aba' has 'a' repeat after an interposing 'b'
    // the interposing character does not matter; cases like 'aaa' are fine
    public static boolean repeatBetweenCheck(String target)
    {
        boolean result = Pattern.matches("^(.*)(.)(.)(\\2)(.*)$", target);
        return result;
    }    
}
