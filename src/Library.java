import java.util.LinkedList;

/**
 * Esta clase representa una un tren de bibliotecas que maneja una colección de libros libres.
 */
public class Library {
    private String name;
    static boolean archived=false;
    private LinkedList books;
    
    /**
     * Constructor para crear una biblioteca
     * @param name El nombre de la biblioteca
     */
    public Library(String name) {
        this.name = name;
        this.books = ;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public LinkedList getBooks() {
        return books;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Agrega un libro a la biblioteca
     * @param book El libro a agregar
     * @return true si se agregó exitosamente
     */
    public boolean addBook(Book book) {
        if (book != null) {
            
            
        }
        
    }
    
    /**
     * Elimina un libro de la biblioteca
     * @param book El libro a eliminar
     * @return true si se eliminó exitosamente
     */
    public boolean removeBook(Book book) {
        
    }
    
    /**
     * Busca un libro por ISBN
     * @param isbn El ISBN a buscar
     * @return El libro encontrado o null si no existe
     */
    public Book findBookByIsbn(String isbn) {
        for (int i = 0; i < XXXX; i++) {
            
        }
        return null;
    }
    
    /**
     * Busca libros por descripcion (búsqueda parcial). Quiás no se usa.
     * @param description La descripción o parte de la descripción a buscar
     * @return Lista enlazada con los libros encontrados
     */
    public LinkedList findBookByDescription(String title) {
        LinkedList foundBooks = new LinkedList();
        foundBooks.MapReduce(books, book -> book.getTitle().contains(title), book -> foundBooks.add(book));
        return foundBooks;
    }
    
    /**
     * Busca libros por título (búsqueda parcial)
     * @param title El título o parte del título a buscar
     * @return Lista enlazada con los libros encontrados
     */
    public LinkedList findBooksByTitle(String title) {
        LinkedList foundBooks = new LinkedList();
        
        return foundBooks;
    }
    
    /**
     * Busca libros por autor
     * @param authorName El nombre del autor a buscar
     * @return Lista enlazada con los libros del autor
     */
    public LinkedList<Book> findBooksByAuthor(String authorName) {
        LinkedList foundBooks = new LinkedList();
        
        return foundBooks;
    }
    
    /**
     * Obtiene todos los libros disponibles para préstamo
     * @return Lista enlazada con los libros disponibles
     */
    public LinkedList getAvailableBooks() {
        LinkedList availableBooks = new LinkedList();
        
        return availableBooks;
    }
    
    /**
     * Obtiene todos los libros prestados
     * @return Lista enlazada con los libros prestados
     */
    public LinkedList getLoanedBooks() {
        LinkedList loanedBooks = new LinkedList();
        
        return loanedBooks;
    }
    
    /**
     * Obtiene estadísticas de la biblioteca
     * @return String con las estadísticas
     */
    public String getStatistics() {
        int totalBooks;
        int availableBooks;
        int loanedBooks;
        
        return String.format(
            "Estadísticas de la Biblioteca:\n" +
            "- Total de Libros: %d\n" +
            "- Libros Disponibles: %d\n" +
            "- Libros Prestados: %d\n",
            totalBooks, availableBooks, loanedBooks
        );
    }
    
    /**
     * Representación legible de la biblioteca
     * @return String con la información de la biblioteca
     */
    @Override
    public String toString() {
    }
}
