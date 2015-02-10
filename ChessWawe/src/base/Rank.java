package base;

import java.util.EnumSet;
import java.util.Iterator;

public enum Rank implements Iterable<Case>{
	Rank1, Rank2, Rank3, Rank4, Rank5, Rank6, Rank7, Rank8;

	public int getNum() {
		return ordinal();
	}

	public static Rank getRank(int num) {
		return Rank.values()[num];
	}
	
	public static Rank getRank(char c) {
		return Rank.values()[c - '1'];
	}
	
	public Case getCase(int num) {
		return Case.values()[(getNum() << 3) + num];
	}

	@Override
	public Iterator<Case> iterator() {
		// TODO Auto-generated method stub
		return EnumSet.range(getCase(0), getCase(7)).iterator();
	}

	@Override
	public String toString() {
		return "" + super.toString().charAt(4);
	}

}
