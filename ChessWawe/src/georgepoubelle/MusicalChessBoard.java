package georgepoubelle;
import java.io.File;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

import bonnefoygeorge.pstl.chesswawe.AbstractChessBoard;


public class MusicalChessBoard {

	AbstractChessBoard<Piece> board;

	public MusicalChessBoard(){

		board=new AbstractChessBoard<Piece>();

		try{

			//blancs
			board.setSquare("A1", Piece.Rook);
			board.setSquare("A2", Piece.Pawn);
			board.setSquare("B1", Piece.Knight);
			board.setSquare("B2", Piece.Pawn);
			board.setSquare("C1", Piece.Bishop);
			board.setSquare("C2", Piece.Pawn);
			board.setSquare("D1", Piece.Queen);
			board.setSquare("D2", Piece.Pawn);
			board.setSquare("E1", Piece.King);
			board.setSquare("E2", Piece.Pawn);
			board.setSquare("F1", Piece.Bishop);
			board.setSquare("F2", Piece.Pawn);
			board.setSquare("G1", Piece.Knight);
			board.setSquare("G2", Piece.Pawn);
			board.setSquare("H1", Piece.Rook);
			board.setSquare("H2", Piece.Pawn);

			//noirs
			board.setSquare("a8", Piece.Rook);
			board.setSquare("a7", Piece.Pawn);
			board.setSquare("b8", Piece.Knight);
			board.setSquare("b7", Piece.Pawn);
			board.setSquare("c8", Piece.Bishop);
			board.setSquare("c7", Piece.Pawn);
			board.setSquare("d8", Piece.Queen);
			board.setSquare("d7", Piece.Pawn);
			board.setSquare("e8", Piece.King);
			board.setSquare("e7", Piece.Pawn);
			board.setSquare("f8", Piece.Bishop);
			board.setSquare("f7", Piece.Pawn);
			board.setSquare("g8", Piece.Knight);
			board.setSquare("g7", Piece.Pawn);
			board.setSquare("h8", Piece.Rook);
			board.setSquare("h7", Piece.Pawn);

		}catch(Exception e){
			e.printStackTrace();

		}
	}

	public void generate8BeatsMidiFile(String fileName){
		File outputFile = new File(fileName);
		Sequence	sequence = null;
		try
		{
			sequence = new Sequence(Sequence.PPQ, 1);
		}
		catch (InvalidMidiDataException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		
		Track	track = sequence.createTrack();
		track.add()
	}
}

}
