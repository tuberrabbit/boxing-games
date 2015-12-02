package com.tuber.fight;

import static java.lang.String.format;

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

    public String attack(Player victim) {
        victim.beHurtBy(atk);
        return format("%s攻击了%s,%s受到了%d点伤害,%s剩余生命：%d",
                name, victim.getName(),
                victim.getName(), atk,
                victim.getName(), victim.getPh());
    }

    private void beHurtBy(Integer hurt) {
        ph -= hurt;
    }
}
