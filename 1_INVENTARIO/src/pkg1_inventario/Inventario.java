package pkg1_inventario;

import java.util.ArrayList;

public class Inventario {
    ArrayList<ArrayList<Object>> baseDatos = new ArrayList<>();

    public Inventario() {
        // Datos de prueba
        agregarProducto(1, "Cables", 20, 40, 5);
        agregarProducto(2, "Tubos PVC", 50, 25, 10);
        agregarProducto(3, "Alambres", 100, 15, 20);
        agregarProducto(4, "Fusibles", 30, 10, 5);
        agregarProducto(5, "Interruptor", 60, 5, 8);
        agregarProducto(6, "TomaCorriente", 60, 5, 8);
        agregarProducto(7, "Placa", 60, 5, 8);
    }

    public void agregarProducto(int id, String nombre, int cantidad, double costo, int consumoDiario) {
        ArrayList<Object> producto = new ArrayList<>();
        producto.add(id);
        producto.add(nombre);
        producto.add(cantidad);
        producto.add(costo);
        producto.add(consumoDiario);
        baseDatos.add(producto);
    }
}
