/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotcombust;

/**
 *
 * @author Phil
 */
import java.util.ArrayList;
import java.io.*;

class DotCom {
	private int numHits = 0;
	private String name;
	private boolean isAlive = true;
        private boolean hasLocation = false;
	private ArrayList<String> locationCells = new ArrayList<>();
	
	public void setName(String n) {
		name = n;
	}
        public String getName(){
            return name;
        }
        
        public boolean isAlive(){
            return isAlive;
        }
        
        public boolean hasLocation(){
            return hasLocation;
        }
	
	public void setLocationCells(ArrayList<String> locs) {
		locationCells = locs;
                hasLocation = true;
	}
        
        
	
	public String checkYourself(String sGuess) {
		String result = "miss";
		int index = locationCells.indexOf(sGuess);
		if (index >= 0) {
			locationCells.remove(index);
			result = "hit";
		}
		
		if (locationCells.isEmpty()) {
			result = "kill";
			isAlive = false;
		}
		return result;
	}
}