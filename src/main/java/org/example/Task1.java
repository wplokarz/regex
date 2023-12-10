package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    Pattern pattern = Pattern.compile("UUID=\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}");

    public boolean checkIfOrder(String str) {
        Matcher matcher = this.pattern.matcher(str);
        return matcher.find();
    }
    public String checkOrderNumber(String str) {
        // Check if order number exists in provided string, if not exit program
        if (!checkIfOrder(str)) {
            System.out.println("No order number");
            System.exit(0);
        }
        Matcher matcher = this.pattern.matcher(str);
        return convertMatcherToString(matcher).substring(5);
    }
    public StringBuilder getUserEmail(String str) {
        Pattern pattern = Pattern.compile("\\w+@\\w+.\\w+");
        Matcher matcher = pattern.matcher(str);
        return convertMatcherToString(matcher);
    }

    private StringBuilder convertMatcherToString(Matcher matcher) {
        StringBuilder textFromString = new StringBuilder();
        while (matcher.find()) {
            String matchText = matcher.group(0);
            textFromString.append(matchText);
        }
        return textFromString;
    }

    public String getOrderNumber(String str) {
        Pattern pattern = Pattern.compile("processed: \\[\\d\\]");
        Matcher matcher = pattern.matcher(str);
        StringBuilder convertedString = convertMatcherToString(matcher);
        int startIndex = convertedString.indexOf("[") +1;
        int endIndex = convertedString.indexOf("]");
    return convertedString.substring(startIndex,endIndex);
    }

    public boolean printWordsStartingWithDe(String str) {
        Pattern pattern = Pattern.compile("\\bde[a-z]*");
        Matcher matcher = pattern.matcher(str);
        List<String> listOfMatchingWords = getWordsFromString(matcher);
        boolean isEmpty = listOfMatchingWords.isEmpty();
        if (isEmpty) {
            System.out.println("No matches found");
            return false;
        }
        for (String word: listOfMatchingWords) {
            System.out.println(word);
        }
        return true;
    }

    private List<String> getWordsFromString(Matcher matcher) {
        List<String> textFromString = new ArrayList<>();
        while (matcher.find()) {
            String matchText = matcher.group(0);
            textFromString.add(matchText);
        }
        return textFromString;
    }
}
