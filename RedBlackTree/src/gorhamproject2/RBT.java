/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gorhamproject2;

import java.util.*;
/**
 * Sean Gorham CS340 Project 2 Red Black Tree
 */
public class RBT{
    public RBT() {
        root = tNil;
        settNil();
    }

    static class Node{
        String key;
        Node parent, left, right;
        String color;
        public Node(String newKey){
            this.key = newKey;
            parent = null;
            left = right = null;
        }
    }

    Node root;
    Node tNil = new Node(null);

    public void settNil() {
        tNil.color = "black";
        tNil.parent = tNil;
        tNil.left = tNil;
        tNil.right = tNil;
    }

    public void leftRotate(Node x){
        Node y = x.right;
        x.right = y.left;
        if(y.left != tNil){
            y.left.parent = x;
        }
        y.parent = x.parent;

        if(x.parent == tNil){
            root = y;
        }else if(x == x.parent.left){
            x.parent.left = y;
        }else{
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    public void rightRotate(Node x){
        Node y = x.left;
        x.left = y.right;
        if(y.right != tNil){
            y.right.parent = x;
        }
        y.parent = x.parent;

        if(x.parent == tNil){
            root = y;
        }else if(x == x.parent.right){
            x.parent.right = y;
        }else{
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public void insert(Node z){
        Node y = tNil;
        Node x = root;

        while(x != tNil){
            y = x;
            if(z.key.compareTo(x.key) < 0){
                x = x.left;
            }else{
                x = x.right;
            }

        }
        z.parent = y;
        if(y == tNil){
            root = z;
        }else if(z.key.compareTo( y.key) < 0){
            y.left = z;
        }else{
            y.right = z;
        }
        z.left = tNil;
        z.right = tNil;
        z.color = "red";
        fixup(z);
    }

    public void fixup(Node z){
        while(z.parent.color == "red"){
            if(z.parent == z.parent.parent.left){
                Node y = z.parent.parent.right;
                if(y.color == "red"){
                    z.parent.color = "black";
                    y.color = "black";
                    z.parent.parent.color = "red";
                    z = z.parent.parent;
                }else{
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.color = "black";
                    z.parent.parent.color = "red";
                    rightRotate(z.parent.parent);
                }

            }else{
                Node y = z.parent.parent.left;
                if(y.color == "red"){
                    z.parent.color = "black";
                    y.color = "black";
                    z.parent.parent.color = "red";
                    z = z.parent.parent;
                }else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.color = "black";
                    z.parent.parent.color = "red";
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = "black";
    }
    public void inOrderWalk(Node x){
        if(x != tNil){
            inOrderWalk(x.left);
            System.out.println(x.key + " color is " + x.color);
            inOrderWalk(x.right);
        }


    }
    public boolean search(Node root, String wordToFind){
        if(wordToFind.equals(root.key)){
            System.out.println("Word " + wordToFind + " was found.");
            return true;
        }
        if(root == tNil){
            System.out.println("Word was not found");
            return false;
        }
            if(wordToFind.compareTo(root.key) < 0){
                return search(root.left, wordToFind);
            }else{
                return search(root.right, wordToFind);
            }



    }

}