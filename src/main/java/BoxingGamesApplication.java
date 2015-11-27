public class BoxingGamesApplication {

    public static void main(String[] asdf) {
        Player player1 = new Player();
        player1.setAtk(10);
        player1.setPh(100);
        player1.setName("player1");

        Player player2 = new Player();
        player2.setAtk(6);
        player2.setPh(200);
        player2.setName("player2");

        while (true) {
            if (isKilled(player1, player2)) {
                break;
            }

            if (isKilled(player2, player1)) {
                break;
            }
        }
        System.out.println("游戏结束");
    }

    private static boolean isKilled(Player player1, Player player2) {
        player1.attack(player2);
        if (player2.getPh().equals(0)) {
            printLoser(player2.getName());
            return true;
        }
        return false;
    }

    private static void printLoser(String name) {
        System.out.println(name + " 被打败了！！！");
    }
}
