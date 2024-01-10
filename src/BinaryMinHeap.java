import java.util.ArrayList;

public class BinaryMinHeap {
    private ArrayList<MinHeapNode> heap;

    public BinaryMinHeap() {
        this.heap = new ArrayList<>();
    }

    // Get parent index
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Get left child index
    private int leftChild(int i) {
        return (2 * i) + 1;
    }

    // Get right child index
    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    // Swap two nodes of the heap
    private void swap(int i, int j) {
        MinHeapNode temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Insert a new node
    public void insert(MinHeapNode node) {
        heap.add(node);
        int currentIndex = heap.size() - 1;

        while (currentIndex != 0) {
            int parentIndex = parent(currentIndex);
            MinHeapNode currentNode = heap.get(currentIndex);
            MinHeapNode parentNode = heap.get(parentIndex);

            if (parentNode.priority > currentNode.priority ||
                    (parentNode.priority == currentNode.priority &&
                            parentNode.timeOfReservation.isAfter(currentNode.timeOfReservation))) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }
    // Remove and return the minimum element from the heap
    public MinHeapNode extractMin() {
        if (heap.size() == 0) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        // Store the minimum value, and remove it from heap
        MinHeapNode root = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        heapify(0);

        return root;
    }

    // Heapify the node at index i
    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left < heap.size() && heap.get(left).priority < heap.get(smallest).priority)
            smallest = left;

        if (right < heap.size() && heap.get(right).priority < heap.get(smallest).priority)
            smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }
    // Peek at the minimum element without removing
    public MinHeapNode peek() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Get the size of the heap
    public int size() {
        return heap.size();
    }

    // Decrease the priority of a specific node
    public void decreaseKey(int patronID, int newPriority) {
        int index = -1;
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i).patronID == patronID) {
                index = i;
                heap.get(i).priority = newPriority;
                break;
            }
        }
        if (index != -1) {
            while (index != 0 && heap.get(parent(index)).priority > heap.get(index).priority) {
                swap(index, parent(index));
                index = parent(index);
            }
        }
    }

    // Remove a specific node from the heap
    public void remove(int patronID) {
        int index = -1;
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i).patronID == patronID) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            swap(index, heap.size() - 1);
            heap.remove(heap.size() - 1);
            heapify(index);
        }
    }

    // Get a list of all reservations
    public ArrayList<MinHeapNode> getAllReservations() {
        return new ArrayList<>(heap);
    }

    // Method to check if a particular patronID exists in the heap
    public boolean contains(int patronID) {
        for (MinHeapNode node : heap) {
            if (node.getPatronID()  == patronID) {
                return true;
            }
        }
        return false;
    }
}