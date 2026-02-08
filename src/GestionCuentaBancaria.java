public class GestionCuentaBancaria {


    public static void gestionCB(CuentaBancaria cb, int opcion){

        //NOS DEVULEVE LA OPCION QUE SELECCIONEMOS
        switch (opcion){
            case 1:
                cb.mostrarInfoCuenta(true);
                break;
            case 2:
                System.out.println("IBAN: " + cb.getIban());
                break;
            case 3:
                cb.mostrarTitular();
                break;
            case 4:
                System.out.println("Saldo: " + cb.getSaldo());
                break;
            case 5:
                System.out.println("Introduce la cantidad que quiera ingresar: ");
                cb.ingreso(UtilisPintar.teclado.nextFloat(), 0);
                UtilisPintar.teclado.nextLine();
                break;
            case 6:
                System.out.println("Introduce la cantidad que quiera retirar: ");
                cb.retirada(UtilisPintar.teclado.nextFloat(), 0);
                UtilisPintar.teclado.nextLine();
                break;
            case 7:
                cb.mostrarMovimientos();
                break;
            case 8:
                CuentaBancaria destino = GestionDamBank.seleccionarCuenta();
                System.out.println("¿Cuanto quieres transferir?");
                int cantidadTransfer = UtilisPintar.teclado.nextInt();
                cb.transferir(destino, cantidadTransfer);
                break;
            case 9:
                System.out.println("Elige el tipo de riesgo para tu inversion (A/M/B)");
                String tipoR = UtilisPintar.teclado.next();
                System.out.println("¿Que cantidad quieres invertir?");
                int cantidad = UtilisPintar.teclado.nextInt();
                cb.invertir(tipoR, cantidad);
                break;
            case 0:
                System.out.println("SALIENDO DEL MENÚ DE GESTION DE CUENTAS");
                //System.exit(0);
                break;
            default:
                System.out.println("OPCIÓN INVÁLIDA");
                break;
        }
    }
}

