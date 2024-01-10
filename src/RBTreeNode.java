
public class RBTreeNode {
    enum Color {
        RED, BLACK
    }

    // Node attributes
    int bookID;
    String bookName;
    String authorName;
    boolean availabilityStatus;
    String borrowedBy;
    BinaryMinHeap reservationHeap; // Assuming you have a BinaryMinHeap class for handling reservations
    RBTreeNode left, right, parent;
    Color color;

    // Constructor
    public RBTreeNode(int bookID, String bookName, String authorName) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.authorName = authorName;
        this.availabilityStatus = true; // Assuming new books are available by default
        this.borrowedBy = null;
        this.reservationHeap = new BinaryMinHeap(); // Initialize the reservation heap
        this.left = null;
        this.right = null;
        this.parent = null;
        this.color = Color.RED; // New nodes are red by default
    }

    // Getters and Setters for the node attributes
    public int getBookID() {
        return bookID;
    }
    public Color getColor() {
        return color;
    }

    public RBTreeNode getLeft() {
        return left;
    }

    public RBTreeNode getParent() {
        return parent;
    }

    public RBTreeNode getRight() {
        return right;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isAvailable() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(String borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public BinaryMinHeap getReservationHeap() {
        return reservationHeap;
    }

    public void setReservationHeap(BinaryMinHeap reservationHeap) {
        this.reservationHeap = reservationHeap;
    }


    // Additional methods for node functionality can be added as needed
}