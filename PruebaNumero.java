public class PruebaNumero {

    // Clase generada con IA para probar si todo funciona.
    
    public static void main(String[] args) {
        // Suma: 1/2 + 1/3 = 5/6
        Racional a = new Numero(1, 2);
        Racional b = new Numero(1, 3);
        a.suma(b);
        System.out.println("1/2 + 1/3 = " + a);

        // Multiplicación: 1/2 * 2/3 = 2/6
        Racional c = new Numero(1, 2);
        Racional d = new Numero(2, 3);
        c.mult(d);
        System.out.println("1/2 * 2/3 = " + c);

        // División: 1/2 / 1/4 = 4/2
        Racional e = new Numero(1, 2);
        Racional f = new Numero(1, 4);
        e.div(f);
        System.out.println("1/2 / 1/4 = " + e);

        // Negación: -(3/4) = -3/4
        Racional g = new Numero(3, 4);
        g.neg();
        System.out.println("-(3/4) = " + g);

        // repOk
        System.out.println("repOk(1/2) = " + new Numero(1, 2).repOk()); // true
        System.out.println("repOk(1/0) = " + new Numero(1, 0).repOk()); // false
    }
}