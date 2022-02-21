import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void movesShouldJobBigNumberRed() {
        int[] speed = {7, 5, 6, 2_147_483_647};
        Game.trafficGreenLight = false;
        Game.maxSpeed = 6;
        int expected = 2;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesShouldJobBigNumberGreen() {
        int[] speed = {7, 5, 6, 2_147_483_647};
        Game.trafficGreenLight = true;
        Game.maxSpeed = 6;
        int expected = 0;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesShouldCountNegativeRed() {
        int[] speed = {-7, 5, 6, 10};
        Game.trafficGreenLight = false;
        Game.maxSpeed = 6;
        int expected = 2;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesShouldCountNegativeGreen() {
        int[] speed = {-7, 5, 6, 10};
        Game.trafficGreenLight = true;
        Game.maxSpeed = 6;
        int expected = 0;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesShouldJobNegativeMaxSpeedRed() {
        int[] speed = {7, 5, 6, 10};
        Game.trafficGreenLight = false;
        Game.maxSpeed = -6;
        int expected = 2;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesShouldJobNegativeMaxSpeedGreen() {
        int[] speed = {7, 5, 6, 10};
        Game.trafficGreenLight = true;
        Game.maxSpeed = -6;
        int expected = 0;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesNegativeMaxSpeedAndNegativeSpeedRed() {
        int[] speed = {7, -5, 6, -7, 0, 5, -6};
        Game.trafficGreenLight = false;
        Game.maxSpeed = -6;
        int expected = 2;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesNegativeMaxSpeedAndNegativeSpeedGreen() {
        int[] speed = {7, -5, 6, -7, 0, 5, -6};
        Game.trafficGreenLight = true;
        Game.maxSpeed = -6;
        int expected = 0;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void losersShouldJobBigNumberRed() {
        int[] speed = {7, 5, 6, 2_147_483_647};
        Game.trafficGreenLight = false;
        Game.maxSpeed = 6;
        int[] expected = {7, 2_147_483_647};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersShouldJobBigNumberGreen() {
        int[] speed = {7, 5, 6, 2_147_483_647};
        Game.trafficGreenLight = true;
        Game.maxSpeed = 6;
        int[] expected = {};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersShouldCountNegativeRed() {
        int[] speed = {0, 5, 10, 4, -3, -7};
        Game.trafficGreenLight = false;
        Game.maxSpeed = 6;
        int[] expected = {10, -7};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersShouldCountNegativeGreen() {
        int[] speed = {0, 5, 10, 4, -3, -7};
        Game.trafficGreenLight = true;
        Game.maxSpeed = 6;
        int[] expected = {};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersShouldJobNegativeMaxSpeedRed() {
        int[] speed = {0, 5, 10, 4, 13, 7};
        Game.trafficGreenLight = false;
        Game.maxSpeed = -6;
        int[] expected = {10, 13, 7};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersShouldJobNegativeMaxSpeedGreen() {
        int[] speed = {0, 5, 10, 4, 13, 7};
        Game.trafficGreenLight = true;
        Game.maxSpeed = -6;
        int[] expected = {};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersNegativeMaxSpeedAndNegativeSpeedRed() {
        int[] speed = {7, -5, 6, -7, 0, 5, -6};
        Game.trafficGreenLight = false;
        Game.maxSpeed = -6;
        int[] expected = {7, -7};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersNegativeMaxSpeedAndNegativeSpeedGreen() {
        int[] speed = {7, -5, 6, -7, 0, 5, -6};
        Game.trafficGreenLight = true;
        Game.maxSpeed = -6;
        int[] expected = {};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldJobBigNumberRed() {
        int[] speed = {7, 5, 6, 2_147_483_647};
        Game.trafficGreenLight = false;
        Game.maxSpeed = 6;
        int[] expected = {5, 6};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldJobBigNumberGreen() {
        int[] speed = {7, 5, 6, 2_147_483_647};
        Game.trafficGreenLight = true;
        Game.maxSpeed = 6;
        int[] expected = {7, 5, 6, 2_147_483_647};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldCountNegativeRed() {
        int[] speed = {0, 5, 10, 4, -3, -7};
        Game.trafficGreenLight = false;
        Game.maxSpeed = 6;
        int[] expected = {0, 5, 4, -3};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldCountNegativeGreen() {
        int[] speed = {0, 5, 10, 4, -3, -7};
        Game.trafficGreenLight = true;
        Game.maxSpeed = 6;
        int[] expected = {0, 5, 10, 4, -3, -7};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldJobNegativeMaxSpeedRed() {
        int[] speed = {0, 5, 10, 4, 3, 7};
        Game.trafficGreenLight = false;
        Game.maxSpeed = -6;
        int[] expected = {0, 5, 4, 3};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldJobNegativeMaxSpeedGreen() {
        int[] speed = {0, 5, 10, 4, 3, 7};
        Game.trafficGreenLight = true;
        Game.maxSpeed = -6;
        int[] expected = {0, 5, 10, 4, 3, 7};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersNegativeMaxSpeedAndNegativeSpeedRed() {
        int[] speed = {0, 5, 10, 4, -3, -7};
        Game.trafficGreenLight = false;
        Game.maxSpeed = -6;
        int[] expected = {0, 5, 4, -3};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersNegativeMaxSpeedAndNegativeSpeedGreen() {
        int[] speed = {0, 5, 10, 4, -3, -7};
        Game.trafficGreenLight = true;
        Game.maxSpeed = -6;
        int[] expected = {0, 5, 10, 4, -3, -7};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void listNameWinNegativeAllSpeedGreen() {
        Game.trafficGreenLight = true;
        Game.maxSpeed = -3;
        String[] players = {
                "Jon -2",
                "Mary -3",
                "Ben -4"
        };
        String[] expected = {"Jon", "Mary", "Ben"};
        String[] actual = Game.listPlayers(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinNegativeAllSpeedRed() {
        Game.trafficGreenLight = false;
        Game.maxSpeed = -3;
        String[] players = {
                "Jon -2",
                "Mary -3",
                "Ben -4"
        };
        String[] expected = {"Jon", "Mary"};
        String[] actual = Game.listPlayers(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinMaxSpeedZeroGreen() {
        Game.trafficGreenLight = true;
        Game.maxSpeed = 0;
        String[] players = {
                "Jon -1",
                "Mary 0",
                "Ben 1"
        };
        String[] expected = {"Jon", "Mary", "Ben"};
        String[] actual = Game.listPlayers(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinMaxSpeedZeroRed() {
        Game.trafficGreenLight = false;
        Game.maxSpeed = 0;
        String[] players = {
                "Jon -1",
                "Mary 0",
                "Ben 1"
        };
        String[] expected = {"Mary"};
        String[] actual = Game.listPlayers(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinMaxAllSpeedZeroGreen() {
        Game.trafficGreenLight = true;
        Game.maxSpeed = 0;
        String[] players = {
                "Jon 0",
                "Mary 0",
                "Ben 0"
        };
        String[] expected = {"Jon", "Mary", "Ben"};
        String[] actual = Game.listPlayers(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinMaxAllSpeedZeroRed() {
        Game.trafficGreenLight = false;
        Game.maxSpeed = 0;
        String[] players = {
                "Jon 0",
                "Mary 0",
                "Ben 0"
        };
        String[] expected = {"Jon", "Mary", "Ben"};
        String[] actual = Game.listPlayers(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinPositiveAllSpeedGreen() {
        Game.trafficGreenLight = true;
        Game.maxSpeed = 3;
        String[] players = {
                "Jon 2",
                "Mary 3",
                "Ben 4"
        };
        String[] expected = {"Jon", "Mary", "Ben"};
        String[] actual = Game.listPlayers(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinPositiveAllSpeedRed() {
        Game.trafficGreenLight = false;
        Game.maxSpeed = 3;
        String[] players = {
                "Jon 2",
                "Mary 3",
                "Ben 4"
        };
        String[] expected = {"Jon", "Mary"};
        String[] actual = Game.listPlayers(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinOnePlayerGreen() {
        Game.trafficGreenLight = true;
        Game.maxSpeed = 3;
        String[] players = {
                "Jon 3"
        };
        String[] expected = {"Jon"};
        String[] actual = Game.listPlayers(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinOnePlayerRed() {
        Game.trafficGreenLight = false;
        Game.maxSpeed = 3;
        String[] players = {
                "Jon 4"
        };
        String[] expected = {};
        String[] actual = Game.listPlayers(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinManyPlayersGreen() {
        Game.trafficGreenLight = true;
        Game.maxSpeed = 3;
        String[] players = {
                "Jon 4",
                "Mary 3",
                "Ben 2",
                "Ivan 0",
                "Natalya -2",
                "Mikael -3",
                "Jessika -4"
        };
        String[] expected = {"Jon", "Mary", "Ben", "Ivan", "Natalya", "Mikael", "Jessika"};
        String[] actual = Game.listPlayers(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinManyPlayersRed() {
        Game.trafficGreenLight = false;
        Game.maxSpeed = 3;
        String[] players = {
                "Jon 4",
                "Mary 3",
                "Ben 2",
                "Ivan 0",
                "Natalya -2",
                "Mikael -3",
                "Jessika -4"
        };
        String[] expected = {"Mary", "Ben", "Ivan", "Natalya", "Mikael"};
        String[] actual = Game.listPlayers(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinAddNumberGreen() {
        Game.trafficGreenLight = true;
        Game.maxSpeed = 3;
        String[] players = {
                "Jon 2",
                "Mary89 3",
                "Ben 4"
        };
        String[] expected = {"Jon", "Mary89", "Ben"};
        String[] actual = Game.listPlayers(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinAddNumberRed() {
        Game.trafficGreenLight = false;
        Game.maxSpeed = 3;
        String[] players = {
                "Jon 2",
                "Mary89 3",
                "Ben 4"
        };
        String[] expected = {"Jon", "Mary89"};
        String[] actual = Game.listPlayers(players);

        Assertions.assertArrayEquals(expected, actual);
    }
}

