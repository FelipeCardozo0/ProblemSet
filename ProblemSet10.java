import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemSet10 {
        public static void main(String[] args) {
            System.out.println(isValidPassword("sdfghjk"));
            System.out.println(isValidFilename("homework5.java","Linux"));
            System.out.println(isValidFilename("myfile_com99.xlsx", "Windows"));
            System.out.println(isValidFilename("mydoc.DOCX", "Linux"));
            System.out.println(extractTitle("<item><title>Split (2017)</title><meta><imdb>6375308</imdb></meta>"));
            System.out.println(extractTitle("<item><title>Split (2017)</title><meta><imdb>6375308</imdb></meta>"));
            System.out.println(extractTitle("<item><title>Improper Title Tag<meta><imdb>1234567</imdb><genre>Unknown</genre>"));
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

                        if (filename.matches("^\\s+|\\s+$")) return false;

                        if (filename.matches(".*[/?<>\\:*|.].*")) return false;

                if (filename.matches(".*[cC][oO][mM][1-9]$") && !filename.matches(".*[cC][oO][mM][1-9][a-zA-Z0-9]*$")) {
                    return false;
                }


                String pattern = "^[^\\.]+\\.[a-z]{2,6}$";
                        if (!filename.matches(pattern)) {
                            return false;
                        }
                    }

                if (sys.equals("Mac") || sys.equals("Linux")) {
                    // Check if filename contains a colon or more than one period
                    if (filename.contains(":") || filename.indexOf('.') != filename.lastIndexOf('.')) {
                        return false;
                    }

                    // Split the filename by the period
                    String[] parts = filename.split("\\.");

                    // Ensure there are exactly two parts: name and extension
                    if (parts.length != 2) return false;

                    // Check that the extension consists of only letters
                    if (!parts[1].matches("^[A-Za-z]+$")) return false;

                    // Ensure the extension length is between 2 and 6 characters
                    if (parts[1].length() < 2 || parts[1].length() > 6) return false;
                }
                return true;
            }

        ///////////////////////
        public static String extractTitle(String s) {
            String pattern = "<item><title>(.*?)</(title| Title Tag)>";
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
            // Add word boundaries to ensure full word matching
            String regex = "(?i)\\b" + word + "\\b";

            // Keep the first and last characters, replace the middle with '*'
            String replacement = word.charAt(0) + "*".repeat(word.length() - 2) + word.charAt(word.length() - 1);

            // Handle case where word length is 1 or 2
            if (word.length() == 1) {
                replacement = word; // No replacement needed for 1-letter words
            } else if (word.length() == 2) {
                replacement = word.charAt(0) + "*"; // For 2-letter words, just replace the second letter
            }

            text = text.replaceAll(regex, replacement);
        }
        return text;
    }

    }
