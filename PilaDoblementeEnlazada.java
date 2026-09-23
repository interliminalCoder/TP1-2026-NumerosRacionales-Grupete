public class PilaDoblementeEnlazada<T> implements Pila<T> {

    private NodoPila<T> inicio;
    private NodoPila<T> fin;

    PilaDoblementeEnlazada() {
        this.inicio = null;
        this.fin = null;
    }

    @Override
    public boolean esVacia() {
        return this.inicio == null && this.fin == null;
    }

    @Override
    public T tope() {
        if(esVacia()){
        throw new IllegalStateException("La pila esta vacia");
        }
        return this.fin.getItem();
    }

    @Override
    public void apilar(T elem) {
        NodoPila<T> pilaNueva = new NodoPila<T>(this.fin, elem, null);
        if(esVacia()){
            this.inicio = pilaNueva;
            this.fin = pilaNueva;
        } else{
            this.fin.setNext(pilaNueva);
            this.fin = pilaNueva;
        }
    }

    @Override
    public T desapilar() {
        if(esVacia()){
            throw new IllegalStateException("No se puede desapilar porque la pila esta vacia");
        }
        T ultimo = this.fin.getItem();
        if(this.inicio == this.fin){
            this.inicio = null;
            this.fin = null;
        } else {
            this.fin = this.fin.getPrev();
            this.fin.setNext(null);
        }
        return ultimo;        
    }

    @Override
    public void imprimir() {
        if(esVacia()){
            throw new IllegalStateException("No se puede imprimir porque la pila es vacia");
        }
        NodoPila<T> elementos = this.fin;
        while(elementos != null){
            System.out.println(elementos.getItem());
            elementos = elementos.getPrev();
        }
    }

}