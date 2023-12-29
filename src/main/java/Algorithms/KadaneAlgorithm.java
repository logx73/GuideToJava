package Algorithms;

public class KadaneAlgorithm {
    public int bruteSumContagiousElements(int[] arr){
        int max = arr[0];
        for(int i=0;i<arr.length-1;i++){
            int sum = arr[i];
            for(int j=i+1;j <arr.length;j++){
                sum = sum + arr[j];
                if(max < sum){
                    max = sum;
                }
            }
        }
        return max;
    }

    public int kadanesAlgo(int[] arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<arr.length;i++){

            if(sum<0){
                sum = 0 ;
            }else {
                sum = sum + arr[i];
            }

            if(sum > max){
                max = sum;
            }

        }
        return max;
    }
}
class KadaneRunner{
    public static void main(String[] args) {
        KadaneAlgorithm kadaneAlgorithm = new KadaneAlgorithm();
        int arr[] = {-2,-3,4,-1,-2,1,5,-3};
        int largestSum = kadaneAlgorithm.kadanesAlgo(arr);
        System.out.println(largestSum);
    }
}
