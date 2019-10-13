public class QuickSort{
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 4 ,2};
        quickSort(arr, 0, arr.length - 1);
        output(arr);
    }
    public static void quickSort(int[] arr, int l, int r){
        if (arr.length == 1 || arr == null){
            return;
        }
        quickSortCore(arr, l, r);
    }
    public static void quickSortCore(int[] arr, int l, int r){
        if (l < r){
            int [] p = partition(arr, l, r);
            quickSortCore(arr, l, p[0]);
            quickSortCore(arr, p[1], r);
        }
    }
    
    public static int[] partition(int[] arr, int l, int r){
        int ll = l;
        int node = arr[l];
        int i = l - 1;
        int j = r + 1;
        while (l < j){
            if (arr[l] < node){
               i += 1;
               l += 1; 
            } else if (arr[l] > node){
                j -= 1;
                swap(arr, l, j); 
            } else{
                l += 1;
            }
        }
        swap(arr, ll, i+1);
        return new int[]{i, j};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void output(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}