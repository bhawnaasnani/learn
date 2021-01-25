package learn.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

  static int[] coins = {2, 5, 7};
  //static int targetSum = 3; //try for false
  static int targetSum = 7;
  
  static Map<Integer, Boolean> memo = new HashMap<>();
  
  public static void main(String[] args) {
    boolean canSum = makeSum(targetSum);
    System.out.println("can sum " + canSum);
    System.out.println(memo);
  }
  
  private static boolean makeSum(int targetSum)
  {
    if(memo.get(targetSum) != null)
    {
      return memo.get(targetSum);
    }
    if(targetSum == 0)
    {
      return true;
    }
    if(targetSum < 0)
    {
      return false;
    }
    
    for (int i = 0; i < coins.length; i++) {
    
      System.out.println("targetSum "  + targetSum +  " coins[" + i + "]" + coins[i]);
      if(makeSum(targetSum - coins[i]))
      {
        memo.put(targetSum - coins[i], true);
        return true;
      }
    }
    memo.put(targetSum, false);
    return false;
  }
}
