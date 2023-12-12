package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    Pattern pattern = Pattern.compile("UUID=\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}");

    // Find and return true or false if String contains orderUUID
    public boolean checkUUIDexistsInString(String str) {
        Matcher matcher = this.pattern.matcher(str);
        return matcher.find();
    }

    // Get UUIDnumber if exists in provided string, if not exit program
    public String getUUIDnumber(String str) {
        if (!checkUUIDexistsInString(str)) {
            System.out.println("No order number");
            System.exit(0);
        }
        Matcher matcher = this.pattern.matcher(str);
        return convertMatcherToString(matcher).substring(5);
    }

    // get user email address from provided string
    public StringBuilder getUserEmail(String str) {
        Pattern pattern = Pattern.compile("\\w+@\\w+.\\w+");
        Matcher matcher = pattern.matcher(str);
        return convertMatcherToString(matcher);
    }

    // get matcher and return as string
    private StringBuilder convertMatcherToString(Matcher matcher) {
        StringBuilder textFromString = new StringBuilder();
        while (matcher.find()) {
            String matchText = matcher.group(0);
            textFromString.append(matchText);
        }
        return textFromString;
    }

    // return order number from provided string
    public String getOrderNumber(String str) {
        Pattern pattern = Pattern.compile("processed: \\[\\d\\]");
        Matcher matcher = pattern.matcher(str);
        StringBuilder convertedString = convertMatcherToString(matcher);
        int startIndex = convertedString.indexOf("[") +1;
        int endIndex = convertedString.indexOf("]");
    return convertedString.substring(startIndex,endIndex);
    }

    // print words starting with 'de' in provided string
    public boolean printWordsStartingWithDe(String str) {
        Pattern pattern = Pattern.compile("\\bde[a-z]*");
        Matcher matcher = pattern.matcher(str);
        List<String> listOfMatchingWords = new ArrayList<>();
        while (matcher.find()) {
            String matchText = matcher.group(0);
            listOfMatchingWords.add(matchText);
        }
        if (listOfMatchingWords.isEmpty()) {
            System.out.println("No matches found");
            return false;
        }
        for (String word: listOfMatchingWords) {
            System.out.println(word);
        }
        return true;
    }
}
