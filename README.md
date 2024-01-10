**Advanced Data Structures COP5536, Fall 2023**

**Programming Project Report**

**RED BLACK TREES & MIN-HEAP**

**Library Management**

**Name: Manav Mishra**

**Under the Guidance of Dr. Sartaj Sahni**

- **PROJECT OBJECTIVES:**

The project, titled "GatorLibrary Management System," aims to create a software system for efficiently managing books, patrons, and borrowing operations in a fictional library, GatorLibrary. The key objectives and requirements are as follows:

1. \*Data Structures\*: The system should utilize a Red-Black tree to manage books and a Binary Min-heap for managing book reservations. Each node in the Red-Black tree represents a book, containing details like book ID, name, author, availability status, borrower ID, and a reservation heap. The reservation heap is ordered by patron priority, and ties are broken by the timestamp of reservation.

2. \*Supported Operations\*: The system should support various operations such as:

- Printing information about specific or a range of books.

- Inserting, borrowing, and returning books.

- Deleting books from the library.

- Finding the closest book by ID.

- Tracking and analyzing color flips in the Red-Black tree.

3. \*Programming Environment\*: The project can be implemented in Java, C++, or Python. The program must compile and run on a specified server and should include a makefile to create an executable file named `gatorLibrary`.

4. \*Input and Output\*: The program should read input from a text file specified as a command-line argument and write output to a text file named by concatenating the input filename with "\_output\_file.txt". The program terminates when the 'Quit()' operation is encountered in the input file.

5. \*Submission Requirements\*: Submissions must include a makefile, well-commented source code, and a PDF report detailing the project, function prototypes, and explanations. All files should be in the first directory after unzipping without nested directories.

6. \*Grading Policy\*: The grading will focus on the correctness and efficiency of algorithms, with emphasis on correct implementation, comments and readability of the code, and the quality of the report.

7. \*Miscellaneous\*: It's mandatory to implement Red-Black trees and Binary min-heaps from scratch without using built-in libraries. Collaboration is limited to discussions, and submissions will be checked for plagiarism.

Overall, the project aims to develop a robust library management system utilizing specific data structures and algorithms, with a focus on efficiency, correctness, and good programming practices.

- **Technologies Used:**

1. JAVA
2. INTELLIJ IDE

- **Steps to Run:**

1) Unzip manav\_mishra.zip and open the folder.

2) Run Terminal in that directory and run one of the following command:

● javac lib\_fetch.java

● java lib\_fetch \<testfilename\>.txt

3) Find the output in \<testfilename\>\_output\_file.txt generated by the code.

- **Function Prototype and Code Structure:**

My project is divided into 5 files:

1. RBTree.java
2. RBTreeNode.java
3. BinaryMinHeap.java
4. Lib\_Fetch.java
5. MinHeapNode.java

RBTREE file:

This Java file is an implementation of a Red-Black Tree (RBTree). Here's a brief description of the first few methods based on the code:

1. \*Constructor `RBTree()`\*: Initializes a new instance of the Red-Black Tree. In this constructor, the root of the tree is set to `null`.

2.\*Method `insertBook(RBTreeNode newNode)`\*: This method inserts a new node into the Red-Black Tree. It follows the standard insertion procedure for binary search trees, where the new node is initially inserted like in a regular binary search tree and then the tree is fixed up to maintain the Red-Black Tree properties.

The Red-Black Tree implementation in your Java file includes several methods. Here's a description of each:

1. \*`insertBook(RBTreeNode newNode)`\*: Inserts a new node into the Red-Black Tree. It initially follows the binary search tree insertion logic and then maintains Red-Black Tree properties.

2. \*`getRoot()`\*: Returns the root node of the Red-Black Tree.

3. \*`borrowBook(String bookId)`\*: This method likely handles the logic for borrowing a book identified by `bookId`. The specifics of the implementation would define how it interacts with the Red-Black Tree structure.

4. \*`returnBook(String bookId)`\*: Manages the process of returning a book with the specified `bookId`. This method probably updates the tree structure or node properties based on the return operation.

5. \*`printBook(String bookId)`\*: Prints information about the book with the given `bookId`. This could involve finding the node in the tree and displaying its details.

