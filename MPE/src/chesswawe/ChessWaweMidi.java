package chesswawe;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

import chesswawe.piece.AbstractChessWawePiece;
import chesswawe.piece.BasicChessWawePiece;

import base.Case;
import base.Piece;


public class ChessWaweMidi {

	private Sequence sequence;
	private Track pawnsTrack,knightsTrack,kingsTrack,queensTrack,rooksTrack,bishopTrack;

	public ChessWaweMidi(){
		try {
			sequence=new Sequence(Sequence.PPQ,1);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
			System.exit(1);
		}
		pawnsTrack=sequence.createTrack();
		rooksTrack=sequence.createTrack();
		queensTrack=sequence.createTrack();
		bishopTrack=sequence.createTrack();
		kingsTrack=sequence.createTrack();
		knightsTrack=sequence.createTrack();
	}

	public void addKey(int time,AbstractChessWawePiece piece,Case c){

		if(piece.isInitialCase(c)) //si une piece est a sa case initiale, on ne fait aucun son
			return;

		Track t=null;

		switch(piece.getType()){
		case PAWN:
			t=pawnsTrack;
			break;
		case KNIGHT:
			t=knightsTrack;
			break;
		case BISHOP:
			t=bishopTrack;
			break;
		case ROOK:
			t=rooksTrack;
			break;
		case QUEEN:
			t=queensTrack;
			break;
		case KING:
			t=kingsTrack;
			break;
		}

		t.add(MidiTools.createNoteOnEvent(piece.keyOfRank(c.getRank()), time));
		t.add(MidiTools.createNoteOffEvent(piece.keyOfRank(c.getRank()), time+1));

	}

	public void saveMidi(String fileName){
		File outputFile = new File(fileName);

		try
		{
			MidiSystem.write(sequence, 0, outputFile);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args){
		ChessWaweMidi cwm=new ChessWaweMidi();


		cwm.addKey(0,new BasicChessWawePiece(Piece.b, Case.B1) , Case.A1);
		cwm.addKey(1,new BasicChessWawePiece(Piece.b, Case.B1) , Case.A1);
		cwm.addKey(2,new BasicChessWawePiece(Piece.b, Case.B1) , Case.A1);
		cwm.addKey(3,new BasicChessWawePiece(Piece.b, Case.B1) , Case.A1);


		cwm.saveMidi("test.mid");
	}
}
