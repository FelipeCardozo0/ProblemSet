/* This code is my own work. It was written without consulting code written by
other students or code from online resources. Felipe Cardozo */



public class ProblemSet8 {
    public static void main(String[] args){

        System.out.println(ack(1, 0));
        System.out.println(ack(1, 1));
        System.out.println(ack(1, 2));
        System.out.println(ack(2, 1));
        System.out.println(ack(2, 2));
        System.out.println(ack(2, 3));
        System.out.println(ack(3, 3));



        System.out.println(ack(1, 1));
        System.out.println(removeLetter("asdfghsasaaaae", 'a'));
        System.out.println(removeLetter("aabca", 'a'));

        System.out.println(isAbecedarian("abcde"));
        System.out.println(isAbecedarian("hello"));
        System.out.println(isAbecedarian("abef"));
    }
    public static long ack(long m, long n){
        if (m==0){
            System.out.println("done");
            return n+1;
        }
        else if (m>0 && n==0){
            System.out.println("continue");
            return ack(m-1,1);
        }
        else{
            System.out.println("continue");
            return ack(m-1,ack(m,n-1));

        }


    }
    public static String removeLetter(String s, char c){
        if (s.isEmpty()){//leaned on codingbat, checks if s is empty
            return "";
        }
        if (s.charAt(0)==c){
            return removeLetter(s.substring(1) ,c);
        }
        return s.charAt(0)+removeLetter(s.substring(1),c);
    }
    public static boolean isAbecedarian(String s){
        if (s.length()<2){
            return true;
        }
        if (s.charAt(0)>s.charAt(1)){
            return false;
        }
        return isAbecedarian(s.substring(1)) ;
    }
}
