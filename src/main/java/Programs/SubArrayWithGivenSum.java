package Programs;

import java.util.ArrayList;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {135,101,170,125,79,159,163,65,106,146,82,28,162,92,196,143,28,37,192,5,103,154,93,183,22,117,119,96,48,127,172,139,70,113,68,100,36,95,104,12,123,134};

        System.out.println(subarraySum(arr,42,468));
    }
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        int start = 0;
        int end = 0;
        int sum = 0;
        ArrayList<Integer> arr1 = new ArrayList<>();
        while(start < n && end <= n){
            if(sum == s){
                break;
            }
            else if(sum<s){
                sum += arr[end];
                end++;
            }else {
                sum -= arr[start];
                start++;
            }
        }

        if(sum != s){
            arr1.add(-1);
            return arr1;
        }else {
            arr1.add(start+1);
            arr1.add(end);
            return arr1;
        }
    }
}
