package com.gp.study1;

public class GrafProcessing {

    public static void main(String[] args) {
        int[][] justArray = {{1,3,3,1,3},{2,1,4,0,7},{0,6,4,8,1},{19,2,7,5,3},{3,4,9,25,107}};
        theLongestWay(justArray);
    }
    public static int theLongestWay(int[][] array) {

        int theLongestway = 0;
        int column = 0;
        int[][] biggerArray = new int[array.length][array.length];

        for (int row = 0; row < array.length; row++) {
            System.out.printf("initialVertex -> [%d][%d] = %d", row, column, array[row][column]);
            System.out.println();
            biggerArray[row][column] = array[row][column];
            theLongestway = Math.max(theLongestway , array[row][column]);
        }
        System.out.println();

        for (column = 1; column < array.length; column++) {
            for (int row = 0; row < array.length; row++) {

                if (array[row][column] == 0){
                    System.out.printf("initialVertex -> [%d][%d] = %d", row, column, array[row][column]);
                    System.out.println();
                    biggerArray[row][column] = array[row][column];
                }
                else if (row == 0) {
                    int bigger = Math.max(biggerArray[row][column - 1], biggerArray[row + 1][column - 1]);
                    System.out.printf("initialVertex -> [%d][%d] = %d", row, column, array[row][column] + bigger);
                    System.out.println();
                    biggerArray[row][column] = array[row][column] + bigger;
                }
                else if (row == array.length - 1) {
                    int bigger = Math.max(biggerArray[row][column - 1], biggerArray[row - 1][column - 1]);
                    System.out.printf("initialVertex -> [%d][%d] = %d", row, column, array[row][column] + bigger);
                    System.out.println();
                    biggerArray[row][column] = array[row][column] + bigger;
                } else {
                    int bigger = Math.max(biggerArray[row][column - 1], biggerArray[row - 1][column - 1]);
                    int bigger1 = Math.max(bigger, biggerArray[row + 1][column - 1]);
                    System.out.printf("initialVertex -> [%d][%d] = %d", row, column, array[row][column] + bigger1);
                    System.out.println();
                    biggerArray[row][column] = array[row][column] + bigger1;
                }
                theLongestway = Math.max(theLongestway, biggerArray[row][column]);
            }
            System.out.println();
        }

        System.out.println("The longest way : " + theLongestway);

        return theLongestway;
    }

}
