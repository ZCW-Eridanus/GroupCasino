package com.github.zipcodewilmington.minesweeper;

import com.github.zipcodewilmington.casino.games.minesweeper.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class MineSweeperGameTest {
    @Test
    public void testGetBoard() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(5);
        mg.initGrids();
        String expected = "  | 0 | 1 | 2 | 3 | 4 |\n" +
                "0 | ? | ? | ? | ? | ? | \n" +
                "1 | ? | ? | ? | ? | ? | \n" +
                "2 | ? | ? | ? | ? | ? | \n" +
                "3 | ? | ? | ? | ? | ? | \n" +
                "4 | ? | ? | ? | ? | ? | \n";
        String actual = mg.getBoard();
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckBomb() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(1);
        mg.initGrids();
        mg.createMines(1);
        boolean actual = mg.checkCell(0, 0);
        assertTrue(actual);
    }

    @Test
    public void testCheckEmpty() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(1);
        mg.initGrids();
        boolean actual = mg.checkCell(0, 0);
        assertFalse(actual);
    }

    @Test
    public void testCheckNeighbors() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        char expected = '0';
        char actual = mg.checkNeighbors(1, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testRevealNeighbors() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.revealNeighbors(1, 1);
        char expected = '0';
        char actualTopLeft = mg.getCell(0, 0);
        char actualTopMiddle = mg.getCell(0, 1);
        char actualMiddleLeft = mg.getCell(1, 0);
        char actualTopRight = mg.getCell(0, 2);
        char actualBottomLeft = mg.getCell(2, 0);
        char actualBottomMiddle = mg.getCell(2, 1);
        char actualMiddleRight = mg.getCell(1, 2);
        char actualBottomRight = mg.getCell(2, 2);
        assertEquals(expected, actualBottomLeft);
        assertEquals(expected, actualBottomMiddle);
        assertEquals(expected, actualBottomRight);
        assertEquals(expected, actualMiddleLeft);
        assertEquals(expected, actualMiddleRight);
        assertEquals(expected, actualTopLeft);
        assertEquals(expected, actualTopMiddle);
        assertEquals(expected, actualTopRight);
    }
}
