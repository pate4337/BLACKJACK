package ca.sheridancollege.project;

import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> cards;
    
    public Hand() {
        cards = new ArrayList<>();
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public ArrayList<Card> getCards() {
        return cards;
    }
    
    public int getValue() {
        int value = 0;
        int aces = 0;
        
        for (Card card : cards) {
            if (!(card instanceof BlackjackCard)) {
                throw new IllegalArgumentException("Invalid card type");
            }
            BlackjackCard bjCard = (BlackjackCard) card;
            if (bjCard.getValue() == 11) {
                aces++;
            }
            value += bjCard.getValue();
        }
        
        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }
        
        return value;
    }
    
    public void clear() {
        cards.clear();
    }
    
    public boolean isBlackjack() {
        return cards.size() == 2 && getValue() == 21;
    }
} 