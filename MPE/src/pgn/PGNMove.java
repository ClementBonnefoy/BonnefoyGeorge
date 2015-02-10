package pgn;

import base.Case;
import static base.Case.*;
import base.File;
import base.Rank;
import base.Piece;
import base.Type;
import static base.Piece.*;
import static base.Type.*;


public class PGNMove {

	private final Piece piece;
	private final Case to;
	private final Rank fromRank;
	private final File fromFile;
	private final Type promotion;
	private final boolean capture;
	private final boolean checkmate;
	private final boolean check;
	private final boolean queenSideCastling;
	private final boolean kingSideCastling;
	
	private PGNMove(Piece piece, Case to, Rank fromRank, File fromFile,
			Type promotion, boolean capture, boolean checkmate, boolean check,
			boolean queenSideCastling, boolean kingSideCastling) {
		super();
		this.piece = piece;
		this.to = to;
		this.fromRank = fromRank;
		this.fromFile = fromFile;
		this.promotion = promotion;
		this.capture = capture;
		this.checkmate = checkmate;
		this.check = check;
		this.queenSideCastling = queenSideCastling;
		this.kingSideCastling = kingSideCastling;
	}
	
	public Piece getPiece() {
		return piece;
	}
	public Case getTo() {
		return to;
	}
	public Rank getFromRank() {
		return fromRank;
	}
	public File getFromFile() {
		return fromFile;
	}
	public Type getPromotion() {
		return promotion;
	}

	public boolean isCapture() {
		return capture;
	}
	public boolean isCheckmate() {
		return checkmate;
	}
	public boolean isCheck() {
		return check;
	}
	public boolean isQueenSideCastling() {
		return queenSideCastling;
	}
	public boolean isKingSideCastling() {
		return kingSideCastling;
	}	
	
	public static PGNMove[] getMoves(String[] strings) {
		PGNMove[] moves = new PGNMove[strings.length];
		
		Piece piece;
		Case to;
		Rank rank;
		File file;
		boolean capture;
		boolean checkmate;
		boolean check;
		String current;
		
		for (int i = 0; i < strings.length; i++) {
			rank = null;
			file = null;
			capture = false;
			checkmate = false;
			check = false;
			current = strings[i];
			
			if (current.matches(".+\\+")) {
				check = true;
				current = current.substring(0,current.length()-1);
			}
			else if (current.matches(".+#")) {
				checkmate = true;
				current = current.substring(0,current.length()-1);
			}
			
			if (current.equals("O-O")) {
				piece = (i%2 == 0) ? K : k;
				to = (i%2 == 0) ? G1 : G8;
				moves[i] = new PGNMove(piece,to,null,null,null,false,checkmate,check,false,true);
				continue;
			}
			else if (current.equals("O-O-O")) {
				piece = (i%2 == 0) ? K : k;
				to = (i%2 == 0) ? C1 : C8;
				moves[i] = new PGNMove(piece,to,null,null,null,false,checkmate,check,true,false);
				continue;
			}
			
			switch (current.charAt(0)) {
			case 'K' : piece = (i%2 == 0) ? K : k; break;
			case 'Q' : piece = (i%2 == 0) ? Q : q; break;
			case 'R' : piece = (i%2 == 0) ? R : r; break;
			case 'N' : piece = (i%2 == 0) ? N : n; break;
			case 'B' : piece = (i%2 == 0) ? B : b; break;
			default : piece = (i%2 == 0) ? P : p;
				if (current.charAt(1) == 'x') {
					capture = true;
					file = File.getFile(current.charAt(0));
					current = current.substring(2);
				}
				
				to = Case.get(File.getFile(current.charAt(0)), Rank.getRank(current.charAt(1)));

				Type promotion = null;
				if (current.length() > 2)
					switch (current.charAt(3)) {
					case 'Q': promotion = QUEEN; break;
					case 'R': promotion = ROOK; break;
					case 'N': promotion = KNIGHT; break;
					case 'B': promotion = BISHOP; break;
					default: break;
					}
				
				moves[i] = new PGNMove(piece, to, null, file, promotion, capture, checkmate, check, false, false);
				continue;
			}
			
			char fileChar = current.charAt(current.length()-2);
			char rankChar = current.charAt(current.length()-1);
			to = Case.get(File.getFile(fileChar), Rank.getRank(rankChar));
			
			current = current.substring(1, current.length() - 2);
			
			// s'il y a prise et/ou desambiguisation
			switch (current.length()) {
			case 3: // double desambiguisation et prise
				capture = true;
				file = File.getFile(current.charAt(0));
				rank = Rank.getRank(current.charAt(1));
				break;
			case 2:
				if (current.charAt(1) == 'x')
					capture = true;
				else
					rank = Rank.getRank(current.charAt(1));
				if (Character.isDigit(current.charAt(0)))
					rank = Rank.getRank(current.charAt(0));
				else
					file = File.getFile(current.charAt(0));
				break;
			case 1:
				if (current.charAt(0) == 'x')
					capture = true;
				else if (Character.isDigit(current.charAt(0)))
					rank = Rank.getRank(current.charAt(0));
				else
					file = File.getFile(current.charAt(0));
				break;
			default: break;
					
			}
			
			moves[i] = new PGNMove(piece, to, rank, file, null, capture, checkmate, check, false, false);
			
		}
		
		return moves;
	}
		
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (kingSideCastling)
			sb.append("O-O");
		else if (queenSideCastling)
			sb.append("O-O-O");
		else if (piece == P || piece == p) {
			if (fromFile != null)
				sb.append(fromFile.toString().toLowerCase()+'x');
			sb.append(to.toString().toLowerCase());
			if (promotion != null) {
				sb.append('=');
				switch (promotion) {
				case QUEEN: sb.append('Q'); break;
				case ROOK: sb.append('R'); break;
				case KNIGHT: sb.append('N'); break;
				case BISHOP: sb.append('B'); break;
				default: break;
				}
			}
				
		}
		else {
			sb.append(piece.toString().toUpperCase());
			if (fromFile != null)
				sb.append(fromFile.toString().toLowerCase());
			if (fromRank != null)
				sb.append(fromRank.toString());
			if (capture)
				sb.append('x');
			sb.append(to.toString().toLowerCase());
		}
			
		
		if (check)
			sb.append('+');
		else if (checkmate)
			sb.append('#');
		
		return sb.toString();
	}
	
}
