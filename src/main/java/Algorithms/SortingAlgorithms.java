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

    public int missingNumber(int[] nums) {
        int[] numss = cyclicSort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]){
                return i;
            }
        }
        Set<Integer> integerSet = new HashSet<>();
        for(int num:nums){
            if(integerSet.contains(num)){
                integerSet.remove(num);
            }else{
                return num;
            }
        }
        List<Integer> integerList = new ArrayList<>();
        return nums.length;
    }
}

class SortRunner{
    public static void main(String[] args) {
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        System.out.println(Arrays.toString(sortingAlgorithms.bubbleSort(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(sortingAlgorithms.selectionSort(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(sortingAlgorithms.insertionSort(new int[]{5, 4, 3, 2, 1})));
//        System.out.println(Arrays.toString(sortingAlgorithms.cyclicSort(new int[]{5, 4, 3, 2, 1})));
        System.out.println(sortingAlgorithms.missingNumber(new int[]{1,3,4,2,2}));

    }
}
