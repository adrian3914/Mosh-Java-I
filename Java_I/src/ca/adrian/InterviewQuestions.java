package ca.adrian;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InterviewQuestions {

    public InterviewQuestions(){};


    /*
        If number is divisible
        by 5: Fizz
        by 3: Buzz
        by both 5 && 3: FizzBuzz
        not divisible bye either: get the number
     */
    public static void fizzBuzz(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number: ");
        int number = scanner.nextInt();

        if (number % 5 == 0 && number % 3 == 0)
            System.out.println("FizzBuzz");
        else if (number % 5 == 0)
            System.out.println("Fizz");
        else if (number % 3 == 0)
            System.out.println("Buzz");
        else
            System.out.println(number);
    }

    /*
        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
     */

    public static int[] twoSum(int[] nums, int target) {

        int[] indexes = new int[2];
        boolean isFound = false;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (isFound)
                break;
            j = i + 1;

            while(j < nums.length) {

                if ((nums[i] + nums[j]) == target) {
                    indexes[0] = i;
                    indexes[1] = j;
                    isFound = true;
                    break;
                }

                j++;
            }
        }

        return indexes;
    }

    // exercise counts how many times a characters is found in string array
    public static void countCharsInStringArray(String[] array, char targetChar){

        int totalCount = 0;
        int countPerWord = 0;

        for (int i = 0; i < array.length; i++){

            // converting string item to char array
            char[] chars = array[i].toCharArray();

            for (int j = 0; j < chars.length; j++){

                if (chars[j] == targetChar){
                    countPerWord++;
                    totalCount++;
                }

            }
            System.out.printf("The character %c was found in %s %d times \n", targetChar, array[i], countPerWord);
            countPerWord = 0;

        }

        System.out.println("total: " + totalCount);
    }
    // Roman to decimal starts here
    /*
        Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
        Given a roman numeral, convert it to an integer.
         */
    public static int romanToInt(String s) {
        Map<Character, Integer> myMap = new HashMap<>();
        myMap.put('I', 1);
        myMap.put('V', 5);
        myMap.put('X', 10);
        myMap.put('L', 50);
        myMap.put('C', 100);
        myMap.put('D', 500);
        myMap.put('M', 1000);

        int result = 0;
        int value = 0;
        char operator = '+';
        char[] chars = s.toUpperCase().toCharArray();

        for (int i = 0; i < chars.length; i++){
            value  = myMap.get(chars[i]);

            switch (chars[i]){
                case 'I':
                    operator = getOperator(chars,i,'V','X');
                    break;
                case 'X':
                    operator = getOperator(chars,i, 'L', 'C');
                    break;
                case 'C':
                    operator = getOperator(chars,i, 'D', 'M');
                    break;
            }

            switch (operator){
                case '+':
                    result = result + value;
                    break;
                case '-':
                    result = result - value;
                    operator = '+';
            }


        }

        return  result;
    }

    public static char getOperator(char[] chars, int i, char char1, char char2){
        if (chars.length == i + 1)
            return  '+';

        if (chars[i + 1] == char1 || chars[i + 1] == char2){
            return  '-';

        }else
            return '+';
    }
    // Roman to decimal ends here
}
