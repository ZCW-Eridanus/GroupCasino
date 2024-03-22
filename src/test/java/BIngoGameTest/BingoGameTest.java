package BIngoGameTest;

import com.github.zipcodewilmington.casino.games.bingo.BingoGame;
import com.github.zipcodewilmington.casino.games.bingo.PlayerBoard;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class BingoGameTest {

    @Test
    public void testBingoGameInitialization() {
        BingoGame bingoGame = new BingoGame();
        assertNotNull(bingoGame);
    }

    @Test
    public void testAddPlayerBoard() {
        BingoGame bingoGame = new BingoGame();
        PlayerBoard player1 = new PlayerBoard(1);
        PlayerBoard player2 = new PlayerBoard(2);
        bingoGame.addPlayerBoard(player1);
        bingoGame.addPlayerBoard(player2);
        List<PlayerBoard> playerBoards = bingoGame.getPlayerBoards();
        assertEquals(2, playerBoards.size());
        assertTrue(playerBoards.contains(player1));
        assertTrue(playerBoards.contains(player2));
    }


    @Test
    public void testAllNumbersMarked() {
        PlayerBoard player = new PlayerBoard(1);
        for (int i = 1; i <= 75; i++) {
            player.markNumber(i);
        }
        int[][] board = player.getBoard();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertEquals(0, board[i][j]);
            }
        }
    }

    @Test
    public void testInvalidInput() {
        PlayerBoard player = new PlayerBoard(1);
        player.markNumber(-1);
        player.markNumber(100);
        assertNotNull(player.getBoard());
    }

    @Test
    public void testRandomNumberInRange() {
        PlayerBoard player = new PlayerBoard(1);
        int[][] board = player.getBoard();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertTrue(board[i][j] >= 1 && board[i][j] <= 75);
            }
        }
    }



    @Test
    public void testPlayerNumbersAssigned() {
        PlayerBoard player1 = new PlayerBoard(1);
        PlayerBoard player2 = new PlayerBoard(2);
        assertNotEquals(player1.getPlayerNumber(), player2.getPlayerNumber());
    }

    @Test
    public void testPlayerBoardValidity() {
        PlayerBoard player = new PlayerBoard(1);
        int[][] board = player.getBoard();
        assertEquals(5, board.length);
        for (int i = 0; i < 5; i++) {
            assertEquals(5, board[i].length);
        }
    }

    @Test
    public void testIsBingoNotBingo() {
        PlayerBoard player = new PlayerBoard(1);

        player.markNumber(1);
        player.markNumber(2);
        player.markNumber(3);
        player.markNumber(4);
        player.markNumber(6);
        player.markNumber(7);
        player.markNumber(8);
        player.markNumber(9);
        player.markNumber(10);
        player.markNumber(11);


        assertFalse(player.isBingo());
    }



}



