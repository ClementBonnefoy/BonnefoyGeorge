package pgn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PGNParser {

	private String game = "";

	public PGNParser(String filename) {
		this(new File(filename));
	}

	public PGNParser(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			StringBuilder sb = new StringBuilder();
			String line = "";

			while (line.length() == 0 || line.charAt(0) != '1')
				line = br.readLine();

			while (line != null) {
				line = line.replace(";.*", "");

				sb.append(line + ' ');
				line = br.readLine();
			}

			game = sb.toString();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String[] parse() throws InvalidMoveException {

		// suppression commentaires et variations
		game = game.replaceAll("\\{[^}]*\\}|\\([^)]*\\)","");
		// suppression des espaces et points en double
		game = game.replaceAll("\\s+", " ").replaceAll("\\.\\.+", ".");
		// insertion d'un espace après le numéro de coup s'il manque
		game = game.replaceAll("\\.([^ ])","\\. $1");
		// on ne garde que les coups, séparés par des espaces (plus de "e.p.")
		game = game.replaceFirst("1. ","").replaceAll(" ([^KQRNBa-hO][^ ]* )+"," ");
		
		String[] moves = game.split(" ");

		String moveRegex =
						"([KQRNB][a-h]?[1-8]?x?[a-h][1-8]|"+
						"([a-h]x)?[a-h][1-8](=[QRBN])?|"+
						"O-O(-O)?)"+
						"[+#]?";
		
		for (String s : moves)
			if (!s.matches(moveRegex))
				throw new InvalidMoveException(s);
		
		return moves;

	}

	public static void main (String[] args) {

		for (File f : new File("games").listFiles()) {
			PGNParser pgn = new PGNParser(f);

			System.out.println(pgn.game);

			try {
				String[] moves = pgn.parse();
				PGNMove[] pgnmoves = PGNMove.getMoves(moves);
				System.out.println(Arrays.toString(moves));
				System.out.println(Arrays.toString(pgnmoves));
				
				String[] moves2 = new String[moves.length];
				for (int i = 0; i < moves.length; i++)
					moves2[i] = pgnmoves[i].toString();
				System.out.println(Arrays.equals(moves, moves2));
				
				System.out.println();

				
			} catch (InvalidMoveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}


}
