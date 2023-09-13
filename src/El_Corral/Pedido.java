package El_Corral;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Pedido implements Producto {

    ArrayList<Producto> listaProductos;

    public int idPedido;

    private String nombreCliente;

    private String direccionCliente;

    private int caloriasTotales;

    public Pedido(String nombreCliente, String direccionCliente) {
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.listaProductos = new ArrayList<>();
    }

    public int getIdPedido() {
        return 7;
    }

    public void agregarProducto(Producto nuevoItem) {
        listaProductos.add(nuevoItem);
    }

    public int getPrecioNetoPedido() {
        int total = 0;
        for (Producto producto : listaProductos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public double getPrecioIVAPedido(int precioNeto) {
        return precioNeto * 0.19;
    }

    public double getPrecioTotalPedido(int precioNeto, double precioIVA) {
        return precioIVA + precioNeto;

    }

    public int getCalorias() {
        for (Producto producto : listaProductos) {
            caloriasTotales += producto.getCalorias();
        }
        return caloriasTotales;
    }

    public void generarTextoFactura() {

        String filePath = ".//src//Facturas//" + idPedido + ".txt";

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("-------------------------");
            bufferedWriter.newLine();
            bufferedWriter.write("FACTURA No. " + idPedido);
            bufferedWriter.newLine();
            bufferedWriter.write("PRODUCTOS");
            bufferedWriter.newLine();
            bufferedWriter.write("Nombre: " + nombreCliente);
            bufferedWriter.newLine();
            bufferedWriter.write("Direccion: " + direccionCliente);
            for (Producto producto : listaProductos) {
                bufferedWriter.newLine();
                bufferedWriter.newLine();
                bufferedWriter.write("    " + producto.getNombre());
                bufferedWriter.newLine();
                bufferedWriter.write("    " + producto.getCalorias() + " cal");
                bufferedWriter.newLine();
                bufferedWriter.write("    -->$" + producto.getPrecio());
            }
            int costoNeto = getPrecioNetoPedido();
            double IVA = getPrecioIVAPedido(costoNeto);

            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("Calorias Totales: " + getCalorias());
            bufferedWriter.newLine();
            bufferedWriter.write("Costo Neto " + costoNeto);
            bufferedWriter.newLine();
            bufferedWriter.write("IVA " + IVA);
            bufferedWriter.newLine();
            bufferedWriter.write("Costo Total " + getPrecioTotalPedido(costoNeto, IVA));
            bufferedWriter.newLine();
            bufferedWriter.write("-------------------------");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public double getPrecio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPrecio'");
    }

    @Override
    public String getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

    public boolean equals(Pedido pedido2) {

        ArrayList<String> nombresPedido2 = new ArrayList<>();
        for (Producto producto : pedido2.listaProductos) {
            nombresPedido2.add(producto.getNombre());
        }
        ArrayList<String> nombresPedido = new ArrayList<>();
        for (Producto producto : listaProductos) {
            nombresPedido.add(producto.getNombre());
        }
        Collections.sort(nombresPedido);
        Collections.sort(nombresPedido2);

        return nombresPedido.equals(nombresPedido2);
    }
}
