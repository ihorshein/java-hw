package org.ihorshein.lesson2.valid_parentheses;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class Solution {
  public boolean isValid(String s) {
    if(s.isEmpty())
      return false;

    // key - close
    // value - open
    HashMap<Character, Character> brackets = new HashMap<>();
    brackets.put(')', '(');
    brackets.put('}', '{');
    brackets.put(']', '[');

    Stack<Character> sequence = new Stack<>();

    for(int i = 0; i < s.length(); i++) {
      char bracket = s.charAt(i);

      if(brackets.containsValue(bracket))
      {
        sequence.push(s.charAt(i));
        continue;
      }

      if(sequence.isEmpty()) {
        return false;
      }

      // Get the opening bracket from the closing one.
      Character openBracket = brackets.get(bracket);
      if(openBracket == null || openBracket != sequence.pop()) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    example1();
    example2();
    example3();
    example4();
    example5();
  }

  public static void example1()
  {
    String s = "()";

    Solution solution = new Solution();
    System.out.println(s + "  " + solution.isValid(s));
  }

  public static void example2()
  {
    String s = "()[]{}";

    Solution solution = new Solution();
    System.out.println(s + "  " + solution.isValid(s));
  }

  public static void example3()
  {
    String s = "(]";

    Solution solution = new Solution();
    System.out.println(s + "  " + solution.isValid(s));
  }

  public static void example4()
  {
    String s = "([])";

    Solution solution = new Solution();
    System.out.println(s + "  " + solution.isValid(s));
  }

  public static void example5()
  {
    String s = ")[(]){}}";

    Solution solution = new Solution();
    System.out.println(s + "  " + solution.isValid(s));
  }
}
