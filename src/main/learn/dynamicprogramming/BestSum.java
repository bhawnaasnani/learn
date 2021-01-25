package learn.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {

  static int[] coins = {2,5,7,1};
  static int targetSum = 7;
  static Map<Integer, List<Integer>> memo = new HashMap<>();
  
  public static void main(String[] args) {
    System.out.println(makeSum(targetSum));
   
  }

  public static List<Integer> makeSum(int targetSum) {
    List<Integer> smallestOptions = new ArrayList<>();

    if (memo.get(targetSum) != null) {
      return memo.get(targetSum);
    }
    if (targetSum < 0) {
      return null;
    }
    if (targetSum == 0) {
      return  new ArrayList<Integer>();
    }
    for (int i = 0; i < coins.length; i++) {

      List<Integer> options = makeSum(targetSum - coins[i]);
      if ( options != null ) {
        options.add(coins[i]);
        if(smallestOptions.size() > options.size() || smallestOptions.size() == 0 )
        {
          smallestOptions = options;
          memo.put(targetSum - coins[i], smallestOptions);
          System.out.println((targetSum - coins[i]) + " : " + smallestOptions);
        }
      }

    }

    return smallestOptions;
  }
}
