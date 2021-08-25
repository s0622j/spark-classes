import static org.apache.commons.lang3.ArrayUtils.swap;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {12,9,23,77,6,34};

        System.out.println("hello world!");
    }

    public static void bubbleSort(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = 0; y < arr.length - 1 - x; y++) {
                if (arr[y] > arr[y + 1]) {
                    int temp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = temp;
//                    swap(arr,y,y+1);
                }
            }
        }
    }

    //打印数组的方法。
    public static void printArray(int[] arr)
    {
        for(int x=0; x<arr.length; x++)
        {
            if(x!=arr.length-1)
                System.out.print(arr[x]+",");
            else
                System.out.println(arr[x]);
        }
    }
}


