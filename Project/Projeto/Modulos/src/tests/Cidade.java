package tests;

import modulos.*;

public class Cidade implements Hashable{
	private String name;
	
	public Cidade(String nameArg) {
		this.name = nameArg;
	}

	@Override
	public int hashCode(int seed) {
		double toConc = Math.pow(seed, seed + 1);
		String toHash = name + toConc;
		return toHash.hashCode();
	}
	
}