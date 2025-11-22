import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    // 1.1 Crear una prueba unitaria que valide que 10 / 2 = 5
    @Test
    void dividirDiezEntreDos_RetornaCinco() {
        Calculadora c = new Calculadora();
        assertEquals(5, c.dividir(10, 2));
    }

    // 1.2 Crear una prueba unitaria que valide que dividir entre 0 lanza excepción
    @Test
    void dividirEntreCero_LanzaExcepcion() {
        Calculadora c = new Calculadora();
        assertThrows(IllegalArgumentException.class, () -> {
            c.dividir(10, 0);
        });
    }

    // 1.3 Crear una prueba que valide que multiplicar(7,3)=21
    @Test
    void multiplicarSietePorTres_RetornaVeintiuno() {
        Calculadora c = new Calculadora();
        assertEquals(21, c.multiplicar(7, 3));
    }
}