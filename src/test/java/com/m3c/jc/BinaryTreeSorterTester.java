package com.m3c.jc;

import com.m3c.jc.model.BinaryTreeSorter;
import com.m3c.jc.model.BinaryTreeSorterPackage.BinaryTree;
import com.m3c.jc.model.BinaryTreeSorterPackage.BinaryTreeImpl;
import com.m3c.jc.model.Sorter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeSorterTester {

    public Sorter sorter;
    public BinaryTree binaryTree;

    @Before
    public void setup() {
        sorter = new BinaryTreeSorter();
        binaryTree = new BinaryTreeImpl();
    }

    @Test
    public void testSorter() {
        int[] test = {1,4,2,5,3,6};
        int[] solution = {1,2,3,4,5,6};
        int[] attempt = sorter.sortArray(test);
        Assert.assertArrayEquals(solution, attempt);
    }

    @Test
    public void testDuplicates() {
        int[] test = {6,1,5,4,2,4,5,3,3,6,2,1};
        int[] solution = {1,1,2,2,3,3,4,4,5,5,6,6};
        int[] attempt = sorter.sortArray(test);
        Assert.assertArrayEquals(solution, attempt);
    }

    @Test
    public void testSorted() {
        int[] test = {1,2,3,4,5,6};
        int[] solution = {1,2,3,4,5,6};
        int[] attempt = sorter.sortArray(test);
        Assert.assertArrayEquals(solution, attempt);
    }

    @Test
    public void testNonNatural() {
        int[] test = {-4,1,0,-6,4,-2,2,-5,5,-1,-3,3,6};
        int[] solution = {-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6};
        int[] attempt = sorter.sortArray(test);
        Assert.assertArrayEquals(solution, attempt);
    }

    @Test
    public void testDesc() {
        int[] test = {1,4,2,5,3,6};
        int[] solution = {6,5,4,3,2,1};
        binaryTree.addElements(test);
        int[] attempt = binaryTree.getSortedTreeDesc().stream().mapToInt(i->i).toArray();
        Assert.assertArrayEquals(solution, attempt);
    }

    @Test
    public void testDuplicateDesc() {
        int[] test = {1,4,2,5,3,6,2,3,4,5};
        int[] solution = {6,5,5,4,4,3,3,2,2,1};
        binaryTree.addElements(test);
        int[] attempt = binaryTree.getSortedTreeDesc().stream().mapToInt(i->i).toArray();
        Assert.assertArrayEquals(solution, attempt);
    }

    @After
    public void teardown() {

    }
}
