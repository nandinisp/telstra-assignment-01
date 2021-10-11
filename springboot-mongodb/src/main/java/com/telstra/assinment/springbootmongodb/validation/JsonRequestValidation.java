package com.telstra.assinment.springbootmongodb.validation;

import com.telstra.assinment.springbootmongodb.model.JsonMessageRequest;

import java.util.*;
import java.util.regex.Pattern;

public class JsonRequestValidation {

    public boolean isValid(JsonMessageRequest input)
    {
        boolean hasDuplicates=false;

        //generating unique id
        input.setId(generateUniqueId());

        //Checking for duplicates assigning back
        ArrayList<Character> arr = FindDuplicates(input.getFindDuplicates());

        //Find duplicates
        input.setFindDuplicates(arr.toString());

        //Removing white space assigning back
        input.setWhiteSpacesGalore(RemoveWhiteSpace(input.getWhiteSpacesGalore()));

        return true;
    }

    //Generating unique id
    public static int generateUniqueId() {
        UUID idOne = UUID.randomUUID();
        String str=""+idOne;
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        return Integer.parseInt(str);
    }

    // Remove whitespaces without using replace()
    private String RemoveWhiteSpace(String inputString)
    {
        boolean searchPerformed = false;
        boolean whitespaceFound = false;
        String methodResult = null;
        String[]  whitespaceSubstrings = inputString.split("\\s+");

        if (whitespaceSubstrings.length>0)
        {
            // Remove whitespace.
            methodResult = loopWhitespaceRemoval(inputString, whitespaceSubstrings);
        }
        else
        {
            // No whitespace found - Return original.
            methodResult = inputString;
        }

        return methodResult;
    }

    // Loops whitespace substrings.
    private String loopWhitespaceRemoval(String inpString,String[] wsArr)
    {
        int matchIndex = 0;			// Substring index.
        int startPoint = 0;			// Index within full string.

        String currentMatch = "";
        int currentCutoff = -1;
        String currentSafeText = "";

        String textRes = "";

        for (matchIndex = 0; matchIndex < wsArr.length; matchIndex = matchIndex + 1)
        {
            // Read current whitespace and find location.
            currentMatch = wsArr[matchIndex];
            currentCutoff = inpString.indexOf(currentMatch, startPoint);
            currentSafeText = "";

            // Whitespace exists.
            if (currentCutoff >= startPoint && currentCutoff < inpString.length())
            {
                // Substring text until whitespace. Add to result.
                currentSafeText = inpString.substring(startPoint, currentCutoff);
                textRes += currentSafeText;

                // Skip whitespace.
                startPoint = currentCutoff + currentMatch.length();
            }
        }

        // Add final substring to result.
        textRes += inpString.substring(startPoint);
        return textRes;
    }

    // Find any duplicates in the string “findDuplicates”
    private ArrayList<Character> FindDuplicates(String inputString)
    {

        ArrayList<Character> methodResult = new ArrayList<Character>();

        methodResult = loopCharacters(inputString);

        return methodResult;
    }

    // Loop string characters to find duplicates.
    private ArrayList<Character> loopCharacters(String inpStr)
    {
        int charIndex = 0;
        char currentChar;
        int currentDuplicate = -1;
        boolean currentUsed = false;


        ArrayList<Character> dupeRes = new ArrayList<Character>();


        for (charIndex = 0; charIndex < inpStr.length(); charIndex = charIndex + 1)
        {
            currentChar = inpStr.charAt(charIndex);
            currentDuplicate = inpStr.indexOf(currentChar, charIndex + 1);	// Search rest of string for char.
            currentUsed = dupeRes.contains(currentChar);

            // Character used again in rest of string, hasn't already been noted.
            if (currentDuplicate > charIndex && currentDuplicate < inpStr.length() && currentUsed != true)
            {
                dupeRes.add(currentChar);
            }
        }

        return dupeRes;
    }
}
