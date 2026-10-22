public class Queue<T> {
    private Node<T> front; // El primero de la fila
    private Node<T> rear;  // El ultimo de la fila
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Agrega un elemento al final de la cola (como llegar a la fila)
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.rear == null) {
            this.front = this.rear = newNode;
        } else {
            this.rear.setNext(newNode);
            this.rear = newNode;
        }
        this.size++;
    }

    // Saca y devuelve al primer elemento de la cola (como atender al primero)
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T data = this.front.getData();
        this.front = this.front.getNext();
        
        // Si al sacar el elemento la cola quedo vacia, el rear tambien es null
        if (this.front == null) {
            this.rear = null;
        }
        this.size--;
        return data;
    }

    // Observa al primer elemento sin sacarlo de la cola
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return this.front.getData();
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public int getSize() {
        return this.size;
    }
}