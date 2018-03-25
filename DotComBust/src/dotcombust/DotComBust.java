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

class DotComBust {
    GameHelper helper = new GameHelper();
    ArrayList<DotCom> dcoms;
    int numGuesses = 0;
	
    private void setUpGame() {
	//instantiate the three dot comes with the GameHelper object on a 7x7 grid
	dcoms = helper.getDotComs();
    }
	
    private void playGame() {
	//use the GameHelper to play the game
        String result;
	while (dcoms.size() >= 1) {
            String guess = helper.getUserInput("Make a guess: ");
            result = "miss";
            numGuesses++;
            for (DotCom d : dcoms) {
                result = d.checkYourself(guess);
                if (result == "kill") {
                    result = "Ouch! You sunk " + d.getName() + "!  :(";
                    dcoms.remove (d);
                    break;
                } else if (result == "hit") {
                    break;
                }
            }
            System.out.println(result);
	}
        finishGame();
    }
    
    private void finishGame() {
        System.out.println("It took you " + numGuesses + " guesses to sink all the DotComs.");
	if (numGuesses > 18) {
            System.out.println("Your stocks are sleeping with the fishes!");
	} else {
            System.out.println("You got out before your stocks sunk as well. Good job!");
	}
    }
	
    public static void main(String[] args) {
	DotComBust game = new DotComBust();	
	game.setUpGame();
	game.playGame();
    }
}
