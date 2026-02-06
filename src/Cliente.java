public class Cliente {
    private final String nombre;
    private final String apellidos;
    private final String dni;
    private final String fechaNacimiento;
    private final String profesion;

    public Cliente(String nombre, String apellidos, String dni,
                   String fechaNacimiento, String profesion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        if (UtilisValidar.validarDNI(dni)){
            this.dni = dni;
        } else {
            this.dni = "00000000Z";
        }

        this.fechaNacimiento = fechaNacimiento;
        this.profesion = profesion;
    }
    public String getNombre (){
        return nombre;
    }
    public String getApellidos () {
        return apellidos;
    }
    public String getDni () {
        return dni;
    }
    public String getFechaNac () {
        return fechaNacimiento;
    }
    public String getProfesion () {
        return profesion;
    }
    public String getPersona (){
        return (getNombre()+" "+getApellidos()
                +" con DNI "+getDni()
                +" nacido en "+getFechaNac()+" y "+getProfesion()+" como profesión actual.");
    }
}
