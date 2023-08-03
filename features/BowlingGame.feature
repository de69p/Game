Feature: Bowling Game Score Calculation

  Scenario: Calculate score for a gutter game
    Given a new bowling game
    When I roll 20 gutters
    Then the score should be 0

  Scenario: Calculate score for a game with all rolls as 1
    Given a new bowling game
    When I roll 20 times with 1 pin down each time
    Then the score should be 20

  Scenario: Calculate score for a game with a spare followed by a 3
    Given a new bowling game
    When I roll a spare and then a 3, and all other rolls as 0
    Then the score should be 16

  Scenario: Calculate score for a game with a strike followed by 4 and 3
    Given a new bowling game
    When I roll a strike, 4, 3, and all other rolls as 0
    Then the score should be 24

  Scenario: Calculate score for a perfect game (all strikes)
    Given a new bowling game
    When I roll 12 strikes
    Then the score should be 300



