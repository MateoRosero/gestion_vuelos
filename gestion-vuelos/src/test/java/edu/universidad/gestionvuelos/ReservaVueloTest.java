package edu.universidad.gestionvuelos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReservaVueloTest {

    @Test
    void testAgregarReservaValida() {
        ReservaVuelo rv = new ReservaVuelo();
        rv.agregarReserva("Juan Pérez", "AV123");
        assertEquals("AV123", rv.obtenerVueloReserva("Juan Pérez"));
    }

    @Test
    void testAgregarReservaConDatosInvalidos() {
        ReservaVuelo rv = new ReservaVuelo();
        assertThrows(IllegalArgumentException.class, () -> rv.agregarReserva("", ""));
    }

    @Test
    void testCancelarReservaExistente() {
        ReservaVuelo rv = new ReservaVuelo();
        rv.agregarReserva("María Rodríguez", "AV456");
        boolean resultado = rv.cancelarReserva("María Rodríguez");
        assertTrue(resultado);
        assertNull(rv.obtenerVueloReserva("María Rodríguez"));
    }

    @Test
    void testCancelarReservaNoExistente() {
        ReservaVuelo rv = new ReservaVuelo();
        boolean resultado = rv.cancelarReserva("ClienteInexistente");
        assertFalse(resultado);
    }

    @Test
    void testObtenerVueloReservaInexistente() {
        ReservaVuelo rv = new ReservaVuelo();
        assertNull(rv.obtenerVueloReserva("SinReserva"));
    }
}
