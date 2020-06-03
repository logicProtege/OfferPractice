package binarySearch;

public class bSearch {

	//this is a test 
	//test2 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = new int[]{2,4,5,8,10,13};
		int[] test2 = new int[]{3};
		
		//System.out.println(classicBSearch(test1,13));
		int result[] = kClosest(test1,6,3);
//		for(int number:result) {
//			System.out.println(number);
//	    }
		System.out.print(smallestLarger(test1,9));
		
		//System.out.println(kClosest(test1,6,3));
	}
	
	public static int classicBSearch(int[] input, int target) {
		if(input == null || input.length == 0) {
			return -1;
		}
		int left = 0;
		int right = input.length-1;
		while(left<= right) {
			int mid = left + (right- left)/2;
			if(input[mid] == target) {
				return mid;
			}
			else if (input[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid -1;
			}
		}
		return -1;
	}
	public static int closestElement(int[] input, int target) {

		if(input == null || input.length == 0) {
			return -1;
		}
		int left = 0;
		int right = input.length-1;
		while(left < right -1) {
			int mid = left + (right - left)/2;
			if(input[mid] == target) {
				return mid;
			}
			else if (input[mid]< target) {
				left = mid;
			}
			else {
				right = mid;
			}
			
		}
		
		if(Math.abs(target-input[left]) <= Math.abs(target- input[right])){
			return left;
		}
		
		return right;
	}
	public static int[] kClosest(int[] input, int target, int k) {
		if(input == null || input.length == 0) {
			return input;
		}
		int left = largestSmaller(input,target);
		//System.out.print(left);
		int right = left +1;
		int[] result = new int[k];
		for(int i =0;i < k; i++) {
			if(right>=input.length || (left >=0 && target-input[left] <=input[right]-target)) {
				result[i] = input[left];
				left--;
			}
			else {
				result[i] = input[right];
				right++;
			}
		}
//		for(int number:result) {
//			System.out.println(number);
//		}
		return result;
		
	}
	private static int largestSmaller(int[]input, int target) {
		int left = 0;
		int right = input.length-1;
		//System.out.println(right);
		while(left < right -1) {
			int mid = left + (right - left)/2;
			if(input[mid]== target) {
				left = mid;
			}
			else if (input[mid] < target) {
				left = mid;
			}
			else {
				right = mid ;
			}	
		}
		if(input[right]<= target) {
			return right;
		}
		if(input[left]<= target){
			return left;
		}
	
			return -1;
		
	}
	private static int smallestLarger(int[]input, int target) {
		int left = 0;
		int right = input.length-1;
		//System.out.println(right);
		while(left < right -1) {
			int mid = left + (right - left)/2;
			if(input[mid]== target) {
				left = mid+1;
			}
			else if (input[mid] < target) {
				left = mid+1;
			}
			else {
				right = mid ;
			}	
		}
		if(input[left]> target) {
			return left;
		}
		if(input[right]> target){
			return right;
		}
	
			return -1;
		
	}
}
