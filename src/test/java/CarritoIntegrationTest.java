import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarritoIntegrationTest {

    // 2.1 TOTAL EXACTO SIN DESCUENTO
    @Test
    void totalSinDescuento() {
        Usuario u = new Usuario();
        Carrito c = new Carrito(u);

        c.agregar(new Item("A", 10.0));
        c.agregar(new Item("B", 20.0));
        c.agregar(new Item("C", 30.0));

        assertEquals(60.0, c.total());
    }

    // 2.2 TOTAL CON DESCUENTO VIP
    @Test
    void totalConDescuentoVIP() {
        Usuario u = new Usuario();
        u.agregarPuntos(50); // Usuario se vuelve VIP

        Carrito c = new Carrito(u);

        c.agregar(new Item("A", 10.0));
        c.agregar(new Item("B", 20.0));
        c.agregar(new Item("C", 30.0));

        assertEquals(48.0, c.total());
    }

    // 2.3 CANTIDAD DE ITEMS
    @Test
    void cantidadDeItemsEsTres() {
        Usuario u = new Usuario();
        Carrito c = new Carrito(u);

        c.agregar(new Item("A", 10.0));
        c.agregar(new Item("B", 20.0));
        c.agregar(new Item("C", 30.0));

        assertEquals(3, c.getCantidad());
    }
}
