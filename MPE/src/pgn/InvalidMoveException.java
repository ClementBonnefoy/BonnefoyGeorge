package pgn;

public class InvalidMoveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7183685649656549751L;

	public InvalidMoveException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidMoveException(String message) {
		super("This move is not valid : "+message);
		// TODO Auto-generated constructor stub
	}

	
	
}
