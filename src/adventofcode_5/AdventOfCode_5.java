package adventofcode_5;

import java.util.ArrayList;

// To solve http://adventofcode.com/day/5 parts i and ii

public class AdventOfCode_5 
{
    final static String INPUT_FILE_NAME = "input.txt";
    
    public static void main(String[] args) 
    {
        if (FileParser.verifyInputFile(INPUT_FILE_NAME))
            naughtyOrNice();
    }

    // asks other functions to report if a given string is 'good' or 'bad',
    // then tallies and reports the sum of good results
    public static void naughtyOrNice()
    {
        ArrayList<String> stringList = FileParser.getStrings(INPUT_FILE_NAME);
        String target = null;
        int nicePart1 = 0;
        int nicePart2 = 0;
        
        for (int i = 0; i < stringList.size(); i++)
        {
            target = stringList.get(i);

            if (niceCheckPart1(target))
                nicePart1++;
            
            if (niceCheckPart2(target))
                nicePart2++;
        }
       
        System.out.println(nicePart1 + " children are nice in part i.");
        System.out.println(nicePart2 + " children are nice in part ii.");
    }
    
    // checks if a given string meets all the requisite conditions to be 
    // be considered 'good' for part 1 of the quesion
    public static boolean niceCheckPart1(String target)
    {
        boolean nice = false;
        
        if (StringChecker.threeVowelCheck(target) && 
                StringChecker.doubleLetterCheck(target) && 
                StringChecker.goodLetterCheck(target))
            nice = true;
        
        return nice;
    }
    
    // checks if a given string meets all the requisite conditions to be 
    // be considered 'good' for part 2 of the quesion
    public static boolean niceCheckPart2(String target)
    {
        boolean nice = false;
        
        if (StringChecker.pairOfPairsCheck(target) && 
                StringChecker.repeatBetweenCheck(target))
            nice = true;
        
        return nice;
    }
}