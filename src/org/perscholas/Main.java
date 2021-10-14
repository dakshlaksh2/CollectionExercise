package org.perscholas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class Main {
    //counting word from each using hash map
    private void count(String line, Map<String, Integer> map){
        String[] listOfWords = line.split(" ");
        for (String str : listOfWords) {
            if (map.containsKey(str)) {
                Integer count = map.get(str);
                map.put(str, count + 1);
            } else {
                map.put(str, 1);
            }
        }
    }
//reading from file using buffer reader
    public void getWordCount() {
        String str = "";
        Map<String, Integer> map = new HashMap<>();
        try {
            FileReader file = new FileReader(
                    "/Users/dakshinrajavel/IdeaProjects/CollectionExercise/src/org/perscholas/book.txt");
            BufferedReader buff = new BufferedReader(file);
            str = buff.readLine();
            if(str != null){
                count(str,map);
            }
            while(str != null){
                str = buff.readLine();
                if(str != null) {
                    count(str, map);
                }
            }
            buff.close();
                //Printing the word and their count using for loop
           for (Map.Entry<String,Integer> entry : map.entrySet()){
                System.out.println( entry.getKey() + "=" + entry.getValue());
                }
            System.out.println("The number of words: "+map.size());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().getWordCount();
        System.out.println();
    }
}


