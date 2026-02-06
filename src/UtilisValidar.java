import java.time.Year;

public class UtilisValidar {
    public static boolean validarIBAN(String iban) {
        if (!iban.matches("^[A-Z]{2}\\d{4}")) {
            System.err.println("ERROR: el formato del IBAN no es correcto");
            return false;
        } else {
            return true;
        }
    }
    public static boolean validarPIN(String pin) {
        if (!pin.matches("^\\d{4}")) {
            System.err.println("ERROR: el formato del PIN no es correcto");
            return false;
        } else {
            return true;
        }
    }
    public static boolean validarDNI(String dni) {
        if (!dni.matches("^\\d{8}[A-Z]{1}")) {
            System.err.println("ERROR: el formato del DNI no es correcto");
            return false;
        } else {
            return true;
        }
    }

    public static boolean validarFechaNac(String fecha){
        String dia_=fecha.substring(0,2);
        int dia=Integer.parseInt(dia_);
        String mes_=fecha.substring(3,5);
        int mes=Integer.parseInt(mes_);
        String año_=fecha.substring(6,10);
        int anio=Integer.parseInt(año_);

        if (anio < 1900 || anio > 2026) {
            return false;
        }if (mes < 1 || mes > 12) {
            return false;
        }

        int diasMes;
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 ||
                mes == 8 || mes == 10 || mes == 12) {
            diasMes = 31;
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            diasMes = 30;
        } else {
            if (esBisiesto(anio)) {
                diasMes = 29;
            } else {
                diasMes = 28;
            }
        }
        return dia >= 1 && dia <= diasMes;

        }

        private static boolean esBisiesto(int anio) {
            return Year.isLeap(anio);
        }
    }


