package blackjack;

import java.util.LinkedList;
import java.util.List;

public class CardDeck {

	// 属性
	private List<Card> cards;
//
//	public Card getCard() {
//		return null;
//	}

	private static final String[] PATTERNS = {"spade","heart","diamond","club"};
	private static final int CARD_COUNT = 13;

	public CardDeck() {

		cards = this.generateCards();
	}

	private List<Card> generateCards() {

		List<Card> cards = new LinkedList<>();

		for(String pattern : PATTERNS) {
			for(int i = 1; i<=CARD_COUNT; i++) {
//				String denomination = this.numberToDenomination(i);
//				int point = this.nunmerToPoint(i);
				Card card = new Card(pattern, i);
				cards.add(card);
			}

		}


		return cards;
	}

//	private int nunmerToPoint(int number) {
//
//		if(number >= 11) {
//
//			return 10;
//		}
//
//		return number;
//
//	}

//	public String numberToDenomination(int number) {
//
//		if(number == 1) {
//			return "A";
//		} else if(number == 11) {
//			return "J";
//		} else if(number == 12) {
//			return "Q";
//		} else if(number == 13) {
//			return "K";
//		} else {
//			return String.valueOf(number);
//		}
//
//	}

	public Card draw() {

		Card selectedCard = getRandomCard();
		cards.remove(selectedCard);

		return selectedCard;
	}

	private Card getRandomCard() {

		int size = cards.size();
		int select = (int)(Math.random()*size);
		return cards.get(select);

	}


	@Override
	public String toString() {
		// TODO 自動生成されたメソッド・スタブ

		StringBuilder sb = new StringBuilder();

		for (Card card : cards) {
			sb.append(card.toString());
			sb.append("\n");

		}
		return sb.toString();
	}
}
