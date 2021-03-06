package com.m3c.jc.model;

import com.m3c.jc.model.BinaryTreeSorterPackage.BinaryTreeImpl;

public class BinaryTreeSorter implements Sorter{

    public int[] sortArray(int[] array) {
        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        binaryTree.addElements(array);
        return binaryTree.getSortedTreeAsc().stream().mapToInt(i->i).toArray();
    }

    @Override
    public String toString() {
        return "Binary Tree Sorter";
    }
}
