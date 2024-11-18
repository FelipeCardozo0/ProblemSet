
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
            if (filename.matches(".*[/?<>\\\\:*|\"].*")) return false;
            if (filename.matches(".*com[1-9]$")) return false;
            if (filename.indexOf(".") == -1 || filename.indexOf(".") != filename.lastIndexOf(".")) return false;
            String[] parts = filename.split("\\.");
            String name = parts[0];
            String extension = parts[1];
            if (!extension.matches("^[a-z]+$")) return false;
            if (extension.length() < 2 || extension.length() > 6) return false;
        }

        if (sys.equals("Mac") || sys.equals("Linux")) {
            if (filename.contains(":") || filename.indexOf(".") == -1) return false;
            String[] parts = filename.split("\\.");
            if (parts.length != 2) return false;
            String name = parts[0];
            String extension = parts[1];
            if (!extension.matches("^[a-z]+$")) return false;
            if (extension.length() < 2 || extension.length() > 6) return false;
            if (name.contains(":") || name.contains(".")) return false;
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
            String maskedWord = word.charAt(0) + "*".repeat(word.length() - 1);
            text = text.replaceAll("(?i)" + word, maskedWord);
        }
        return text;
    }
}
