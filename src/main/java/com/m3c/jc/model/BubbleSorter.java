package com.m3c.jc.model;

public class BubbleSorter implements Sorter {

    //Defines a 'sortArray' method, as per 'Sorter' interface
    public int[] sortArray(int[] array) {
        boolean swapped = true;

        while(swapped) {
            swapped = false;

            for(int i = 0; i < array.length - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        }

        return array;
    }

    @Override
    public String toString() {
        return "Bubble Sorter";
    }
}
