package edu.universidad.gestionvuelos;

import java.util.HashMap;
import java.util.Map;

/**
 * Gestiona reservas de clientes en vuelos.
 * Internamente usa un mapa <String:cliente, String:codigoVuelo>.
 */
public class ReservaVuelo {
    // Mapa que relaciona nombre de cliente ↔ código de vuelo reservado
    private Map<String, String> mapaReservas = new HashMap<>();

    /** Agrega una reserva (cliente, vuelo). */
    public void agregarReserva(String cliente, String codigoVuelo) {
        if (cliente == null || cliente.isBlank() || codigoVuelo == null || codigoVuelo.isBlank()) {
            throw new IllegalArgumentException("Datos inválidos para reserva");
        }
        mapaReservas.put(cliente, codigoVuelo);
    }

    /** Elimina una reserva existente; devuelve true si existía. */
    public boolean cancelarReserva(String cliente) {
        return mapaReservas.remove(cliente) != null;
    }

    /** Consulta el código de vuelo reservado por un cliente (null si no existe). */
    public String obtenerVueloReserva(String cliente) {
        return mapaReservas.get(cliente);
    }
}
