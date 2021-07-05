package utils;

public class StringUtils {

    private static final String LEFT_BRACKET = "(";
    private static final String RIGHT_BRACKET = ")";
    private static final String COMMA_SEPARATOR = ", ";

    public static String appendBrackets(String value) {
        return LEFT_BRACKET + value + RIGHT_BRACKET;
    }


    public static String createListOfValues(String[] values) {
        return appendBrackets(String.join(COMMA_SEPARATOR, values));
    }
}
