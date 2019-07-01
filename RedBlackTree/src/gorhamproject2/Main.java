/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gorhamproject2;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"perm15k.txt", "perm30k.txt", "perm45k.txt", "perm60k.txt", "perm75k.txt", "perm90k.txt", "perm105k.txt", "perm120k.txt", "perm135k.txt", "perm150k.txt",
                "sorted15k.txt", "sorted30k.txt", "sorted45k.txt", "sorted60k.txt", "sorted75k.txt", "sorted90k.txt", "sorted105k.txt", "sorted120k.txt", "sorted135k.txt", "sorted150k.txt"};
//        RBT rbTree = new RBT();
//        BST bTree = new BST();
//        BST.Node root = null;
//        for(int j = 0; j < files.length; j++) {
//            File toRead = new File(files[j]);
//            Scanner fin = new Scanner(toRead);
//            ArrayList<String> readIn = new ArrayList<>();
//            while (fin.hasNext()) {
//                readIn.add(fin.next());
//            }
//            String[] toSort = new String[readIn.size()];
//            toSort = readIn.toArray(toSort);
//            //begin time
//            long start = System.nanoTime();
//            for (int i = 0; i < toSort.length; i++) {
//                //add node to RBT
////                RBT.Node newNode = new RBT.Node(toSort[i]);
////                rbTree.insert(newNode);
//                root = bTree.insert(root, toSort[i]);
//            }
//            //end time
//            long end = System.nanoTime();
//            long duration = (end - start) / 1000000;
//            System.out.println("It took " + duration + " ms to sort this file");
//        }


        Scanner kb = new Scanner(System.in);
        String choice;

        do{
            System.out.println("Which data structure would you like to use? RBT or BST? Enter 'q' to quit");
            choice = kb.next();
            choice.toUpperCase();

            if(choice.equals("RBT")){
                RBT rbTree = new RBT();
                System.out.println(" Which size document would you like to sort through? Choose the number for which document to sort: " +
                        " 0 = 15k, 1 = 30k, 2 = 45k, 3 = 60k, 4 = 75k, 5 = 90k, 6 = 105k, 7 = 120k, 8 = 135k, 9 = 150k for permuted files " +
                        " 10 - 19 for the respective sorted files ");
                int file = kb.nextInt();
                File toRead = new File(files[file]);
                Scanner fin = new Scanner(toRead);
                ArrayList<String> readIn = new ArrayList<>();
                while(fin.hasNext()){
                    readIn.add(fin.next());
                }
                String[] toSort = new String[readIn.size()];
                toSort = readIn.toArray(toSort);
                //begin time
                long start = System.nanoTime();
                for(int i = 0; i < toSort.length; i++){
                    //add node to RBT
                    RBT.Node newNode= new RBT.Node(toSort[i]);
                    rbTree.insert(newNode);
                }
                //end time
                long end = System.nanoTime();
                long duration = (end - start) / 1000000;
                System.out.println("It took " + duration + " ms to sort this file");
                System.out.println("Enter a word to search for ");
                String wordSearch = kb.next();

                long start2 = System.nanoTime();
                rbTree.search(rbTree.root, wordSearch);
                long end2 = System.nanoTime();
                long duration2 = (end2 - start2);
                System.out.println("It took " + duration2 + " ms to search for that word");
            }else if (choice.equals("BST")){
                 BST bTree = new BST();
                 BST.Node root = null;
                 System.out.println(" Which size document would you like to sort through? Choose the number for which document to sort: " +
                 " 0 = 15k, 1 = 30k, 2 = 45k, 3 = 60k, 4 = 75k, 5 = 90k, 6 = 105k, 7 = 120k, 8 = 135k, 9 = 150k for permuted files " +
                 " 10 - 19 for the respective sorted files ");
                 int file = kb.nextInt();
                 File toRead = new File(files[file]);
                 Scanner fin = new Scanner(toRead);
                 ArrayList<String> readIn = new ArrayList<>();
                 while(fin.hasNext()){
                 readIn.add(fin.next());
                 }
                 String[] toSort = new String[readIn.size()];
                 toSort = readIn.toArray(toSort);
                long start = System.nanoTime();
                 //begin time
                 for(int i = 0; i < toSort.length; i++){
                 //add node to BST
                     root = bTree.insert(root, toSort[i]);
                 }
                long end = System.nanoTime();
                long duration = (end - start) / 1000000;
                 //end time
                System.out.println("It took " + duration + " ms to sort the file");
                 System.out.println("Enter a word to search for ");
                 String wordSearch = kb.next();

                long start2 = System.nanoTime();
                bTree.search(root, wordSearch);
                long end2 = System.nanoTime();
                long duration2 = (end2 - start2);
                System.out.println("It took " + duration2 + " ms to find the word");

            }else{
                if(choice.equals("Q")){
                    break;
                }
                System.out.println("Not a valid selection choose again");
            }
        }while(!choice.equals("Q"));

    }

}