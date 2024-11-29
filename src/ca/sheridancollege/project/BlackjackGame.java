package ca.sheridancollege.project;

import java.util.Scanner;

public class BlackjackGame extends Game {
    private final Dealer dealer;
    private final BlackjackPlayer player;
    private final Scanner scanner;
    
    public BlackjackGame(String playerName) {
        super("Blackjack");
        this.dealer = new Dealer();
        this.player = new BlackjackPlayer(playerName, 1000); // Start with 1000 chips
        this.scanner = new Scanner(System.in);
    }
    
    @Override
    public void play() {
        while (player.getChips() > 0) {
            System.out.println("\nYou have " + player.getChips() + " chips.");
            System.out.print("How much would you like to bet? (0 to quit): ");
            int bet = scanner.nextInt();
            
            if (bet == 0) {
                break;
            }
            
            if (bet > player.getChips()) {
                System.out.println("You don't have enough chips!");
                continue;
            }
            
            player.placeBet(bet);
            playRound();
        }
        
        System.out.println("\nGame Over! You ended with " + player.getChips() + " chips.");
    }
    
    private void playRound() {
        // Clear hands and deal initial cards
        dealer.getHand().clear();
        player.getHand().clear();
        
        // Deal initial cards
        player.getHand().addCard(dealer.dealCard());
        dealer.getHand().addCard(dealer.dealCard());
        player.getHand().addCard(dealer.dealCard());
        dealer.getHand().addCard(dealer.dealCard());
        
        // Show the cards
        System.out.println("\nDealer's visible card: " + dealer.getVisibleCard());
        System.out.println("Your cards: " + player.getHand().getCards() + " (Value: " + player.getHand().getValue() + ")");
        
        // Player's turn
        while (player.getHand().getValue() < 21) {
            System.out.print("Do you want to hit (h) or stand (s)? ");
            String choice = scanner.next().toLowerCase();
            
            if (choice.equals("s")) {
                break;
            } else if (choice.equals("h")) {
                player.getHand().addCard(dealer.dealCard());
                System.out.println("Your cards: " + player.getHand().getCards() + " (Value: " + player.getHand().getValue() + ")");
            }
        }
        
        // Dealer's turn if player hasn't busted
        if (player.getHand().getValue() <= 21) {
            dealer.play();
            System.out.println("Dealer's cards: " + dealer.getHand().getCards() + " (Value: " + dealer.getHand().getValue() + ")");
        }
        
        declareWinner();
    }
    
    @Override
    public void declareWinner() {
        int playerValue = player.getHand().getValue();
        int dealerValue = dealer.getHand().getValue();
        int bet = player.getCurrentBet();
        
        System.out.println("\nYour hand value: " + playerValue);
        System.out.println("Dealer's hand value: " + dealerValue);
        
        if (playerValue > 21) {
            System.out.println("You busted! You lose " + bet + " chips.");
        } else if (dealerValue > 21) {
            System.out.println("Dealer busted! You win " + bet + " chips!");
            player.chips += bet * 2;
        } else if (playerValue > dealerValue) {
            System.out.println("You win " + bet + " chips!");
            player.chips += bet * 2;
        } else if (dealerValue > playerValue) {
            System.out.println("Dealer wins! You lose " + bet + " chips.");
        } else {
            System.out.println("It's a tie! Your bet is returned.");
            player.chips += bet;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        
        BlackjackGame game = new BlackjackGame(playerName);
        game.play();
        
        scanner.close();
    }
} 