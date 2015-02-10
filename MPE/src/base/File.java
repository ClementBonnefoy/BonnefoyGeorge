package base;

import java.util.ArrayList;
import java.util.Iterator;

public enum File implements Iterable<Case> {	
	FileA, FileB, FileC, FileD, FileE, FileF, FileG, FileH;

	public int getNum() {
		return ordinal();
	}

	public static File getFile(int num) {
		return File.values()[num];
	}
	
	public static File getFile(char c) {
		return File.values()[c - 'a'];
	}

	public Case getCase(int num) {
		return Case.values()[(num << 3) + getNum()];
	}	
	
	@Override
	public Iterator<Case> iterator() {
		
		ArrayList<Case> cases = new ArrayList<>(8);
		
		for (int i = 0; i < 8; i++)
			cases.add(getCase(i));
		
		// TODO Auto-generated method stub
		return cases.iterator();
	}
	
	@Override
	public String toString() {
		return "" + super.toString().charAt(4);
	}

}

