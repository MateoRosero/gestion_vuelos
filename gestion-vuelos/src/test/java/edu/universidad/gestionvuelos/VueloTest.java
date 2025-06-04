package edu.universidad.gestionvuelos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VueloTest {

    @Test
    void testConstructorValido() {
        Vuelo v = new Vuelo("AV123", "Quito", "Guayaquil", 100);
        assertEquals("AV123", v.getCodigo());
        assertEquals("Quito", v.getOrigen());
        assertEquals("Guayaquil", v.getDestino());
        assertEquals(100, v.getAsientosDisponibles());
    }

    @Test
    void testConstructorConPlazasNegativas() {
        assertThrows(IllegalArgumentException.class, () -> new Vuelo("AV001", "Quito", "Loja", -5));
    }

    @Test
    void reservarAsientoDisponible() {
        Vuelo v = new Vuelo("AV005", "Quito", "Cuenca", 2);
        v.reservarAsiento();
        assertEquals(1, v.getAsientosDisponibles());
    }

    @Test
    void reservarAsientoNoDisponible() {
        Vuelo v = new Vuelo("AV010", "Quito", "Guayaquil", 1);
        v.reservarAsiento();  // Ahora asientosDisponibles = 0
        assertThrows(IllegalStateException.class, v::reservarAsiento);
    }

    @Test
    void cancelarReservaIncrementaDisponibilidad() {
        Vuelo v = new Vuelo("AV020", "Guayaquil", "Quito", 0);
        v.cancelarReserva();
        assertEquals(1, v.getAsientosDisponibles());
    }
}
