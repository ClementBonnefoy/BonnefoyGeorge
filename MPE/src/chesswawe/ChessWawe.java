package chesswawe;

import move.Move;
import chesswawe.piece.AbstractChessWawePiece;
import chesswawe.piece.ChessWawePieceFactory;
import base.AdvancedBoard;
import base.Case;
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

	private AdvancedBoard board;

	public ChessWawe(){
		board=new AdvancedBoard(new ChessWawePieceFactory());	
	}


	public void playAMove(Move mv){
		board.playMove(mv);
	}

	public void createMidiFromPGN(String pgnFileName,String midiFileName){

		ChessWaweMidi md=new ChessWaweMidi();

		PGNParser parser=new PGNParser(pgnFileName);

		Move[] moves=null;

		try {
			moves=Move.fromPGNMove(PGNMove.getMoves(parser.parse()));
		} catch (InvalidMoveException e) {
			e.printStackTrace();
			System.exit(0);
		}

		int time=0;

		for(int i=0;i<moves.length;i++){

			playAMove(moves[i]);

			for(int j=0;j<plage.length;j++){
				for(Case c: plage[j]){
					if(!board.isEmpty(c)){
						md.addKey(time, (AbstractChessWawePiece)board.getSquare(c), c);
					}
				}

				time++;
			}
		}

		md.saveMidi(midiFileName);
	}



}
