import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        Librarian librarian = new Librarian("Alice", 1);

        // Adding some books initially
        librarian.addBookToLibrary(library, new Book("Java Programming", "Author A"));
        librarian.addBookToLibrary(library, new Book("Python Basics", "Author B"));
        librarian.addBookToLibrary(library, new Book("C++ Fundamentals", "Author C"));

        User user = new User("Bob", 101);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Show Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = sc.nextLine();
                    Book borrowBook = library.findBook(borrowTitle);
                    if (borrowBook != null)
                        user.borrowBook(borrowBook);
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    Book returnBook = library.findBook(returnTitle);
                    if (returnBook != null)
                        user.returnBook(returnBook);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
            sc.close();
        }
    }
}
