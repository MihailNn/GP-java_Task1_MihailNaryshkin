package com.gp.study1;
//There is an array of positive integers.  The array has to be with equal dimensions, i.e  i=j.
//        The cells in the array are the vertices of the graph. The integers are the edges of the graph.
//
//        The first vertex 'initialVertex' is associated with the edge values [0][0], [1][0],.....[array.length-1][0]. You can move through the array only from left to right, from left to diagonal up and from left to diagonal down.
//
//        You need to find the longest path from the original 'initialVertex', which is represented in the array. In this case, you need to print all the longest found paths from 'initialVertex'.
//
//        Example, given an array:
//        {1, 3, 3},
//        {2, 1, 4},
//        {0, 6, 4}
//
//        output:
//        all longest paths tree from initialVertex:
//        initialVertex -> [0][0] = 1
//        initialVertex -> [1][1] = 3
//        initialVertex -> [2][2] = 12
//        initialVertex -> [0][1] = 5
//        initialVertex -> [1][2] = 12
//        initialVertex -> [0][2] = 8
//        initialVertex -> [2][0] = 0
//        initialVertex -> [1][0] = 2
//        initialVertex -> [2][1] = 8
//        longest path tree from vertex 'initialVertex' = 12
//
//        hint: you need to implement Dijkstra's algorithm "in reverse".


public class GrafProcessing {

    public static void main(String[] args) {
        int[][] array = {{1,3,3,1,3},{2,1,4,0,7},{0,6,4,8,1},{19,2,7,5,3},{3,4,9,25,107}};
        theLongestWay(array);
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
