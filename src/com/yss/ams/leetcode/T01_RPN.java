package com.yss.ams.leetcode;

import java.util.Stack;

/**
 * 逆波兰式(二叉树的后续遍历) 计算逆波兰式 “3 4 + 5 * 6 -”的值
 * 
 * @author shenyao
 *
 */
public class T01_RPN {
	public static void main(String[] args) {
		T01_RPN t = new T01_RPN();
		System.out.println(t.evalRPN(new String[] { "3", "4", "+", "5", "*",
				"6", "-" }));
		System.out.println(t.evalRPN(new String[] { "18"}));
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		for (String str : tokens) {
			if (!"+".equals(str) && !"-".equals(str) && !"*".equals(str) && !"/".equals(str)) {
				Integer integer = Integer.parseInt(str);
				result = integer;
				stack.push(integer);
			} else {
				Integer num2 = stack.pop();
				Integer num1 = stack.pop();
				result = calc(num1, num2, str.charAt(0));
				stack.push(result);
			}
		}
		return result;
	}

	private Integer calc(Integer num1, Integer num2, char c) {
		Integer integer = 0;
		switch (c) {
		case '+':
			integer = num1 + num2;
			break;
		case '-':
			integer = num1 - num2;
			break;
		case '*':
			integer = num1 * num2;
			break;
		case '/':
			integer = num1 / num2;
			break;
		default:
			break;
		}
		return integer;
	}
}
