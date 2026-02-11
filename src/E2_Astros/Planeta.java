package E2_Astros;

import java.util.ArrayList;

class Planeta extends Astro{

    // Atributos
    private double distSol;
    private boolean tieneSat;
    private Satelite[] satelites;

    // Constructor
    Planeta(String nombre, double masa, double diamMedio, double rotEje,  double traslacion,
            double gravedad, double distSol) {
        super(nombre, masa, diamMedio, rotEje, traslacion);
        this.distSol = distSol;
        this.tieneSat = false;
        this.satelites = new Satelite[5];
    }


    // Añadimos un satélite
    public void añadirSatelite(Satelite s) {
        //Añadir un satélite a la lista
        this.tieneSat = true;
    }

    // Mostramos información del planeta
    public void muestra() {
        System.out.println("*** PLANETA "+this.getNombre() +"***");
        super.muestra();
        System.out.println("Distancia al sol : " + this.getDistSol());
        System.out.println("Tiene satélites  : " + this.getTieneSat());
 
        
        if (tieneSat) {
            for (int i = 0; i < getSatelites().length; i++) {
                // completar
            }
        } 
    }

    // GETTERS Y SETTERS
    ;
    
    public double getDistSol() {
        return distSol;
    }

    public void setDistSol(double distSol) {
        this.distSol = distSol;
    }

    public boolean getTieneSat() {
        return tieneSat;
    }

    public void setTieneSat(boolean tieneSat) {
        this.tieneSat = tieneSat;
    }

    public Satelite[] getSatelites() {
        return satelites;
    }

    public void setSatelites(Satelite[] satelites) {
        this.satelites = satelites;
    }

}
