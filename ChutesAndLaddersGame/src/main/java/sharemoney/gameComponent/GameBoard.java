package main.java.sharemoney.gameComponent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mrunal Dave on 6/3/2017.
 */
public class GameBoard {

    private Map<Integer, Integer> chutes;
    private Map<Integer, Integer> ladders;

    public GameBoard() {
        fillChutesMap();
        fillLaddersMap();
    }


    /*Assigns chute points as given in the game description image in the instructions.
          Can be made dynamic easily.
        */
    private void fillChutesMap() {
        chutes = new HashMap<>();
        chutes.put(16, 6);
        chutes.put(47, 26);
        chutes.put(49, 11);
        chutes.put(56, 53);
        chutes.put(62, 19);
        chutes.put(64, 60);
        chutes.put(87, 24);
        chutes.put(93, 73);
        chutes.put(95, 75);
        chutes.put(98, 78);
    }

    /*Assigns ladder points as given in the game description image in the instructions.
      Can be made dynamic easily.
    */
    private void fillLaddersMap() {
        ladders = new HashMap<>();
        ladders.put(1, 38);
        ladders.put(4, 14);
        ladders.put(9, 31);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(80, 100);
    }

    public boolean checkChute(int token){
        return chutes.containsKey(token);
    }

    public boolean checkLadder(int token){
        return ladders.containsKey(token);
    }

    public int getChuteFallBack(int token){
        return chutes.get(token);
    }

    public int getLadderJump(int token){
        return ladders.get(token);
    }

}
