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
import java.io.*;
import java.util.ArrayList;

public class GameHelper {
            
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + "  ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0) return null;
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		return inputLine;
	}
	
	public ArrayList<DotCom> getDotComs() {
		ArrayList<DotCom> dcoms = new ArrayList<DotCom>();
		//Create three DotComs and give them names
                DotCom one = new DotCom();
                one.setName("Pets.com");
                DotCom two = new DotCom();
                two.setName("Geocities");
                DotCom three = new DotCom();
                three.setName("WebVan.com");
                
                //generate three sets of locations, ensuring that there's no overlapping cells
                ArrayList<String> tempLocs = new ArrayList<String>();
                while (tempLocs.size() < 9) {
                    ArrayList<String> locs = generateLocation();
                    boolean overlap = false;
                    for (String cell : locs) {
                        if (tempLocs.indexOf(cell) >= 0) {
                            overlap = true;
                        }
                    }
                    if (overlap == false) {
                        tempLocs.addAll(locs);
                        if (!one.hasLocation()) {
                            one.setLocationCells(locs);
                        } else if (!two.hasLocation()) {
                            two.setLocationCells(locs);
                        } else {
                            three.setLocationCells(locs);
                        }
                    }
                }
                
                                
                dcoms.add(one);
                dcoms.add(two);
                dcoms.add(three);
                
		return dcoms;
	}
        
        public ArrayList<String> generateLocation() {
            ArrayList<String> locs = new ArrayList<String>();
            String[] aLetters = {"A", "B", "C", "D", "E", "F", "G"};
            boolean isVertical = false;
            
            if (Math.random() >= 0.5 ) {
                isVertical = true;
            }
            
            int xAxis = (int) (Math.random() * 7);
            int yAxis = (int) (Math.random() * 7);
            
            //modify start point based on horizontal/vertical orientation
            if (isVertical && yAxis > 4) {
                yAxis = yAxis - (yAxis % 4);
            } else if (!isVertical && xAxis > 4) {
                xAxis = xAxis - (xAxis % 4);
            }
            
            //add start point to the ArrayList, e.g. "A4" (0,4)
            locs.add(aLetters[yAxis] + Integer.toString(xAxis));
            //add the other points depending on orientation
            if (isVertical) {
                locs.add(aLetters[yAxis+1] + Integer.toString(xAxis));
                locs.add(aLetters[yAxis+2] + Integer.toString(xAxis));
            } else {
                locs.add(aLetters[yAxis] + Integer.toString(xAxis+1));
                locs.add(aLetters[yAxis] + Integer.toString(xAxis+2));
            }
            
            return locs;
        }
}
 