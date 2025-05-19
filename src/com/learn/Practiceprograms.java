package com.learn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Stack;

public class Practiceprograms {
	public static int[] findAdditionOfTwoIntegers(int[] nums, int target) {
		int[] result;
		HashMap<Integer, Integer> numMap = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			
			if(numMap.containsKey(diff)) {
				result = new int[]{diff, nums[i]};
				return result;
			}
			numMap.put(nums[i], diff);	
		}
		
		return null;
	}
	
	public static boolean findBalancedBrackets(char[] brackets) {
			
			HashMap<Character, Character> bracketMap = new HashMap<>();
			Stack<Character> bracketStack = new Stack<>();
			
			bracketMap.put(')', '(');
			bracketMap.put('}', '{');
			bracketMap.put(']', '[');
			
			for(int i = 0; i < brackets.length; i++) {
				
				if(bracketMap.containsKey(brackets[i]))
				{
					if(bracketStack.size() == 0) {
						return false;
						
					}else {
						if(bracketStack.peek()== bracketMap.get(brackets[i])) {
							bracketStack.pop();
							continue;
						}
						else {
							return false;
						}
					}
				}
				bracketStack.add(brackets[i]);
			}
			
			if(bracketStack.empty()) {
				return true;
			}else {
				return false;
			}
			
		}
	
	//Find the contiguous sub array within an array which has the largest sum.
	//[5,-1,-7,8,7,-4,9,0,2]
	//currSum = 5, maxSum = 5, start = 0, end = 0
	//currSum = 4, maxSum = 5, start = 0, end = 0
	//currSum = 0, maxSum = 5, if currSum=0, start = 0, end = 0
	//currSum = 8, maxSum = 8
	//currSum = 15, maxSum = 15
	//currSum = 11, maxSum = 15
	//currSum = 20, maxSum = 20
	//currSum = 20, maxSum = 20
	//currSum = 22, maxSum = 22
	//update max_start=temp_start and max_end=i when there is an update to maxSum
	//every time currSum becomes 0, update temp_start=i
	
	public static int[] findlenOfMaxSumSubArray(int[] nums) {
		if(nums.length == 0) {
			return null;
		}
		if(nums.length == 1) {
			return nums;
		}
		int tempStart = 0;
		int maxStart = 0;
		int maxEnd = 0;
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int[] maxSubArray;
		
		for(int i = 0; i < nums.length; i++) {
			currSum = currSum + nums[i];
			
			if(currSum > maxSum) {
				maxSum = currSum;
				maxStart = tempStart;
				maxEnd = i;	
			}
			if(currSum < 0) {
				currSum = 0;
				tempStart = i; //do +1 when returning result
			}
		
		}
		return Arrays.copyOfRange(nums, maxStart+1, maxEnd+1);
	}
	
	//Remove Duplicates from Sorted Array
	public static int[] removeDuplicates(int[] nums) {
		LinkedHashSet<Integer> numSet = new LinkedHashSet<>();
		int[] result;
		
		for (int i = 0; i< nums.length; i++) {
			numSet.add(nums[i]);
		}
		int arraySize = numSet.size();
		result = new int[arraySize];
		
		int j = 0;
		for(int number : numSet) {
			result[j] = number;
			j++;
		}
		return result;
		
	}
	
	//Best possible Time to Buy and Sell Stock [6,1,4,6,9,3]
	//[0, 0, 3, 5, 8, 2]
	public static int sellStock(int[] stocks) {
		int minStock = stocks[0];
		int maxProfit = 0;
        
        for(int i=1; i < stocks.length; i++) {
        	if(minStock > stocks[i]) {
        		minStock = stocks[i];
        	}else if(minStock < stocks[i]) {
        		maxProfit = Math.max(maxProfit, stocks[i]-minStock);	
        	}
        }
        return maxProfit;
	}
	
	
	
	
	
	public static void main(String args[]) {
		//Given an array of integers, find two numbers such that they add up to a specific target number
		int[] nums = {1,6,8,3,2,9};
		int[] result;
		result =  findAdditionOfTwoIntegers(nums, 8);
		
		if(result != null) {
		System.out.println(result[0]+ " , "+ result[1]);
		}
		
		//Balanced Brackets
		char[] brackets = {'(','[','{','[',']','}',')',')'};
		System.out.println(findBalancedBrackets(brackets));
		
		
		//Find the contiguous sub array within an array which has the largest sum.
		int[] nums1 = {5,-1,-7,8,7,-4,9,0,2};
		int[] maxSubArray = findlenOfMaxSumSubArray(nums1);
		System.out.println("contiguous sub array");
		System.out.println(Arrays.toString(maxSubArray));
	
		
		//Remove Duplicates from Sorted Array
		int[] nums2 = {1,1,4,5,6,6,8,9,9};
		int[] result_removeDup = removeDuplicates(nums2);
		System.out.println("Remove Duplicates from Sorted Array");
		for(int i=0; i < result_removeDup.length; i++) {
			System.out.println(result_removeDup[i]);
		}
		
		int[] stocks = {6,1,4,6,9,3};
		System.out.println("maxProfit is " + sellStock(stocks));
		
	}	
}
