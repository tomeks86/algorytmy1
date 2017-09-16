package com.company;

public class Math {

    public static double pow(double base, int exp) {
        if (exp < 0) {
            return -1;
        }
        double res = 1;
        int r;
        while (exp > 0) {
            r = exp % 2;
            exp /= 2;
            if (r > 0) {
                res *= base;
                //res %= 1000;    //return only last 3 digits...
            }
            base *= base;
        }
        return res;
    }

    public static double sqrtNewton(double r, double e) {
        if (r < 0) {
            System.out.println("negative numbers not implemented!");
            return -1;
        } else if (r < 1) {
            int n = 0;
            double r2 = r;
            while (r2 < 1) {
                r2 *= 10;
                n += 1;
            }
            return sqrtNewton(r2,e)/sqrtNewton(pow(10.,n),e);
        } else {
            double xn = r, xnp1 = .5 * (r / xn + xn);
            while ((xn - xnp1) > e) {
                xn = xnp1;
                xnp1 = .5 * (r / xnp1 + xnp1);
            }
            return xnp1;
        }
    }

    public static double sqrt(double r, double e) {
        if (r < 0) {
            System.out.println("negative numbers not implemented!");
            return -1;
        }
        double L = 0, P = r, c;
        while (P-L > e) {
            c = (P + L) / 2;
            if (c*c > r) {
                P = c;
            } else {
                L = c;
            }
        }
        return (L + P) / 2;
    }

    public static void main(String[] args) {

        System.out.println(sqrtNewton(2,1.e-6));
        System.out.println(sqrt(2,1.e-6));
        System.out.println(sqrtNewton(0.000000000016,1.e-10));
        System.out.println(sqrtNewton(2000,1.e-3));
        System.out.println(sqrt(2000,1.e-3));
        //System.out.println(sqrt(2,1.e-1) - sqrt(2,1e-4));
    }
}
