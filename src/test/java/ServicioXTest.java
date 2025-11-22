/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServicioGrupo4Test {

    @Test
    void testNombreVacio() {
        assertFalse(ServicioGrupo4.validarCliente(""));
    }

    @Test
    void testNombreNulo() {
        assertFalse(ServicioGrupo4.validarCliente(null));
    }

    @Test
    void testNombreEspacios() {
        assertFalse(ServicioGrupo4.validarCliente("    "));
    }

    @Test
    void testNombreValido() {
        assertTrue(ServicioGrupo4.validarCliente("Carlos"));
    }
}

