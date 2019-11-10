import java.util.Scanner;

class KMP {
    public static void main(String[] args){
        Scanner sc = Scanner(System.in);
        try {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            sc.close();
        }
        if (str2.length() > str1.length()){
            return;
        }
        int[] nextArr = getNextArr(str2);
        int i = 0;
        int j = 0;
        while (j < str2.length() && i < str1.length()){
            while (str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }
            j = nextArr[j];
        }

    }
    public static int[] getNextArr(String str) {
        return new int[0];
    }
}