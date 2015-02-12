package base;
import static base.Case.*;
import static base.Piece.*;

import java.util.ArrayList;
import move.Move;

import base.interfaces.IAdvancedPiece;
import base.interfaces.IAdvancedPieceFactory;



/**
 * Classe representant un echiquier 8x8 de pieces de type IAdvancedPiece
 * @author clementgeorge
 */
public class AdvancedBoard {

	private ArrayList<ArrayList<IAdvancedPiece>> board;
	private IAdvancedPieceFactory fact;

	/**
	 * constructeur par defaut: construit un echiquier 8x8 vide
	 */
	private AdvancedBoard(){

		board = new ArrayList<ArrayList<IAdvancedPiece>>();

		for(int i=0;i<8;i++){
			board.add(new ArrayList<IAdvancedPiece>());
			for(int j=0;j<8;j++){
				board.get(i).add(null);
			}
		}
	}
	
	/**
	 * constructeur par factory, construit un echiquier 8x8 ou chaque piece est a sa place
	 * @param fact: une IAdvancedFactory
	 */
	public AdvancedBoard(IAdvancedPieceFactory fact){
		this();
		this.fact=fact;
		setSquare(A1, fact.createPiece(R,A1));
		setSquare(B1, fact.createPiece(N,B1));
		setSquare(C1, fact.createPiece(B,C1));
		setSquare(D1, fact.createPiece(Q,D1));
		setSquare(E1, fact.createPiece(K,E1));
		setSquare(F1, fact.createPiece(B,F1));
		setSquare(G1, fact.createPiece(N,G1));
		setSquare(H1, fact.createPiece(R,H1));
		
		setSquare(A2, fact.createPiece(P,A2));
		setSquare(B2, fact.createPiece(P,B2));
		setSquare(C2, fact.createPiece(P,C2));
		setSquare(D2, fact.createPiece(P,D2));
		setSquare(E2, fact.createPiece(P,E2));
		setSquare(F2, fact.createPiece(P,F2));
		setSquare(G2, fact.createPiece(P,G2));
		setSquare(H2, fact.createPiece(P,H2));
		
		setSquare(A8, fact.createPiece(r,A8));
		setSquare(B8, fact.createPiece(n,B8));
		setSquare(C8, fact.createPiece(b,C8));
		setSquare(D8, fact.createPiece(q,D8));
		setSquare(E8, fact.createPiece(k,E8));
		setSquare(F8, fact.createPiece(b,F8));
		setSquare(G8, fact.createPiece(n,G8));
		setSquare(H8, fact.createPiece(r,H8));
		
		setSquare(A7, fact.createPiece(p,A7));
		setSquare(B7, fact.createPiece(p,B7));
		setSquare(C7, fact.createPiece(p,C7));
		setSquare(D7, fact.createPiece(p,D7));
		setSquare(E7, fact.createPiece(p,E7));
		setSquare(F7, fact.createPiece(p,F7));
		setSquare(G7, fact.createPiece(p,G7));
		setSquare(H7, fact.createPiece(p,H7));
		
		
	}

	/**
	 * retourne le contenu de la case de coordonnee passee en parametre
	 * @param coordinate : la coordonnee
	 * @return
	 */
	public IAdvancedPiece getSquare(Case coordinate){
		return board.get(coordinate.getFile().getNum()).get(coordinate.getRank().getNum());
	}
	
	/**
	 * modifie le contenu de la case de coordonnee 'coordinate' en la valeur 'val' 
	 * @param coordinate
	 * @param val
	 */
	public void setSquare(Case coordinate,IAdvancedPiece val){
		board.get(coordinate.getFile().getNum()).set(coordinate.getRank().getNum(), val);
	}
	
	/**
	 * deplace, sans verifications, une piece de la Case 'from' a la Case 'to'.
	 * @param from
	 * @param to
	 */
	public void move(Case from,Case to){
		setSquare(to, getSquare(from));
		setSquare(from,null);
	}
	
	/**
	 * verifie qu'une case est vide (ne contient aucune piece)
	 * @param coordinate : La coordonnee echiqueenne de la case
	 * @return
	 */
	public boolean isEmpty(Case coordinate){
		return this.getSquare(coordinate)==null;
	}
	
	/**
	 * joue un (demi) coup sur le plateau, sans aucune vérification
	 * @param mv : le coup a jouer
	 */
	public void playMove(Move mv){
		if(mv.isKingSideCastling()){ //petit rocque
			if(mv.getTo()==G1){
				move(E1,G1);
				move(H1,F1);
			}
			else if(mv.getTo()==G8){
				move(E8,G8);
				move(H8,F8);
			}
			return;
		}
		if(mv.isQueenSideCastling()){ //grand rocque
			if(mv.getTo()==C1){
				move(E1,C1);
				move(A1,D1);
			}
			else if(mv.getTo()==C8){
				move(E8,C8);
				move(A8,D8);
			}
			return;
		}
		
		move(mv.getfrom(),mv.getTo()); //tout autre deplacement
		
		
		if(mv.isPromotion()){ //en cas de promotion
			setSquare(mv.getTo(),fact.createPiece(mv.getPromotion(),null));
		}
		
	}

	@Override
	public String toString() {
		String res="";
		for(int i=7;i>=0;i--){
			Rank r=Rank.getRank(i);
			for(int j=0;j<8;j++){
				IAdvancedPiece piece=this.getSquare(r.getCase(j));
				if(piece!=null)
					res+=piece.getPiece().toString();
				res+="\t";
			}
			res+="\n";
		}
		return res;
	}
	
	/*public static void main(String[] args){
		AdvancedBoard b=new AdvancedBoard(new ChessWawePieceFactory());
		
		b.playMove(new Move(null,C8,false,true,null));
		System.out.println(b.toString());
	}*/
	
	


}
