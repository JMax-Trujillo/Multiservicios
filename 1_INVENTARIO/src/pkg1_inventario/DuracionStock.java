package pkg1_inventario;

import java.util.ArrayList;

public class DuracionStock {
    public void calcularDuracion(Inventario inventario) {
        System.out.println("\n--- DURACIÓN DEL STOCK ---");
        for (ArrayList<Object> producto : inventario.baseDatos) {
            int cantidad = (int) producto.get(2);
            int consumoDiario = (int) producto.get(4);
            int dias = (consumoDiario > 0) ? cantidad / consumoDiario : 0;
            System.out.printf("ID: %d | Producto: %s | Duración estimada: %d días\n",
                    producto.get(0), producto.get(1), dias);
        }
    }
}
