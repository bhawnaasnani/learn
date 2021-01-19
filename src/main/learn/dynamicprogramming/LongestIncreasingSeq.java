package learn.dynamicprogramming;

/**
 * Compare each element at 'ith' index with all 'i-1' elements to see which sequences it can participate it.
 * If  'arr[j] < arr[i]' then, i can participate in j's seq and hence  'lis[i] = max(lis[i], lis[j] + 1);'
 * 
 * @author bhawna
 *
 */
public class LongestIncreasingSeq {
  
  public static void main(String[] args) {
    int[] arr = {10, 9, 2, 5, 6, 7, 101, 18};
    System.out.println(lis(arr));
  }
  
  static int lis(int[] arr) {
    
    int[] lis = new int[arr.length]; //lis ending at 'i' index
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
        lis[i] = 1;
        for (int j = 0; j < i; j++) {
            System.out.println("comparing if " + arr[j] + " < "  + arr[i]);
            if (arr[j] < arr[i]) {
                lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        max = Math.max(max, lis[i]);
        System.out.println("lis[" + i + "] - " + lis[i]);
    }
    return max;
  }
}
