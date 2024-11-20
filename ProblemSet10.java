/* This code is my own work. It was written without consulting code written by
other students or code from online resources. [Felipe Cardozo] */


public class ProblemSet10 {
        public static void main(String[] args) {


            System.out.println(isValidPassword("duck"));
            System.out.println(isValidFilename("myfile_com99.xlsx", "Windows"));
            System.out.println(isValidFilename("rom_com3.txt", "Windows"));
            System.out.println(isValidFilename("roooco.txt", "Mac"));
            System.out.println("");


            System.out.println(extractTitle("<item><title>(.*?)</title>"));
            System.out.println(swearFilter("duck", new String[]{"DUCK"}));
            System.out.println(swearFilter("duck", new String[]{"DUCK"}));
            System.out.println(swearFilter("DUCK", new String[]{"duck"}));
            System.out.println(swearFilter("Duck", new String[]{"duck"}));
            System.out.println(swearFilter("ducking", new String[]{"duck"}));
            System.out.println(swearFilter("reduck", new String[]{"duck"}));



        }
        public static boolean isValidPassword(String s){
            if (!s.matches(".{6,8}")) {
                return false;
            }

            if (!s.matches("^([A-Z!@#])([\\w]{5,7})([^*%.])$")) {
                return false;
            }
            if (s.matches(".*\\s.*")) {
                return false;
            }

            return true;
        }

        public static boolean isValidFilename(String filename, String sys){

            if (sys.equals("Windows")){
                String regex = "^[^\\s/?:*<>\"|.]+(?<!com[1-9])\\.[a-z]{2,6}$";

                return filename.matches(regex);

            }

            if (sys.equals("Mac") || sys.equals("Linux")) {
                if (filename.matches(".*:.*|.*\\..*\\..*")) {
                    return false;
                }


                    String[] parts=filename.split("\\.");
                //I couldn't find a way to have a . between file and file extension and still ban other .'s
                // so decided to split the string, learned this on codinbat 3 arrays
                if (parts.length!=2) return false;
                if (filename.matches(":"))return false;

                    if (!parts[1].matches("^[A-Za-z]+$")) return false;
                return parts[1].matches("^.{2,6}$"); //Idea suggestion for simplification
                }

                return false;
            }

        public static String extractTitle(String s) {
            String result = s.replaceAll(".*<title>(.*?)</title>.*", "$1");

            if (result.equals(s)) {//idea suggestion for simplification
                return s;
            } else {
                return result;
            }
        }


    public static String swearFilter(String text, String[] swearWords) {
        for (String swear : swearWords) {
            // Find the swear word in a case-insensitive way
            String lowerCaseText = text.toLowerCase();
            String lowerCaseSwear = swear.toLowerCase();

            int index = lowerCaseText.indexOf(lowerCaseSwear);
            while (index != -1) {
                String originalWord = text.substring(index, index + swear.length());
                String censoredWord = originalWord.charAt(0)
                        + "*".repeat(originalWord.length() - 2)
                        + originalWord.charAt(originalWord.length() - 1);

                text = text.substring(0, index) + censoredWord + text.substring(index + swear.length());
                lowerCaseText = text.toLowerCase();

                index = lowerCaseText.indexOf(lowerCaseSwear, index + censoredWord.length());
            }
        }
        return text;
    }
}

    }



