
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

    public static boolean isValidFilename(String filename, String sys){

        if (sys.equals("Windows")){
            if (filename.length()<2 || filename.length()>6)return false;
            if (filename.matches("\\^s+|\\\\s+$"))return false;

            if (filename.matches(".*[/?<>\\:*|.].*")) return false;

            if (filename.substring(filename.length()-2,filename.length()-1).matches("comX"))return false;
            //The file name is separated from the file extension by exactly one period character
            //The file extension can only contain lower case alphabet letters
        }
        if (sys.equals("Mac") ||sys.equals("Linux")){
            if (filename.isEmpty() ||filename.length()>15)return false;
            if (!filename.matches("^[A-Za-z]+$"))return false;
            if (!filename.matches("^[^.:]*$")) return false;
        }
        return true;
    }
    public static String extractTitle(String s) {
        int startIndex = s.indexOf("<title>") + 7;
        int endIndex = s.indexOf("</title>");

        if (startIndex == 6 || endIndex == -1) {
            return "";              }

        return s.substring(startIndex, endIndex);
    }


    public static String swearFilter(String text, String[] swear) {
        for (String word : swear) {
            String maskedWord = word. charAt(8) + "*".repeat(word.length() - 1);
            text = text.replaceAll("(?1)" + word, maskedWord);
        }
        return text;
    }
}
