import java.util.Arrays;

public class Heap {
	private int[] items = new int[10];
	private int size = 0;

	public int[] getItems(){
		return items;
	}
	
	public void insert(int value){
		if(isFull()){
			throw new IllegalStateException();
		}
		items[size++] = value;
		bubbleUp();
	}

	public int remove(){
		if(isEmpty()){
			throw new IllegalStateException();
		}
		int root = items[0];
		items[0] = items[--size];
		bubbleDown();
		items[size] = 0;
		return root;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	private void bubbleDown(){
		int index = 0;
		while(index <= size && !isValidParent(index)){
			int largerChildIndex = largerChildIndex(index);
			swap(index, largerChildIndex);
			index = largerChildIndex;
		}
	}

	private boolean isValidParent(int index){
		if(!hasLeftChild(index)){
			return true;
		}
		boolean isValid = items[index] >= leftChild(index);
		if(hasRightChild(index)){
			isValid &= items[index] >= rightChild(index);
		}
		return isValid;
	}

	private int largerChildIndex(int index){
		if(!hasLeftChild(index)){
			return index;
		}
		if(!hasRightChild(index)){
			return leftChildIndex(index);
		}
		return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
	}

	private boolean hasLeftChild(int index){
		return leftChildIndex(index) <= size;
	}

	private boolean hasRightChild(int index){
		return rightChildIndex(index) <= size;
	}

	private int leftChild(int index){
		return items[leftChildIndex(index)];
	}

	private int rightChild(int index){
		return items[rightChildIndex(index)];
	}

	private int leftChildIndex(int index){
		return 2 * index + 1;
	}

	private int rightChildIndex(int index){
		return 2 * index + 2;
	}

	public boolean isFull(){
		return size == items.length;
	}

	public int getSize(){
		return size;
	}

	@Override
	public String toString(){
		return Arrays.toString(items);
	}

	private void bubbleUp(){
		int index = size - 1;
		while(index > 0 && items[index] > items[parent(index)]){
			swap(index, parent(index));
			index = parent(index);
		}
	}

	private int parent(int index){
		return (index - 1) / 2;
	}

	private void swap(int first, int second){
		items[first] = items[first] ^ items[second];
		items[second] = items[first] ^ items[second];
		items[first] = items[first] ^ items[second];
	}
}
