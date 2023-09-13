package El_Corral;

public class ProductoMenu implements Producto {

    private String nombre;
    private int precioBase;
    private int calorias;

    ProductoMenu(String nombre, int precioBase, int calorias) {
        this.calorias = calorias;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    @Override
    public int getCalorias() {
        return calorias;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precioBase;
    }

    @Override
    public void generarTextoFactura() {
    }
}
