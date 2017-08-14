package blackjack;

import java.util.LinkedList;
import java.util.List;

public class Dealer implements Player {

	private List<Card> cards;
	private static final int CAN_RECEIVE_POINT = 16;
	private boolean turn;
	private static final String NAME = "ディーラー";

	public Dealer() {

		cards = new LinkedList<>();
	}

	public void receiveCard(Card card) {

		if(this.isReceiveCard()) {

			this.cards.add(card);
			this.showCards();

		} else {

			System.out.println("カードの総合計が１７以上です。それ以上カードを受け入れでいません。");

		}

	}

	public void showCards() {
		StringBuilder sb = new StringBuilder();
		sb.append("現在のカードの一覧\n");
		for(Card card : cards) {
			sb.append(card.toString());
			sb.append("\n"); } System.out.println(sb.toString());
		}



	public List<Card> openCard() {
		return this.cards;
	}

	private boolean isReceiveCard() {

		boolean boo;

		if(getPointSum() <= CAN_RECEIVE_POINT) {

			boo = true;
		} else {

			boo = false;
		}

		return boo;
	}

	private int getPointSum() {
		int sum = 0;
		for(Card card : cards) {

			sum += card.getPoint();
		}

		return sum;
	}

	@Override
	public void showCard() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public List<Card> openCards() {
		// TODO 自動生成されたメソッド・スタブ
		return this.cards;
	}

	@Override
	public void turnOff() {
		this.setTurn(false);
	}

	@Override
	public void turnOn() {
		this.setTurn(true);
	}

	@Override
	public boolean isTurn() {
		return this.turn;
	}

	@Override
	public String getName() {
		return NAME;
	}

	private void setTurn(boolean turn) {
		this.turn = turn;
	}


}
