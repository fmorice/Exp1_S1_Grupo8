package ex1_s2_grupo8;

public class CuentaAhorro extends CuentaBancaria {

    public CuentaAhorro(int numeroCuenta) {
        super(numeroCuenta);
    }

    @Override
    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a 0.");
        } else if (monto > saldo) {
            System.out.println("No puede girar más de lo que tiene.");
        } else {
            saldo -= monto;
            System.out.println("Giro desde cuenta de ahorro exitoso. Saldo actual: " + saldo + " pesos.");
        }
    }
}
