# Blackjack Game

A simple command-line Blackjack game implemented in Java. This game allows players to play against a dealer, place bets, and try to win chips.

## Features

- Player vs Dealer gameplay
- Betting system with chips
- Standard Blackjack rules
- Command-line interface
- Dealer must hit on 16 and stand on 17

## How to Play

1. Compile the Java files:
```bash
javac src/ca/sheridancollege/project/*.java
```

2. Run the game:
```bash
cd src
java ca.sheridancollege.project.BlackjackGame
```

3. Follow the on-screen instructions:
   - Enter your name
   - Place bets using your chips (start with 1000 chips)
   - Choose to hit (h) or stand (s) during your turn
   - Try to beat the dealer without going over 21
   - Enter 0 as bet amount to quit the game

## Game Rules

- Each player starts with 1000 chips
- Aces are worth 11 but change to 1 if the hand would bust
- Face cards (Jack, Queen, King) are worth 10
- Dealer must hit on 16 and stand on 17
- Winning pays 1:1 (double your bet)
- Ties return your original bet

## Project Structure

- `src/ca/sheridancollege/project/`
  - `BlackjackGame.java` - Main game logic and entry point
  - `BlackjackPlayer.java` - Player class with betting functionality
  - `Dealer.java` - Dealer logic and card dealing
  - `Deck.java` - Card deck management
  - `Hand.java` - Hand evaluation and card storage
  - `Card.java` - Base card class
  - `BlackjackCard.java` - Specific card implementation
  - `Rank.java` - Card ranks
  - `Suit.java` - Card suits

## Requirements

- Java 8 or higher
- Command-line interface 