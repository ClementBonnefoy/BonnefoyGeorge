package chesswawe.piece;

import base.Case;
import base.Piece;
import base.Rank;

public class BasicChessWawePiece extends AbstractChessWawePiece {

	private static int[] scale = 
		{ 64 , 66 , 69 , 69 , 71 , 73 , 76 , 78 , 81 }; //gamme pentatonique (chinese style!)

	public BasicChessWawePiece(Piece piece,Case initialCase) {
		super(piece,initialCase);
	}

	@Override
	protected int keyOfRankForWhite(Rank rank){
		return scale[rank.getNum()];
	}


}
