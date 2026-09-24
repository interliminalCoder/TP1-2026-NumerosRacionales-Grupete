public class Calculadora {

    /**
     * Evalúa una expresión en notación prefija y devuelve el resultado.
     *
     * Recorreremos la expresión de derecha a izquierda (LIFO).
     * Así, cuando encontramos un operador, sus operandos ya están en la pila.
     */
    
    public static Racional evaluarExpresion(String expresion) {
        // Pila auxiliar donde guardamos racionales.
        Pila<Racional> pila = new PilaDoblementeEnlazada<>();

        // Separamos la expresión por los espacios en tokens.
        // " + 1R2 1R2 " -> ["+", "1R2", "1R2"]

        // Usamos split(), ya que divide el texto según un separador (en este caso el carácter vacío), y te devuelve un arreglo con las partes.
        String[] tokens = expresion.split(" ");

        // Recorremos el arreglo de tokens desde el último hasta el primero (por eso inicializamos en length - 1 y usamos i--).
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            // Comprobamos si el token es un operador (según los definidos).
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {

                // Desapilamos dos operandos.
                // El primero en salir es el operando derecho (b).
                // El segundo en salir es el operando izquierdo (a).
                // Esto es así porque recorremos de derecha a izquierda.
                Racional b = pila.desapilar();
                Racional a = pila.desapilar();

                // Aplicamos la operación correspondiente según el token.
                // Todos los métodos de Racional modifican la instancia "a" y guardan ahí mismo el resultado.
                if (token.equals("+")) {
                    a.suma(b);
                } else if (token.equals("-")) {
                    // No hay método "resta" en la interfaz, por eso sumamos el opuesto del "b" (A - B = A + B.neg()).
                    b.neg();
                    a.suma(b);
                } else if (token.equals("*")) {
                    a.mult(b);
                } else {
                    a.div(b);
                }

                // Apilamos el resultado (que quedó guardado en la instancia "a").
                pila.apilar(a);

            } else {
                // Si no corresponde a ninguna operación, el token es un número: lo parseamos y lo apilamos.
                pila.apilar(parsear(token));
            }
        }

        // Al terminar, la pila tiene un solo elemento, que es el resultado.
        return pila.desapilar();
    }

    /**
     * Convierte un token de texto en un Racional.
     * Si el token tiene forma "aRb" equivale a racional a/b.
     * Si el token es solo un entero "a" equivale a racional a/1.
     */
    private static Racional parsear(String token) {
        if (token.contains("R")) {
            // Separamos por la letra R. "1R2" pasa a ser ["1", "2"]
            String[] partes = token.split("R");
            int num = Integer.parseInt(partes[0]);
            int den = Integer.parseInt(partes[1]);
            return new Numero(num, den);
        } else {
            // Es un entero: lo interpretamos como num/1.
            int num = Integer.parseInt(token);
            return new Numero(num, 1);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usar java Calculadora <expresion>");
            System.out.println("Ej: java Calculadora '+ 1R2 2R3'");
        } else {
            System.out.println(evaluarExpresion(args[0]));
        }
    }
}