/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import base.Pedido;
import modelo.Producto;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    void testListaVacia() {
        List<Producto> productos = List.of();
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                Pedido.calcularTotalPedido(productos, 10));
        assertEquals("Error: no hay productos en el pedido", ex.getMessage());
    }

    @Test
    void testSubtotalCero() {
        List<Producto> productos = List.of(
                new Producto("X", 0, 1)
        );

        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                Pedido.calcularTotalPedido(productos, 10));
        assertEquals("Error: monto inválido", ex.getMessage());
    }

    @Test
    void testDescuentoValido() {
        List<Producto> productos = List.of(
                new Producto("A", 100, 2)
        );

        double total = Pedido.calcularTotalPedido(productos, 10);
        assertEquals(180.0, total);
    }

    @Test
    void testDescuentoCero() {
        List<Producto> productos = List.of(
                new Producto("A", 100, 2)
        );

        double total = Pedido.calcularTotalPedido(productos, 0);
        assertEquals(200.0, total);
    }
}

