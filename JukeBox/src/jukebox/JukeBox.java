/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jukebox;

import java.util.*;
import java.io.*;

public class JukeBox {
    
    ArrayList<Song> songList = new ArrayList<>();
    TreeSet<String> tsSongList = new TreeSet<>();
    
    public static void main(String[] args){
        new JukeBox().go();
    }
    
    public void go(){
        getSongs();
        Collections.sort(songList);
        System.out.println(songList);
        //System.out.println(tsSongList);
    }
    
    void getSongs(){
        try {
            File file = new File("song_data.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null){
                addSong(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    void addSong (String lineToParse){
        String[] tokens = lineToParse.split("/");
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
        tsSongList.add(tokens[0]);
    }
}