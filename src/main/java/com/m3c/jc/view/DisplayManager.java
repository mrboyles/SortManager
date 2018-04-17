package com.m3c.jc.view;

import com.m3c.jc.model.Sorter;

import java.text.DecimalFormat;
import java.util.Arrays;

public class DisplayManager {

    //For console before sorting
    public static void displayUnsorted(Sorter sorter, int[] arrayToSort) {
        System.out.println("Sort using: " + sorter.toString());
        System.out.println("Unsorted array: " + Arrays.toString(arrayToSort));
    }

    //For console after sorting
    public static void displaySorted(int[] sortedArray, long time) {
        DecimalFormat df = new DecimalFormat("###,###.####");
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
        System.out.println("Time taken: " + df.format(time) + " nanoseconds");
    }

    //For displaying exceptions to console
    public static void displayException(String message) {
        System.out.println(message);
    }
}
