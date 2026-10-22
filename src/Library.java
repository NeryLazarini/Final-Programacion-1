public class Library {
    private String name;
    private LinkedList<Book> books;
    // Tarea 2: Pila para el historial de prestamos
    private Stack<Book> loanHistory; 
    
    public Library(String name) {
        this.name = name;
        this.books = new LinkedList<>();
        // Inicializamos la pila vacia al crear la biblioteca
        this.loanHistory = new Stack<>(); 
    }
    
    public String getName() { return name; }
    public LinkedList<Book> getBooks() { return books; }
    public void setName(String name) { this.name = name; }
    
    public boolean addBook(Book book) {
        if (book != null) {
            books.add(book);
            return true;
        }
        return false;
    }
    
    public boolean removeBook(Book book) {
        if (book != null) {
            return books.remove(book);
        }
        return false;
    }
    
    public Book findBookByIsbn(String isbn) {
        for (int i = 0; i < books.getSize(); i++) {
            Book currentBook = books.get(i);
            if (currentBook.getIsbn().equals(isbn)) {
                return currentBook;
            }
        }
        return null;
    }
    
    public LinkedList<Book> findBooksByTitle(String title) {
        LinkedList<Book> foundBooks = new LinkedList<>();
        for (int i = 0; i < books.getSize(); i++) {
            Book currentBook = books.get(i);
            if (currentBook.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(currentBook);
            }
        }
        return foundBooks;
    }
    
    public LinkedList<Book> findBooksByAuthor(String authorName) {
        LinkedList<Book> foundBooks = new LinkedList<>();
        for (int i = 0; i < books.getSize(); i++) {
            Book currentBook = books.get(i);
            if (currentBook.getAuthor().toLowerCase().contains(authorName.toLowerCase())) {
                foundBooks.add(currentBook);
            }
        }
        return foundBooks;
    }
    
    public LinkedList<Book> getAvailableBooks() {
        LinkedList<Book> availableBooks = new LinkedList<>();
        for (int i = 0; i < books.getSize(); i++) {
            Book currentBook = books.get(i);
            if (currentBook.isAvailable()) {
                availableBooks.add(currentBook);
            }
        }
        return availableBooks;
    }
    
    public LinkedList<Book> getLoanedBooks() {
        LinkedList<Book> loanedBooks = new LinkedList<>();
        for (int i = 0; i < books.getSize(); i++) {
            Book currentBook = books.get(i);
            if (!currentBook.isAvailable()) {
                loanedBooks.add(currentBook);
            }
        }
        return loanedBooks;
    }

    // --- METODOS DE LA TAREA 2 (PILA) ---
    public boolean registerLoan(Book book) {
        if (book != null && book.lend()) {
            loanHistory.push(book); // Apilamos el libro prestado
            return true;
        }
        return false;
    }

    public Book getLastLoan() {
        return loanHistory.peek();
    }

    public boolean undoLastLoan() {
        Book lastBook = loanHistory.pop(); // Desapilamos el ultimo prestamo
        if (lastBook != null) {
            lastBook.returnBook(); // Le devolvemos el estado disponible
            return true;
        }
        return false;
    }
    
    public String getStatistics() {
        int totalBooks = books.getSize();
        int availableBooks = getAvailableBooks().getSize();
        int loanedBooks = getLoanedBooks().getSize();
        
        return String.format(
            "Estadisticas de la Biblioteca:\n" +
            "- Total de Libros: %d\n" +
            "- Libros Disponibles: %d\n" +
            "- Libros Prestados: %d\n",
            totalBooks, availableBooks, loanedBooks
        );
    }
    
    @Override
    public String toString() {
        return "Biblioteca: " + name + " | Cantidad de libros: " + books.getSize();
    }
}