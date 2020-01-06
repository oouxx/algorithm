class Adapter extends Target{
    private Adaptee adaptee;
    public Adapater(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    public static void request(){
        adaptee.specificRequest();
    }
}

interface ScoreOperation{
    public int[] sort(int[] array);

    public int search(int[] array, int key);
}

class OperationAdapter implements ScoreOperation {
    private QuickSort quickSort;
    private BinarySearch binarySearch;

    public OperationAdapter() {
        quickSort = new QuickSort();
        binarySearch = new BinarySearch();
    }

    public int[] sort(int[] array) {
        return quickSort.quickSort(array);
    }

    public int search(int[] array, int key) {
        return binarySearch.binarySearch(array, key);
    }

}

class QuickSort{
    public int[] quickSort(int[] array){
        if(array == null || array.length == 0){
            return new int[0];
        }
        sort(array, 0, array.length - 1);
        return array;
    }
    private void sort(int[] array, int p, int r){
        int q = 0;
        if(p < r){
            q = partition(array, p, r);
            sort(array, p, q - 1);
            sort(array, q + 1, r);
        }
    }
    private int partition(int[] a, int p, int r){
        int x = a[r];
        int j = p - 1;
        for(int i = p; i <= r - 1; i++){
            if(a[i] <= x){
                j++;
                swap(a, i, j);
            }
        }
        swap(a, j + 1, r);
        return j + 1;
    }
    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

class BinarySearch{
    public int binarySearch(int[] array, int key){
        int low = 0;
        int high = array.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int midVal = array[mid];
            if(midVal < key){
                low = mod + 1;
            }else if(midVal > key){
                high = mid - 1;
            }else{
                return 1;
            }
        }
        return -1;
    }
}
