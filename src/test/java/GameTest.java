import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void movesShouldJobBigNumberRed() {
        Game game = new Game(false, 6);
        int[] speed = {7, 5, 6, 2_147_483_647};
        int expected = 2;
        int actual = game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesShouldJobBigNumberGreen() {
        Game game = new Game(true, 6);
        int[] speed = {7, 5, 6, 2_147_483_647};
        int expected = 0;
        int actual = game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesShouldCountNegativeRed() {
        Game game = new Game(false, 6);
        int[] speed = {-7, 5, 6, 10};
        int expected = 2;
        int actual = game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesShouldCountNegativeGreen() {
        Game game = new Game(true, 6);
        int[] speed = {-7, 5, 6, 10};
        int expected = 0;
        int actual = game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesShouldJobNegativeMaxSpeedRed() {
        Game game = new Game(false, -6);
        int[] speed = {7, 5, 6, 10};
        int expected = 2;
        int actual = game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesShouldJobNegativeMaxSpeedGreen() {
        Game game = new Game(true, -6);
        int[] speed = {7, 5, 6, 10};
        int expected = 0;
        int actual = game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesNegativeMaxSpeedAndNegativeSpeedRed() {
        Game game = new Game(false, -6);
        int[] speed = {7, -5, 6, -7, 0, 5, -6};
        int expected = 2;
        int actual = game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesNegativeMaxSpeedAndNegativeSpeedGreen() {
        Game game = new Game(true, -6);
        int[] speed = {7, -5, 6, -7, 0, 5, -6};
        int expected = 0;
        int actual = game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void losersShouldJobBigNumberRed() {
        Game game = new Game(false, 6);
        int[] speed = {7, 5, 6, 2_147_483_647};
        int[] expected = {7, 2_147_483_647};
        int[] actual = game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersShouldJobBigNumberGreen() {
        Game game = new Game(true, -6);
        int[] speed = {7, 5, 6, 2_147_483_647};
        int[] expected = {};
        int[] actual = game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersShouldCountNegativeRed() {
        Game game = new Game(false, 6);
        int[] speed = {0, 5, 10, 4, -3, -7};
        int[] expected = {10, -7};
        int[] actual = game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersShouldCountNegativeGreen() {
        Game game = new Game(true, 6);
        int[] speed = {0, 5, 10, 4, -3, -7};
        int[] expected = {};
        int[] actual = game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersShouldJobNegativeMaxSpeedRed() {
        Game game = new Game(false, -6);
        int[] speed = {0, 5, 10, 4, 13, 7};
        int[] expected = {10, 13, 7};
        int[] actual = game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersShouldJobNegativeMaxSpeedGreen() {
        Game game = new Game(true, -6);
        int[] speed = {0, 5, 10, 4, 13, 7};
        int[] expected = {};
        int[] actual = game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersNegativeMaxSpeedAndNegativeSpeedRed() {
        Game game = new Game(false, -6);
        int[] speed = {7, -5, 6, -7, 0, 5, -6};
        int[] expected = {7, -7};
        int[] actual = game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersNegativeMaxSpeedAndNegativeSpeedGreen() {
        Game game = new Game(true, -6);
        int[] speed = {7, -5, 6, -7, 0, 5, -6};
        int[] expected = {};
        int[] actual = game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldJobBigNumberRed() {
        Game game = new Game(false, 6);
        int[] speed = {7, 5, 6, 2_147_483_647};
        int[] expected = {5, 6};
        int[] actual = game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldJobBigNumberGreen() {
        Game game = new Game(true, 6);
        int[] speed = {7, 5, 6, 2_147_483_647};
        int[] expected = {7, 5, 6, 2_147_483_647};
        int[] actual = game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldCountNegativeRed() {
        Game game = new Game(false, 6);
        int[] speed = {0, 5, 10, 4, -3, -7};
        int[] expected = {0, 5, 4, -3};
        int[] actual = game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldCountNegativeGreen() {
        Game game = new Game(true, 6);
        int[] speed = {0, 5, 10, 4, -3, -7};
        int[] expected = {0, 5, 10, 4, -3, -7};
        int[] actual = game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldJobNegativeMaxSpeedRed() {
        Game game = new Game(false, -6);
        int[] speed = {0, 5, 10, 4, 3, 7};
        int[] expected = {0, 5, 4, 3};
        int[] actual = game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldJobNegativeMaxSpeedGreen() {
        Game game = new Game(true, -6);
        int[] speed = {0, 5, 10, 4, 3, 7};
        int[] expected = {0, 5, 10, 4, 3, 7};
        int[] actual = game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersNegativeMaxSpeedAndNegativeSpeedRed() {
        Game game = new Game(false, -6);
        int[] speed = {0, 5, 10, 4, -3, -7};
        int[] expected = {0, 5, 4, -3};
        int[] actual = game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersNegativeMaxSpeedAndNegativeSpeedGreen() {
        Game game = new Game(true, -6);
        int[] speed = {0, 5, 10, 4, -3, -7};
        int[] expected = {0, 5, 10, 4, -3, -7};
        int[] actual = game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }


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