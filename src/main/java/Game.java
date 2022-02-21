public class Game {

    public boolean trafficGreenLight;
    public int maxSpeed;

    public Game(boolean trafficGreenLight, int maxSpeed) {
        this.trafficGreenLight = trafficGreenLight;
        this.maxSpeed = maxSpeed;
    }
    public int moves(int[] speeds) {   // расчет количества выбывающих с учетом скорости движения
        int quantityLosers = 0;
        if (trafficGreenLight == false) {
            for (int speed : speeds) {
                if (Math.abs(speed) > Math.abs(maxSpeed)) {
                    quantityLosers++;
                }
            }
        }
        return quantityLosers;
    }

    public int[] losers(int[] speeds) { // формирование списка скоростей выбывающих с учетом скорости движения
        int quantityLosers = moves(speeds);
        int[] quantitySpeedLosers = new int[quantityLosers];
        int i = 0;
        if (quantityLosers != 0) {
            for (int speed : speeds) {
                if (Math.abs(speed) > Math.abs(maxSpeed)) {
                    quantitySpeedLosers[i] = speed;
                    i++;
                }
            }
        }
        return quantitySpeedLosers;
    }

    public int[] winners(int[] speeds) { // формирование списка скоростей победителей
        int[] quantitySpeedWinners;
        if (trafficGreenLight == true) {
            quantitySpeedWinners = speeds;
        } else {
            int quantityWinners = 0;
            int i = 0;
            for (int speed : speeds) {
                if (Math.abs(speed) <= Math.abs(maxSpeed)) {
                    quantityWinners++;
                    i++;
                }
            }
            quantitySpeedWinners = new int[quantityWinners];
            i = 0;
            if (quantityWinners != 0) {
                for (int speed : speeds) {
                    if (Math.abs(speed) <= Math.abs(maxSpeed)) {
                        quantitySpeedWinners[i] = speed;
                        i++;
                    }
                }
            }
        }
        return quantitySpeedWinners;
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