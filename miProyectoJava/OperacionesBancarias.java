package ex1_s1_grupo8;
public class OperacionesBancarias {
    private String numeroCuenta;
    private int saldo;
    private RegistroCliente cliente;
    
    public OperacionesBancarias (String numeroCuenta, RegistroCliente cliente){
        if (numeroCuenta == null || numeroCuenta.isEmpty()) {
            throw new IllegalArgumentException("Numero de cuenta no puede estar vacio");
        }
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.saldo = 0;
    }
    public String getNumeroCuenta(){
        return numeroCuenta;
    }
    public int getSaldo(){
        return saldo;
    }
    public RegistroCliente getCliente(){
        return cliente;
    }
    public void depositar (int monto){
        if (monto <=0){
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a 0");
        }
        this.saldo += monto;
        System.out.println("Tu deposito de $"+this.saldo+" se ha realizado con exito");
    }
    public boolean girar (int monto){
        if (monto <=0) {
            throw new IllegalArgumentException("El monto a girar debe ser mayor a 0 y menor a $"+this.saldo);
        }
        if (monto > saldo) {
            System.out.println("Saldo insuficiente");
            return false;
        }
        this.saldo -= monto;
        System.out.println("Transaccion exitosa. Tu nuevo saldo es de: $"+this.saldo);
        return true;
    }
    public void informacionCuenta(){
        System.out.println("==== Informacion de tu cuenta ====");
        System.out.println("\nTitular de la cuenta: "+cliente.getNombre()+" "+cliente.getApellidoPaterno()+" "+cliente.getApellidoMaterno());
        System.out.println("RUT: "+cliente.getRut());
        System.out.println("Numero de cuenta: "+numeroCuenta);
        System.out.println("Saldo actual: $"+saldo);
    }
}
