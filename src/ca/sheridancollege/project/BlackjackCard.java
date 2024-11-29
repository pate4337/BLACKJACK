package ca.sheridancollege.project;

public class BlackjackCard extends Card {
    private final Suit suit;
    private final Rank rank;
    
    public BlackjackCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
    
    public int getValue() {
        return rank.getValue();
    }
    
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
} 