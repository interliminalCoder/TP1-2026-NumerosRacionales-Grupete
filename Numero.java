/**
 * Implementación de un número racional como par de números numerador y denominador.
 * Ambas partes del par numérico son enteras, y el denominador nunca puede ser 0.
 *
 * Importante: como dice la interfaz, todas las operaciones CAMBIAN la
 * instancia actual. Es decir, a.suma(b) modifica el estado guardado en la variable "a".
*/

public class Numero implements Racional {

    // Atributos que nos servirán más adelante.
    private int numerador;
    private int denominador;

    
    // Acá creamos un tipo de dato Número con un numerador y un denominador.
    public Numero(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;

        assert repOk();
    }

    /**
     * Sumamos el racional r a la instancia actual.
     * Fórmula: a/b + c/d = (a*d + c*b) / (b*d)
     */

    @Override
    public void suma(Racional r) {

        // Necesitamos ver los valores de r, pero r está declarado como Racional y la interfaz no tiene getters. Por eso casteamos:
        Numero otro = (Numero) r;

        // Calculamos el nuevo numerador y denominador y los guardamos en variables locales.
        // Usamos variables locales para no pisar el valor de "this.numerador" antes de terminar.

        int num = this.numerador * otro.denominador + otro.numerador * this.denominador;
        int den = this.denominador * otro.denominador;

        // Recién ahora asignamos, con el cálculo ya hecho.
        this.numerador = num;
        this.denominador = den;

        assert repOk();
    }

    /**
     * Multiplicamos la instancia actual por el racional r.
     * Fórmula: a/b * c/d = (a*c) / (b*d)
     */

    @Override
    public void mult(Racional r) {
        Numero otro = (Numero) r;

        // En la multiplicación no hay riesgo de pisar variables antes de terminar, porque cada atributo se calcula con su propio valor original.
        this.numerador = this.numerador * otro.numerador;
        this.denominador = this.denominador * otro.denominador;

        assert repOk();
    }

    /**
     * Cambia el signo de la instancia actual (resta unaria).
     * Fórmula: -(a/b) = (-a)/b
     */

    @Override
    public void neg() {
        // Solo cambia el signo del numerador; el denominador queda igual.
        this.numerador = -this.numerador;

        assert repOk();
    }

    /**
     * Divide la instancia actual por el racional r. O sea, multiplicamos cruzado.
     * Fórmula: (a/b) / (c/d) = (a*d) / (b*c)
     */
    
    @Override
    public void div(Racional r) {
        Numero otro = (Numero) r;

        this.numerador = this.numerador * otro.denominador;
        this.denominador = this.denominador * otro.numerador;

        assert repOk();
    }

    /**
     * Invariante de clase.
     * Según la interfaz, solo hay que chequear que el denominador no sea 0.
     *
     * @return true si el objeto está en un estado válido
     */

    @Override
    public boolean repOk() {
        // 1. El denominador nunca puede ser 0.
        if (this.denominador == 0) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en texto del racional, con el formato
     * "numerador/denominador". Por ejemplo, 1/2 se muestra como "1/2".
     */
    @Override
    public String toString() {
        return this.numerador + "/" + this.denominador;
    }
}