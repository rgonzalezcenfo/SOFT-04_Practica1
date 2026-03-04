import java.util.ArrayList;

public class DispositivoLocalizacion {

    private final String ID;
    private static int contador = 0;
    private ArrayList<RegistroUbicacion> ubicaciones = new ArrayList<>();


    //constructor
    public DispositivoLocalizacion() {
        contador++;
        this.ID = "DL-" + contador;
    }

    //getters

    public String getID() {
        return ID;
    }

    public static int getContador() {
        return contador;
    }

    public ArrayList<RegistroUbicacion> getUbicaciones() {
        return ubicaciones;
    }

    public ArrayList<String> getUbicacionesIDs() {
         ArrayList<String> ubicacionesIDs = new ArrayList<>();

         ubicaciones.forEach(ubicacion -> ubicacionesIDs.add(ubicacion.getID()));

         return  ubicacionesIDs;
    }

    //equals

    public boolean equals(DispositivoLocalizacion dispositivo){
        return this.ID.equals(dispositivo.getID());
    }

    //toString
    public String toString() {
        return "DispositivoLocalizacion: " + ID;
    }

    //registraUbicacion

    public void registrarUbicacion(double latitud, double longitud){
        RegistroUbicacion ubicacion = new RegistroUbicacion(latitud, longitud);
        this.ubicaciones.add(ubicacion);
    }
}
