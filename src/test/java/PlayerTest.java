import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {

    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = new Player();
        player2 = new Player();


    }

    @Test
    public void should_create_player1_with_some_necessary_attributes() {
        player1.setPh(200);
        player1.setAtk(200);
        player1.setName("player1");

        assertThat(player1.getPh(), is(200));
        assertThat(player1.getAtk(), is(200));
        assertThat(player1.getName(), is("player1"));
    }

    @Test
    public void should_initial_attributes_when_create_player1_without_any_attributes() {
        assertThat(player1.getPh(), is(0));
        assertThat(player1.getAtk(), is(0));
        assertThat(player1.getName(), is("no name"));

    }

    @Test
    public void player2_should_get_zero_ph_when_the_hurt_equal_to_his_ph() {
        player1.setAtk(200);
        player2.setPh(200);

        player1.attack(player2);

        assertThat(player2.getPh(), is(0));

    }

    @Test
    public void player2_should_be_alive_when_the_hurt_is_less_than_his_ph() {
        player1.setAtk(100);
        player2.setPh(200);

        player1.attack(player2);

        assertThat(player2.getPh(), is(100));

    }

    @Test
    public void should_return_attack_result_when_the_player_attack_others() {
        player1.setName("张三");
        player1.setAtk(8);
        player1.setPh(10);
        player2.setName("李四");
        player2.setPh(20);
        player2.setAtk(9);

        assertThat(player1.attack(player2), is("张三攻击了李四,李四受到了8点伤害,李四剩余生命：12\n"));
        assertThat(player2.attack(player1), is("李四攻击了张三,张三受到了9点伤害,张三剩余生命：1\n"));
        assertThat(player1.attack(player2), is("张三攻击了李四,李四受到了8点伤害,李四剩余生命：4\n"));
        assertThat(player2.attack(player1), is("李四攻击了张三,张三受到了9点伤害,张三剩余生命：-8\n张三被打败了\n"));
    }
}
