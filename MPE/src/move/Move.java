package move;

import pgn.PGNMove;
import base.Case;
import base.Piece;

public class Move {
	
	private final Case from;
	private final Case to;
	private final boolean kingSideCastling;
	private final boolean queenSideCastling;
	private final Piece promotion;
	
	
	public Move(Case from,Case to,  boolean kingSideCastling, boolean queenSideCastling,Piece promotion){
		this.from=from;
		this.to=to;
		this.kingSideCastling=kingSideCastling;
		this.queenSideCastling=queenSideCastling;
		this.promotion=promotion;
	}
	
	public Case getTo() {
		return to;
	}
	
	public Case getfrom() {
		return from;
	}
	
	public boolean isKingSideCastling() {
		return kingSideCastling;
	}


	public boolean isQueenSideCastling() {
		return queenSideCastling;
	}
	
	public boolean isPromotion(){
		return promotion!=null;
	}
	
	public Piece getPromotion() {
		return promotion;
	}
	
	public static Move[] fromPGNMove(PGNMove[] moves){
		//TODO 
		
		return null;
	}
}
