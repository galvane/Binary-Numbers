package com.galvane.hackerrank;

import java.util.Scanner;

import static sun.swing.MenuItemLayoutHelper.max;

public class BinaryNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base10n = sc.nextInt();
        String base10s = Integer.toBinaryString(base10n);
        char [] binary = base10s.toCharArray();

        int head = base10s.indexOf("1"); // find the start of consecutive 1's


        System.out.println(calculateOnes(binary, binary.length-1));
    }

    private static int calculateOnes(char[] binary, int tail){
        int head = 0;
        int breakpoint = 0;
        int count = 0;


        for(int i = tail; i >= 0; i--){
            if(binary[i] == '1') {
                count++;
            }else {
                breakpoint = i-1;
                count = max(calculateOnes(binary, breakpoint), count);
                i = -1;
            }
        }
        return count;

    }
}
