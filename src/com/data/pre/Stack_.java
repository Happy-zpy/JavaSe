package com.data.pre;

import java.util.Stack;

/**
 * 作者：张鹏烨
 * 2025/9/26
 **/
@SuppressWarnings({"all"})
public class Stack_ {
    public static int getPriority(char c){
        return switch (c){
            case '+', '-' -> 1;
            case '*','/'  -> 2;
            case '(',')'  -> 0;
            default -> {
                System.out.println("运算符有问题");
                yield -1;
            }
        };
    }

    public static Stack convert(String s){
        Stack num = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Stack<Character> charac = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                i--;
                num.push(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
            else if (s.charAt(i) == '('){
                charac.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')'){
                while (!charac.empty() && charac.peek() != '('){
                    num.push(charac.pop());
                }
                if (charac.empty()) {
                    System.out.println("括号不匹配");
                    return null;
                }
                charac.pop();
            }
            else {
                while (!charac.empty() && Stack_.getPriority(s.charAt(i)) <= Stack_.getPriority(charac.peek()) ){
                    num.push(charac.pop());
                }
                charac.push(s.charAt(i));
            }

        }
        while (!charac.empty()){
            num.push(charac.pop());
        }
        return num;
    }
    public static int calculate(String s){
        Stack stack = convert(s);
        Stack<Integer> num = new Stack<>();
        Stack<Character> charac = new Stack<>();
        for (Object o : stack) {
            if(o instanceof Integer){
                num.push((Integer) o);
            }
            else {
                charac.push((Character) o);
            char c = charac.pop();
            int b = num.pop();
            int a = num.pop();
            switch (c) {
                case '+' -> {
                    num.push(a + b);
                }
                case '-' -> {
                    num.push(a - b);
                }
                case '*' -> {
                    num.push(a * b);
                }
                case '/' -> {
                    if (b == 0) {
                        System.out.println("除数不能为零");
                    }
                    num.push(a / b);
                }
            }
        }
            }
        return num.pop();
    }
    public static void main(String[] args) {
        String s = "3+4+9*2/2*(3+4*2)";
        Stack stack = convert(s);
        System.out.println(stack);
        System.out.println(calculate(s));
    }
}
