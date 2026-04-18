package com.santosh.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMajorityElement3Times {
	
	public static void main(String[] args) {
		int [] array = {2, 2, 3, 1, 3, 2, 1, 1};
		
		List<Integer> majorityElements = majorityElementByThreeTimes(array);
		System.out.println("majorityElements : "+majorityElements);
	}
	
	// Approach
	// use 2 loops. initialize count=0
	// compare elements at i'th and j'th location. if both are same then increment counter 
	// in the same loop check count > n/3. if yes then add element to list. before adding check for existence .
	// if you found 2 majority elements then break the loop 
	// T(C) -> O()n ^ 2
	// S(C) -> O(1)
	static List<Integer> majorityElementByThreeTimes(int [] array){
		if(array == null || array.length < 0) {
			System.out.println("invalid input");
			return Collections.emptyList() ;
		}
		
		int n  = array.length;
		List<Integer> resultList = new ArrayList();
		
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

}
