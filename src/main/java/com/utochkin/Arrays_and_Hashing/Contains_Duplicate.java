package com.utochkin.Arrays_and_Hashing;

import java.util.HashMap;

public class Contains_Duplicate {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 3};

        System.out.println(hasDuplicate(nums));
    }

    public static boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            if(map.containsKey(i)){
                return true;
            }
            else {
                map.put(i,1);
            }
        }
        return false;
    }
}