package com.utochkin.Two_Pointers;

public class Valid_Palindrome {

    public static void main(String[] args) {

        String s = "Was it a car or a cat I saw?";

        System.out.println((isPalindrome(s)));
    }

    public static boolean isPalindrome(String s) {

        String lowerCase = s.toLowerCase();

        String lowerCaseWithOnlyWords = lowerCase.replaceAll("[^a-z-0-9]", "");

        char[] charArray = lowerCaseWithOnlyWords.toCharArray();

        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
