package chesswawe.piece;

import base.Case;
import base.Piece;

public class MusicalPieceFactory {
	
	public static AbstractMusicalPiece createFromPiece(Piece p,Case c){
		switch(p){
		case P:
		case p:
			return new DrumMusicalPiece(p, c);
		default:
			return new BasicMusicalPiece(p, c);
		}
	}

}
