public class Librarian extends User {

    public Librarian(String name, int userId) {
        super(name, userId);
    }

    public void addBookToLibrary(Library library, Book book) {
        library.addBook(book);
    }
}
