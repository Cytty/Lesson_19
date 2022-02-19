import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

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



