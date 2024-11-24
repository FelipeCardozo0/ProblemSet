public class ProblemSet11 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};

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
