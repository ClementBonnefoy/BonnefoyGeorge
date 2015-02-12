package chesswawe.piece;

import base.Case;
import base.Piece;
import base.interfaces.IAdvancedPiece;
import base.interfaces.IAdvancedPieceFactory;

public class ChessWawePieceFactory implements IAdvancedPieceFactory{
	
	
	public ChessWawePieceFactory(){
		super();
	}
	
	
	@Override
	public IAdvancedPiece createPiece(Piece p,Case c){
		switch(p){
		case P:
		case p:
			return new DrumMusicalPiece(p, c);
		default:
			return new BasicChessWawePiece(p, c);
		}
	}

}
