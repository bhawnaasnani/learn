package learn.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * given a grid of m*n, how many ways can you travel from top level corner to bottom right corner
 * @author bhawna
 *
 */
public class GridTraveler {
  
  static Map<String, Long> memo  = new HashMap<>();
  
  public static void main(String[] args) {
    //int p = travel(3,2); //3
    //int p = travel(3,3); //6
    long p = travel(18,18); //2333606220
    System.out.println(p);
    System.out.println(memo);
  }
  
  private static long travel(int m, int n) {
    if(memo.get(m + "," + n) != null)
    {
      return memo.get(m + "," + n);
    }
    if(m == 0 || n == 0)
    {
      return 0;
    }
    if(m==1 && n==1)
    {
      return 1;
    }
    System.out.println("m " + m + " n " + n);
    long x = travel(m-1, n);
    memo.put(m-1 + "," + n, x);
    long y = travel(m, n-1);
    memo.put(m + "," + (n-1), y);
    memo.put(m + "," + n, x+y);
    return x+y;
  }

}
