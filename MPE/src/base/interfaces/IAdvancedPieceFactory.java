package base.interfaces;

import base.Case;
import base.Piece;

public interface IAdvancedPieceFactory {

	public IAdvancedPiece createPiece(Piece p,Case originSquare);
}
