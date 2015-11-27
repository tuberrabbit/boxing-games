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
    public void player2_should_get_zero_ph_when_the_hurt_is_more_than_his_ph() {
        player1.setAtk(300);
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
}
