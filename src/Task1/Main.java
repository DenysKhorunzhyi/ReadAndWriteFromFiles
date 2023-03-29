package Task1;

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileReader fileA;
        File fileB = new File("D:\\Khai\\3rd_kurs_2d_term\\Java\\ЛР4\\fileB.txt");
        int[][] matrixA = new int[5][5];
        int[][] matrixB = new int[5][5];
        try {
            fileA = new FileReader("D:\\Khai\\3rd_kurs_2d_term\\Java\\ЛР4\\fileA.txt");
            Scanner input = new Scanner(fileA);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    matrixA[i][j] = input.nextInt();
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл з елементами масиву А не створено!");
            return;
        } catch (InputMismatchException e) {
            System.out.println("Перевірте запис елементів масиву А у файлі!");
            return;
        } catch (NoSuchElementException e) {
            System.out.println("У файлі недостатньо елементів для масиву розміром 5х5");
            return;
        }
        System.out.println("Матрица А:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrixA[i][j] + "\t");
            }
            System.out.print("\n");
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrixB[i][j] = matrixA[i][j];
            }
        }

        int sumAbove = 0, sumBelow = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j > i) {
                    sumAbove += matrixA[i][j];
                } else if (j < i) {
                    sumBelow += matrixA[i][j];
                }
            }
        }

        System.out.println("Сума над головною діагоналлю " + sumAbove);
        System.out.println("Сума під головною діагоналлю " + sumBelow);
        int diagonalDiff = Math.abs(sumAbove - sumBelow);
        System.out.println("Різниця цих сум " + diagonalDiff);
        System.out.println("Матрица B:");
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    matrixB[i][j] = diagonalDiff;
                } else {
                    matrixB[i][j] = matrixA[i][j];
                }
                System.out.print(matrixB[i][j] + " ");
            }
            System.out.println();
        }
            try {
                FileWriter fileWrite = new FileWriter(fileB);
                BufferedWriter bufferedWrite = new BufferedWriter(fileWrite);
                PrintWriter printFileB = new PrintWriter(bufferedWrite);
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        printFileB.print(matrixB[i][j] + "\t");
                    }
                    printFileB.println();
                }
                printFileB.close();
            } catch (IOException e) {
                System.out.println("Помилка при створенні файлу з масивом В");
            }
        }
    }