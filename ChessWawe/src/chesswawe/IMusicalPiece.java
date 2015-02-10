package chesswawe;

import base.Case;
import base.Rank;
import base.Type;

public interface IMusicalPiece {
	
	public Type getType();
	public boolean isInitialCase(Case c);
	public int keyOfRank(Rank rank);

}
