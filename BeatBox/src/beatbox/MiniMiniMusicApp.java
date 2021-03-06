/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Phil Brosgol <phil.brosgol at gmail.com>
 */

import javax.sound.midi.*;

public class MiniMiniMusicApp {
    
    public static void main(String[] args){
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }
    
    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open(); //sequencer must be opened after being created
            
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            
            Track track = seq.createTrack(); //Ask the sequence for a Track.
            
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);
            
            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);
            
            player.setSequence(seq);
            
            player.start();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
