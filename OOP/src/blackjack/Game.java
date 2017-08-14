package blackjack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

	private static final int INIT_RECEIVE_CARD_COUNT = 2;

	//TODO 文字列確認
	private static final String STOP_RECEIVE_CARD = "0";

	public void play() {
		System.out.println("★BlackJack Start★");
		Scanner sc = new Scanner(System.in);

		List<Player> players = Arrays.asList(new Gamer("ユーザー１"), new Dealer());
		Rule rule = new Rule();
		CardDeck cardDeck = new CardDeck();

		List<Player> players1 = Arrays.asList(new Gamer(), new Dealer());
		List<Player> initAfterPlayers = initPhase(cardDeck, players1);
		List<Player> playingAfterPlayers = playingCheck(sc, cardDeck, initAfterPlayers);

		Player winner = rule.getWinner(playingAfterPlayers);
		System.out.println("勝者は" + winner.getName());

	}

	private List<Player> playingCheck(Scanner sc, CardDeck cardDeck, List<Player> players) {

		List<Player> cardReceivedPlayers;

		while(true) {

			cardReceivedPlayers = receiveCardAllPlayer(sc, cardDeck, players);


			if(isAllPlayerTurnOff(cardReceivedPlayers)) {

				break;
			}
		}

		return cardReceivedPlayers;


	}

	private List<Player> receiveCardAllPlayer(Scanner sc, CardDeck cardDeck, List<Player> players) {

		for(Player player : players) {
			if(isReceiveCard(sc)) {

				Card card  = cardDeck.draw();
				player.receiveCard(card);
				player.turnOn();

			} else {

				player.turnOff();
			}
		}
		return players;
	}

	private boolean isAllPlayerTurnOff(List<Player> players) {
		for(Player player : players) {
			if(player.isTurn()) {
				return false;
			}
		}
		return true;
	}

	private boolean isReceiveCard (Scanner sc) {
		System.out.println("カードをDrawしますか。終了は０です");
		return !STOP_RECEIVE_CARD.equals(sc.nextLine());
	}

	private List<Player> initPhase(CardDeck cardDeck, List<Player> players) {

		System.out.println("最初は２枚のカードをDRAWします。");
		for(int i = 0; i < INIT_RECEIVE_CARD_COUNT; i++) {

			for (Player player : players) {
				Card card = cardDeck.draw();
				player.receiveCard(card);
			}

		}

		return players;

	}

}
