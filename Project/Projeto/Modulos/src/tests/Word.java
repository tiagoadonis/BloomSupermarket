package tests;

import modulos.*;

public class Word implements Hashable{
	
	private String word;
	
	public Word(String word) {
		this.word = word;
	}
	
	@Override
	public int hashCode(int seed) {
		double toConc = Math.pow(seed, seed + 1);
		String toHash = word + toConc;
		return toHash.hashCode();
	}
	
	@Override
	public String toString() {
		return this.word;
	}

}
