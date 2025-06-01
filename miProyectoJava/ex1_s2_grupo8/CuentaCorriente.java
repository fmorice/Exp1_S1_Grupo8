
package ex1_s2_grupo8;

// Ahora hereda de CuentaBancaria
public class CuentaCorriente extends CuentaBancaria {

    // Constructor que llama al constructor de la clase abstracta
    public CuentaCorriente(int numeroCuenta) {
        super(numeroCuenta);
    }

    // Implementación del método abstracto 'girar'
    @Override
    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor que cero.");
        } else if (monto > saldo) {
            System.out.println("Fondos insuficientes.");
        } else {
            saldo -= monto;
            System.out.println("Giro exitoso. Saldo actual: " + saldo + " pesos.");
        }
    }
}