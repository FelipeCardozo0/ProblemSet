import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemSet10 {
        public static void main(String[] args) {


            System.out.println(swearFilter("duck", new String[]{"DUCK"}));
            System.out.println(swearFilter("DUCK", new String[]{"duck"}));
            System.out.println(swearFilter("Duck", new String[]{"duck"}));
            System.out.println(swearFilter("ducking", new String[]{"duck"}));
            System.out.println(swearFilter("reduck", new String[]{"duck"}));
            System.out.println(swearFilter("shipping duck ship", new String[]{"DUCK","ship"}));





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

                        if (filename.matches("^\\s+|\\s+$")) return false;

                        if (filename.matches(".*[/?<>\\:*|.].*")) return false;

                if (filename.matches(".*[cC][oO][mM][1-9]$") && !filename.matches(".*[cC][oO][mM][1-9][a-zA-Z0-9]*$")) {
                    return false;
                }


                String pattern = "^[^<>:\"/\\\\|?*]+\\.[a-z]{2,6}$";

                if (!filename.matches(pattern)) {
                            return false;
                        }
                    }

                if (sys.equals("Mac") || sys.equals("Linux")) {
                    if (filename.contains(":") || filename.indexOf('.') != filename.lastIndexOf('.')) {
                        return false;
                    }

                    String[] parts = filename.split("\\.");

                    if (parts.length != 2) return false;

                    if (!parts[1].matches("^[A-Za-z]+$")) return false;

                    if (parts[1].length() < 2 || parts[1].length() > 6) return false;
                }
                return true;
            }

        public static String extractTitle(String s) {
            String pattern = "<item><title>(.*?)</(title| Title Tag)>";
            Pattern r = Pattern.compile(pattern);

            Matcher m = r.matcher(s);

            if (m.find()) {
                return m.group(1);
            }
            else {
                return s;
            }
        }

    public static String swearFilter(String text, String[] swearWords) {
        for (String swear : swearWords) {
            Pattern pattern = Pattern.compile("(?i)" + swear);
            Matcher matcher = pattern.matcher(text);

            text = matcher.replaceAll(match -> {
                String word = match.group();
                if (word.length() > 2) {
                    return word.charAt(0) + "*".repeat(word.length() - 2) + word.charAt(word.length() - 1);
                }
                return word;
            });
        }
        return text;
    }



    }
