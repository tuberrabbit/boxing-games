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
        this.ph = ph;
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

    public String attack(Player player) {
        player.setPh(player.getPh() - atk);
        return String.format("%s攻击了%s,%s受到了%d点伤害,%s剩余生命：%d\n",
                name, player.getName(),
                player.getName(), atk,
                player.getName(), player.getPh())
                + (player.getPh() < 0 ? String.format("%s被打败了\n", player.getName()) : "");
    }
}
