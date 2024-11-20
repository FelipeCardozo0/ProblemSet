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
            System.out.println(isValidFilename("myfile_com99.xlsx", "Windows"));






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
                // Regular expression to match the conditions:
                // 1. No leading or trailing whitespace
                // 2. Does not contain the restricted special characters
                // 3. Does not end with com1, com2, ..., or com9
                // 4. Exactly one period separating the filename and extension
                // 5. Extension contains only lowercase alphabet letters (between 2 to 6 characters)

                String regex = "^[^\\s/?:*<>\"|.]+\\.[a-z]{2,6}$";  // Matches:
                // - No leading or trailing whitespace or special characters
                // - Exactly one period separating the filename and extension
                // - The extension must be between 2 to 6 characters, and only lowercase letters

                // Additional condition: does not end with "com" followed by a digit from 1 to 9
                String additionalRegex = "^(?!.*com[1-9]$).*"; // Ensures the filename doesn't end with com1, com2, ..., com9

                // Use matches() to check if the filename matches both regex patterns
                return filename.matches(regex) && filename.matches(additionalRegex);
            
            }

                if (sys.equals("Mac") || sys.equals("Linux")) {
                    if (filename.contains(":") || filename.indexOf('.') != filename.lastIndexOf('.')) {
                        return false;
                    }

                    String[] parts = filename.split("\\.");

                    if (parts.length != 2) return false;

                    if (!parts[1].matches("^[A-Za-z]+$")) return false;

                    if (parts[1].length() < 2 || parts[1].length() > 6) return false;
                    else return true;
                }


                return false;
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
