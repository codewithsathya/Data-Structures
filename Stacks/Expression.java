package com.myselfsathya;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private final List<Character> leftBrackets = Arrays.asList('(', '[', '<', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', ']', '>', '}');

    public boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if(isLeft(ch))
                stack.push(ch);

            if(isRight(ch)) {
                if (stack.empty()) return false;
                var top = stack.pop();
                if(!BracketsMatch(ch, top))
                    return false;
            }
        }
        return stack.empty();
    }

    private boolean isLeft(char ch) {
        return leftBrackets.contains(ch);
    }
    private boolean isRight(char ch) {
        return rightBrackets.contains(ch);
    }
    private boolean BracketsMatch(char first, char second) {
        return leftBrackets.indexOf(first) == rightBrackets.indexOf(second);
    }
}
