package com.m3c.jc.model.BinaryTreeSorterPackage;

public class ElementNotFoundException extends Exception {

    //Exception in the event an element being searched for does not exist
    public ElementNotFoundException(String message) {
        super(message);
    }
}
