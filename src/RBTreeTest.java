

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RBTreeTest {
    public static void main(String[] args) {
        RBTree myLibrary = new RBTree();

        // Inserting a book into the library
        myLibrary.insertBook(new RBTreeNode(101, "The Great Gatsby", "F. Scott Fitzgerald"));

        // Simulating a situation where the book is borrowed
        myLibrary.borrowBook(300, 101, 1); // Patron 300 borrows the book

        // Access the book node using findBook method
        RBTreeNode bookNode = myLibrary.findBook(101);
        if (bookNode != null) {
            // Adding reservations with the same priority but different times
            LocalDateTime now = LocalDateTime.now();
            bookNode.getReservationHeap().insert(new MinHeapNode(201, 2, now.minus(2, ChronoUnit.HOURS))); // Earlier
            bookNode.getReservationHeap().insert(new MinHeapNode(202, 2, now.minus(1, ChronoUnit.HOURS))); // Later

            // Now, attempting to borrow the book by different patrons
            System.out.println("Attempt by Patron 202: " + myLibrary.borrowBook(202, 101, 2)); // Should be denied
            System.out.println("Attempt by Patron 201: " + myLibrary.borrowBook(201, 101, 2)); // Should be successful
        } else {
            System.out.println("Book not found in the library.");
        }

        // Display the tree after borrowing attempts
        System.out.println("\nTree after borrowing attempts:");
        displayTree(myLibrary.getRoot());
    }

    // Method to display the tree
    public static void displayTree(RBTreeNode node) {
        if (node != null) {
            displayTree(node.getLeft());
            System.out.println("Book ID: " + node.getBookID() + ", Title: " + node.getBookName()
                    + ", Author: " + node.getAuthorName() + ", Color: " + node.getColor()
                    + ", Borrowed By: " + (node.getBorrowedBy() != null ? node.getBorrowedBy() : "None"));
            displayTree(node.getRight());
        }
    }
}



//public class RBTreeTest {
//    public static void main(String[] args) {
//        RBTree myLibrary = new RBTree();
//
//        // Inserting some books into the library
//        myLibrary.insertBook(new RBTreeNode(101, "The Great Gatsby", "F. Scott Fitzgerald"));
//        myLibrary.insertBook(new RBTreeNode(102, "1984", "George Orwell"));
//        myLibrary.insertBook(new RBTreeNode(103, "To Kill a Mockingbird", "Harper Lee"));
//        myLibrary.insertBook(new RBTreeNode(104, "The Catcher in the Rye", "J.D. Salinger"));
//
//        // Testing the borrowBook method
//        // Case 1: Borrow an available book
//        System.out.println("Borrowing Book ID 101: " + myLibrary.borrowBook(201, 101, 1));
//
//        // Case 2: Attempt to borrow the same book again
//        System.out.println("Borrowing Book ID 101 again: " + myLibrary.borrowBook(202, 101, 2));
//
//        // Case 3: Borrow another available book
//        System.out.println("Borrowing Book ID 103: " + myLibrary.borrowBook(203, 103, 1));
//        // Case 4: Borrow non-existing book
//        System.out.println("Borrowing Book not there: " + myLibrary.borrowBook(203, 108, 1));
//        // Display the tree after borrowing
//        System.out.println("\nTree after borrowing books:");
//        displayTree(myLibrary.getRoot());
//
//        // Add more test cases as needed
//    }
//
//    // Method to display the tree (same as before)
//    public static void displayTree(RBTreeNode node) {
//        if (node != null) {
//            displayTree(node.getLeft());
//            System.out.println("Book ID: " + node.getBookID() + ", Title: " + node.getBookName()
//                    + ", Author: " + node.getAuthorName() + ", Color: " + node.getColor()
//                    + ", Borrowed By: " + (node.getBorrowedBy() != null ? node.getBorrowedBy() : "None")+", time of borrow: ");
//            displayTree(node.getRight());
//        }
//    }
//}