6. \*`printBooks()`\*: This method may print details of all books in the Red-Black Tree, possibly through an in-order traversal to display them in a sorted manner.

7. \*`deleteBook(String bookId)`\*: Removes the book with the specified `bookId` from the tree. This would include handling the deletion in a way that maintains the Red-Black Tree properties.

8. \*`findClosestNode(String bookId)`\*: Finds and returns the node closest to the given `bookId`. This could be based on some metric of closeness defined in the tree structure.

9. \*`deleteNode(RBTreeNode node)`\*: Deletes a specific node from the Red-Black Tree. Similar to `deleteBook`, but this one operates directly on a node rather than a book ID.

10. \*`findBook(String bookId)`\*: Searches for and returns the node containing the book with the specified `bookId`.

These methods collectively manage the operations of inserting, deleting, finding, and manipulating books within a Red-Black Tree structure, likely representing a library or collection system.

In addition to the public methods in your Red-Black Tree (RBTree) Java implementation, there are several private helper methods that support the main functionalities. Here's a description of each:

1. \*`fixInsert(RBTreeNode node)`\*: A private method used to maintain the Red-Black Tree properties after a new node is inserted. This includes balancing the tree and re-coloring nodes as needed.

2. \*`rotateLeft(RBTreeNode node)`\*: Performs a left rotation on the specified node. This is a standard operation in Red-Black Trees used to maintain balance.

3. \*`rotateRight(RBTreeNode node)`\*: Executes a right rotation on the given node, which is another key operation for maintaining the balance of a Red-Black Tree.

4. \*`printBooksInRange(RBTreeNode node, LocalDateTime startDate, LocalDateTime endDate)`\*: Prints books within a specified date range. This method likely traverses the tree to find and display books that fall within the given date parameters.

5. \*`findClosestLess(String bookId)`\*: Finds the closest node with a book ID less than the specified `bookId`. This could be used in various tree operations where relative positioning is important.

6. \*`findClosestGreater(String bookId)`\*: Similar to `findClosestLess`, but finds the closest node with a book ID greater than the given `bookId`.

7. \*`transplant(RBTreeNode u, RBTreeNode v)`\*: Replaces one subtree as a child of its parent with another subtree. This is a common operation in tree deletion processes.

8. \*`minimum(RBTreeNode node)`\*: Finds the node with the minimum key in the subtree rooted at the given node. This is often used in tree deletion and manipulation operations.

9. \*`deleteFixup(RBTreeNode x)`\*: Fixes the Red-Black Tree after a node is deleted to ensure that the tree continues to satisfy all Red-Black Tree properties.

10. \*`setColor(RBTreeNode node, int color)`\*: Sets the color of a given node. In Red-Black Trees, nodes are either red or black, and this function is integral to maintaining the tree's properties.

11. \*`findBookRecursive(RBTreeNode node, String bookId)`\*: A recursive method to find a book with the given `bookId`, starting from the specified node.

These helper methods are essential for the internal workings of the Red-Black Tree, dealing with rotations, balancing, and maintaining the properties that define the Red-Black Tree structure.

- **RBTreeNode:**

The `RBTreeNode.java` file contains several methods, each with a specific purpose. Here's an explanation of each method:

1. \*`getBookID()`\*: This method returns the book ID associated with a node in the Red-Black Tree.

2. \*`getColor()`\*: This method returns the color (RED or BLACK) of the node, which is a key feature in Red-Black Trees for maintaining balance.

3. \*`getLeft()`\*: This method returns the left child of the current node.

4. \*`getParent()`\*: This method returns the parent node of the current node.

5. \*`getRight()`\*: This method returns the right child of the current node.

6. \*`setBookID(int bookID)`\*: This method sets the book ID for the node.

7. \*`getBookName()`\*: This method returns the name of the book associated with the node.

8. \*`setBookName(String bookName)`\*: This method sets the name of the book for the node.

9. \*`getAuthorName()`\*: This method returns the author's name of the book associated with the node.

10. \*`setAuthorName(String authorName)`\*: This method sets the author's name for the book in the node.

11. \*`isAvailable()`\*: This method returns the availability status of the book (true if available, false otherwise).

