package pkg1_inventario;

import java.util.ArrayList;

public class InformeProductos {
    public void mostrarInforme(Inventario inventario) {
        System.out.println("\n--- INFORME DE PRODUCTOS ---");
        for (ArrayList<Object> producto : inventario.baseDatos) {
            System.out.printf("ID: %d | Producto: %s | Cantidad: %d | Costo: %.2f | Consumo Diario: %d\n",
                    producto.get(0), producto.get(1), producto.get(2), producto.get(3), producto.get(4));
        }
    }
}
