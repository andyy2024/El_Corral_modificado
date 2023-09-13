package El_Corral;

public class Ingrediente {
    private String nombre;
    private int costoAdicional;
    private int calorias;

    Ingrediente(String nombre, int costoAdicional, int calorias) {
        this.nombre = nombre;
        this.costoAdicional = costoAdicional;
        this.calorias = calorias;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return costoAdicional;
    }

    public int getCalorias() {
        return calorias;
    }
}