12. \*`setAvailabilityStatus(boolean availabilityStatus)`\*: This method sets the availability status of the book in the node.

13. \*`getBorrowedBy()`\*: This method returns the name of the person who has borrowed the book, if any.

14. \*`setBorrowedBy(String borrowedBy)`\*: This method sets the name of the borrower for the book in the node.

15. \*`getReservationHeap()`\*: This method returns a `BinaryMinHeap` object associated with the node, likely used for managing reservations.

16. \*`setReservationHeap(BinaryMinHeap reservationHeap)`\*: This method sets the `BinaryMinHeap` object for the node, for managing reservations.

Each method is a standard getter or setter, providing a way to access or modify the properties of a `RBTreeNode` object, which seems to represent a node in a Red-Black Tree data structure used for storing book-related information.

- **BinaryMinHeap:**

This Java file defines a class `BinaryMinHeap`, which is an implementation of a binary min-heap data structure. This structure is commonly used in algorithms and programming for efficiently managing a set of elements ordered by their keys, where the smallest key is always at the top.

Based on the code Here's a brief explanation of each:

1. \*Constructor `BinaryMinHeap()`\*: This initializes the `BinaryMinHeap` object, creating an `ArrayList` to store the heap elements.

2. \*`parent(int i)`\*: A private helper method to get the index of the parent node of a given node in the heap.

3. \*`leftChild(int i)`\*: A private helper method to get the index of the left child of a given node.

4. \*`rightChild(int i)`\*: Similar to `leftChild`, this method gets the index of the right child of a given node.

5. \*`swap(int i, int j)`\*: This method swaps two nodes in the heap. It is a common operation in heap maintenance, especially during insertion and deletion.

6. \*`insert(MinHeapNode node)`\*: This public method inserts a new node into the heap. It appears to add the node to the end of the `ArrayList` and then adjust its position to maintain the min-heap property.

7. \*Continuation of `insert(MinHeapNode node)`\*: This part of the `insert` method handles the heapify-up process, where the newly added node is swapped with its parent nodes until the min-heap property is satisfied. The method compares the priority of the current node with its parent, and also seems to take into account a `timeOfReservation` attribute for tie-breaking.

8. \*`extractMin()`\*: This public method removes and returns the minimum element from the heap. It handles different cases like when the heap is empty or has only one element. If the heap has more than one element, it swaps the first and last elements, removes the last element (which is the minimum), and then performs heapify-down from the root to restore the min-heap property.

9. \*`heapify(int i)`\*: This is a private helper method used in the `extractMin` method. It ensures that the subtree rooted at index `i` satisfies the min-heap property. This is done by comparing the node with its children and swapping it with the smaller child if necessary.

10. \*Continuation of `heapify(int i)`\*: This method continues with the heapify-down process, ensuring the subtree rooted at the given index maintains the min-heap property by recursively calling itself after a swap if necessary.

11. \*`peek()`\*: This method returns the minimum element (the root) of the heap without removing it. It's useful for just checking the top element of the heap.

12. \*`isEmpty()`\*: A simple method that checks whether the heap is empty. It returns a boolean value.

13. \*`size()`\*: This method returns the number of elements currently in the heap.

14. \*`decreaseKey(int patronID, int newPriority)`\*: This method decreases the priority of a specific node identified by `patronID` and adjusts the heap accordingly. This is typically used in algorithms like Dijkstra's shortest path, where the priority of nodes in the heap may need to be updated.

15. \*`remove(int patronID)`\*: This method removes a specific node from the heap, identified by `patronID`. It performs necessary adjustments to maintain the heap structure after removal.

16. \*`getAllReservations()`\*: It appears to return a list of all elements (reservations) in the heap. This might be used for getting a snapshot of all elements in the heap.

17. \*`contains(int patronID)`\*: This method checks if a particular `patronID` exists in the heap. It's useful for membership testing.

From the methods outlined, it's evident that this `BinaryMinHeap` class is tailored for a specific use case, possibly related to managing reservations or similar tasks where priorities can change and fast access to the smallest element is needed. The class provides a comprehensive set of operations for managing a min-heap, including insertion, extraction, updating priorities, and checking for the existence of specific elements.

- **MINHEAPNODE:**

