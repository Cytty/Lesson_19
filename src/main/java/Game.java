public class Game {
    public static boolean trafficGreenLight = false;
    public static int maxSpeed = 5;

    public static String[] listPlayers(String[] players) {
        String[] nameWin;
        int quantityWin = 0;
        for (String player : players) {
            String[] part = player.split(" ");
            int x = Integer.parseInt(part[1]);
            if (Math.abs(x) <= Math.abs(maxSpeed) || trafficGreenLight == true) {
                quantityWin++;
            }
        }

        nameWin = new String[quantityWin];
        int i = 0;
        for (String player : players) {
            String[] part = player.split(" "); // ("Jon", "5")
            int x = Integer.parseInt(part[1]);         // "5" = 5
            if (Math.abs(x) <= Math.abs(maxSpeed) || trafficGreenLight == true) {
                nameWin[i] = part[0];
                i++;
            }
        }
        return nameWin;
    }
}

