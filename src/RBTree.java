import java.time.LocalDateTime;

public class RBTree {

    private RBTreeNode root;

    // Constructor
    public RBTree() {
        this.root = null;
    }

    // Method to insert a new book
    public void insertBook(RBTreeNode newNode) {
        RBTreeNode y = null;
        RBTreeNode x = this.root;

        while (x != null) {
            y = x;
            if (newNode.bookID < x.bookID) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        newNode.parent = y;
        if (y == null) {
            root = newNode;
        } else if (newNode.bookID < y.bookID) {
            y.left = newNode;
        } else {
            y.right = newNode;
        }

        newNode.color = RBTreeNode.Color.RED;
        fixInsert(newNode);
    }

    // Method to fix the tree after insertion
    private void fixInsert(RBTreeNode k) {
        RBTreeNode u;
        while (k.parent != null && k.parent.color == RBTreeNode.Color.RED) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left; // uncle
                if (u != null && u.color == RBTreeNode.Color.RED) {
                    u.color = RBTreeNode.Color.BLACK;
                    k.parent.color = RBTreeNode.Color.BLACK;
                    k.parent.parent.color = RBTreeNode.Color.RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rotateRight(k);
                    }
                    k.parent.color = RBTreeNode.Color.BLACK;
                    k.parent.parent.color = RBTreeNode.Color.RED;
                    rotateLeft(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right; // uncle

                if (u != null && u.color == RBTreeNode.Color.RED) {
                    u.color = RBTreeNode.Color.BLACK;
                    k.parent.color = RBTreeNode.Color.BLACK;
                    k.parent.parent.color = RBTreeNode.Color.RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        rotateLeft(k);
                    }
                    k.parent.color = RBTreeNode.Color.BLACK;
                    k.parent.parent.color = RBTreeNode.Color.RED;
                    rotateRight(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = RBTreeNode.Color.BLACK;
    }

    // Method to perform a left rotation
    private void rotateLeft(RBTreeNode x) {
        RBTreeNode y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Method to perform a right rotation
    private void rotateRight(RBTreeNode x) {
        RBTreeNode y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }
    public  RBTreeNode getRoot(){
        return root;
    }

    public String borrowBook(int patronID, int bookID, int patronPriority) {
        RBTreeNode bookNode = findBook(bookID); // Method to find the book node

        if (bookNode == null) {
            return "Book with ID " + bookID + " not found.";
        }

        if (bookNode.isAvailable()) {
            // Book is available for borrowing
            bookNode.setAvailabilityStatus(false);
            bookNode.setBorrowedBy(Integer.toString(patronID));
            return "Book borrowed successfully.";
        } else {
            // Handle the case when the book is not available
            BinaryMinHeap reservationHeap = bookNode.getReservationHeap();

            if (reservationHeap.contains(patronID)) {
                // Check if the patron is next in line based on priority and reservation time
                MinHeapNode firstInLine = reservationHeap.peek();
                if (firstInLine != null && firstInLine.getPatronID() == patronID) {
                    reservationHeap.extractMin(); // Remove from reservation heap
                    bookNode.setBorrowedBy(Integer.toString(patronID));
                    return "Reservation found. Book borrowed successfully.";
                } else {
                    return "You have a reservation, but it's not your turn yet.";
                }
            } else {
                // Add the patron to the reservation heap if not already reserved
                reservationHeap.insert(new MinHeapNode(patronID, patronPriority, LocalDateTime.now()));
                return "Book is currently unavailable. Added to the reservation list.";
            }
        }
    }

    // Method to find a book by bookID
    public RBTreeNode findBook(int bookID) {
        return findBookRecursive(root, bookID);
    }

    // Helper method for recursive search
    private RBTreeNode findBookRecursive(RBTreeNode node, int bookID) {
        if (node == null || node.getBookID() == bookID) {
            return node;
        }

        if (bookID < node.getBookID()) {
            return findBookRecursive(node.getLeft(), bookID);
        } else {
            return findBookRecursive(node.getRight(), bookID);
        }
    }

}
