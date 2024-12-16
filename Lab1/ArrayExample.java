package Lab1;

import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // One-Dimensional Array
        System.out.print("Enter the size of the one-dimensional array: ");
        int size1D = scanner.nextInt();
        int[] oneDArray = new int[size1D];

        System.out.println("Enter elements for the one-dimensional array:");
        for (int i = 0; i < size1D; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            oneDArray[i] = scanner.nextInt();
        }

        // Display One-Dimensional Array using for loop
        System.out.println("\nOne-Dimensional Array:");
        for (int i = 0; i < size1D; i++) {
            System.out.print(oneDArray[i] + " ");
        }

        // Multi-Dimensional Array
        System.out.print("\n\nEnter the number of rows for the two-dimensional array: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for the two-dimensional array: ");
        int columns = scanner.nextInt();
        int[][] twoDArray = new int[rows][columns];

        System.out.println("Enter elements for the two-dimensional array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Element at (" + i + ", " + j + "): ");
                twoDArray[i][j] = scanner.nextInt();
            }
        }

        // Display Multi-Dimensional Array using for loop
        System.out.println("\nTwo-Dimensional Array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
