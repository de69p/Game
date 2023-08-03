package com.example.application;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameSteps {
    private BowlingGame game;

    @Given("^a new bowling game$")
    public void createNewGame() {
        game = new BowlingGame();
    }

    @When("^I roll (\\d+) gutters$")
    public void rollGutters(int rolls) {
        for (int i = 0; i < rolls; i++) {
            game.roll(0);
        }
    }

    @Then("^the score should be (\\d+)$")
    public void checkScore(int expectedScore) {
        assertEquals(expectedScore, game.score());
    }

    @When("^I roll (\\d+) times with (\\d+) pin down each time$")
    public void rollPins(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    @When("^I roll a spare and then a (\\d+), and all other rolls as (\\d+)$")
    public void rollSpareAndNextRoll(int nextRoll, int otherRolls) {
        game.roll(5);
        game.roll(5); // Spare
        game.roll(nextRoll);
        for (int i = 0; i < otherRolls; i++) {
            game.roll(0);
        }
    }

    @When("^I roll a strike, (\\d+), (\\d+), and all other rolls as (\\d+)$")
    public void rollStrikeAndNextRolls(int nextRoll1, int nextRoll2, int otherRolls) {
        game.roll(10); // Strike
        game.roll(nextRoll1);
        game.roll(nextRoll2);
        for (int i = 0; i < otherRolls; i++) {
            game.roll(0);
        }
    }

    @When("^I roll (\\d+) strikes$")
    public void rollStrikes(int strikes) {
        for (int i = 0; i < strikes; i++) {
            game.roll(10);
        }
    }
}

