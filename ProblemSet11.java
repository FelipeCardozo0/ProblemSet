public class ProblemSet11 {
    public static void main(String[] args) {

    }
    public static int sumOfIntegerDiv(int[] a, int n) {
        //https://www.chegg.com/homework-help/questions-and-answers/write-method-java-sumofintegerdiv-int-int-n-takes-array-integers-integer-n-input-returns-i-q37006874
        int sum = 0;
        int currentIndex = 1;

        for (int i = 1; i < n; i++) {
            try {
                int dividend = a[currentIndex];
                int divisor = a[currentIndex - 1];
                int quotient = dividend / divisor;
                sum += quotient;
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero. Skipping index: " + currentIndex);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Cannot access array at index: " + currentIndex);
                return sum; // Terminate and return the result
            } catch (Exception e) {
                System.out.println("Something went wrong! Skipping index: " + currentIndex);
            }

            currentIndex++;
        }

        return sum;
    }
    public static int[] stringToIntArray(String s, int n) {
        // Handle invalid inputs
        if (s == null || n <= 0 || n > s.length()) {
            throw new IllegalArgumentException("Invalid input: Check string or number of digits.");
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            // Convert each character to an integer and store in the array
            result[i] = Character.getNumericValue(s.charAt(i));
        }
        return result;
    }
    public static int[] subarray(int[] x, int start, int end) {
        // Validate input
        if (x == null || start < 0 || end > x.length || start >= end) {
            throw new IllegalArgumentException("Invalid start or end indices.");
        }

        // Create a new array for the subarray
        int[] result = new int[end - start];
        for (int i = start; i < end; i++) {
            result[i - start] = x[i];
        }
        return result;
    }


}
