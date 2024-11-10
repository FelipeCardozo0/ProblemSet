/* This code is my own work. It was written without consulting code written by
other students or code from online resources. Felipe Cardozo */
import java.util.Arrays;
public class ProblemSet9 {
    public static void main(String[] args) {
        System.out.println(groupSum(0, new int[]{1, 2, 3}, 2));
        System.out.println(groupSum6(0, new int[]{1, 2, 3}, 2));
        System.out.println(groupSumClump(0, new int[]{1, 2, 3}, 2));
        System.out.println(groupSumNoAdj(0, new int[]{1, 2, 3}, 2));
        System.out.println(rollDice(1));
        sumDice();

    }
    public static boolean groupSum(int start, int[] nums, int target) {

        if (start >= nums.length) return (target == 0);


        if( groupSum(start+1,nums,target))return true;
        if(groupSum(start+1,nums,target-nums[start]))return true;



        return false;

    }
    public static boolean groupSum6(int start, int[] nums, int target){
        if (start >= nums.length) return (target == 0);


        if(nums[start]!=6&&groupSum6(start+1,nums,target))return true;
        if(groupSum6(start+1,nums,target-nums[start]))return true;



        return false;

    }
    public static boolean groupSumNoAdj(int start, int[] nums, int target){
        if (start >= nums.length) return (target == 0);
        if (nums.length==1&&nums[start]==target)return true;


        if(groupSumNoAdj(start+1,nums,target))return true;
        if(groupSumNoAdj(start+2,nums,target-nums[start]))return true;



        return false;






    }

    public static boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) return (target == 0);
        if (nums.length==1&&nums[start]==target)return true;
        int sum = nums[start];
        int count =1;
        if (start+1<nums.length&&nums[start]==nums[start + 1]) {
            while (start+count<nums.length&&nums[start]==nums[start + count]) {
                sum +=nums[start + count];
                count++;
            }
        }


        if (groupSumClump(start + count, nums, target)) return true;
        if (groupSumClump(start + count, nums, target - sum)) return true;



        return false;
    }


    public static int rollDice(int n) {
        return (int)(Math.random()*n)+1;
    }
    public static void sumDice() {
        int[] sumCounts = new int[13];
        int rolls = 1000;

        for (int i = 0; i < rolls; i++) {
            int dice1 = rollDice(6);
            int dice2 = rollDice(6);

            int sum = dice1 + dice2;
            sumCounts[sum]++;
        }

        for (int i = 2; i <= 12; i++) {
            System.out.println("Sum " + i + ": " + sumCounts[i]);
        }
    }

}
