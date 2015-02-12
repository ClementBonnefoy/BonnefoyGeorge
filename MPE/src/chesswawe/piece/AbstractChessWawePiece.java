package chesswawe.piece;

import base.Case;
import base.Color;
import base.Piece;
import base.Rank;
import base.Type;
import base.interfaces.IAdvancedPiece;

public abstract class AbstractChessWawePiece implements IAdvancedPiece{
	
	protected Piece piece;
	private Case initialCase;
	
	public AbstractChessWawePiece (Piece piece,Case initialCase){
		super();
		this.piece=piece;
		this.initialCase=initialCase;
	}
	
	@Override
	public Piece getPiece(){
		return piece;
	}
	
	public Type getType(){
		return piece.getType();
	}
	
	
	public boolean isInitialCase(Case c){
		return c==initialCase;
	}
	
	public int keyOfRank(Rank rank){
		if(piece.getColor()==Color.BLACK){
			return keyOfRankForWhite(Rank.values()[7-rank.getNum()]);
		}
		return keyOfRankForWhite(rank);
	}

	protected abstract int keyOfRankForWhite(Rank rank);
	
	
	
	
	
	

}
