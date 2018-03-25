/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtree;

import java.util.TreeSet;

public class TestTree {

    public static void main(String[] args) {
        new TestTree().go();
    }
    
    public void go(){
        //create three books, add them to the TreeSet, print it out
        Book b1 = new Book("How Cats Work");
        Book b2 = new Book("Remix your Body");
        Book b3 = new Book("Finding Emo");
        
        TreeSet<Book> tSet = new TreeSet<>();
        tSet.add(b1);
        tSet.add(b2);
        tSet.add(b3);
        System.out.println(tSet);
    }
    
}

class Book implements Comparable<Book>{
    String title;
    public Book(String t){
        title = t;
    }
    
    @Override
    public int compareTo(Book b){
        return title.compareTo(b.title);
    }
    
    public String toString(){
        return title;
    }
}