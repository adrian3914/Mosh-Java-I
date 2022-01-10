package ca.adrian;

import java.text.NumberFormat;
import java.util.*;

public class Main {
    final static byte MONTHS_IN_YEARS = 12;
    final static byte PERCENT = 100;
    final static float MORTGAGE_MIN = 1000;
    final static float MORTGAGE_MAX = 1_000_000;
    final static float ANNUAL_INTEREST_RATE_MIN = 1.0F;
    final static float ANNUAL_INTEREST_RATE_MAX = 30.0F;
    final static byte YEARS_MIN = 1;
    final static byte YEARS_MAX = 30;

    public static void main(String[] args) {

        int principal = (int)readNumber("Principal ($1K - $1M): ", MORTGAGE_MIN, MORTGAGE_MAX);
        float annualInterestRate = (float)readNumber("Annual Interest: ", ANNUAL_INTEREST_RATE_MIN, ANNUAL_INTEREST_RATE_MAX);
        byte years =  (byte)readNumber("Period (Years): ", YEARS_MIN, YEARS_MAX);

        printMorgagePayment(principal, annualInterestRate, years);
        printPaymentSchedule(principal, annualInterestRate, years);

    }

    private static void printMorgagePayment(int principal, float annualInterestRate, byte years) {
        double mortagePayment = calculateMortgage(principal, annualInterestRate, years);
        String mortagePaymentFormatted = NumberFormat.getCurrencyInstance().format(mortagePayment);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------------");
        System.out.println("Mortgage:" + mortagePaymentFormatted);
    }

    private static void printPaymentSchedule(int principal, float annualInterestRate, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-------------------");

        for (short month = 1; month <= years * MONTHS_IN_YEARS; month++){
            double balance = calculateBalance(principal, annualInterestRate, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years){
        short numberOfPayments = (short)(years * MONTHS_IN_YEARS);
        float monthlyInterestRate = annualInterest / PERCENT / MONTHS_IN_YEARS;

        float mortagePayment = (float) (principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));

        return  mortagePayment;
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();

            if (value >= min && value <= max)
            break;
            System.out.printf("Enter a value between %f and %f.", min, max);
        }

        return value;
    }

    public static double mortgagePayment() {
        final float MORTGAGE_MIN = 1000;
        final float MORTGAGE_MAX = 1_000_000;
        final float ANNUAL_INTEREST_RATE_MIN = 1.0F;
        final float ANNUAL_INTEREST_RATE_MAX = 30.0F;
        final byte YEARS_MIN = 1;
        final byte YEARS_MAX = 30;

        int principal = (int)readNumber("Principal ($1K - $1M): ", MORTGAGE_MIN, MORTGAGE_MAX);
        float annualInterestRate = (float)readNumber("Annual Interest: ", ANNUAL_INTEREST_RATE_MIN, ANNUAL_INTEREST_RATE_MAX);
        byte years =  (byte)readNumber("Period (Years): ", YEARS_MIN, YEARS_MAX);

        double mortagePayment = calculateMortgage(principal, annualInterestRate,years);

        return mortagePayment;
    }

    public static double calculateBalance(int principal,
                                        float annualInterest,
                                        byte years, short numberOfPaymentsMade){
        // Formula to calculate remaining Loan balance => B = L [(1+c)^n - (1+c)^p] / [(1+c)^n - 1]
        // L = principal | c = monthlyInterest | n = noOfPayments | p = noOfPaymentMade
        short numberOfPayments = (short)(years * MONTHS_IN_YEARS);
        float monthlyInterestRate = annualInterest / PERCENT / MONTHS_IN_YEARS;

            double balance = principal *
                    (Math.pow((1 + monthlyInterestRate), numberOfPayments) - Math.pow((1 + monthlyInterestRate), numberOfPaymentsMade)) /
                    (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1);

            return balance;

    }

    public static void getFullNameAndDisplayToUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.println("Your full name is " + name + ".");
    }

    public static void getAgeAndDisplayToUser(String question){
        try {
            Scanner scanner = new Scanner(System.in); // we must specify where are reading the data from terminal | file
            System.out.print(question);
            byte age = scanner.nextByte();

            for (int i = 0; i < question.length() + 2; i++ ){
                System.out.print('-');
            }

            System.out.println("\nYou are " +  age + " years old.");
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }

    }

    public static boolean isValid(byte min, byte max, byte input ){
       boolean isValid = (input < min || input > max)? false: true;
       return isValid;
    }

    public static String greetUser(String firstName, String lastName){
        return String.format("Hello %s %s \n", firstName, lastName);
    }

    public static boolean isStringValid(String s){
        char[] chars = s.toLowerCase().toCharArray();
        boolean isValid = false;
        // 97 - 122 a-z

        for (int i = 0; i < chars.length; i++){

            if (chars[i] >= 97 && chars[i] <= 122){
                isValid = true;
            }else{
                isValid = false;
                break;
            }
        }
        return isValid;

    }

    // Longest Substring Without Repeating Characters ************ TO DO ************
    public static int lengthOfLongestSubstring(String s) {
//        Example 1:
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
        /*
                a   b   c   d   r
                    ^
         */

        int count = 0;
        char[] chars = s.toCharArray();
        char second = chars[1];
        int last = chars.length - 1;
        List<Character> characterList = new ArrayList<>();

        if (isStringValid(s)){

            for(int i = 1 ; i < last; i++){

                for (int j = 2; j < chars.length; j++){

                }
            }
        }

        return count;
    }

    public static String longestCommonPrefix(String[] strs) {

            /*
        Write a function to find the longest common prefix string amongst an array of strings.
        If there is no common prefix, return an empty string "".
        Example 1:
        Input: strs = ["flower","flow","flight"]
        Output: "fl"
     */
        if (strs.equals(null))
            return "";
        if (strs.length == 1)
            return strs[0];

        StringBuffer prefix = new StringBuffer();
        int count = 1;

        for (int i = 0; i < strs.length; i++){
            char c = strs[i].toCharArray()[i];

            for (int j = 1; j < strs.length; j++){

                char c2 = strs[j].toCharArray()[i];
                if (c == c2){
                    count++;
                }

            }
            if (count == strs.length){
                prefix.append(c);
                count = 1;
            }
            else
                break;
        }
        return (prefix.toString().length() >= 2)? prefix.toString():"";
    }


    /* PRIMITIVE TYPES
    // we can store number up to 127 -> takes only one byte
    byte age = 38;

    long viewsCount = 3_123_456_789L;

    // Decimals
    float price = 10.99F;

    // Characters
    char letter = 'A';

    // Boolean
    boolean isEligible = true;

     int x = 1;
         int y = x;
         x = 5;
        System.out.println(y); -> 1
     */

    /*
     // Reference Type
        Date now = new Date();
        System.out.println(now);

        Point point1 = new Point(1,1);
        Point point2 = point1;
        point1.x = 2;
        System.out.println(point2);
     */

    /* String
        String message = "Hello World" + "!!";
        String message2 = message.replace('!', '?');
        System.out.println(message2);
        System.out.println(message);
     */

    /*
    // scape characters
     String message = "Hello \"Adrian\"";
     System.out.println(message);

     // C:\Users\adria\OneDrive\Documents
     String path = "C:\\Users\\adria\\OneDrive\\Documents";
     System.out.println(path);
     */

    /*
        // Arrays
        int[] numbers = {2, 3, 5 , 1, 4};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        // Multi-dimensional arrays - MATRIX
        // Old syntax
        int[][] numbers = new int[2][3]; // 2 rows and 3 columns
        numbers[0][0] = 1;
        System.out.println(Arrays.deepToString(numbers));

        // New syntax
        int [][] numbers2 = {{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(numbers2));

     */

    /*
    Casting
     // Implicit Casting - automatic
        // byte > short > int > long > float > double
        double x = 1.1;
        int y = (int)x + 2; // converts 2 > 2.0 then sum
        System.out.println(y);

       String x = "1";
       int y = Integer.parseInt(x) + 2;
       System.out.println(y);
     */

    /*
        The Math Class
        int resultCeil =(int) Math.ceil(1.1F);
        int resultMax =(int) Math.max(3, 5);
        int resultRandom = (int)Math.round(Math.random()*100);
        int resultRandom2 = (int)(Math.random() * 100);

        for (int i = 0; i < 100; i++){
            System.out.println((int)(Math.random() * 100));
        }

        System.out.println(resultRandom);
     */

    /*  // Formatting Numbers
        NumberFormat currency  = NumberFormat.getCurrencyInstance();
        NumberFormat percentage  = NumberFormat.getPercentInstance();
        String resultPercentage  = percentage.format(234.5666);
        String resultCurrency  = currency.format(123456.789);
        System.out.println(resultPercentage);
        System.out.println(resultCurrency);
     */

    /*
        // Comparison Operators
        int temperature = 22;
        boolean isWarm = temperature > 20 && temperature < 30; // both condition must be true
        System.out.println(isWarm);

        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        boolean hasCriminalRecord = false;
        boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord; // if one condition is true then returns true
        System.out.println(isEligible);
     */

    /*
        // If statements
        int temp = 19;

        if (temp > 30){
            System.out.println("It is a hot day\nDrink plenty of water.");
        } else if (temp > 20){
            System.out.println("It is a nice day.");
        } else{
            System.out.println("It is cold.");
        }

        int income = 120_000;
        boolean hasHighIncome = (income > 100_000);

        The Ternary Operator
        int income = 120_000;
        String className = income > 100_000? "First" : "Economy"; // syntax condition? true : false;


     */

    /*
     // Switch Statements
        String role = "admin";

        switch (role){
            case "admin":
                System.out.println("You are an admin.");
                break;
            case "moderator":
                System.out.println("You are a moderator.");
                break;
            default:
                System.out.println("You are a guest.");
        }
     */

    /*
            // For Loops
        for (int i = 5; i > 0; i--)
            System.out.println("Hello World " + i);

        for (int i = 0; i < 6; i++)
            System.out.println("Hello Adrian " + i);
     */

    /*
        // While Loops
        Scanner scanner = new Scanner(System.in);
        String input = "";
        int counter = 0;

        while (!input.equals("quit")){
            System.out.println("\nType one of the following options and press ENTER");
            System.out.println("1. Quit");
            System.out.println("2. Print new line.");

            int userRequest = scanner.nextInt();

            if (userRequest < 1 || userRequest > 2){
                System.out.println("Enter correct value");
                continue;
            }

            switch (userRequest){
                case 1:
                    System.out.println("Bye");
                    input = "quit";
                    break;
                case 2:
                    counter++;
                    System.out.println("Hello user!!!" +  counter);
                    continue;
            }

        }
       // -----------------------------------------------------------------------------------
       Scanner scanner = new Scanner(System.in);
       String input = "";

       while (true){
           System.out.print("Input: ");
           input = scanner.next().toLowerCase();

           if (input.equals("pass"))
               continue;

           if (input.equals("quit"))
               break;

           System.out.println(input);
       }
       // -----------------------------------------------------------------------------------
     */

    /*
        // For-Each Loop
        String [] fruits = {"Apple", "Mango", "Orange"};

        for (String fruit: fruits){
            System.out.println(fruit);
        }
     */
}
