package chesswawe.piece;

import base.Case;
import base.Piece;
import base.Rank;

public class BasicMusicalPiece extends AbstractMusicalPiece {

	private static int[] scale = 
		{ 64 , 66 , 69 , 69 , 71 , 73 , 76 , 78 , 81 }; //gamme pentatonique (chinese style!)

	public BasicMusicalPiece(Piece piece,Case initialCase) {
		super(piece,initialCase);
	}

	@Override
	protected int keyOfRankForWhite(Rank rank){
		return scale[rank.getNum()];
	}


}
