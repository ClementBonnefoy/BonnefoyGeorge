package chesswawe.piece;

import base.Case;
import base.Piece;
import base.Rank;

public class DrumMusicalPiece extends AbstractMusicalPiece {

	private static int[] scale = 
		{ 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 };
	
	public DrumMusicalPiece(Piece piece, Case initialCase) {
		super(piece, initialCase);
	}

	@Override
	protected int keyOfRankForWhite(Rank rank) {
		return(scale[rank.getNum()]);
	}

}
