package com.m3c.jc.model.BinaryTreeSorterPackage;

public class Node {

    //Class describing each node in the binary tree
    //Each node has a value assigned to it
    //Each node can have a left and right child node associated

    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int number) {
        value = number;
    }

    public int getValue() {
        return value;
    }

    public void setLeftNode(Node node) {
        leftNode = node;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public boolean isLeftNode() {
        if (this.getLeftNode() == null) {
            return false;
        } else {
            return true;
        }
    }

    public void setRightNode(Node node) {
        rightNode = node;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public boolean isRightNode() {
        if (this.getRightNode() == null) {
            return false;
        } else {
            return true;
        }
    }
}
