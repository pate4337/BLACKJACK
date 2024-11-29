package ca.sheridancollege.project;

public class BlackjackPlayer extends Player {
    private final Hand hand;
    int chips;
    private int currentBet;
    
    public BlackjackPlayer(String name, int initialChips) {
        super(name);
        this.hand = new Hand();
        this.chips = initialChips;
        this.currentBet = 0;
    }
    
    @Override
    public void play() {
        // Implementation done by BlackjackGame
    }
    
    public boolean placeBet(int amount) {
        if (amount <= chips) {
            currentBet = amount;
            chips -= amount;
            return true;
        }
        return false;
    }
    
    public Hand getHand() {
        return hand;
    }
    
    public int getChips() {
        return chips;
    }
    
    public int getCurrentBet() {
        return currentBet;
    }
    
    // Other methods
} 