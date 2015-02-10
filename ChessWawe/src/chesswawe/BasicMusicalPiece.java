package chesswawe;

import base.Case;
import base.Color;
import base.Piece;
import base.Rank;

public class BasicMusicalPiece extends AbtractMusicalPiece {

	private static int[] scale = 
		{ 64 , 66 , 69 , 69 , 71 , 73 , 76 , 78 , 81 }; //gamme pentatonique (chinese style!)

	public BasicMusicalPiece(Piece piece,Case initialCase) {
		super(piece,initialCase);
	}

	@Override
	public int keyOfRank(Rank rank){
		if(piece.getColor()==Color.BLACK){
			return keyOfRankForBlack(rank);
		}
		return keyOfRankForWhite(rank);
	}



	private int keyOfRankForBlack(Rank rank) {
		return scale[7-rank.getNum()];
	}

	private int keyOfRankForWhite(Rank rank){
		return scale[rank.getNum()];
	}


}
