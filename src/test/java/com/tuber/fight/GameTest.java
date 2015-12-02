package com.tuber.fight;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {
    @Test
    public void player2_should_be_killed_after_cycle_attack() {
        Game game = new Game(new Reporter());
        Player player1 = new Player("player1", 10, 10);
        Player player2 = new Player("player2", 10, 10);

        Player loser = game.fight(player1, player2);

        assertThat(loser.getName(), is("player2"));
    }

    @Test
    public void player1_should_be_killed_after_cycle_attack() {
        Game game = new Game(new Reporter());
        Player player1 = new Player("player1", 10, 5);
        Player player2 = new Player("player2", 10, 6);

        Player loser = game.fight(player1, player2);

        assertThat(loser.getName(), is("player1"));
    }

    @Test
    public void should_record_each_attack_process() {
        Player player1 = new Player("张三", 10, 8);
        Player player2 = new Player("李四", 20, 9);
        Game game = new Game(new Reporter());

        game.fight(player1, player2);
        Reporter reporter = game.getReporter();

        assertThat(reporter.getMessagesSize(), is(5));
    }
}
