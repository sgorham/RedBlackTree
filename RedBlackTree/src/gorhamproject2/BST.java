/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gorhamproject2;

import java.util.*;

//This class was taken from a C++ implementation that I had
//done in a previous semester. C++ source code can be provided as proof.
//Sean Gorham CS340

public class BST {

    static class Node{
        String key;
        Node left;
        Node right;

        public Node(String word){
            key = word;
            left = right =  null;
        }
    }



    public Node search(Node root, String wordToFind){
        if(root == null || wordToFind.equals(root.key)) {
            if(root == null){
                System.out.println("Word not found");
                return root;
            }
            if(wordToFind.equals(root.key)){
                System.out.println("Word was found");
                return root;
            }

        }
        if(wordToFind.compareTo(root.key) < 0){
            return search(root.left, wordToFind);
        }else{
            return search(root.right, wordToFind);
        }

    }



//    public void toInsert(String wordToAdd){
//        insert(root, wordToAdd);
//    }

    public Node insert(Node x, String wordToAdd){

        if(x == null){
            x = new Node(wordToAdd);
            return x;
        }
        if(wordToAdd.compareTo(x.key) <= 0 ){
           x.left = insert(x.left, wordToAdd);
        }
        if(wordToAdd.compareTo(x.key) > 0){
            x.right = insert(x.right, wordToAdd);
        }
        return x;
    }

//   // public void print(){
//        inOrderWalk();
//    }
    public void inOrderWalk(Node x){
        if(x != null){
            inOrderWalk(x.left);
            System.out.println(x.key);
            inOrderWalk(x.right);
        }


    }
//    public void find(String wordToFind){
//        search(root, wordToFind);
//    }
}