package learn.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinChange {

  static int[] coins = {2, 5, 7};
  static int targetSum = 7;
  static Set<String> options = new HashSet<>();

  public static void main(String[] args) {
    makeSum(targetSum, new ArrayList<Integer>());
    for (String string : options) {
      System.out.println(string);
    }
  }

  // public static void makeSum(int targetSum, List<Integer> optionPaths){
  //
  //
  //
  // for (int i = 0; i < coins.length; i++) {
  // targetSum = targetSum - coins[i];
  // if(targetSum < 0){
  // continue;
  // }
  //
  // optionPaths.add(coins[i]);
  //
  // System.out.println("targetsum " + targetSum + " coins["+i+"] "+ coins[i]);
  //
  // if(targetSum == 0){
  // String path = null;
  // System.out.println("optionPaths " + optionPaths);
  // for (Integer option : optionPaths) {
  // path = path + ","+ option ;
  // }
  // options.add(path.substring(5, path.length() ));
  // continue;
  // }
  // makeSum(targetSum, optionPaths);
  // }
  // }

  public static boolean makeSum(int targetSum, List<Integer> optionPaths) {

    boolean makeSum = false;

    for (int i = 0; i < coins.length; i++) {
      if(targetSum <0)
      {
        continue;
      }
      if(targetSum ==0)
      {
        makeSum = true;
        continue;
      }
     System.out.println("targetsum " + targetSum + " coins["+i+"] "+ coins[i]);
     if(makeSum(targetSum-coins[i], optionPaths) || makeSum)
     {
       makeSum = true;
       optionPaths.add(coins[i]);
     }
     
    }
    String path = null;
    for (Integer option : optionPaths) {
       path = path + ","+ option ;
       }
      System.out.println(path);
    return makeSum;
  }
}
