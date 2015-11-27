public class Player {
    private Integer ph;
    private Integer atk;
    private String name;

    public Player() {
        this.ph = 0;
        this.atk = 0;
        this.name = "no name";
    }

    public Integer getPh() {
        return ph;
    }

    public void setPh(int ph) {
        this.ph = Math.max(0, ph);
    }

    public Integer getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void attack(Player player) {
        player.setPh(player.getPh() - atk);
    }
}
