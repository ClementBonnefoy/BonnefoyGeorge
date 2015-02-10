package base;

import java.util.ArrayList;
import static base.Piece.*;
import static base.Case.*;
import static base.Rank.*;

public class Board {

	ArrayList<Case> whiteSide = new ArrayList<>(16);
	ArrayList<Case> blackSide = new ArrayList<>(16);
	
	Case whiteKing = E1;
	Case blackKing = E8;
	

	Board (){
		super();

		A1.setPiece(R);
		B1.setPiece(N);
		C1.setPiece(B);
		D1.setPiece(Q);
		E1.setPiece(K);
		F1.setPiece(B);
		G1.setPiece(N);
		H1.setPiece(R);
		for (Case c : Rank2) {
			c.setPiece(P);
			whiteSide.add(c);
		}
		
		for (Case c : Rank1)
			whiteSide.add(c);

		A8.setPiece(r);
		B8.setPiece(n);
		C8.setPiece(b);
		D8.setPiece(q);
		E8.setPiece(k);
		F8.setPiece(b);
		G8.setPiece(n);
		H8.setPiece(r);
		for (Case c : Rank7) {
			c.setPiece(p);
			blackSide.add(c);
		}
		
		for (Case c : Rank8)
			blackSide.add(c);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
		
		Rank rank;
		
		for(int j = 7; j >= 0; j--) {
			rank = Rank.values()[j];
			for (Case c : rank)
				if (c.getPiece() == null)
					sb.append('.');
				else
					sb.append(c.getPiece());
			sb.append('\n');
		}
		return sb.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Board());
	}

}
