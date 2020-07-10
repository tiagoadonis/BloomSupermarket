package modulos;

public class CountFilter <E extends Hashable> {
	private int m; 			// S as being the Set -> |S| = n
	private int n;			// B the Bloom Filter -> |B| = m
	private int k;			// k independent hash functions
	private int[] filter;
	private int elements = 0;
	private double p = 0.01;
	
	public CountFilter(int n) {
		this.n = n;
		m = (int)Math.round((-n * Math.log(p)) / Math.pow(Math.log(2),2)); 
		filter = new int[m];
		k = (int)((m/n)*Math.log(2));
	}
	
	public void insert(E value) {
		for (int i = 0; i < k; i++) {
			filter[Math.abs(value.hashCode(i) % m)]++;
		}
		elements++;
	}
	
	public boolean isMember(E value) {
		int count = 0;
		for(int i = 0; i < k; i++) {
			if (filter[Math.abs(value.hashCode(i) % m)] != 0) {
				count++;
			}
		}
		return count == k;
	}
	
	public void delete(E value) {
		for(int i = 0; i < k; i++) {
			if(filter[Math.abs(value.hashCode(i) % m)] > 0) {
				filter[Math.abs(value.hashCode(i) % n)]--;
			}
		}
		elements--;
	}
	
	public int count(E value) {
		if(!isMember(value)) {
			return 0;
		}
		int aux = filter[Math.abs(value.hashCode(0) % m)];
		for (int i = 0; i < k; i++) {
			if (filter[Math.abs(value.hashCode(i) % n)] < aux) {
				aux = filter[Math.abs(value.hashCode(i) % m)];
			}
		}
		return aux;
	}
	
	public int size() {
		return elements;
	}
	
	@Override
	public String toString() {
		return "Counting Filter\nSize of filter: "+ m +"\nNumber of set members: "+ n +
				"\\nNumber of Hash Functions: "+ k +"\nElements Added: " + elements;
	}
}
