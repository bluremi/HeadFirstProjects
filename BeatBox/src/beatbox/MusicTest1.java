/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beatbox;

/**
 * 
 * @author Phil Brosgol <phil.brosgol at gmail.com>
 */
import javax.sound.midi.*;

public class MusicTest1 {
    
    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("Successfully got a sequencer!");
        } catch (MidiUnavailableException ex) {
            System.out.println("Bummer, couldn't get a sequencer this time...");
        }
    }
}
