package com.santosh.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
	
	public static void main(String[] args) {
//		Input: arr[] = [[1, 3], [2, 4], [6, 8], [9, 10]]
//		Output: [[1, 4], [6, 8], [9, 10]]
//		Explanation: In the given intervals, we have only two overlapping intervals [1, 3] and [2, 4]. 
//		Therefore, we will merge these two and return [[1, 4]], [6, 8], [9, 10]].

//		Input: arr[] = [[7, 8], [1, 5], [2, 4], [4, 6]]
//		Output: [[1, 6], [7, 8]]
//		Explanation: We will merge the overlapping intervals [[1, 5], [2, 4], [4, 6]] into a single interval [1, 6].
		
		int[][] arr = {{7, 8}, {1, 5}, {2, 4}, {4, 6}};
        List<int[]> res = mergeOverlap(arr);

        for (int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }
        
        System.out.println("result using optimised version");
        List<int[]> result = mergeOverlapOptimised(arr);
        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
	}
	
	
	// Approach
	// 1. need to sort an array
	// 2. loop array. start with first interval by compairing with other intervals for overlaps.
	// 3. If the first interval overlaps with any other interval, then remove the other interval from the list and merge the other into the first interval.
	// 4. repeat the same steps for other intervals
	
	// T(C) -> O(n^2)
	// S(C) -> O(n)
	static List<int[]> mergeOverlap(int[][] array){
		List<int[]> resultList = new ArrayList<>();
		int n = array.length;
		
		Arrays.sort( array, (a, b) -> Integer.compare(a[0], b[0]));
		
		for(int i = 0; i < n; i++) {
			int start= array[i][0];
			int end = array[i][1];
			
			 // Skipping already merged intervals
            if (!resultList.isEmpty() && resultList.get(resultList.size() - 1)[1] >= end) {
            	continue;
            }
            
            for(int j=i ; j <n; j++) {
            	if(end >= array[j][0]) {
            		end = Math.max(end, array[j][1]);
            	}
            }
            
            resultList.add(new int[] {start,end});
		}
		return resultList;
	}
	
	
	
	// Approach 
	// 1. Sort array based on their starting points.
	// 2. After sorting identify overlapping intervals by comparing each interval with last merged interval.
	// 3. loop from 1 to end of array.
	// 4. if current interval overlaps with merged interval then merge them both
	// 5. otherwise append merged interval with result.
	
	// T(C) -> O(n log n)
	// S(C) -> O(n)
	
	static List<int[]> mergeOverlapOptimised(int[][] array){
		List<int[]> resultList = new ArrayList<>();
		
		Arrays.sort(array, (a,b) -> Integer.compare(a[0], b[0]));
		
		resultList.add(new int[] {array[0][0], array[0][1]});
		
		for(int i = 1; i < array.length ; i++) {
			int[] current = array[i];
			int[] last = resultList.get(resultList.size() -1 );
			
			if(last[1] > current[0]) {
				last[1] = Math.max(last[1], current[1]);
			}else {
				resultList.add(new int [] {current[0], current[1]});
			}
		}
		
		return resultList;
	}

}
