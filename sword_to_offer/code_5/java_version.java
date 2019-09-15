public class Solution {
    public static String replaceSpace(StringBuffer str) {
    	for(int i=0;i< str.length();i++) {
    		String s = Character.toString(str.charAt(i));
    		if (s.equals(" ")) {
    			str.deleteCharAt(i);
    			str.insert(i, "%20");
    		}
    	}
    	StringBuffer result = str;
    	return result.toString();
    }
    public static void main(String[] args) {
    	StringBuffer s  = new StringBuffer("We Are Happy");
    	String result = replaceSpace(s);
    	System.out.println(result);
    }
}






