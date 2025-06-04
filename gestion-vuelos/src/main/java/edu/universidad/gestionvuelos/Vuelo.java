package edu.universidad.gestionvuelos;

public class Vuelo {
    private String codigo;
    private String origen;
    private String destino;
    private int asientosDisponibles;

    public Vuelo(String codigo, String origen, String destino, int plazas) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        if (plazas < 0) throw new IllegalArgumentException("Plazas iniciales inválidas");
        this.asientosDisponibles = plazas;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    /** Reserva un asiento si hay disponibilidad. */
    public void reservarAsiento() {
        if (asientosDisponibles <= 0) {
            throw new IllegalStateException("No hay asientos disponibles");
        }
        asientosDisponibles--;
    }

    /** Cancela una reserva, incrementando la disponibilidad. */
    public void cancelarReserva() {
        asientosDisponibles++;
    }
}
