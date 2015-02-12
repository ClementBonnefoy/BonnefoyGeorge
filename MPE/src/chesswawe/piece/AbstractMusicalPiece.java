package chesswawe.piece;

import base.Case;
import base.Color;
import base.Piece;
import base.Rank;
import base.Type;

public abstract class AbstractMusicalPiece{
	
	protected Piece piece;
	private Case initialCase;
	
	public AbstractMusicalPiece (Piece piece,Case initialCase){
		super();
		this.piece=piece;
		this.initialCase=initialCase;
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
