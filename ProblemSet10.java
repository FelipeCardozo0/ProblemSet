
            import java.util.regex.*;
            public class ProblemSet10 {
                public static void main(String[] args) {
                    System.out.println(isValidPassword("sdfghjk"));
                    System.out.println(isValidFilename("homework5.java","Linux"));
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

                ///////////////////////
                public static boolean isValidFilename(String filename, String sys){

                    if (sys.equals("Windows")){
                        if (filename.length()<2 || filename.length()>6)return false;
                        if (filename.matches("\\^s+|\\\\s+$"))return false;

                        if (filename.matches(".*[/?<>\\:*|.].*")) return false;

                        if (filename.substring(filename.length()-2,filename.length()-1).matches("comX"))return false;

                    }
                    if (sys.equals("Mac") ||sys.equals("Linux")){
                        // Rule 1: No period or colon allowed except for exactly one period separating the name and extension
                        if (filename.matches(".*[:].*|.*[.].*")) return false;
                        String[] parts = filename.split("\\.");

                        // Rule 2: Exactly one period separating the name and extension
                        if (parts.length != 2) return false; // If there's not exactly one period, return false

                        // Rule 3: The extension must only contain alphabet letters
                        if (!parts[1].matches("^[A-Za-z]+$")) return false;

                        // Rule 4: The extension length must be between 2 and 6 characters
                        if (parts[1].length() < 2 || parts[1].length() > 6) return false;
                        



            }
            return true;
        }
        ///////////////////////
        public static String extractTitle(String s) {
            String pattern = "<item><title>(.*?)</title>";
            Pattern r = Pattern.compile(pattern);

            Matcher m = r.matcher(s);

            if (m.find()) {
                return m.group(1);
            } else {
                return "";
            }
        }

        public static String swearFilter(String text, String[] swear) {
            for (String word : swear) {
                String regex = "\\b" + word.charAt(0) + "(?:" + ".".repeat(word.length() - 2) + ")" + word.charAt(word.length() - 1) + "\\b";
                String replacement = word.charAt(0) + "*".repeat(word.length() - 2) + word.charAt(word.length() - 1);
                text = text.replaceAll(regex, replacement);
            }
            return text;
        }
    }


            if (filename.isEmpty() ||filename.length()>15)return false;
            if (!filename.matches("^[A-Za-z]+$"))return false;
            if (!filename.matches("^[^.:]*$")) return false;


        }
        return true;
    }
    ///////////////////////
        public static String extractTitle(String s) {
            String pattern = "<item><title>(.*?)</title>";
            Pattern r = Pattern.compile(pattern);

            Matcher m = r.matcher(s);

            if (m.find()) {
                return m.group(1);
            } else {
                return "";
            }
        }

    public static String swearFilter(String text, String[] swear) {
        for (String word : swear) {
            String regex = "\\b" + word.charAt(0) + "(?:" + ".".repeat(word.length() - 2) + ")" + word.charAt(word.length() - 1) + "\\b";
            String replacement = word.charAt(0) + "*".repeat(word.length() - 2) + word.charAt(word.length() - 1);
            text = text.replaceAll(regex, replacement);
        }
        return text;
    }
}
