package com.company;

public class Math {

    public static double sqrt(double r, double e) {
        if (r < 0) {
            System.out.println("negative numbers not implemented!");
            return -1;
        } else {
            double xn = r, xnp1 = .5 * (r / xn + xn);
            while ((xn - xnp1) > e) {
                xn = xnp1;
                xnp1 = .5 * (r / xnp1 + xnp1);
            }
            return xnp1;
        }
    }

    public static void main(String[] args) {

        System.out.println(sqrt(2,1.e-6));
        System.out.println(sqrt(-0.002,1.e-3));
        System.out.println(sqrt(2000,1.e-3));
        //System.out.println(sqrt(2,1.e-1) - sqrt(2,1e-4));
    }
}
