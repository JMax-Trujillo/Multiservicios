package pkg1_inventario;

import java.util.ArrayList;

public class VerificarStock {
    public void mostrarStock(Inventario inventario) {
        System.out.println("\n--- STOCK ACTUAL ---");
        for (ArrayList<Object> producto : inventario.baseDatos) {
            System.out.printf("ID: %d | Producto: %s | Cantidad: %d\n",
                    producto.get(0), producto.get(1), producto.get(2));
        }
    }
}
