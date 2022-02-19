public class Game {

    public boolean trafficGreenLight;
    public int maxSpeed;

    public Game(boolean trafficGreenLight, int maxSpeed) {
        this.trafficGreenLight = trafficGreenLight;
        this.maxSpeed = maxSpeed;
    }

    public String[] start(String[] players) {
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
            String[] part = player.split(" ");
            int x = Integer.parseInt(part[1]);
            if (Math.abs(x) <= Math.abs(maxSpeed) || trafficGreenLight == true) {
                nameWin[i] = part[0];
                i++;
            }
        }
        return nameWin;
    }
}

