package com.example.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {

    private BowlingGame game;

    @BeforeEach
    public void setUp() {
        game = new BowlingGame();
    }

    @Test
    public void testGutterGame() {
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }

    @Test
    public void testAllOnesGame() {
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.score());
    }

    @Test
    public void testSpareFollowedBy3() {
        game.roll(5);
        game.roll(5); // Spare
        game.roll(3);
        for (int i = 0; i < 17; i++) {
            game.roll(0);
        }
        assertEquals(16, game.score());
    }

    @Test
    public void testStrikeFollowedBy4And3() {
        game.roll(10); // Strike
        game.roll(4);
        game.roll(3);
        for (int i = 0; i < 16; i++) {
            game.roll(0);
        }
        assertEquals(24, game.score());
    }


    @Test
    public void testPerfectGame() {
        for (int i = 0; i < 12; i++) {
            game.roll(10); // 12 strikes for a perfect game
        }
        assertEquals(300, game.score());
    }


    @Test
    public void testInvalidRollAfterGameEnds() {
        for (int i = 0; i < 20; i++) {
            game.roll(3);
        }
        // Trying to roll after the game has ended (currentRoll is at 20)
        game.roll(4);
        assertEquals(60, game.score()); // The score should remain unchanged
    }


    @Test
    public void testAllSparesGame() {
        for (int i = 0; i < 21; i++) {
            game.roll(5);
        }
        assertEquals(150, game.score());
    }


    @Test
    public void testRandomNoSparesNoStrikes() {
        game.roll(2);
        game.roll(4);
        game.roll(7);
        game.roll(1);
        game.roll(3);
        game.roll(6);
        for (int i = 0; i < 14; i++) {
            game.roll(0);
        }
        assertEquals(23, game.score());
    }

    @Test
    public void testGuttersWithStrikeInLastFrame() {
        for (int i = 0; i < 18; i++) {
            game.roll(0);
        }
        game.roll(10); // Strike in the last frame
        game.roll(2);
        game.roll(3);
        assertEquals(15, game.score());
    }

    @Test
    public void testAlternatingStrikesAndSpares() {
        for (int i = 0; i < 10; i++) {
            game.roll(10); // Strikes in odd frames
            game.roll(5);
            game.roll(5); // Spares in even frames
        }
        game.roll(10); // Bonus strike for the 10th frame
        assertEquals(200, game.score());
    }


}