/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base;

import modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Producto> detallesPedido = new ArrayList<>();

    public boolean agregarProducto(Producto producto, int cantidad) {

        if (cantidad <= 0) {
            System.err.println("Error: cantidad inválida");
            return false;
        }

        boolean existe = detallesPedido.stream()
                .anyMatch(p -> p.getSku().equals(producto.getSku()));

        if (existe) {
            return false;
        }

        if (!producto.isEsActivo()) {
            return false;
        }

        Producto copia = new Producto(
                producto.getNombre(),
                producto.getPrecio(),
                cantidad,
                producto.getSku(),
                producto.getCategoria(),
                producto.isEsActivo(),
                producto.isDescuentoAplicable()
        );

        detallesPedido.add(copia);
        return true;
    }

    public boolean validarStock() {
        if (detallesPedido.isEmpty()) {
            return true;
        }

        return detallesPedido.stream().allMatch(p -> p.getCantidad() > 0);
    }

    public static double calcularTotalPedido(List<Producto> productos, double descuento) {

        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("Error: no hay productos en el pedido");
        }

        double subtotal = productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getCantidad())
                .sum();

        if (subtotal <= 0) {
            throw new IllegalArgumentException("Error: monto inválido");
        }

        return subtotal - (subtotal * (descuento / 100));
    }

    public List<Producto> getDetallesPedido() {
        return detallesPedido;
    }
}



