Chutes and Ladders

Game simulation source code is divided into following packages and classes:

   1) main.java.sharemoney.gameComponent.GameBoard.java  : Consists of a HashMap<Integer, Integer> to store Chutes and Ladders.
   2) main.java.sharemoney.gameComponent.Dice.java       : A random number generator between values 1 and 6 (including both).
   3) main.java.sharemoney.GameConductor.java            : Class that contains the game functionality and contains the game logic.
   4) main.java.sharemoney.GameRunner.java               : Uses the GameConductor instance to simulate the game. Run this file to see game simulation.

** I have not implemented the JUnit tests to avoid current dependency issues.
