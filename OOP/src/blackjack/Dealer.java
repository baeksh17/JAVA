package blackjack;

import java.util.LinkedList;
import java.util.List;

public class Dealer {

	private List<Card> cards;
	private static final int CAN_RECEIVE_POINT;

	public Dealer() {

		cards = new LinkedList<>();
	}

	public void receiveCard() {

		if(this.is)
	}

	public List<Card> openCard() {
		return null;
	}

	private boolean isReceiveCard() {

		return getPointSum() <= CAN_RECEIVE_POINT;
	}

	private int getPointSum() {
		int sum = 0;
		for(Card card : cards) {

			sum += card.getPoint();
		}
	}

}
