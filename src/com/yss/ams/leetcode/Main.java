package com.yss.ams.leetcode;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = 0;
		String[] input = new String[2];
		while (in.hasNext()) {
			input[i] = in.nextLine();
			i++;
			if (i == 2) {
				i = 0;
				String str = input[0];
				String append = input[1];

				if (str.length() <= 8) {
					if(str.length()>0){
						System.out.println(modifyStr(str));
					}
					str = append;
					while(str.length() >= 8){
						System.out.println(str.substring(0, 8));
						str = str.substring(8);
					}
					if(str.length()>0){
						System.out.println(modifyStr(str));
					}
				} else{
					while(str.length() >= 8){
						System.out.println(str.substring(0, 8));
						str = str.substring(8);
					}
					if(str.length()>0){
						System.out.println(modifyStr(str));
					}
					
					str = append;
					while(str.length() >= 8){
						System.out.println(str.substring(0, 8));
						str = str.substring(8);
					}
					if(str.length()>0){
						System.out.println(modifyStr(str));
					}
				
			}
		  }
		}
	}

	private static String modifyStr(String str) {
		if (str.length() < 8) {
			for (int i = str.length(); i < 8; i++) {
				str = str + "0";
			}
		}
		return str;
	}

}
