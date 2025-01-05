package pkg1_inventario;

import java.util.ArrayList;

public class ValorTotal {
    public void calcularValorTotal(Inventario inventario) {
        double total = 0;
        for (ArrayList<Object> producto : inventario.baseDatos) {
            int cantidad = (int) producto.get(2);
            double costo = (double) producto.get(3);
            total += cantidad * costo;
        }
        System.out.printf("\nEl valor total del inventario es: S/ %.2f\n", total);
    }
}
