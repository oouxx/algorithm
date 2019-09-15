package 数组中重复的数字;

public class Ques_02 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor----------------------------------------------------------- in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	if ( numbers == null || length == 0) {
    		return false;
    	}
    	int low = 1;
    	int high = length-1;
    	while(high >= low) {
    		int mid = (high - low)/2+low;
    		int count = repeat_time(numbers, length, low, mid);
    		if(high == low) {
    			if (count > 1) {
    				duplication[0] = low;
    				return true;
    			}
    			else {
    				break;
    			}
    			
    		}
    		if(count > (mid-low+1)) {
    			high = mid;
    		}
    		else {
    			low = mid + 1;
    		}
    	}
    	return false;
    }
    public int repeat_time(int numbers[], int length, int low, int end) {
    	if(numbers == null) {
    		return 0;
    	}
    	int count = 0;
    	for(int i=0;i<length;i++) {
    		if(numbers[i] >= low && numbers[i] <= end) {
    			++count;
    		}
    	}
    	return count;
    }
}