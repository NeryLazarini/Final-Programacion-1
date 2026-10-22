public class LinkedList<T> {
    private Node<T> head; // Referencia al primer nodo de la lista
    private int size;     // Contador de elementos
    
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    // Añade un elemento al final de la lista
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<T> current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        this.size++;
    }
    
    // Accede a un elemento por su posicion
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null; // O podriamos lanzar una excepcion
        }
        Node<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }
    
    // Elimina el primer elemento que coincida con el valor pasado
    public boolean remove(T data) {
        if (this.head == null) {
            return false;
        }
        
        // Si el elemento a eliminar es el primero (head)
        if (this.head.getData().equals(data)) {
            this.head = this.head.getNext();
            this.size--;
            return true;
        }
        
        // Si esta en el medio o al final, lo buscamos
        Node<T> current = this.head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                // Saltamos el nodo para desconectarlo de la lista
                current.setNext(current.getNext().getNext());
                this.size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    // Verifica si un elemento existe en la lista
    public boolean contains(T data) {
        Node<T> current = this.head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    // Verifica si la lista esta vacia
    public boolean isEmpty() {
        return this.head == null; // Tambien podria ser this.size == 0
    }
    
    // Elimina todos los elementos
    public void clear() {
        this.head = null;
        this.size = 0;
    }
    
    // Agrego este metodo extra porque lo vas a necesitar para saber la cantidad de libros
    public int getSize() {
        return this.size;
    }
}