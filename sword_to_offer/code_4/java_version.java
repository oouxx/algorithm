public class Solution {
    public boolean Find(int target, int [][] array) {
    	int rows = array.length;
    	int cols = array[0].length;
    	int row = 0;
    	int col = cols - 1;
    	if(array == null)
    		return false;
    	while(row <= (rows-1) && col >= 0) {
    		if(array[row][col] > target) --col;
    		else if(array[row][col] < target) ++row;
    		else return true;
        }
        return false;
    }
}