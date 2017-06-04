package main.java.sharemoney;

import main.java.sharemoney.gameComponent.Dice;
import main.java.sharemoney.gameComponent.GameBoard;

/**
 * Created by Mrunal Dave on 6/3/2017.
 */
public class GameConductor {

    private final GameBoard gameBoard;
    private final Dice dice;
    private int diceRollCount;
    private int firstPlayerPosition;
    private int secondPlayerPosition;
    private final String firstPlayerTurn;
    private final String secondPlayerTurn;

    public GameConductor() {
        gameBoard = new GameBoard();
        dice = new Dice();
        diceRollCount = 0;
        firstPlayerPosition = 0;
        secondPlayerPosition = 0;
        firstPlayerTurn = "Player 1";
        secondPlayerTurn = "Player 2";
    }

    //Starts the game
    public void runGame() {
        System.out.println("Starting the game!");
        while (firstPlayerPosition < 100 && secondPlayerPosition < 100) {
            diceRollCount++;
            firstPlayerPosition = playOnce(firstPlayerPosition, firstPlayerTurn);
            System.out.println("-------------------------------------------------");
            if (checkGameStatus(firstPlayerPosition, firstPlayerTurn)) return;
            secondPlayerPosition = playOnce(secondPlayerPosition, secondPlayerTurn);
            System.out.println("-------------------------------------------------");
            if (checkGameStatus(secondPlayerPosition, secondPlayerTurn)) return;
        }
    }

    //Game runs for one turn
    private int playOnce(int playerPosition, String player) {
        System.out.print(player + "'s turn. ");
        int diceRoll = dice.getNextRoll();
        System.out.print("You got " + diceRoll + " on dice. ");
        if (diceRoll + playerPosition > 100) {
            System.out.println("That exceeds 100th step! Please wait for next turn!");
            return playerPosition;
        }
        return playWithinBounds(playerPosition, diceRoll);
    }

    //If the roll of the dice plus the current position is less than 100
    private int playWithinBounds(int playerPosition, int diceRoll) {
        playerPosition += diceRoll;
        System.out.println("Now at " + playerPosition);
        return dealWithChuteOrLadder(playerPosition);
    }

    //Checks and updates position if the current token position is a chute or a ladder
    private int dealWithChuteOrLadder(int playerPosition) {
        if (gameBoard.checkChute(playerPosition)) {
            System.out.println("Hardluck! That's a chute! You fall back to " + gameBoard.getChuteFallBack(playerPosition));
            return gameBoard.getChuteFallBack(playerPosition);
        } else if (gameBoard.checkLadder(playerPosition)) {
            System.out.println("Congrats! That's a ladder! You jump to " + gameBoard.getLadderJump(playerPosition));
            return gameBoard.getLadderJump(playerPosition);
        }
        //Neither a chute nor a ladder
        return playerPosition;
    }

    //Checks the game status if any player has reached 100
    private boolean checkGameStatus(int playerPosition, String player) {
        if (playerPosition == 100) {
            System.out.println(player + " that's a victory!! Game ended with " + diceRollCount + " dice rolls! Goodbye");
            return true;
        }
        return false;
    }


}
