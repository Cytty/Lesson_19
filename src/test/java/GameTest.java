import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void listNameWinNegativeAllSpeedGreen() {
        Game game = new Game(true, -3);
        String[] players = {
                "Jon -2",
                "Mary -3",
                "Ben -4"
        };
        String[] expected = {"Jon", "Mary", "Ben"};
        String[] actual = game.start(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinNegativeAllSpeedRed() {
        Game game = new Game(false, -3);
        String[] players = {
                "Jon -2",
                "Mary -3",
                "Ben -4"
        };
        String[] expected = {"Jon", "Mary"};
        String[] actual = game.start(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinMaxSpeedZeroGreen() {
        Game game = new Game(true, 0);
        String[] players = {
                "Jon -1",
                "Mary 0",
                "Ben 1"
        };
        String[] expected = {"Jon", "Mary", "Ben"};
        String[] actual = game.start(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinMaxSpeedZeroRed() {
        Game game = new Game(false, 0);
        String[] players = {
                "Jon -1",
                "Mary 0",
                "Ben 1"
        };
        String[] expected = {"Mary"};
        String[] actual = game.start(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinMaxAllSpeedZeroGreen() {
        Game game = new Game(true, 0);
        String[] players = {
                "Jon 0",
                "Mary 0",
                "Ben 0"
        };
        String[] expected = {"Jon", "Mary", "Ben"};
        String[] actual = game.start(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinMaxAllSpeedZeroRed() {
        Game game = new Game(false, 0);
        String[] players = {
                "Jon 0",
                "Mary 0",
                "Ben 0"
        };
        String[] expected = {"Jon", "Mary", "Ben"};
        String[] actual = game.start(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinPositiveAllSpeedGreen() {
        Game game = new Game(true, 3);
        String[] players = {
                "Jon 2",
                "Mary 3",
                "Ben 4"
        };
        String[] expected = {"Jon", "Mary", "Ben"};
        String[] actual = game.start(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinPositiveAllSpeedRed() {
        Game game = new Game(false, 3);
        String[] players = {
                "Jon 2",
                "Mary 3",
                "Ben 4"
        };
        String[] expected = {"Jon", "Mary"};
        String[] actual = game.start(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinOnePlayerGreen() {
        Game game = new Game(true, 3);
        String[] players = {
                "Jon 3"
        };
        String[] expected = {"Jon"};
        String[] actual = game.start(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinOnePlayerRed() {
        Game game = new Game(false, 3);
        String[] players = {
                "Jon 4"
        };
        String[] expected = {};
        String[] actual = game.start(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinManyPlayersGreen() {
        Game game = new Game(true, 3);
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
        String[] actual = game.start(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinManyPlayersRed() {
        Game game = new Game(false, 3);
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
        String[] actual = game.start(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinAddNumberGreen() {
        Game game = new Game(true, 3);
        String[] players = {
                "Jon 2",
                "Mary89 3",
                "Ben 4"
        };
        String[] expected = {"Jon", "Mary89", "Ben"};
        String[] actual = game.start(players);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void listNameWinAddNumberRed() {
        Game game = new Game(false, 3);
        String[] players = {
                "Jon 2",
                "Mary89 3",
                "Ben 4"
        };
        String[] expected = {"Jon", "Mary89"};
        String[] actual = game.start(players);

        Assertions.assertArrayEquals(expected, actual);
    }
}



