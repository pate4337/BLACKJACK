package ca.sheridancollege.project;

public class Dealer extends Player {
    private final Hand hand;
    private final Deck deck;
    
    public Dealer() {
        super("Dealer");
        this.hand = new Hand();
        this.deck = new Deck();
    }
    
    @Override
    public void play() {
        while (mustHit()) {
            hand.addCard(deck.dealCard());
        }
    }
    
    public boolean mustHit() {
        return hand.getValue() < 17;
    }
    
    public Card dealCard() {
        return deck.dealCard();
    }
    
    public Card getVisibleCard() {
        return hand.getCards().get(0);
    }
    
    public Hand getHand() {
        return hand;
    }
} 