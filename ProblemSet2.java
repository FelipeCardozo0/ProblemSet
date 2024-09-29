/* This code is my own work. It was written without consulting code written by other students or code from online resources. Felipe Cardozo */

public class ProblemSet2{

    public static boolean isTriangle(int a, int b, int c){
        if (a <= 0|| b<= 0 ||c <= 0){
            return false;
        }

        if (a >= b+c||b >= a + c||c >= a + b){
            return false;
        }
        return true;
    }

    public static int factorial(int j){
        int store = 1;
        for (int l = 1; l <= j;l++) {
            store*=l;
        }
        if (j < 0) {
            return -1;
        }
        return store;
    }
    public static double compoundInterest(double amount_old, int years){
        double amount_new = amount_old;
        double rate;

        for (int y = 1; y <=years; y++){ //in the next 8 years the rates are also going up
            if (y <= 8) {
                rate =0.05;
            } else{
                rate=0.0575;
            }
            amount_new*=(1+rate);
        }

        return amount_new;
    }


    public static void main(String[] args){
        System.out.println(isTriangle(3, 4, 5));
        System.out.println(isTriangle(1, 1, 2));
        System.out.println(isTriangle(0, 4, 5));
        System.out.println(isTriangle(7, 10, 20));

        System.out.println(factorial(-9999));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
        System.out.println(factorial(6));

        System.out.println(compoundInterest(1000,1));
        System.out.println(compoundInterest(1000,7));
        System.out.println(compoundInterest(1000,8));
        System.out.println(compoundInterest( 1000,9));
    }
}
