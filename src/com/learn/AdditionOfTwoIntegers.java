package com.learn;

import java.util.HashMap;
import java.util.Stack;

public class AdditionOfTwoIntegers {
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
	}
}
