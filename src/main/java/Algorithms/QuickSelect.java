package Algorithms;

import javax.swing.text.Element;

public class QuickSelect {
    void kthSmallestElement(int[] arr, int low, int high, int k){
        int median = (low + high)/2;
        int settledIndex = partition(arr, low,high,median);
        if(settledIndex == k-1){
            System.out.println("Element found "+arr[settledIndex]);
        }
        else if(k-1 < settledIndex){
            kthSmallestElement(arr,low,settledIndex-1,k);
        }else if(k-1 > settledIndex){
            kthSmallestElement(arr,high,settledIndex+1,k);
        }
        else {
            System.out.println("Element not found");
        }

    }

    private int partition(int[] arr, int low, int high, int median) {


        while (low <= high){
            while(arr[low] < arr[median]){
                low++;
            }
            while (arr[high] > arr[median]){
                high--;
            }
            if(low<=high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }

}

class QuickRunner{
    public static void main(String[] args) {
        QuickSelect quickSelect = new QuickSelect();
        int[] arr={5,3,4,1,2,6};
        quickSelect.kthSmallestElement(arr,0,arr.length-1,3);
    }
}
