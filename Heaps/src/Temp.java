public class Temp {
	static void heapify(int[] arr) {
		int len = arr.length;
		int lastParentIndex = len / 2 - 1;
		for (int i = lastParentIndex; i >= 0; i--) {
			int index = i;
			while (index < len && !isValidParent(arr, index)) {
				int largerChildIndex = getLargerChildIndex(arr, index);
				swap(arr, index, largerChildIndex);
				index = largerChildIndex;
			}
		}
	}

	private static boolean isValidParent(int[] arr, int index) {
		if (!hasLeftChild(arr, index)) {
			return true;
		}
		if (!hasRightChild(arr, index)) {
			return arr[index] >= leftChild(arr, index);
		}
		return arr[index] >= leftChild(arr, index) && arr[index] >= rightChild(arr, index);
	}

	private static boolean hasLeftChild(int[] arr, int index) {
		return leftChildIndex(arr, index) < arr.length;
	}

	private static boolean hasRightChild(int[] arr, int index) {
		return rightChildIndex(arr, index) < arr.length;
	}

	private static void swap(int[] arr, int first, int second) {
		arr[first] = arr[first] ^ arr[second];
		arr[second] = arr[first] ^ arr[second];
		arr[first] = arr[first] ^ arr[second];
	}

	private static int getLargerChildIndex(int[] arr, int index) {
		if (!hasRightChild(arr, index)) {
			return leftChildIndex(arr, index);
		}
		return (leftChild(arr, index) > rightChild(arr, index)) ? leftChildIndex(arr, index) : rightChildIndex(arr, index);
	}

	private static int leftChild(int[] arr, int index) {
		return arr[leftChildIndex(arr, index)];
	}

	private static int rightChild(int[] arr, int index) {
		return arr[rightChildIndex(arr, index)];
	}

	private static int leftChildIndex(int[] arr, int index) {
		return 2 * index + 1;
	}

	private static int rightChildIndex(int[] arr, int index) {
		return 2 * index + 2;
	}
}
