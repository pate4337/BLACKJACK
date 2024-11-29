package ca.sheridancollege.project;

public final class Deck extends GroupOfCards {
    public Deck() {
        super(52);
        resetDeck();
    }
    
    public void resetDeck() {
        getCards().clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                getCards().add(new BlackjackCard(suit, rank));
            }
        }
        shuffle();
    }
    
    public Card dealCard() {
        if (getCards().isEmpty()) {
            resetDeck();
        }
        return getCards().remove(0);
    }
} 