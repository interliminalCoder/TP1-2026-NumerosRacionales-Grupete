public class PruebaPila {

    // Clase generada con IA para probar si todo funciona.

    public static void main(String[] args) {
        Pila<Integer> p = new PilaDoblementeEnlazada<>();

        System.out.println("esVacia al inicio: " + p.esVacia()); // true

        p.apilar(1);
        p.apilar(2);
        p.apilar(3);

        System.out.println("tope: " + p.tope());               // 3
        System.out.println("esVacia ahora: " + p.esVacia());   // false

        System.out.println("desapilo: " + p.desapilar());      // 3
        System.out.println("desapilo: " + p.desapilar());      // 2
        System.out.println("tope: " + p.tope());               // 1

        System.out.println("imprimir:");
        p.imprimir();  // imprime 1
    }
}