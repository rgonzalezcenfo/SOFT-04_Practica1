import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class RegistroUbicacion {

    private final String ID;
    private static int contador = 0;
    private LocalDate fecha;
    private LocalTime hora;
    private double[] coordenadas = new double[2];
    //coornedanas[0] > 0 -> Norte, coornedanas[0] < 0 -> Sur
    //coordenadas[1] > 0 -> Este, coornedanas[0] < 0 -> Oeste

    //constructor
    public RegistroUbicacion(double latitud, double longitud) {
        contador++;
        this.ID = "RU-" + contador;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
        this.coordenadas[0] = latitud;
        this.coordenadas[1] = longitud;
    }

    //getters

    public String getID() {
        return ID;
    }

    public static int getContador() {
        return contador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public double[] getCoordenadas() {
        return coordenadas;
    }

    //setters


    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setCoordenadas(double[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    //equals
    public boolean equals(RegistroUbicacion ubicacion) {
        return this.ID.equals(ubicacion.ID);
    }

    //ToString
    public String toString() {
        return "RegistroUbicacion{" +
                "ID='" + ID + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", coordenadas=" + Arrays.toString(coordenadas) +
                '}';
    }
}
