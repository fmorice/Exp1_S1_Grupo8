
package ex1_s2_grupo8;

public class Cliente implements InformacionCliente{
   
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private CuentaBancaria cuenta;

    // Constructor
    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno,
                   String domicilio, String comuna, String telefono, CuentaBancaria cuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = cuenta;
    }
    //Implementacion de interfaz InformacionCliente
    @Override
    public void mostrarInformacion() {
            System.out.println("RUT: " + rut);
            System.out.println("Nombre: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno);
            System.out.println("Domicilio: " + domicilio);
            System.out.println("Comuna: " + comuna);
            System.out.println("Teléfono: " + telefono);
            System.out.println("Tipo de Cuenta: "+ cuenta.getClass().getSimpleName());
            System.out.println("Número de Cuenta: " + cuenta.getNumeroCuenta());
            System.out.println("Saldo Actual: " + cuenta.getSaldo() + " pesos");
        }
    
    Cliente() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Getters
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    // Setters
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }
    
    public void verDatos() {
        mostrarInformacion();
    }
}

