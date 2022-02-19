package com.epam.mathfile.refactor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberParser {
    public static Data parse(String dataString) throws DataParserException {

        if(!validate(dataString)) {
            throw new DataParserException("Validation exception");
        } else {
            Data data = null;
            String[] elements = dataString.split(" ");
            switch (elements[elements.length - 1]) {
                case "+":
                    data = new Data(Integer.valueOf(elements[0]), Integer.valueOf(elements[1]), Sign.PLUS);
                    break;
                case "-":
                    data = new Data(Integer.valueOf(elements[0]), Integer.valueOf(elements[1]), Sign.MINUS);
                    break;
                case "*":
                    data = new Data(Integer.valueOf(elements[0]), Integer.valueOf(elements[1]), Sign.MULTIPLICATION);
                    break;
                case "/":
                    data = new Data(Integer.valueOf(elements[0]), Integer.valueOf(elements[1]), Sign.DIVISION);
                    break;
                default:
                    break;
            }
            return data;
        }
    }

    private static boolean validate(String data) {
        String pattern = "-?\\d+\\s-?\\d+\\s[\\+\\-\\*\\/]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(data);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
