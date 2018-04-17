package com.m3c.jc.control;

import com.m3c.jc.model.Sorter;
import com.m3c.jc.view.DisplayManager;
import org.apache.log4j.Logger;

import java.util.Random;

public class SortManager {

    private static Logger log = Logger.getLogger(SortManager.class.getName());

    public void sortArray() {
        try {
            //Creates, and then sorts a randomly generated array of 10 integers
            Sorter sorter = SortFactory.getInstance();
            int[] arrayToSort = createArray(10);
            DisplayManager.displayUnsorted(sorter, arrayToSort);
            //The sorter is timed for analysis
            long start = System.nanoTime();
            int[] sortedArray = sorter.sortArray(arrayToSort);
            long end = System.nanoTime();
            DisplayManager.displaySorted(sortedArray, end - start);
            log.info("Sort performed using " + sorter.toString());

        } catch (SortManagerException sme) {
            DisplayManager.displayException(sme.getMessage());
        }
    }

    //For creating random array of integers
    private int[] createArray(int size) {
        Random random = new Random();
        int[] unsortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            unsortedArray[i] = random.nextInt(size*10)+1;
        }
        return unsortedArray;
    }
}
