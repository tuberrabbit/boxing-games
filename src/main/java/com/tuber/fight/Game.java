package com.tuber.fight;

public class Game {

    private static Game instance;

    private Game() {
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public Player fight(Player player1, Player player2) {
        while (true) {
            player1.attack(player2);
            if (player2.getPh() < 0) {
                return player2;
            }
            player2.attack(player1);
            if (player1.getPh() < 0) {
                return player1;
            }
        }
    }
}
