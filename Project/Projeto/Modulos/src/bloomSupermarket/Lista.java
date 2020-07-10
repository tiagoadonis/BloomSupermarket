package bloomSupermarket;
@SuppressWarnings("unused")

public class Lista<T extends Comparable<T>> {
	private No<T> first = null;
	private No<T> last = null;
	private int size = 0;
	
	public Lista() {}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void add(T e) {
		this.first = add(first, e);
		size++;
	}
	private No<T> add(No<T> n, T e){
		if (n == null || e.compareTo(n.elem) < 0) {
			return new No<T>(e, n);
		}
		n.next = add(n.next, e);
		return n;
	}
	
	public T get(int index) {
		return get(this.first, index);
	}
	private T get(No<T> n, int index) {
		if (index == 0) {
			return n.elem;
		}
		return get(n.next, --index);
	}
	
	public void insert (T e, int index) {
		insert(this.first, e, index);
	}
	private void insert(No<T> n, T e, int index) {
		if (index == 0) {
			n.elem = e;
		}
		else {
			insert(n.next, e, --index);
		}
	}
	
	public void remove(int index) {
		this.first = remove(this.first, index);
		size--;
	}
	private No<T> remove(No<T> n, int index) {
		if (index == 0) {
			return n.next;
		}
		n.next = remove(n.next, --index);
		if (n.next == null) {
			this.last = n;
		}
		return n;
	}
	
	public void remove(T e) {
		this.first = remove(this.first, e);
		size--;
	}
	private No<T> remove(No<T> n, T e) {
		if (n.elem.equals(e)) {
			return n.next;
		}
		n.next = remove(n.next, e);
		if (n.next == null) {
			this.last = n;
		}
		return n;
	}
	
	@SuppressWarnings("hiding")
	private class No<T> {
		private T elem;
		private No<T> next;
		
		private No(T e, No<T> n) {
			this.elem = e;
			this.next = n;
		}
		private No(T e) {
			this.elem = e;
			this.next = null;
		}
	}
}

