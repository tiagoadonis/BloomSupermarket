package modulos;

import java.util.*;

public class MinHashing {
	private int[] minHash;
	
	public MinHashing (List<String> list, int hf) {		// hf - number of Hash Functions
		minHash = new int[hf];
		for(int i = 0; i < hf; i++) {
			int min = list.size() * 1000 + 1;
			for(int j = 0; j < list.size(); j++) {
				double toConcatenate = Math.pow(i, (i+1));
				String toHash = list.get(j) + toConcatenate;
				int hashValue = Math.abs(toHash.hashCode() % (list.size() * 1000));
				if (hashValue < min) {
					min = hashValue;
				}
			}
			minHash[i] = min;
 		}
	}
	
	public static double getSimilarity(MinHashing x, MinHashing y) {
		if (x.minHash.length != y.minHash.length) {
			System.out.println(" Sets must have the same size!!!");
			return 0;
		}
		int length = x.minHash.length;
		double intersect = 0;
		for (int i = 0; i < length; i++) {
			if (x.minHash[i] == y.minHash[i]) {
				intersect++;
			}
		}
		return intersect/length;  // Jaccard's index
	}
}
