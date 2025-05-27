package ex1_s1_grupo8;
import java.util.Random;

public class RegistroCliente {
    private String nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono, rut;
    private int numeroCuenta;
    
    public RegistroCliente (String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String comuna, String rut, String telefono, RegistroCliente[]clientesExistentes){
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.rut = rut;
        this.telefono = telefono;
        
        Random random = new Random();
        int nCuenta;
        boolean unico;
        do{
            nCuenta = 100000000 + random.nextInt(900000000);
            unico = true;
        
            if (clientesExistentes != null) {
                for (RegistroCliente cliente : clientesExistentes) {
                    if (cliente != null && cliente.getNumeroCuenta() == nCuenta) {
                        unico = false;
                        break;
                    }
                }
            }
        }while(!unico);    
    }    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        if (nombre !=null && !nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }
    public String getApellidoPaterno(){
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno){
        if (apellidoPaterno !=null && !apellidoPaterno.isEmpty()) {
            this.apellidoPaterno = apellidoPaterno;
        }
    }
    public String getApellidoMaterno(){
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno){
        if (apellidoMaterno !=null && !apellidoMaterno.isEmpty()) {
            this.apellidoMaterno = apellidoMaterno;
        }
    }
    public String getDomicilio(){
        return domicilio;
    }
    public void setDomicilio(String domicilio){
        if (domicilio !=null && !domicilio.isEmpty()) {
            this.domicilio = domicilio;
        }
    }
    public String getComuna(){
        return comuna;
    }
    public void setComuna(String comuna){
        if (comuna !=null && !comuna.isEmpty()) {
            this.comuna = comuna;
        }
    }
    public String getRut(){
        return rut;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
            this.telefono = telefono;
    }
    public int getNumeroCuenta(){
        return this.numeroCuenta;
    }
}
