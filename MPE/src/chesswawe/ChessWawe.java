package chesswawe;

import chesswawe.piece.AbstractMusicalPiece;
import chesswawe.piece.MusicalPieceFactory;
import base.AbstractChessBoard;
import base.Case;
import static base.Piece.*;
import static base.Case.*;
import pgn.InvalidMoveException;
import pgn.PGNMove;
import pgn.PGNParser;

public class ChessWawe {
	
	private static Case[][] plage = 
		{ { A1 , A2 , A3 , A4 } ,	{ B1 , B2 , B3 , B4 } ,	{ C1 , C2 , C3 , C4 } ,	{ D1 , D2 , D3 , D4 } ,
		 { E1 , E2 , E3 , E4 } ,	{ F1 , F2 , F3 , F4 } ,	{ G1 , G2 , G3 , G4 } ,	{ H1 , H2 , H3 , H4 } ,
		 { A5 , A6 , A7 , A8 } ,	{ B5 , B6 , B7 , B8 } ,	{ C5 , C6 , C7 , C8 } ,	{ D5 , D6 , D7 , D8 } ,
		 { E5 , E6 , E7 , E8 } ,	{ F5 , F6 , F7 , F8 } ,	{ G5 , G6 , G7 , G8 } ,	{ H5 , H6 , H7 , H8 }
		};

	private AbstractChessBoard<AbstractMusicalPiece> board;

	public ChessWawe(){
		board=new AbstractChessBoard<AbstractMusicalPiece>();
		
		board.setSquare(A1, MusicalPieceFactory.createFromPiece(R, A1));
		board.setSquare(B1, MusicalPieceFactory.createFromPiece(N, B1));
		board.setSquare(C1, MusicalPieceFactory.createFromPiece(B, C1));
		board.setSquare(D1, MusicalPieceFactory.createFromPiece(Q, D1));
		board.setSquare(E1, MusicalPieceFactory.createFromPiece(K, E1));
		board.setSquare(F1, MusicalPieceFactory.createFromPiece(B, F1));
		board.setSquare(G1, MusicalPieceFactory.createFromPiece(N, G1));
		board.setSquare(H1, MusicalPieceFactory.createFromPiece(R, H1));
		
		board.setSquare(A2, MusicalPieceFactory.createFromPiece(P, A2));
		board.setSquare(B2, MusicalPieceFactory.createFromPiece(P, B2));
		board.setSquare(C2, MusicalPieceFactory.createFromPiece(P, C2));
		board.setSquare(D2, MusicalPieceFactory.createFromPiece(P, D2));
		board.setSquare(E2, MusicalPieceFactory.createFromPiece(P, E2));
		board.setSquare(F2, MusicalPieceFactory.createFromPiece(P, F2));
		board.setSquare(G2, MusicalPieceFactory.createFromPiece(P, G2));
		board.setSquare(H2, MusicalPieceFactory.createFromPiece(P, H2));
		
		board.setSquare(A8, MusicalPieceFactory.createFromPiece(r, A8));
		board.setSquare(B8, MusicalPieceFactory.createFromPiece(n, B8));
		board.setSquare(C8, MusicalPieceFactory.createFromPiece(b, C8));
		board.setSquare(D8, MusicalPieceFactory.createFromPiece(q, D8));
		board.setSquare(E8, MusicalPieceFactory.createFromPiece(k, E8));
		board.setSquare(F8, MusicalPieceFactory.createFromPiece(b, F8));
		board.setSquare(G8, MusicalPieceFactory.createFromPiece(n, G8));
		board.setSquare(H8, MusicalPieceFactory.createFromPiece(r, H8));
		
		board.setSquare(A7, MusicalPieceFactory.createFromPiece(p, A7));
		board.setSquare(B7, MusicalPieceFactory.createFromPiece(p, B7));
		board.setSquare(C7, MusicalPieceFactory.createFromPiece(p, C7));
		board.setSquare(D7, MusicalPieceFactory.createFromPiece(p, D7));
		board.setSquare(E7, MusicalPieceFactory.createFromPiece(p, E7));
		board.setSquare(F7, MusicalPieceFactory.createFromPiece(p, F7));
		board.setSquare(G7, MusicalPieceFactory.createFromPiece(p, G7));
		board.setSquare(H7, MusicalPieceFactory.createFromPiece(p, H7));
		
		
	}
	
	public void playAMove(PGNMove mv){
		//a completer
	}
	
	public void createMidiFromPGN(String pgnFileName,String midiFileName){
		
		ChessWaweMidi md=new ChessWaweMidi();
		
		PGNParser parser=new PGNParser(pgnFileName);
		
		PGNMove[] moves=null;
		
		try {
			moves=PGNMove.getMoves(parser.parse());
		} catch (InvalidMoveException e) {
			e.printStackTrace();
		}
		
		int time=0;
		
		for(int i=0;i<moves.length;i++){
			
			playAMove(moves[i]);
			
			for(int j=0;j<plage.length;j++){
				for(Case c: plage[j]){
					if(!board.isEmpty(c)){
						md.addKey(time, board.getSquare(c), c);
					}
				}
				
				time++;
			}
		}
		
		md.saveMidi(midiFileName);
		
		
	}
	
	

}
