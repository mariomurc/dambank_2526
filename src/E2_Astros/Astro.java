package E2_Astros;

class Astro {

    // Atributos
    private String nombre;
    private double masa;
    private double diametroMedio;
    private double rotEje;
    private double traslacion;

    // Constructor
    public Astro(String nombre, double masa, double diamMedio, double rotEje,  double traslacion) {
        this.nombre = nombre;
        this.masa = masa;
        this.diametroMedio = diamMedio;
        this.rotEje = rotEje;
        this.traslacion = traslacion;
    }

   
    public void muestra() {
      System.out.println("NOMBRE           : " + getNombre());
      System.out.println("Masa:            : " + getMasa());
      System.out.println("Diametro MEdio   : " + getDiametroMedio());
      System.out.println("Rotacion Eje     : " + getRotEje());
      System.out.println("Traslacion       : " + getTraslacion());
    	
    	
    }
    // GETTERS Y SETTERS


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getMasa() {
        return masa;
    }
    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getDiametroMedio() {
        return diametroMedio;
    }

    public void setDiametroMedio(double diametroMedio) {
        this.diametroMedio = diametroMedio;
    }

    public double getRotEje() {
        return rotEje;
    }

    public void setRotEje(double rotEje) {
        this.rotEje = rotEje;
    }

    public double getTraslacion() {
        return traslacion;
    }

    public void setTraslacion(double traslacion) {
        this.traslacion = traslacion;
    }
}
