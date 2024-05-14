package util;

public class RemoveBlank {
    public static String removeBlank(String string) {
        String trimString = string.trim();
        String replaceString = trimString.replaceAll("\\s+", "");
        return replaceString;
    }
}
