public class ProblemSet3 {
    public static void main(String[] args) {
    System.out.println(sumOdds(-1,29));
    System.out.println(approximatePi(20));
    }
    public static String sumOdds(int start, int end) {
        if (start % 2 == 0 || end % 2 == 0) {
            return "Error: Both start and end must be odd numbers.";
        }

        int n = (end - start)/2 +1;
        int Sum = n/2*(start+end);

         return ""+ Sum;
    }
    public static int digitsInARow (int n){
        if (n <10) {
            return 1;
        }
        if (n < 0) {
            n = -n;
        }

        int previous_digit = n%10;          //To keep track of the previous digit for comparison.
        n/=10;
        int current_count =1;      //To count how many times the current digit has appeared consecutively.
        int highest_count = 1;              //To store the maximum count of consecutive digits found.
        while (n > 0) {
            int currentDigit = n % 10; // Current digit

            if (currentDigit == previous_digit){
                current_count++; // Increment current count if digits match
            }
            else {
                highest_count = Math.max(highest_count, current_count); // Update highest count
                current_count = 1; // Reset count for the new digit
            }

            previous_digit = currentDigit; // Update lastDigit for the next comparison
            n /= 10; // Remove the last digit
        }

        // Final check to ensure the last sequence is counted
        highest_count = Math.max(highest_count, current_count);

        return highest_count; // Return the highest count of consecutive digits

    }

    public static double approximatePi(int n) {

        double approx = 0.0;
        int sign = -1;

        // -- start Gregory-Leibniz series
        for (int i = 1; i <= n; i++) {  // do this 'n' times
            sign *= -1;
            approx += sign * (4.0 / (2 * i - 1));
        }
        // -- end Gregory-Leibniz series

        System.out.println("Approximate value of pi is: " + approx);

        double PI = Math.PI;  // Get the constant value of PI from the Math library
        double difference = PI - approx;
        System.out.println("Deviation from Pi is: " + difference);

        return approx;
    }
}
