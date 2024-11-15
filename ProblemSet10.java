
public class ProblemSet10 {
    public static void main(String[] args) {
        System.out.println(isValidPassword("sdfghjk"));
        System.out.println(isValidFilename("sdfghjk", "Windows"));
        System.out.println(extractTitle("<item><title>Split (2017)</title><meta><imdb>6375308</imdb></meta>"));
        System.out.println(swearFilter("A duck was sailing on a ship shipping whole wheat bread. Duck that SHIP!!!",
                new String[]{"duck","ship", "whole"}));


    }
    public static boolean isValidPassword(String s){
        if (s.length()>8  ||  s.length()<6) return false;


        if (!s.matches("^[A-Z]+$")) return false;

        if(s.substring(s.length() - 2, s.length() - 1).matches("[^*%.]")) return false;
        if(!s.substring(1,s.length()-2).matches("\\w+"))return false;
        if(!s.substring(0,1).matches("[A-Z@!#]"))return false;


        if (s.matches("^[A-Z@!#].*[^*%.]$") && s.substring(1, s.length() - 2).matches("\\w+")) return true;
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
return s.substring(s.indexOf("<item>")+6,s.indexOf("</title>")); //this was a suggestion from IDEA,
// I typed "if (s.startsWith("<item>")&& s.endsWith("</title>"))" and he suggestes it

    }
    public static String swearFilter(String text, String[] swear){
        String temp = text.toLowerCase();
        for(String t : swear){
            String star = "";
            for(int i=0;i<t.length()-2;i++){
                star+="*";
            }
            temp=temp.replace(t, t.charAt(0)+star+t.charAt(t.length()-1));
        }
        String ret="";
        for(int i=0;i<temp.length();i++){
            if(temp.charAt(i)=='*'){
                ret +="*";
            }else{
                ret +=text.charAt(i);
            }
        }
        return ret;
    }
}
