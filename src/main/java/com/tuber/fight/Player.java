package com.tuber.fight;

public class Player {
    private Integer ph;
    private Integer atk;
    private String name;

    public Player(String name, int ph, int atk) {
        this.name = name;
        this.ph = ph;
        this.atk = atk;
    }

    public Integer getPh() {
        return ph;
    }

    public Integer getAtk() {
        return atk;
    }

    public String getName() {
        return name;
    }

    public void attack(Player victim) {
        victim.beHurtBy(atk);
    }

    private void beHurtBy(Integer hurt) {
        ph -= hurt;
    }
}
