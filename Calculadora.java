public class Calculadora {

    public static Racional evaluarExpresion(String expresion) {
        Pila<Racional> pila = new PilaDoblementeEnlazada<>();

        String[] tokens = expresion.split(" ");
            
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {

                Racional b = pila.desapilar();
                Racional a = pila.desapilar();

                if (token.equals("+")) {
                    a.suma(b);
                } else if (token.equals("-")) {
                    b.neg();
                    a.suma(b);
                } else if (token.equals("*")) {
                    a.mult(b);
                } else {
                    a.div(b);
                }

                pila.apilar(a);

            } else {
                pila.apilar(parsear(token));
            }
        }

        return pila.desapilar();
    }

    private static Racional parsear(String token) {
        if (token.contains("R")) {
            String[] partes = token.split("R");
            int num = Integer.parseInt(partes[0]);
            int den = Integer.parseInt(partes[1]);
            return new Numero(num, den);
        } else {
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