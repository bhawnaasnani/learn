package learn.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {

  static int[] coins = { 2, 5, 7};
  static int targetSum = 7;
  static Map<Integer, List<Integer>> memo = new HashMap<>();

  public static void main(String[] args) {
    System.out.println(makeSum(targetSum));

  }

  public static List<Integer> makeSum(int targetSum) {

    if (memo.get(targetSum) != null) {
      return memo.get(targetSum);
    }
    if (targetSum < 0) {
      return null;
    }
    if (targetSum == 0) {
      return new ArrayList<>();
    }
    for (int i = 0; i < coins.length; i++) {

      System.out.println("targetsum " + targetSum + " coins[" + i + "] " + coins[i]);
      List<Integer> options = makeSum(targetSum - coins[i]);
      if (options != null) {
        options.add(coins[i]);
        memo.put(targetSum - coins[i], options);
        return options;
      }

    }

    return null;
  }
}
