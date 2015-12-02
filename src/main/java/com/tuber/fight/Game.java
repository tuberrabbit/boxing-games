package com.tuber.fight;

import static java.lang.String.format;

public class Game {

    private Reporter reporter;

    public Game(Reporter reporter) {
        this.reporter = reporter;
    }

    public Player fight(Player player1, Player player2) {
        while (true) {
            if (isGameOver(player1, player2)) {
                return player2;
            }
            if (isGameOver(player2, player1)) {
                return player1;
            }
        }
    }

    public Reporter getReporter() {
        return reporter;
    }

    private boolean isGameOver(Player attacker, Player victim) {
        reporter.record(attacker.attack(victim));
        if (victim.getPh() < 0) {
            reporter.record(format("%s被打败了", victim.getName()));
            return true;
        }
        return false;
    }
}
