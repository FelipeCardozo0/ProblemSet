public class ProblemSet10 {
    
   


    public static boolean isValidPassword(String s){
        if (s.length()>8  ||  s.length()<6) return false;


        if (!s.matches("^[A-Z]+$")) return false;

        if(s.substring(s.length() - 2, s.length() - 1).matches("[^*%.]")) return false; 
        if(!s.substring(1,s.length()-2).matches("\\w+"))return false;
        if(!s.substring(0,1).matches("[A-Z@!#]"))return false;
        
    
              if (s.length() >= 6 && s.length() <= 8 && s.matches("^[A-Z@!#].*[^*%.]$") && s.substring(1, s.length() - 2).matches("\\w+")) return true;
        return true;

  

    }
    public static boolean isValidFilename(String filename, String sys){

        if (sys.equals("Windows")){
            if (filename.length()<2 \ \filename.length()>6)return false;
            if (filename.matches("\\^s+|\\\\s+$"))return false;
        
            if (filename.matches("/ ? < > \\ : * | ."))return false;

        if (filename.substring(filename.length()-2,filename.length()-1).matches("comX"))return false;
        //The file name is separated from the file extension by exactly one period character
        //The file extension can only contain lower case alphabet letters
        }
        if (sys.equals("Mac") \ \sys.equals("Linux")){
            if (filename.length()<1 \ \filename.length()>15)return false;
            if (!filename.matches("^[A-Za-z]+$"))return false;
            if (!filename.matches("^[^.:]*$")) return false;
        }
        return true;
    }
    public static String extractTitle(String s) {




        return ;


    }
    public String swearFilter(String text, String[] swear){
        return string;
        
    }


}
