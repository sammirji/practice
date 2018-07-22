package my.practice.trees;

public class MinHeap {

	private int[] heap;
	private int maxSize;
	private int size;

	private static final int front = 1;

	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		this.heap = new int[this.maxSize + 1];
		this.heap[0] = Integer.MIN_VALUE;
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private boolean isLeaf(int pos) {
		return (pos > (size / 2) && pos <= size) ? true : false;
	}

	private void swap(int fpos, int spos) {
		int temp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = temp;
	}

	public void insert(int data) {
		this.heap[++size] = data;
		int current = size;

		while (this.heap[current] < this.heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void print() {
		for (int i = 1; i <= (size / 2); i++) {
			System.out.println("Parent: " + this.heap[i] + ", leftChild: " + this.heap[2 * i] + ", rightChild: "
					+ this.heap[(2 * i) + 1]);
		}
	}

	private void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (this.heap[pos] > this.heap[leftChild(pos)] || this.heap[pos] > this.heap[rightChild(pos)]) {
				if (this.heap[leftChild(pos)] < this.heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}

	public void minHeap() {
		for (int i = (size / 2); i >= 1; i--) {
			minHeapify(i);
		}
	}

	public int remove() {
		int popped = this.heap[front];
		this.heap[front] = this.heap[size--];
		minHeapify(front);
		return popped;
	}

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(15);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);
		minHeap.minHeap();

		minHeap.print();
		System.out.println("The Min val is " + minHeap.remove());
	}

}
