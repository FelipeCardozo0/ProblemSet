/* This code is my own work. It was written without consulting code written by other students or code from online resources. Felipe Cardozo*/

public class ProblemSet3 {
    public static void main(String[] args) {
        System.out.println(sumOdds(8, 29));
        System.out.println(sumOdds(-48, 12));
        System.out.println(sumOdds(12, -48));
        System.out.println(sumOdds(-4, 10));

        System.out.println(digitsInARow(1122233333));
        System.out.println(digitsInARow(-0000001));
        System.out.println(digitsInARow(-10000001));
        System.out.println(digitsInARow(988888889));

        System.out.println(approximatePi(999999999));

    }
    public static String sumOdds(int start, int end) {
            if (start > end) {
                int temp = start;
                start = end;
                end = temp;
            }

            if (start % 2 == 0) {
                start++;
            }

            if (end % 2 == 0) {
                end--;
            }

            int sum = 0;

            for (int i = start; i <= end; i += 2) {
                sum += i;
            }
            return "" + sum;
    }

    public static int digitsInARow (int n){
        if (n < 0) {
            n = -n;
        }
        if (n <10) {
            return 1;
        }


        int previous_digit = n%10;
        n/=10;
        int current_count =1;
        int highest_count = 1;
        while (n > 0) {
            int currentDigit = n % 10;

            if (currentDigit == previous_digit){
                current_count++;
            }
            else {
                highest_count = Math.max(highest_count, current_count);
                current_count = 1;
            }

            previous_digit = currentDigit;
            n /= 10;
        }
        highest_count = Math.max(highest_count, current_count);

        return highest_count;

    }

    public static double approximatePi(int n) {

    double approx = 0;
    int sign = -1;

    for (int i = 1; i <= n; i++) {
        sign *= -1;
        approx += sign * (4.0 / (2 * i - 1));
    }

    return approx;
    }
}
