/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jukebox;

/**
 * 
 * @author Phil Brosgol <phil.brosgol at gmail.com>
 */
public class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;
    
    Song(String t, String a, String r, String b){
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }
    
    @Override
    public int compareTo(Song s){
        return title.compareTo(s.getTitle());
    }
    
    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public String getRating(){
        return rating;
    }
    public String getBpm(){
        return bpm;
    }
    
    public String toString(){
        return title;
    }
}
