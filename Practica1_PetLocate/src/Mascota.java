public class Mascota {

    private final String ID;
    private static int contador = 0;
    private String nombre;
    private String especie;
    private DispositivoLocalizacion dispositivo;

    //constructor

    public Mascota(String nombre, String especie) {
        contador++;
        this.ID = "M-" + contador;
        this.nombre = nombre;
        this.especie = especie;
    }

    //getters

    public String getID() {
        return ID;
    }

    public static int getContador() {
        return contador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public DispositivoLocalizacion getDispositivo() {
        return dispositivo;
    }

    //setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    //equals
    public boolean equals(Mascota mascota){
        return this.ID.equals(mascota.getID());
    }

    //toString
    public String toString() {
        return "Mascota{" +
                "ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", dispositivo=" + dispositivo.getID() +
                '}';
    }

    //asociarDispositivo

    public void asociarDispositivo(){
        dispositivo = new DispositivoLocalizacion();
    }

    //getInfo
    public void getInfo(){
        System.out.println("ID:" + this.ID + ". Nombre: " + this.nombre + ". Especie: " + especie +
                            "\nDispositivo: " + dispositivo.getID() +
                            "\nUbicaciones:");
        dispositivo.getUbicaciones().forEach(ubicacion -> {
            System.out.println("UbicacionID:" + ubicacion.getID() + " Fecha:" + ubicacion.getFecha() +
                    " Hora:" + ubicacion.getHora());
            if (ubicacion.getCoordenadas()[0] > 0) {
                System.out.println("             Ubicacion: " + ubicacion.getCoordenadas()[0] + "° Norte");
            } else if (ubicacion.getCoordenadas()[0] < 0) {
                System.out.println("             Ubicacion: " + ubicacion.getCoordenadas()[0] + "° Sur");
            } else {
                System.out.println("             Ubicacion: " + "Latitud " + ubicacion.getCoordenadas()[0] + "°");
            }

            if (ubicacion.getCoordenadas()[1] > 0) {
                System.out.println("                        " + ubicacion.getCoordenadas()[1] + "° Este");
            } else if (ubicacion.getCoordenadas()[1] < 0) {
                System.out.println("                        " + ubicacion.getCoordenadas()[1] + "° Oeste");
            } else {
                System.out.println("                        " + "Longitud " + ubicacion.getCoordenadas()[1] + "°");
            }
        });
    }
}
