package base;

public enum Piece {

	K (Color.WHITE, Type.KING),
	Q (Color.WHITE, Type.QUEEN),
	R (Color.WHITE, Type.ROOK),
	N (Color.WHITE, Type.KNIGHT),
	B (Color.WHITE, Type.BISHOP),
	P (Color.WHITE, Type.PAWN),
	k (Color.BLACK, Type.KING),
	q (Color.BLACK, Type.QUEEN),
	r (Color.BLACK, Type.ROOK),
	n (Color.BLACK, Type.KNIGHT),
	b (Color.BLACK, Type.BISHOP),
	p (Color.BLACK, Type.PAWN);

	private final Color color;
	private final Type type;

	private Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
	}

	public Color getColor() {
		return color;
	}

	public Type getType() {
		return type;
	}
}

