package com.telstra.assinment.springbootmongodb.validation;

import com.telstra.assinment.springbootmongodb.model.JsonMessageRequest;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JsonRequestValidation {

    //Validate the data types of the incoming JSON request.
    public boolean Validate(JsonMessageRequest jsonMessageRequest) {

        if(jsonMessageRequest == null)
        {
            return false;
        }
        else
        {
            if(jsonMessageRequest.getWhiteSpacesGalore() == null || jsonMessageRequest.getWhiteSpacesGalore().equals("")) {
                return false;
            }
            else if(jsonMessageRequest.getFindDuplicates() == null || jsonMessageRequest.getFindDuplicates().equals("")) {
                return false;
            }
            else if(jsonMessageRequest.getNumbersMeetNumbers() == null)
            {
                return false;
            }
        }

        return true;
    }

    /*
    a) Store the JSON request in MongoDB (refer to below incoming request sample using "id":"{{$randomInt}}") into:
    --> An “incoming” collection
    b) Validate the data types of the incoming JSON request. (string, boolean, integer)
    c) Build the following methods to manage the data and store the results in a MongoDB “outgoing” collection:
    --> Select the largest number from the array “numbersMeetNumbers”
    --> Find any duplicates in the string “findDuplicates”
    --> Remove whitespaces from “whiteSpacesGalore” without using replace()
     */
    public void transformData(JsonMessageRequest input)
    {
        //generating unique id
        input.setId(generateUniqueId());

        //Checking for duplicates assigning back
        ArrayList<Character> arr = FindDuplicates(input.getFindDuplicates());

        //Find duplicates
        input.setFindDuplicates(arr.toString());

        //Removing white space assigning back
        input.setWhiteSpacesGalore(RemoveWhiteSpace(input.getWhiteSpacesGalore()));

        int largestNumber = FindLargestNumber(input.getNumbersMeetNumbers());

        input.setLargestNumber(largestNumber);
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
        String result ="";

        Scanner sc = new Scanner(inputString);

        while(sc.hasNext()) {
            result += sc.next();
        }

        return result;
    }



    // Find any duplicates in the string “findDuplicates”
    private ArrayList<Character> FindDuplicates(String inputString)
    {

        ArrayList<Character> methodResult = new ArrayList<Character>();
        int count;
        //Converts given string into character array
        char inputStringArray[] = inputString.toCharArray();


        //Counts each character present in the string
        for(int i = 0; i <inputStringArray.length; i++) {
            count = 1;
            for(int j = i+1; j <inputStringArray.length; j++) {
                if(inputStringArray[i] == inputStringArray[j] && inputStringArray[i] != ' ') {
                    count++;
                    //Set string[j] to 0 to avoid printing visited character
                    inputStringArray[j] = '0';
                }
            }
            //A character is considered as duplicate if count is greater than 1
            if(count > 1 && inputStringArray[i] != '0') {
                methodResult.add(inputStringArray[i]);
            }
        }

        return methodResult;
    }

    private int FindLargestNumber(int [] inputIntArray) {
        int size = inputIntArray.length;
        Arrays.sort(inputIntArray);
        int largestNumber = inputIntArray[size-1];
        return largestNumber;
    }

}
