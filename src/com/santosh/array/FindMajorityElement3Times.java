package com.santosh.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMajorityElement3Times {
	
	public static void main(String[] args) {
		int [] array = {2, 2, 3, 1, 3, 2, 1, 1};
		
		List<Integer> majorityElements = majorityElementByThreeTimes(array);
		System.out.println("majorityElements : "+majorityElements);
		System.out.println("--------------------------------------------");
		List<Integer> majorityElementsOutput = majorityElementByThreeTimesOptimised(array);
		System.out.println("majorityElementsOutput : "+majorityElementsOutput);
	}
	
	// Approach
	// use 2 loops. initialize count=0
	// compare elements at i'th and j'th location. if both are same then increment counter 
	// in the same loop check count > n/3. if yes then add element to list. before adding check for existence .
	// if you found 2 majority elements then break the loop 
	// T(C) -> O(n ^ 2)
	// S(C) -> O(1)
	static List<Integer> majorityElementByThreeTimes(int [] array){
		if(array == null || array.length < 0) {
			System.out.println("invalid input");
			return Collections.emptyList() ;
		}
		
		int n  = array.length;
		List<Integer> resultList = new ArrayList<Integer>();
		
		for(int i=0; i <n ; i++) {
			int count = 0;
			for(int j=0; j <n ; j++) {
				if(array[i] == array[j]) {
					count++;
				}
			}
			
			if(count > (n/3)) {
				if(resultList.size() == 0 || array[i] != resultList.get(0)) {
					resultList.add(array[i]);
				}
			}
			
			// If we have found two majority elements, 
            // we can stop our search
            if (resultList.size() == 2) {
                if (resultList.get(0) > resultList.get(1))
                    java.util.Collections.swap(resultList, 0, 1);
                break;
            }
		}
		
		return resultList;
	}

	
	// Approach
	// use of two variables as element1 and element2 along with their count variables as count1 and count2.
	// loop 0 to N
	// initialize element1 and element2 to -1. And count1 and count2  to 0.
	// check next element in array is equal to element1 or element2 and increment respective count.
	// if count1 is 0 then reinitialize element1 to number and increment count1. follow this step for count2 as well.
	// if number is not equal to element1 or element2 then decrement count1 and count2.
	// count occurrences of candidates
	// add result to list
	
	// T(C) -> O(n)
	// S(C) -> O(1)
	static List<Integer> majorityElementByThreeTimesOptimised(int [] array){
		if(array == null || array.length < 0) {
			System.out.println("invalid input");
			return Collections.emptyList() ;
		}
		
		int n = array.length;
		List<Integer> resultList = new ArrayList<Integer>();
		int element1 = -1;
		int count1 = 0;
		int element2 = -1;
		int count2 = 0;
		
		for(int num : array) {
			
			
			if(element1 == num) {
				count1++;
			}
			
			else if(element2 == num) {
				count2++;
			}
			else if(count1 == 0) {
				element1 = num;
				count1++;
			}
			else if(count2 == 0) {
				element2 = num;
				count2++;
			}else {
				count1--;
				count2--;
			}
		}
		
		count1 = 0;
		count2 = 0;
		
		//count occurrences of candidates
		for(int number : array) {
			if(element1 == number) {
				count1++;
			}
			if(element2 == number) {
				count2++;
			}
		}
		// add to result if they are majority element
		if(count1 > n/3) {
			resultList.add(element1);
		}
		
		if(count2 > n/3 && element1 != element2) {
			resultList.add(element2);
		}
			
		return resultList;
	}
}
