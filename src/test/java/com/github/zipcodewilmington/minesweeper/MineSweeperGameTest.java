package com.github.zipcodewilmington.minesweeper;

import com.github.zipcodewilmington.casino.CasinoAccount;
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
    public void testCheckNeighborsC1R1NoMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        char expected = '0';
        char actual = mg.checkNeighbors(1, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC0R1NoMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        char expected = '0';
        char actual = mg.checkNeighbors(1, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC1R0NoMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        char expected = '0';
        char actual = mg.checkNeighbors(0, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC0R0NoMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        char expected = '0';
        char actual = mg.checkNeighbors(0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC2R0NoMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        char expected = '0';
        char actual = mg.checkNeighbors(0, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC0R2NoMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        char expected = '0';
        char actual = mg.checkNeighbors(2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC2R1NoMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        char expected = '0';
        char actual = mg.checkNeighbors(1, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC1R2NoMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        char expected = '0';
        char actual = mg.checkNeighbors(2, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC2R2NoMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        char expected = '0';
        char actual = mg.checkNeighbors(2, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC1R1YesMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.createMines(9);
        char expected = '8';
        char actual = mg.checkNeighbors(1, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC0R1YesMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.createMines(9);
        char expected = '5';
        char actual = mg.checkNeighbors(1, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC1R0YesMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.createMines(9);
        char expected = '5';
        char actual = mg.checkNeighbors(0, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC0R0YesMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.createMines(9);
        char expected = '3';
        char actual = mg.checkNeighbors(0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC2R0YesMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.createMines(9);
        char expected = '3';
        char actual = mg.checkNeighbors(0, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC0R2YesMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.createMines(9);
        char expected = '3';
        char actual = mg.checkNeighbors(2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC2R1YesMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.createMines(9);
        char expected = '5';
        char actual = mg.checkNeighbors(1, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC1R2YesMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.createMines(9);
        char expected = '5';
        char actual = mg.checkNeighbors(2, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckNeighborsC2R2YesMines() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.createMines(9);
        char expected = '3';
        char actual = mg.checkNeighbors(2, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testRevealNeighborsC1R1() {
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

    @Test
    public void testRevealNeighborsC0R1() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.revealNeighbors(1, 0);

        char expected = '0';
        char actualTopLeft = mg.getCell(0, 0);
        char actualTopMiddle = mg.getCell(0, 1);
        char actualBottomLeft = mg.getCell(2, 0);
        char actualBottomMiddle = mg.getCell(2, 1);
        char actualCenter = mg.getCell(1, 1);

        assertEquals(expected, actualBottomLeft);
        assertEquals(expected, actualBottomMiddle);
        assertEquals(expected, actualCenter);
        assertEquals(expected, actualTopLeft);
        assertEquals(expected, actualTopMiddle);
    }

    @Test
    public void testRevealNeighborsC1R0() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.revealNeighbors(0, 1);

        char expected = '0';
        char actualTopLeft = mg.getCell(0, 0);
        char actualMiddleLeft = mg.getCell(1, 0);
        char actualTopRight = mg.getCell(0, 2);
        char actualMiddleRight = mg.getCell(1, 2);
        char actualCenter = mg.getCell(1, 1);

        assertEquals(expected, actualTopRight);
        assertEquals(expected, actualMiddleRight);
        assertEquals(expected, actualCenter);
        assertEquals(expected, actualTopLeft);
        assertEquals(expected, actualMiddleLeft);
    }

    @Test
    public void testRevealNeighborsC0R0() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.revealNeighbors(0, 0);

        char expected = '0';
        char actualTopMiddle = mg.getCell(0, 1);
        char actualMiddleLeft = mg.getCell(1, 0);
        char actualCenter = mg.getCell(1, 1);

        assertEquals(expected, actualCenter);
        assertEquals(expected, actualMiddleLeft);
        assertEquals(expected, actualTopMiddle);
    }

    @Test
    public void testRevealNeighborsC2R0() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.revealNeighbors(0, 2);

        char expected = '0';
        char actualTopMiddle = mg.getCell(0, 1);
        char actualMiddleRight = mg.getCell(1, 2);
        char actualCenter = mg.getCell(1, 1);

        assertEquals(expected, actualCenter);
        assertEquals(expected, actualMiddleRight);
        assertEquals(expected, actualTopMiddle);
    }

    @Test
    public void testRevealNeighborsC0R2() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.revealNeighbors(2, 0);

        char expected = '0';
        char actualBottomMiddle = mg.getCell(2, 1);
        char actualMiddleLeft = mg.getCell(1, 0);
        char actualCenter = mg.getCell(1, 1);

        assertEquals(expected, actualCenter);
        assertEquals(expected, actualMiddleLeft);
        assertEquals(expected, actualBottomMiddle);
    }

    @Test
    public void testRevealNeighborsC2R2() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.revealNeighbors(2, 2);

        char expected = '0';
        char actualBottomMiddle = mg.getCell(2, 1);
        char actualMiddleRight = mg.getCell(1, 2);
        char actualCenter = mg.getCell(1, 1);

        assertEquals(expected, actualCenter);
        assertEquals(expected, actualMiddleRight);
        assertEquals(expected, actualBottomMiddle);
    }

    @Test
    public void testRevealNeighborsC2R1() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.revealNeighbors(1, 2);

        char expected = '0';
        char actualTopRight = mg.getCell(0, 2);
        char actualTopMiddle = mg.getCell(0, 1);
        char actualCenter = mg.getCell(1, 1);
        char actualBottomMiddle = mg.getCell(2, 1);
        char actualBottomRight = mg.getCell(2, 2);

        assertEquals(expected, actualBottomMiddle);
        assertEquals(expected, actualBottomRight);
        assertEquals(expected, actualCenter);
        assertEquals(expected, actualTopMiddle);
        assertEquals(expected, actualTopRight);
    }

    @Test
    public void testRevealNeighborsC1R2() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.revealNeighbors(2, 1);

        char expected = '0';
        char actualMiddleRight = mg.getCell(1, 2);
        char actualMiddleLeft = mg.getCell(1, 0);
        char actualCenter = mg.getCell(1, 1);
        char actualBottomLeft = mg.getCell(2, 0);
        char actualBottomRight = mg.getCell(2, 2);

        assertEquals(expected, actualBottomLeft);
        assertEquals(expected, actualBottomRight);
        assertEquals(expected, actualCenter);
        assertEquals(expected, actualMiddleLeft);
        assertEquals(expected, actualMiddleRight);
    }

    @Test
    public void testRevealNeighborsReturn() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();

        assertTrue(mg.revealNeighbors(1, 1));
    }

    @Test
    public void testSetGridSizeAndReturn() {
        int expected = 3;
        MineSweeperGame mg = new MineSweeperGame();
        int actual = mg.setGridSize(3);

        assertEquals(expected, actual);
    }

    @Test
    public void testExitGame() {
        MineSweeperGame mg = new MineSweeperGame();
        MineSweeperPlayer mp = new MineSweeperPlayer(new CasinoAccount());
        assertTrue(mg.exitGame(mp));
    }

    @Test
    public void testActionSkipInput() {
        int expected = 1;
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(2);
        mg.initGrids();
        int actual = mg.action(true, "");

        assertEquals(expected, actual);
    }

    @Test
    public void testActionSkipInputExit() {
        int expected = 0;
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(2);
        mg.initGrids();
        int actual = mg.action(true, "X");

        assertEquals(expected, actual);
    }

    @Test
    public void testInitGrids() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(2);

        assertTrue(mg.initGrids());
    }

    @Test
    public void testGetWager() {
        int expected = 5;
        MineSweeperGame mg = new MineSweeperGame();

        mg.setWager(expected);

        assertEquals(expected, mg.getWager());
    }

    @Test
    public void testCheckMine() {
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.createMines(9);

        assertTrue(mg.checkCell(1, 1));
    }

    @Test
    public void testAddAndGetPlayer() {
        MineSweeperGame mg = new MineSweeperGame();
        MineSweeperPlayer mp = new MineSweeperPlayer(new CasinoAccount());
        mg.add(mp);

        assertEquals(mp, mg.getPlayer());
    }

    @Test
    public void testHitMine() {
        int expected = -1;
        MineSweeperGame mg = new MineSweeperGame();
        mg.setGridSize(3);
        mg.initGrids();
        mg.createMines(9);

        int actual = mg.action(true, "1, 1");

        assertEquals(expected, actual);
    }


}
