public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTION DE BIBLIOTECA ===");
        System.out.println("Aplicacion Java de consola iniciada.\n");
        
        // Crear una biblioteca
        Library library = new Library("Biblioteca Central");
        
        // Crear algunos libros
        Book book1 = new Book("El Quijote", "978-84-376-0494-7", "Miguel de Cervantes", 1605);
        Book book2 = new Book("Cien anos de soledad", "978-84-376-0495-4", "Gabriel Garcia Marquez", 1967);
        Book book3 = new Book("1984", "978-84-376-0496-1", "George Orwell", 1949);
        Book book4 = new Book("El amor en los tiempos del colera", "978-84-376-0497-8", "Gabriel Garcia Marquez", 1985);
        
        // Agregar libros a la biblioteca
        System.out.println("AGREGANDO LIBROS A LA BIBLIOTECA:");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        System.out.println("Libros agregados exitosamente.");
        
        // Buscar libros por titulo
        System.out.println("\nBUSQUEDA POR TITULO ('amor'):");
        LinkedList<Book> searchResults = library.findBooksByTitle("amor");
        for (int i = 0; i < searchResults.getSize(); i++) {
            System.out.println("  - " + searchResults.get(i).getTitle());
        }
        
        // Buscar libros por autor
        System.out.println("\nBUSQUEDA POR AUTOR ('Garcia Marquez'):");
        LinkedList<Book> authorBooks = library.findBooksByAuthor("Garcia Marquez");
        for (int i = 0; i < authorBooks.getSize(); i++) {
            System.out.println("  - " + authorBooks.get(i).getTitle());
        }
        
        // --- PRUEBA TAREA 2: PRESTAMOS E HISTORIAL (PILA) ---
        System.out.println("\nSIMULANDO PRESTAMOS (TAREA 2):");
        Book foundBook1 = library.findBookByIsbn("978-84-376-0494-7");
        if (foundBook1 != null && library.registerLoan(foundBook1)) {
            System.out.println("Se presto: " + foundBook1.getTitle());
        }
        
        Book foundBook2 = library.findBookByIsbn("978-84-376-0495-4");
        if (foundBook2 != null && library.registerLoan(foundBook2)) {
            System.out.println("Se presto: " + foundBook2.getTitle());
        }

        System.out.println("Deshaciendo el ultimo prestamo por error...");
        if (library.undoLastLoan()) {
            System.out.println("El ultimo libro prestado volvio a estar disponible.");
        }

        // --- PRUEBA TAREA 3: LISTA DE ESPERA (COLA) ---
        System.out.println("\nSIMULANDO LISTA DE ESPERA (TAREA 3):");
        System.out.println("El libro '" + foundBook1.getTitle() + "' esta prestado. Agregando usuarios a la fila...");
        
        foundBook1.addToWaitlist("Juan Perez");
        foundBook1.addToWaitlist("Maria Gomez");
        
        System.out.println("Primer usuario en la fila: " + foundBook1.getFirstInWaitlist());
        
        System.out.println("El libro fue devuelto. Asignando al primer usuario en espera...");
        foundBook1.returnBook();
        String nextUser = foundBook1.assignToNextInWaitlist();
        System.out.println("Libro asignado a: " + nextUser);
        // Lo volvemos a prestar a Juan Perez
        library.registerLoan(foundBook1); 
        
        // Mostrar estadisticas finales
        System.out.println("\nESTADISTICAS FINALES:");
        System.out.println(library.getStatistics());
        
        System.out.println("Demostracion completada.");
    }
}