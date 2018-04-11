package com.m3c.jc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BubbleSorterTester.class,
        MergeSorterTester.class,
        BinaryTreeSorterTester.class
})

public class TestSuite {
}

