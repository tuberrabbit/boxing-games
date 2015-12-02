package com.tuber.fight;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {

    private Player player1;
    private Player player2;

    @Test
    public void should_create_player_with_some_necessary_attributes() {
        player1 = new Player("tuber", 100, 10);

        assertThat(player1.getPh(), is(100));
        assertThat(player1.getAtk(), is(10));
        assertThat(player1.getName(), is("tuber"));
    }

    @Test
    public void should_be_killed_when_hurt_is_more_than_ph() {
        player1 = new Player("player1", 9, 10);
        player2 = new Player("player2", 9, 11);

        player1.attack(player2);

        assertThat(player2.getPh(), is(-1));
    }

    @Test
    public void should_be_alive_when_hurt_is_equal_to_ph() {
        player1 = new Player("player1", 10, 10);
        player2 = new Player("player2", 10, 10);

        player1.attack(player2);

        assertThat(player2.getPh(), is(0));
    }

    @Test
    public void should_be_alive_when_hurt_is_less_than_ph() {
        player1 = new Player("player1", 10, 9);
        player2 = new Player("player2", 10, 10);

        player1.attack(player2);

        assertThat(player2.getPh(), is(1));
    }

    @Test
    public void should_return_formated_message_when_attack_is_over() {
        player1 = new Player("张三", 10, 8);
        player2 = new Player("李四", 20, 9);

        assertThat(player1.attack(player2), is("张三攻击了李四,李四受到了8点伤害,李四剩余生命：12"));
        assertThat(player2.attack(player1), is("李四攻击了张三,张三受到了9点伤害,张三剩余生命：1"));
        assertThat(player1.attack(player2), is("张三攻击了李四,李四受到了8点伤害,李四剩余生命：4"));
        assertThat(player2.attack(player1), is("李四攻击了张三,张三受到了9点伤害,张三剩余生命：-8"));
    }
}
