package Algorithms;

import java.util.*;

public class SortingAlgorithms {
    public int[] bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){ //For each element
            for(int j=0;j<arr.length-1-i;j++){//Iterate maximum element at the end
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public int[] selectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int max = Integer.MIN_VALUE;
            int index = Integer.MIN_VALUE;

            for(int j=0;j<arr.length-i;j++){
                if(max < arr[j]){
                    max = arr[j];
                    index = j;
                }
            }

            if(index != arr.length-i-1) {
                int temp = arr[index];
                arr[index] = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = temp;
            }
        }
        return arr;
    }

    public int[] insertionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j-1]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
        return arr;
    }

    public int[] cyclicSort(int[] arr){
        int i=0;
        while(i<arr.length){
            int currentPos = arr[i]-1;
            if(arr[i]!=arr[currentPos]){
                swap(arr,i,currentPos);
            }else{
                i++;
            }
        }
        return arr;
    }

    void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;

        int[] lhs = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] rhs = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return sort(lhs,rhs);
    }

    public int[] sort(int[] lhs,int[] rhs){

        int[] overallMerge = new int[lhs.length + rhs.length];
        int i=0,j=0,k=0;
        while (i < lhs.length && j < rhs.length){
            if(lhs[i] > rhs[j]){
                overallMerge[k] = rhs[j];
                j++;
            }else{
                overallMerge[k] = lhs[i];
                i++;
            }
            k++;
        }
        while (i < lhs.length){
            overallMerge[k]=lhs[i];
            i++;
            k++;
        }
        while (j < rhs.length){
            overallMerge[k]=rhs[j];
            j++;
            k++;
        }
        return overallMerge;
    }
    public void inPlaceMergeSort(int[] a, int start, int end){
        if(end-start == 1){
            return;
        }
        int mid = (start + end)/2;
        inPlaceMergeSort(a,start,mid);
        inPlaceMergeSort(a,mid,end);
        merge(a,start,end,mid);
    }
    void merge(int[] a,int start, int end, int mid){
        int[] mixedArray = new int[end-start];
        int i = start;
        int j =end;
        int k = 0;
        while(i<j){
            if(a[i]<a[mid]){
                mixedArray[k] = a[i];
                i++;
                k++;
            }
            else{

            }
        }
    }
    public void sort012(int a[], int n)
    {
        int pivot = a.length/2;
        partiti(a,0,a.length-1,pivot);
    }

    void partiti(int[] a, int start, int end, int pivot){

        while(start<end){

            while(a[start] < a[pivot]){
                start++;
            }

            while(a[end] > a[pivot]){
                end--;
            }

            if(start<end){
                int temp = a[start];
                a[start]=a[end];
                a[end]=temp;
                start++;
                end--;
            }
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> integerMap =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(integerMap.containsKey(target-nums[i])){
                return new int[]{integerMap.get(target-nums[i]),i};
            }
            integerMap.put(nums[i],i);
        }
        return new int[]{};
    }

    public int getPairsCount(int[] arr, int n, int k) {
        // code here
        int count = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0;i<n;i++) {
            if (m.containsKey(k-arr[i])) {
                count +=m.get(k-arr[i]);
                m.put(arr[i], m.getOrDefault(arr[i],0) +1);
            } else {
                m.put(arr[i],m.getOrDefault(arr[i], 0) +1);
            }
        }
        return count;
    }

}

class SortRunner{
    public static void main(String[] args) {
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        System.out.println(Arrays.toString(sortingAlgorithms.bubbleSort(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(sortingAlgorithms.selectionSort(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(sortingAlgorithms.insertionSort(new int[]{5, 4, 3, 2, 1})));
//        System.out.println(Arrays.toString(sortingAlgorithms.cyclicSort(new int[]{5, 4, 3, 2, 1})));
//        System.out.println(sortingAlgorithms.missingNumber(new int[]{1,3,4,2,2}));
        sortingAlgorithms.sort012(new int[]{0,1,2,0,1,2},5);
        sortingAlgorithms.twoSum(new int[]{2,7,11,15},9);
        sortingAlgorithms.getPairsCount(new int[]{1,5,7,1},4,6);
    }
}
