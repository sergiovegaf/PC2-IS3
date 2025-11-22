/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import base.Pedido;
import modelo.Producto;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegracionTest {

    // Caso exitoso
    @Test
    void testFlujoCorrecto() {
        List<Producto> productos = List.of(
                new Producto("Laptop", 2500, 1),
                new Producto("Mouse", 100, 2)
        );

        double total = Pedido.calcularTotalPedido(productos, 10);
        boolean valido = ServicioGrupo4.validarCliente("Carlos");

        assertTrue(valido);
    }

    // Error en función base
    @Test
    void testErrorEnPedido() {
        List<Producto> productos = List.of();

        assertThrows(IllegalArgumentException.class, () -> {
            Pedido.calcularTotalPedido(productos, 10);
        });
    }

    // Error en función secundaria
    @Test
    void testErrorEnValidacionCliente() {
        List<Producto> productos = List.of(
                new Producto("Libro", 50, 1)
        );

        double total = Pedido.calcularTotalPedido(productos, 0);

        assertFalse(ServicioGrupo4.validarCliente(""));
    }

    // Valores límite
    @Test
    void testValorLimiteDescuento() {
        List<Producto> productos = List.of(
                new Producto("Item", 10, 10)
        );

        double total = Pedido.calcularTotalPedido(productos, 0);

        assertEquals(100, total);
    }

    // Combinación de validaciones
    @Test
    void testCombinacion() {
        List<Producto> productos = List.of(
                new Producto("Silla", 150, 2)
        );

        double total = Pedido.calcularTotalPedido(productos, 5);

        assertTrue(total > 0);
        assertTrue(ServicioGrupo4.validarCliente("Cliente Premium"));
    }
}

