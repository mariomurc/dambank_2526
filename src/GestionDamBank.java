import java.util.Random;


public class GestionDamBank {
    static CuentaBancaria cb[] = new CuentaBancaria[UtilisPintar.NUM_MAX_CUENTAS];
           //CuentaBancaria cb[] = new CuentaBancaria[Utilidades.NUM_MAX_CUENTAS];


    /*public static void mostrarInformacionCuentas() {
        System.out.println("---- INFORMACIÓN DE TODAS LAS CUENTAS ----");
        boolean algo = false;
        for (int i = 0; i < UtilisPintar.NUM_MAX_CUENTAS; i++) {
            if (cb[i] != null) {
                System.out.println("Cuenta " + (i + 1));
                cb[i].mostrarInfoCuenta();
                algo = true;
            }
        }
        if(!algo) System.out.println("NO HAY NINGUNA CUENTA");
    }*/



    public static void eliminarCuentaBancaria() {
        mostrarListadoIbansActivos();
        System.out.println();
        System.out.println("Ingrese el IBAN de la cuenta que quiere eliminar: ");
        String ibanAEliminar = UtilisPintar.teclado.nextLine();

        for (int i = 0; i < cb.length; i++) {
            if (cb[i] == null) {
            }
            else if (cb[i].getIban().equals(ibanAEliminar)) {
                System.out.println("Cuenta eliminada correctamente");
                if (CuentaBancaria.totalCuentas > 0) {
                    CuentaBancaria.totalCuentas--;
                    cb[i]  = null;
                }
            }
        }
        for (int i = 0; i < cb.length; i++) {
            if (i > 0 && cb[i-1] == null) {
                cb[i-1] =  cb[i];
                cb[i] = null;
            }
        }
    }

    public static CuentaBancaria seleccionarCuenta(){
        System.out.println("¿QUIERES UN LISTADO DE LOS IBAN DE DAMBANK? (S/N)");
        String resp = UtilisPintar.teclado.next();
        if (resp.equalsIgnoreCase("S")){
            mostrarListadoIbansActivos();
        }
        UtilisPintar.teclado.nextLine();
        System.out.println("INTRODUCE EL IBAN DE LA CUENTA: ");
        String iban = UtilisPintar.teclado.nextLine();
        for (int i = 0; i < CuentaBancaria.totalCuentas; i++) {
            if (cb[i] != null){
                if (cb[i].getIban().equals(iban)){
                    return cb[i];
                }
            }
        }
        return null;
    }

    public static void crearCuenta() {
        String numIban, numPin;
        //String titular;
        boolean ibanBien, pinBien;
        Random r = new Random();

        System.out.println();
        System.out.println("CREACION DE UNA CUENTA DAMBANK");
        System.out.println();
        String cod =String.valueOf(r.nextInt(0,10))+
                String.valueOf(r.nextInt(0,10))+
                String.valueOf(r.nextInt(0,10))+
                String.valueOf(r.nextInt(0,10));
        do {
            //System.out.println("Introduce el IBAN de la cuenta: ");
            numIban = "ES" + cod;
            //numIban = UtilisPintar.teclado.nextLine();
            ibanBien = UtilisValidar.validarIBAN(numIban);
        } while (ibanBien != true);

        do {
            //System.out.println("Introduce el PIN de la cuenta: ");
            //numPin = UtilisPintar.teclado.nextLine();
            numPin = cod;
            pinBien = UtilisValidar.validarPIN(numPin);
        } while (pinBien != true);
        //ahora tengo que pedir todos los datos del cliente (nombre, apellidos,
        //dni, y fecha_nac)

        Cliente c = crearCliente();
        cb[CuentaBancaria.totalCuentas] = new CuentaBancaria(numIban, c, numPin);
        System.out.println("CUENTA BANCARIA AÑADIDA AL SISTEMA");

    }
    public static Cliente crearCliente(){
        String dni, fechaNac;
        Random r = new Random();
        //System.out.println("INTRODUCE EL NOMBRE DEL TITULAR DE LA CUENTA: ");
        //String nombre = UtilisPintar.teclado.nextLine();
        String nombre = UtilisDatos.nombre[r.nextInt(0,UtilisDatos.nombre.length)];
        //System.out.println("INTRODUCE EL APELLIDO DEL TITULAR DE LA CUENTA: ");
        //String apellido = UtilisPintar.teclado.nextLine();
        String apellido = UtilisDatos.apellido[r.nextInt(0,UtilisDatos.apellido.length)];
        /*do{
            System.out.println("INTRODUCE EL DNI DEL TITULAR DE LA CUENTA: ");
            dni = UtilisPintar.teclado.nextLine();
        } while (!UtilisValidar.validarDNI(dni));*/
        dni="77777777E";

//        do{
//            System.out.println("INTRODUCE LA FEC DE NAC DEL TITULAR (Formato dd/mm/aaaa):");
//            fechaNac = UtilisPintar.teclado.nextLine();
//        } while (!UtilisValidar.validarFechaNac(fechaNac));
        fechaNac = "12/12/2012";
        String profesion = UtilisDatos.profesiones[r.nextInt(0,UtilisDatos.profesiones.length)];;

        return new Cliente(nombre, apellido, dni, fechaNac, profesion);
    }
    public static void mostrarListadoIbansActivos(){
        for (int i = 0; i < CuentaBancaria.totalCuentas; i++) {
            if (cb[i] != null || cb[i].isEstado()){
                cb[i].mostrarIban();
            }
        }
    }


}

