package bloomSupermarket;
@SuppressWarnings("unused")

public class Comparisson implements Comparable<Comparisson> {
	private Produto origProd;
	private Produto simProd;
	private double distance;
	
	public Comparisson(Produto prod1, Produto prod2, double distance) {
		this.origProd = prod1;
		this.simProd= prod2;
		this.distance = distance;
	}
	
	@Override
	public int compareTo(Comparisson other) {
		if (this.distance > other.distance) {
			return 1;
		}
		else if (this.distance < other.distance) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public Produto getSimProd() {
		return simProd;
	}
}
