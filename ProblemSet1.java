public class ProblemSet1 {

    public static String getAmerican(String day, int date, String month, int year){
        return day + ", " + month + " " + date + ", " + year;
    }

    public static String getEuropean(String day, int date, String month, int year){
        return day + " " + date + " " + month + ", " + year;
    }

    public static int secondsSinceMidnight(int hr, int min, int sec){
        int hr_sec = hr * 3600;
        int min_sec = min * 60;
        return hr_sec + min_sec + sec;
    }

    public static int secondsLeftToday(int hr, int min, int sec){
        int day_sec=24 * 3600;
        int sec_passed=secondsSinceMidnight(hr, min, sec);
        int sec_left=day_sec-sec_passed;
        return sec_left;
    }

    public static double percentOfDayPassed(int hr, int min, int sec){
        int day_sec = 24 * 3600;
        int sec_passed = secondsSinceMidnight(hr,min,sec);
        double percent_passed =(sec_passed/(double) day_sec) * 100;
        return percent_passed;
    }

    public static double multadd(double a, double b, double c){
        return a * b + c;
    }

    public static double yikes(double x){
        double e_power_minus_x=Math.exp(-x);
        double one_minus_e_power_minus_x = 1 - e_power_minus_x;
        double sqrt_one_minus_e_power_minus_x =Math.sqrt(one_minus_e_power_minus_x);
        return multadd(x, e_power_minus_x, sqrt_one_minus_e_power_minus_x);
    }

    public static void main(String[] args){
        String day = "Tuesday";
        int date = 17;
        String month = "September";
        int year = 2024;

        String americanDate = getAmerican(day, date, month, year);
        System.out.println("American format:");
        System.out.println(americanDate);

        String europeanDate = getEuropean(day, date, month, year);
        System.out.println("European format:");
        System.out.println(europeanDate);

        int hr = 17;
        int min = 1;
        int sec = 44;
        System.out.println("Current time is: "+ hr + ":0" + min + ":" + sec);

        int sec_passed = secondsSinceMidnight(hr, min, sec);
        System.out.println("Number of seconds since midnight: " + sec_passed);

        int sec_left = secondsLeftToday(hr, min, sec);
        System.out.println("Seconds left today: " + sec_left);

        double percent_passed = percentOfDayPassed(hr, min, sec);
        System.out.println("Percent of day passed: " + percent_passed + "%");

        double a = 7.0;
        double b = 8.0;
        double c = 9.0;
        double multadditionization = multadd(a, b, c);
        System.out.println("Multadditionization: " + multadditionization);

        double pi_over_4 = Math.PI / 4;
        double sin_pi_over_4 = Math.sin(pi_over_4);
        double cos_pi_over_4_over_2 = Math.cos(pi_over_4)/2;
        double equation1 = multadd(sin_pi_over_4, 1, cos_pi_over_4_over_2);
        System.out.println("sin(π/4) + (cos(π/4))/2 = " + equation1);

        double log10 = Math.log10(10);
        double log20 = Math.log10(20);
        double equation2 = multadd(log10, 1, log20);
        System.out.println("log(10) + log(20) = " + equation2);

        double value1 = yikes(1.0);
        System.out.println("yikes with x=1.0 is " +  value1);
        double value2 = yikes(2.0);
        System.out.println("yikes with x=2.0 is " + value2);
        double value3 = yikes(3.0);
        System.out.println("yikes with x=3.0 is " + value3);
    }
}
