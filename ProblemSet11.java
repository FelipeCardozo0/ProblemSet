/* This code is my own work. It was written without consulting code written by
other students or code from online resources. Felipe Cardozo */

public class ProblemSet11 {
    public static void main(String[] args) {

    }
    public static int sumOfIntegerDiv(int[] a, int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            try {
                if (i >= a.length) {
                    throw new ArrayIndexOutOfBoundsException(i);
                }
                sum += a[i] / a[i - 1];
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero. Skipping index: " + i);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Cannot access array at index: " + i);
                return sum;
            } catch (Exception e) {
                System.out.println("Something went wrong! Skipping index: " + i);
            }
        }

        return sum;
    }

    public static int[] stringToIntArray(String s, int n) {
        int[] result = new int[n];
        int count = 0;

        try {
            for (int i = 0; i < s.length(); i++) {
                if (count >= n) break;

                char c = s.charAt(i);
                try {
                    int num = Integer.parseInt(String.valueOf(c));
                    result[count++] = num;
                } catch (NumberFormatException e) {
                    System.out.println("Index " + i + " not a valid integer: " + c + ". Skipping.");
                } catch (Exception e) {
                    System.out.println("Something went wrong with character at index " + i + ": " + c + ". Skipping.");
                }
            }

            if (count < n) {
                System.out.println("Out of digits. Stopping with only " + count + " numbers.");
                int[] truncatedResult = new int[count];
                System.arraycopy(result, 0, truncatedResult, 0, count);
                return truncatedResult;
            }

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String index out of bounds. Stopping with only " + count + " numbers.");
            int[] truncatedResult = new int[count];
            System.arraycopy(result, 0, truncatedResult, 0, count);
            return truncatedResult;
        }

        return result;
    }







    public static int[] subarray(int[] x, int start, int end) {

        if (start < 0 || end > x.length || start > end) {
            throw new ArrayIndexOutOfBoundsException(
                    "Invalid indices: start=" + start + ", end=" + end + ". Valid range is 0 to " + x.length);
        }

        int[] result = new int[end - start];
        for (int i = start; i < end; i++) {
            result[i - start] = x[i];
        }
        return result;
    }


}
