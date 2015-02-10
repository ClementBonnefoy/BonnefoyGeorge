package georgepoubelle;

import java.util.ArrayList;

/**
 * Classe permettant de representer une coordonnee echiqueenne d'un echiquier 8x8
 * @author clementgeorge
 *
 */
public class ChessCoordinate {

	/**
	 * attributs de classe:
	 * rank : numero de rangee
	 * column : numero de colonne (colonne A:1, B:2 , ... , H:8)
	 */
	private int column,rank;

	/**
	 * Constucteur d'une coordonnee echiqueenne, a partir de sa notation algebrique (ex: "A1" , "g8" ) 
	 * @param coordinate : String de la coordonnee 
	 * @throws Exception : renvoie une exception si la string n'est pas conforme a une coordonnee echiqueenne
	 */
	public ChessCoordinate(String coordinate) throws IllegalArgumentException{
		char letter=coordinate.charAt(0);
		int number=Integer.valueOf(String.valueOf(coordinate.charAt(1)));

		if(number<1 || number >8){
			throw new IllegalArgumentException("Coordinate Error: "+number+" is not a valid number for chess coordinates");
		}

		if(Character.isUpperCase(letter) && letter<'I'){
			this.column=letter-'A'+1;
			this.rank=number;
		}
		else if(Character.isLowerCase(letter) && letter<'i'){
			this.column=letter-'a'+1;
			this.rank=number;
		}
		else{
			throw new IllegalArgumentException("Coordinate Error: "+letter+" is not a valid letter for chess coordinates");
		}
	}
	
	private ChessCoordinate(int column,int rank){
		this.column=column;
		this.rank=rank;
	}


	/**
	 * renvoit le numero de colonne (renvoit 1 pour la colonne A, 8 pour la colonne H)
	 * @return
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * renvoit le numero de rangee
	 * @return
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	 * fonction statique qui renvoit l'ensemble des coordonnees d'une rangee donnee
	 * @param rank : le numero de rangee
	 * @return
	 */
	public static ArrayList<ChessCoordinate> coordinatesOfARank(int rank){
		ArrayList<ChessCoordinate> res=new ArrayList<ChessCoordinate>();
		for(int i=1;i<9;i++){
			res.add(new ChessCoordinate(i,rank));
		}
		return res;
	}
	
	/**
	 * fonction statique qui renvoit l'ensemble des coordonnees d'une colonne donnee
	 * @param column : le numero de colonne
	 * @return
	 */
	public static ArrayList<ChessCoordinate> coordinatesOfAColumn(String column) throws IllegalArgumentException{
		
		ArrayList<ChessCoordinate> res=new ArrayList<ChessCoordinate>();
		
		ChessCoordinate coord=new ChessCoordinate(column+"1");
		res.add(coord);
		for(int i=2;i<9;i++){
			res.add(new ChessCoordinate(coord.getColumn(),i));
		}
		return res;
	}
	
	boolean equals(ChessCoordinate c){
		return c.column==column && c.rank==rank;
	}
}
