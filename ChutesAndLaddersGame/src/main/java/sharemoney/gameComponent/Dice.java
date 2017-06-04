package main.java.sharemoney.gameComponent;

import java.util.Random;

/**
 * Created by Mrunal Dave on 6/3/2017.
 */
public class Dice {

    private final Random dice;

    public Dice(){
        dice = new Random();
    }

    public int getNextRoll(){
        return dice.nextInt(6) + 1;
    }

}
