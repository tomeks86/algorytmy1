package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class InvModulo {
    private static int swap(int a, int b) {
        return a;
    }

    public static int invModulo(int a, int b) {
        int u = 1, v = 0, w = a, x = 0, y = 1, z = b;
        while (w != 0) {
            if (w < z) {
                u = swap(x, x = u);
                v = swap(y, y = v);
                w = swap(z, z = w);
            }
            int q = w / z;
            u -= q * x;
            v -= q * y;
            w -= q * z;
        }
        if (z == 1) {
            if (x < 0) return x + b;
            else return x;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*int a = sc.nextInt();
        int b = sc.nextInt();*/
        int a = 12767; //561;
        int b = 256; //15156;
        int c = invModulo(a, b);
        if (c > 0) {
            System.out.println("inverted modulo a & b (x): " + c);
            System.out.println("checking a*x % b");
            System.out.println(a * c % b);
        } else System.out.println("inverted modulo a & b doesn't exist!");
    }
}
