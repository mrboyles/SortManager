package com.m3c.jc.model.BinaryTreeSorterPackage;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeImpl implements BinaryTree {

    private static Logger log = Logger.getLogger(BinaryTreeImpl.class.getName());

    private Node root;
    private int nodeCount = 0;

    public int getRootElement() {
        return root.getValue();
    }

    private void setRootNode(Node node) {
        root = node;
    }

    private Node getRootNode() {
        return root;
    }

    public int getNumberOfElements() {
        return nodeCount;
    }

    public void addElement(int element) {
        //Assigns the relevant node a left/right child which is a node of value given
        Node node = new Node(element);
        if (nodeCount == 0) {
            this.setRootNode(node);
        } else {
            boolean elementAdded = false;
            Node currentNode = getRootNode();
            while (! elementAdded) {
                if (node.getValue() < currentNode.getValue() && currentNode.isLeftNode()) {
                    currentNode = currentNode.getLeftNode();
                } else if (node.getValue() < currentNode.getValue()) {
                    currentNode.setLeftNode(node);
                    elementAdded = true;
                } else if (currentNode.isRightNode()) {
                    currentNode = currentNode.getRightNode();
                } else {
                    currentNode.setRightNode(node);
                    elementAdded = true;
                }
            }
        }
        nodeCount++;
    }

    public void addElements(int[] elements) {
        for (int number : elements) {
            addElement(number);
        }
    }

    public boolean findElement(int value) {
        //Traverses binary tree to infer if value exists in binary tree
        Node currentNode = getRootNode();
        boolean foundElement = false;
        while (currentNode != null && !foundElement) {
            if (currentNode.getValue() == value) {
                foundElement = true;
            } else if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeftNode();
            } else {
                currentNode = currentNode.getRightNode();
            }
        }
        return foundElement;
    }

    public int getLeftChild(int element) throws ElementNotFoundException {
        //Traverses to element given and returns left child's value, if exists
        if (findElement(element)) {
            Node currentNode = getRootNode();
            while (currentNode.getValue() != element) {
                if (element < currentNode.getValue()) {
                    currentNode = currentNode.getLeftNode();
                } else {
                    currentNode = currentNode.getRightNode();
                }
            }
            if (! currentNode.isLeftNode()) {
                log.debug("The element you entered does not have a left child");
                throw new ElementNotFoundException("The element you entered does not have a left child");
            } else {
                return currentNode.getLeftNode().getValue();
            }
        } else {
            log.debug("The element you entered is not in the list");
            throw new ElementNotFoundException("The element you entered is not in the list");
        }
    }

    public int getRightChild(int element) throws ElementNotFoundException {
        //Traverses to element given and returns right child's value, if exists
        if (findElement(element)) {
            Node currentNode = getRootNode();
            while (currentNode.getValue() != element) {
                if (element < currentNode.getValue()) {
                    currentNode = currentNode.getLeftNode();
                } else {
                    currentNode = currentNode.getRightNode();
                }
            }
            if (! currentNode.isRightNode()) {
                log.debug("The element you entered does not have a right child");
                throw new ElementNotFoundException("The element you entered does not have a right child");
            } else {
                return currentNode.getRightNode().getValue();
            }
        } else {
            log.debug("The element you entered is not in the list");
            throw new ElementNotFoundException("The element you entered is not in the list");
        }
    }

    private List<Integer> setSortedTreeAsc(Node node) {
        //Recursively sorts binary tree into ascending order
        List<Integer> list = new ArrayList<Integer>();
        if (node.isLeftNode()) {
            list.addAll(setSortedTreeAsc(node.getLeftNode()));
        }
        list.add(node.getValue());
        if (node.isRightNode()) {
            list.addAll(setSortedTreeAsc(node.getRightNode()));
        }
        return list;
    }

    private List<Integer> setSortedTreeDesc(Node node) {
        //Recursively sorts binary tree into descending order
        List<Integer> list = new ArrayList<Integer>();
        if (node.isRightNode()) {
            list.addAll(setSortedTreeDesc(node.getRightNode()));
        }
        list.add(node.getValue());
        if (node.isLeftNode()) {
            list.addAll(setSortedTreeDesc(node.getLeftNode()));
        }
        return list;
    }

    public List<Integer> getSortedTreeAsc() {
        if (nodeCount > 0) {
            return setSortedTreeAsc(this.getRootNode());
        } else {
            return null;
        }
    }

    public List<Integer> getSortedTreeDesc() {

        if (nodeCount > 0) {
            return setSortedTreeDesc(this.getRootNode());
        } else {
            return null;
        }
    }
}
