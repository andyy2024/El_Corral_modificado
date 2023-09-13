package El_Corral;

public class Bebida implements Producto {

    private int precio;

    private String nombre;

    private int calorias;

    Bebida(String nombre, int precio, int calorias) {
        this.precio = precio;
        this.nombre = nombre;
        this.calorias = calorias;

    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void generarTextoFactura() {
        // useless
    }

    @Override
    public int getCalorias() {
        return calorias;
    }

}
