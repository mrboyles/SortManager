package com.m3c.jc.model;

public class MergeSorter implements Sorter{

    //Defines a 'sortArray' method, as per 'Sorter' interface
    private int[] merge(int[] left, int[] right) {
        if (left.length != 0 && right.length != 0) {
            int[] merged = new int[left.length + right.length];
            int i = 0;
            int j = 0;

            for(int k = 0; k < left.length + right.length; ++k) {
                if (i == left.length) {
                    while(j < right.length) {
                        merged[k] = right[j];
                        ++j;
                        ++k;
                    }
                } else if (j == right.length) {
                    while(i < left.length) {
                        merged[k] = left[i];
                        ++i;
                        ++k;
                    }
                } else if (left[i] < right[j]) {
                    merged[k] = left[i];
                    ++i;
                } else {
                    merged[k] = right[j];
                    ++j;
                }
            }

            return merged;
        } else {
            return left.length == 0 ? right : left;
        }
    }

    public int[] sortArray(int[] array) {
        if (array.length < 2) {
            return array;
        } else {
            int middle = array.length / 2;
            int[] tmp_left = new int[middle];
            int[] tmp_right = new int[array.length - middle];

            int i;
            for(i = 0; i < middle; ++i) {
                tmp_left[i] = array[i];
            }

            for(i = 0; i < array.length - middle; ++i) {
                tmp_right[i] = array[i + middle];
            }

            int[] left = this.sortArray(tmp_left);
            int[] right = this.sortArray(tmp_right);
            return this.merge(left, right);
        }
    }

    @Override
    public String toString() {
        return "Merge Sorter";
    }
}