This Java file defines a class named `MinHeapNode`. This class is part of a data structure, likely a Min Heap, where each node has certain properties. Here's an overview of the class and its methods:

Class Overview: `MinHeapNode`

- \*Attributes\*:

- `patronID`: An integer, possibly identifying a user or an entity.

- `priority`: An integer where lower values indicate higher priority.

- `timeOfReservation`: A `LocalDateTime` object, likely representing the time when a reservation or a request was made.

- \*Constructor\*:

- The class has a constructor that initializes the `patronID`, `priority`, and `timeOfReservation` attributes.

- \*Methods\*:

- There are getters and possibly setters (not fully visible in the preview) for each attribute. These methods are standard in Java for accessing and modifying private class attributes.

this class is designed to represent an element in a Min Heap structure, where each element has a priority and is associated with a timestamp (`timeOfReservation`). The Min Heap is a popular data structure used in various applications, including priority scheduling, queue management, and efficient sorting algorithms.

- **Lib\_fetch:**

The file `lib_fetch.java` you've provided appears to be a Java class that includes various methods and attributes. From the initial preview of the file, here is an overview:

Class Overview: `lib_fetch`

- \*Attributes\*:

- `inputFileName`: A static variable likely used to store the name of an input file.

- `myLib`: An instance of `RBTree` (presumably a Red-Black Tree), used to store `Book` objects. This indicates that the class is related to library management or book tracking.

The `lib_fetch.java` file is a comprehensive Java class designed for a library management system. Here's a detailed report on the class and its methods:

Class Overview: `lib_fetch`

- \*Purpose\*: The class seems to manage a library system, handling operations like adding, removing, and querying books, as well as handling reservations. It uses a Red-Black Tree for efficient data management.

- \*Key Attributes\*:

- `inputFileName`: Static variable for storing the input file name.

- `myLib`: A private instance of `RBTree`, indicating usage of a Red-Black Tree data structure.

Key Methods:

1. \*fetchInputParameter\*

- \*Purpose\*: Extracts a specific parameter from a comma-separated string based on its index.

- \*Parameters\*: `String parameters`, `int index`.

- \*Return\*: Extracted parameter as a String.

2. \*performOperation\*

- \*Purpose\*: Reads operations from an input file and performs them. The operations include adding, removing, and querying books, among others.

- \*Parameters\*: `String inputFileName`.

- \*Exception\*: `IOException`.

3. \*PrintBook\*

- Part of the `switch` statement in `performOperation`, it appears to handle printing book details.

- \*Parameter Extraction\*: Uses `fetchInputParameter` to extract book ID from parameters.

4. \*AddBook\*

- Handles adding a new book to the system.

5. \*RemoveBook\*

- Manages the removal of a book from the system.

6. \*CheckOutBook\*

- Deals with the process of checking out a book.

7. \*ReturnBook\*

- Manages the return of a borrowed book.

8. \*FindClosestBook\*

- \*Purpose\*: Finds the two books closest to a given target ID and returns details.

- \*Parameters\*: `Integer targetID`.

- \*Logic\*: Determines closeness based on the absolute difference in IDs and handles edge cases accordingly.

9. \*printBookOutput\*

- A helper method to format and return the details of a book.

10. \*Main Method\*

- Processes command-line input and initiates operations.

Analysis:

- The class is designed to interact with an external file, likely containing a list of commands or operations to perform on the library system.

- Use of a Red-Black Tree suggests a focus on efficient data handling, especially for operations that require sorting or rapid access, like finding a book.

- Exception handling and input validation are integral parts of the system, ensuring robust operation.

- The class is modular, with distinct methods handling specific operations, enhancing readability and maintainability.

Conclusion:

`lib_fetch` is a well-structured Java class designed for efficient library management, demonstrating good programming practices such as modularity, encapsulation, and efficient data structures. This class can be a part of a larger library management system or serve as a standalone tool for managing a collection of books.

DEFENCE for colourflipcount

According to the logic of my code I have flipped the color wherever the flip takes place.

**CLASS DIAGRAM ON THE NEXT PAGE**
![image](https://github.com/HardCoder19/Lib_Manage/assets/57640822/c47c4365-1d84-4561-909e-148ad7fbc9d6)
