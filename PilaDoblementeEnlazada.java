public class PilaDoblementeEnlazada<T> implements Pila<T> {

    // Creamos los dos nodos de la pila (como atributos), uno para el Nodo inicial y otro para el Nodo final.
    private NodoPila<T> inicio;
    private NodoPila<T> fin;
    
    // Creamos el constructor de la pila, inicializando los nodos en null.
    public PilaDoblementeEnlazada() {
        this.inicio = null;
        this.fin = null;
    }
    
    // Se fija si la pila esta vacía, si lo esta devuelve true, sino false.
    @Override
    public boolean esVacia() {
        return this.inicio == null && this.fin == null;
    }
    
    // Si la pila esta vacía lanza una excepción, sino devuelve el elemento que está en el tope de la pila.
    @Override
    public T tope() {
        if (esVacia()) {
            throw new IllegalStateException("La pila esta vacia");
        }
        return this.fin.getItem();
    }
    
    // Agrega un elemento a la pila, si la pila está vacía el elemento se agrega al inicio y al final, sino se agrega al final.
    @Override
    public void apilar(T elem) {
        NodoPila<T> pilaNueva = new NodoPila<T>(this.fin, elem, null);

        if (esVacia()) {
            this.inicio = pilaNueva;
            this.fin = pilaNueva;

        } else {
            this.fin.setNext(pilaNueva);
            this.fin = pilaNueva;
        }
    }
    
    // Si la pila está vacía lanza una excepción, sino elimina el elemento que está en el tope de la pila y lo devuelve.
    @Override
    public T desapilar() {
        if (esVacia()) {
            throw new IllegalStateException("No se puede desapilar porque la pila esta vacia");
        }
        
        // Almacenamos el valor contenido en el tope de la pila en una variable auxiliar para luego retornarlo al final del metodo.
        T ultimo = this.fin.getItem();

        // Si la pila tiene un solo elemento, se elimina el nodo (que vendria siendo inicio y fin al mismo tiempo), sino se elimina el nodo final y se actualiza el nodo final al nodo anterior.
        if (this.inicio == this.fin) {
                this.inicio = null;
                this.fin = null;
        } else {
            this.fin = this.fin.getPrev();
            this.fin.setNext(null);
        }

        return ultimo;        
    }

    // Imprime todos los elementos de la pila desde el final hasta el inicio.
    // Si la pila está vacía se lanza una excepción.
    @Override
    public void imprimir() {
        if (esVacia()) {
            throw new IllegalStateException("No se puede imprimir porque la pila es vacia");
        }
        
        // Creamos un nodo auxiliar para iterar los elementos de la pila desde el final hasta el inicio, imprimiendo sus valores.
        NodoPila<T> elementos = this.fin;
        while (elementos != null) {
            System.out.println(elementos.getItem());
            elementos = elementos.getPrev();
        }
    }
    
}