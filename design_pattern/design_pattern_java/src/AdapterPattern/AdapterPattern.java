/**
 * 对象适配器模式
 * @author wxx
 */
// target
interface ScoreOperation{
    public int[] sort(int[] array);

    public int search(int[] array, int key);
}
// adapter
// 类适配器
// class Adapter extends Adaptee implements Target
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
// adaptee
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
//adaptee
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

class Client{
    public static void main(String[] args[]){
        ScoreOperation operation;
        operation = (ScoreOperation)XMLUtil.getBean();
        int scores[] = {84, 76, 50, 69, 91 ,88, 96};
        int result[];
        int score;

        System.out.println("成绩排序结果:");
        result = operation.sort(scores);
        for(int i: scores){
            System.out.println(i + ",");
        }
        System.out.println();
        System.out.println("查找成绩90:");
        score = operation.search(result, 90);
        if(score != -1){
            System.out.println("找到成绩90");
        }else{
            System.out.println("没有找到成绩90");
        }

        System.out.println();
        System.out.println("查找成绩92:");
        score = operation.search(result, 92);
        if(score != -1){
            System.out.println("找到成绩92");
        }else{
            System.out.println("没有找到成绩92");
        }
    }
}