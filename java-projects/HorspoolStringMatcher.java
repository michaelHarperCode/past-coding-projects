/**
This is the implementation of the Boyer-Moore-Horspool Algorithm (aka the Horspool Algorithm), used to find patterns in strings.
*/

import java.util.ArrayList;
import java.util.List;

public class HorspoolStringMatcher {
    int numberOfLetters = 0;
    int uniqueChar;
    List<Character> lettersSeen = new ArrayList<>();
    List<Integer> shiftTable = new ArrayList<>();
    String pattern;
    int patternLength;

    /**
     * Fills two lists; a list of each unique character, and the shift table.
     * @param s String of the pattern.
     */
    public HorspoolStringMatcher(String s) {
       //gets unique chars in string
       for(int i = 0; i < s.length(); i++){
           uniqueChar = 1;
           for (Character character : lettersSeen) {
               if (s.charAt(i) == character) {
                   uniqueChar = 0;
                   break;
               }
           }
           if(uniqueChar == 1) {
               numberOfLetters++;
               lettersSeen.add(s.charAt(i));
           }
       }
       lettersSeen.add('*');

       //assigns the numerical value of each char
        int[] charValues = new int[lettersSeen.size()];
        for(int i = 0; i < s.length(); i++){
            if(i == s.length() - 1){
                if(charValues[lettersSeen.indexOf(s.charAt(i))] == 0){
                    charValues[lettersSeen.indexOf(s.charAt(i))] = s.length();
                }
                else{
                    //do nothing, keep existing value
                }
            }
            else{
                charValues[lettersSeen.indexOf(s.charAt(i))] = s.length() - i - 1;
            }
        }
        charValues[charValues.length - 1] = s.length();
        for (int charValue : charValues) {
            shiftTable.add(charValue);
        }
        pattern = s;
        patternLength = pattern.length();
    }

    /**
     * Returns the shift table value of a given character, or the * value if the character doesn't have its own entry.
     * @param m the character being looked up.
     * @return the shift table value of the given character.
     */
    public int getShift(char m) {
      for(int i = 0; i < shiftTable.size() - 1; i++){
          if(m == lettersSeen.get(i)){
              return shiftTable.get(i);
          }
      }
        return shiftTable.get(shiftTable.size() - 1);
    }

    /**
     * Finds the location of the first match for String s and the pattern, or -1 if no match is found.
     * @param s The string being compared to against the current pattern.
     * @return The location of the first match, or -1.
     */
    public int match(String s) {
        int match = 0;
        int location = patternLength - 1;
        int compare = patternLength - 1;
        int innerLoopDone;
        while(location < s.length()){
            if(s.charAt(location) == pattern.charAt(compare)){
                match++;
                if(match == patternLength){
                    return location;
                }
                location--;
                compare--;
            }
            else{
                innerLoopDone = 0;
                for(int j = 0; j < lettersSeen.size() - 2; j++){
                    if(s.charAt(location) == lettersSeen.get(j)){
                        location = location + shiftTable.get(j);
                        compare = patternLength - 1;
                        innerLoopDone = 1;
                    }
                }
                if(innerLoopDone == 0) {
                    location = location + shiftTable.get(shiftTable.size() - 1);
                    compare = patternLength - 1;
                }
            }
        }
        return -1;
    }

}
