package El_Corral;

import java.util.HashMap;

public class Combo implements Producto {
    private double descuento;
    private double precio;
    private String nombre;
    private String hamburguesa;
    private String bebida;
    private String papas;
    private int calorias;

    Combo(String nombre, double descuento, String hamburguesa, String bebida, String papas,
            HashMap<String, Double> mapaDePrecios, int calorias) {
        this.descuento = descuento;
        this.nombre = nombre;
        this.hamburguesa = hamburguesa;
        this.bebida = bebida;
        this.papas = papas;
        this.precio = calcularPrecio(mapaDePrecios);
        this.calorias = calorias;
    }

    double calcularPrecio(HashMap<String, Double> mapaDePrecios) {
        double total = mapaDePrecios.get(bebida) + mapaDePrecios.get(hamburguesa) + mapaDePrecios.get(papas);
        total = total * (1 - descuento / 100);
        return Math.round(total * Math.pow(10, 2)) / Math.pow(10, 2);
    }

    void agregarItemACombo(Producto itemCombo) {
        // useless function
    }

    public String getBebida() {
        return bebida;
    }

    public String getPapas() {
        return papas;
    }

    public String getHamburguesa() {
        return hamburguesa;
    }

    public int getCalorias() {
        return calorias;
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
    }
}
