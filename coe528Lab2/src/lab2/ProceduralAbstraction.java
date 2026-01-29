/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

public class ProceduralAbstraction {

    //Requires: None
    //Modifies: None
    //Effects: Returns the smallest positive integer n for which n!
    // (i.e. 1*2*3*…*n) is greater than or equal to x, for positive
    // integer x. Otherwise returns 1.
    public static int reverseFactorial(int x) {
        if (x <= 0) return 1;

        int n = 1;
        long fact = 1; 

        while (fact < x) {
            n++;
            fact *= n;
        }
        return n;
    }

    //Requires: None
    //Modifies: None
    //Effects: If the matrix arr satisfies Nice property, prints the sum and
    // returns true. Otherwise returns false.
    public static boolean isMatrixNice(int[][] arr) {
        // basic validity checks
        if (arr == null || arr.length == 0) return false;

        int n = arr.length;

        // must be square and no null rows
        for (int i = 0; i < n; i++) {
            if (arr[i] == null || arr[i].length != n) return false;
        }

        // target sum = sum of first row
        int target = 0;
        for (int j = 0; j < n; j++) {
            target += arr[0][j];
        }

        // check each row sum
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) rowSum += arr[i][j];
            if (rowSum != target) return false;
        }

        // check each column sum
        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) colSum += arr[i][j];
            if (colSum != target) return false;
        }

        // main diagonal
        int diag1 = 0;
        for (int i = 0; i < n; i++) diag1 += arr[i][i];
        if (diag1 != target) return false;

        // secondary diagonal
        int diag2 = 0;
        for (int i = 0; i < n; i++) diag2 += arr[i][n - 1 - i];
        if (diag2 != target) return false;

        // if nice, print sum and return true
        System.out.println(target);
        return true;
    }

    // Optional quick test (you can delete before submitting if you want)
    public static void main(String[] args) {
        System.out.println(reverseFactorial(24));   // 4
        System.out.println(reverseFactorial(119));  // 5
        System.out.println(reverseFactorial(-2));   // 1

        int[][] nice = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 8}
        };
        System.out.println(isMatrixNice(nice)); // prints 15 then true

        int[][] notNice = {
            {-3, 1, 0},
            {4, -3, 4},
            {7, -9, 0}
        };
        System.out.println(isMatrixNice(notNice)); // false
    }
}
