package chesswawe;

import base.Case;
import base.Piece;
import base.Type;

public abstract class AbtractMusicalPiece implements IMusicalPiece{
	
	protected Piece piece;
	private Case initialCase;
	
	public AbtractMusicalPiece (Piece piece,Case initialCase){
		super();
		this.piece=piece;
		this.initialCase=initialCase;
	}
	
	@Override 
	public Type getType(){
		return piece.getType();
	}
	
	@Override
	public boolean isInitialCase(Case c){
		return c==initialCase;
	}
	
	
	
	
	
	

}
