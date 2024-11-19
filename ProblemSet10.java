
public class ProblemSet10 {
    public static void main(String[] args) {
        System.out.println(isValidPassword("sdfghjk"));
        System.out.println(isValidFilename("sdfghjk", "Windows"));
        System.out.println(extractTitle("<item><title>Split (2017)</title><meta><imdb>6375308</imdb></meta>"));
        System.out.println(swearFilter("A duck was sailing on a ship shipping whole wheat bread. Duck that SHIP!!!",
                new String[]{"duck","ship", "whole"}));


    }
    public static boolean isValidPassword(String s){
        if (s.length() < 6 || s.length() > 8) {
            return false;
        }
        String passwordPattern = "^([A-Z!@#])([\\w]{5,7})([^*%.])$";
        if (!s.matches(passwordPattern)) {
            return false;
        }
        if (s.matches(".*\\s.*")) {
            return false;
        }

        return true;
    }

public static boolean isValidFilename(String filename, String sys) {
    if (sys.equals("Windows")) {
        if (filename.matches("^\\s+|\\s+$")) return false;
        if (filename.matches(".*[/?<>\\:*|.\"]+.*")) return false;
        if (filename.length() >= 4 && filename.substring(filename.length() - 4).matches("com[1-9]")) return false;
        int lastDot = filename.lastIndexOf('.');
        if (lastDot == -1 || lastDot == 0 || lastDot == filename.length() - 1) return false;
        String extension = filename.substring(lastDot + 1);
        if (!extension.matches("[a-z]{2,6}")) return false;
    }

    if (sys.equals("Mac") || sys.equals("Linux")) {
        if (filename.contains(".") || filename.contains(":")) return false;
        int lastDot = filename.lastIndexOf('.');
        if (lastDot == -1 || lastDot == 0 || lastDot == filename.length() - 1) return false;
        String extension = filename.substring(lastDot + 1);
        if (!extension.matches("[a-zA-Z]{2,6}")) return false;
    }

    return true;
}


    public static String extractTitle(String s) {
        int startIndex = s.indexOf("<title>") + 7;
        int endIndex = s.indexOf("</title>");

        if (startIndex == 6 || endIndex == -1) {
            return ""; // Return empty string if no valid title tags are found
        }

        return s.substring(startIndex, endIndex);
    }



public static String swearFilter(String text, String[] swear) {
    for (String word : swear) {
        String maskedWord = word.charAt(0) + "*".repeat(word.length() - 2) + word.charAt(word.length() - 1);
        String regex = "(?i)\\b" + word + "\\b";  // case-insensitive matching for whole words
        text = text.replaceAll(regex, maskedWord);
    }
    return text;
}

}
