package com.tuber.fight;

import static java.lang.String.format;

public class FightApp {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        Player player1 = new Player("张三", 10, 2);
        Player player2 = new Player("李四", 10, 3);
        Player loser = game.fight(player1, player2);
        System.out.println(format("%s被打败了。\n", loser.getName()));
    }
}
