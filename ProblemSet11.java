public class ProblemSet11 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};

        // Test case 1: Successful execution
        try {
            int[] sub = subarray(array, 1, 4);
            System.out.print("Subarray (1, 4): ");
            for (int num : sub) {
                System.out.print(num + " ");
            }
            System.out.println();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Test case 2: Out-of-bounds indices
        try {
            int[] sub = subarray(array, -1, 10);
            System.out.print("Subarray (-1, 10): ");
            for (int num : sub) {
                System.out.print(num + " ");
            }
            System.out.println();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

                    System.out.println(sumOfIntegerDiv(new int[]{2,4,6,8}, 1));
                    System.out.println(sumOfIntegerDiv(new int[]{2,4,6,8}, 2));
                            System.out.println(sumOfIntegerDiv(new int[]{2,4,6,8}, 3));
                                    System.out.println(sumOfIntegerDiv(new int[]{0,2,4,6,8}, 3));
                                            System.out.println(sumOfIntegerDiv(new int[]{2,4,6,0,8,16}, 5));
                                                    System.out.println(sumOfIntegerDiv(new int[]{0,1,2,3}, 2));
                                                            System.out.println(sumOfIntegerDiv(new int[]{1,2,3,0}, 2));
                                                                    System.out.println(sumOfIntegerDiv(new int[]{1,2,3,0}, 5) );

    }
    public static int sumOfIntegerDiv(int[] a, int n) {
        int sum = 0;

        // Ensure n does not exceed the length of the array
        if (n > a.length || n < 2) {
            System.out.println("Invalid value for n. It must be between 2 and the length of the array.");
            return sum; // return 0 if n is not valid
        }

        for (int i = 1; i < n; i++) {
            try {
                // Attempt to divide the current element by the previous one
                sum += a[i] / a[i - 1];
            } catch (ArithmeticException e) {
                // Handle division by zero
                System.out.println("Cannot divide by zero. Skipping index: " + i);
            } catch (ArrayIndexOutOfBoundsException e) {
                // Handle out of bounds access
                System.out.println("Cannot access array at index: " + i);
                return sum; // Return the sum immediately if an out of bounds access occurs
            } catch (Exception e) {
                // Handle any other type of exception
                System.out.println("Something went wrong! Skipping index: " + i);
            }
        }

        return sum;
    }
    

    public static int[] stringToIntArray(String s, int n) {
        int[] result = new int[n];
        int count = 0; // To keep track of valid integers added to the array

        try {
            for (int i = 0; i < s.length(); i++) {
                if (count >= n) break; // Stop when we have enough numbers

                char c = s.charAt(i);
                try {
                    // Convert the current character to an integer
                    int num = Integer.parseInt(String.valueOf(c));
                    result[count++] = num; // Add to the result array
                } catch (NumberFormatException e) {
                    // Handle invalid character conversion
                    System.out.println("Not a valid integer: '" + c + "'. Skipping...");
                } catch (Exception e) {
                    // Handle any other unexpected exception
                    System.out.println("Something went wrong with character: '" + c + "'. Skipping...");
                }
            }

            // If we run out of characters but don't have enough numbers
            if (count < n) {
                System.out.println("String ended early. Stopping with only " + count + " numbers.");
                int[] truncatedResult = new int[count];
                System.arraycopy(result, 0, truncatedResult, 0, count);
                return truncatedResult;
            }

        } catch (StringIndexOutOfBoundsException e) {
            // Handle if string indexing fails
            System.out.println("String index out of bounds. Stopping with only " + count + " numbers.");
            int[] truncatedResult = new int[count];
            System.arraycopy(result, 0, truncatedResult, 0, count);
            return truncatedResult;
        }

        return result;
    }
    public static int[] subarray(int[] x, int start, int end) {
        // Check for out-of-bounds indices and throw an exception if necessary
        if (start < 0 || end > x.length || start > end) {
            throw new ArrayIndexOutOfBoundsException(
                    "Invalid indices: start=" + start + ", end=" + end + ". Valid range is 0 to " + x.length);
        }

        // Create a new array for the subarray
        int[] result = new int[end - start];
        for (int i = start; i < end; i++) {
            result[i - start] = x[i];
        }
        return result;
    }


}
