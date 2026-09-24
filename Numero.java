public class Numero implements Racional{

    private int numerador;
    private int denominador;
    
    public Numero(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    @Override
    public void suma(Racional r) {
        Numero otro = (Numero) r;

        int nuevoNumerador = this.numerador * otro.denominador + otro.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otro.denominador;

        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
    }

    @Override
    public void mult(Racional r) {
        Numero otro = (Numero) r;
        int nuevoNumerador = this.numerador * otro.numerador;
        int nuevoDenominador = this.denominador * otro.denominador;

        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
    }

    @Override
    public void neg() {
       this.numerador = -this.numerador;
    }

    @Override
    public void div(Racional r) {
        Numero otro = (Numero) r;
        
        int nuevoNumerador = this.numerador * otro.denominador;
        int nuevoDenominador = this.denominador * otro.numerador;

        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
    }

    @Override
    public boolean repOk() {

        if (this.denominador == 0 || this.numerador == 0) {
            return false;
        }



        return true;

    }
    
    @Override
    public String toString() {
        return this.numerador + "R" + this.denominador;
    }




}
