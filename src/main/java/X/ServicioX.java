/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package X;

public class X {

    public static boolean validarDescuentoAplicable(modelo.Producto p, double porcentaje) {
        return p.isDescuentoAplicable() && porcentaje >= 0 && porcentaje <= 50;
    }

    public static boolean validarCliente(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
