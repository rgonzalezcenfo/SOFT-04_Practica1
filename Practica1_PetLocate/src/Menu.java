import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Menu {
    private Scanner in = new Scanner(System.in);
    private boolean ejecutando = true;
    private ArrayList<Mascota> mascotas = new ArrayList<>();

    public void iniciarMenu(){
        while(ejecutando) {
            String mascotaID;

            System.out.println("Bienvenido a PetLocate!");
            System.out.println("1- Registre su mascota");
            System.out.println("2- Asocie su dispositivo");
            System.out.println("3- Registre una Ubicacion");
            System.out.println("4- Consulte la informacion de su mascota");
            System.out.println("X- Cerrar el programa");
            System.out.println("Elija una opcion...");

            switch (in.nextLine().toLowerCase()) {
                case "1":
                    System.out.println("Ingrese el nombre de su mascota...");
                    String mascotaNombre = in.nextLine();
                    System.out.println("Ingrese la especie de su mascota...");
                    String mascotaEspecie = in.nextLine();

                    Mascota mascota = new Mascota(mascotaNombre, mascotaEspecie);
                    mascotas.add(mascota);
                    System.out.println("El ID de su mascota es " + mascota.getID());
                    System.out.println(" ");
                    break;

                case "2":
                    System.out.println("Ingrese el ID de su mascota...");
                    mascotaID = in.nextLine().toUpperCase();
                    AtomicBoolean dispositivoCreado = new AtomicBoolean(false); //lo convirtio intelliJ para poder cambiarlo dentro del forEach()

                    mascotas.forEach(animal -> {
                        if (mascotaID.equals(animal.getID())) {
                            animal.asociarDispositivo();
                            dispositivoCreado.set(true);
                        }
                    });

                    if (dispositivoCreado.get()) {
                        System.out.println("Dispositvo creado con exito!");
                        System.out.println(" ");
                    } else {
                        System.out.println("No se encontro su mascota en el sistema");
                        System.out.println(" ");
                    }

                    break;

                case "3":
                    System.out.println("Ingrese el ID de su mascota...");
                    mascotaID = in.nextLine().toUpperCase();
                    AtomicBoolean ubicacionCreada = new AtomicBoolean(false); //lo convirtio intelliJ para poder cambiarlo dentro del forEach()

                    mascotas.forEach(animal -> {
                        double latitud = 0;
                        double longitud = 0;
                        if (mascotaID.equals(animal.getID()) && animal.getDispositivo() != null) {
                            boolean correctoLat = false;
                            boolean correctoLong = false;
                            while (!correctoLat) {
                                System.out.println("Ingrese la latitud de la ubicacion (valor entre 90 y -90)");
                                latitud = Double.parseDouble(in.nextLine());
                                if (latitud > 90 || latitud < -90) {
                                    System.out.println("Valor de Latitud invalido \nIntentelo de nuevo");
                                } else {
                                    correctoLat = true;
                                }
                            }
                            while (!correctoLong) {
                                System.out.println("Ingrese la longitud de la ubicacion (valor entre 180 y -180)");
                                longitud = Double.parseDouble(in.nextLine());
                                if (longitud > 180 || longitud < -180) {
                                    System.out.println("Valor de Longitud invalido \nIntentelo de nuevo");
                                } else {
                                    correctoLong = true;
                                }

                            }
                            ubicacionCreada.set(true);
                            animal.getDispositivo().registrarUbicacion(latitud, longitud);
                        }
                    });
                    if (ubicacionCreada.get()) {
                        System.out.println("Ubicacion registrada con exito!");
                        System.out.println(" ");
                    } else {
                        System.out.println("No se encontro su mascota en el sistema o su mascota no tiene un dispositivo asociado");
                        System.out.println(" ");
                    }
                    break;

                case "4":
                    System.out.println("Ingrese el ID de su mascota...");
                    AtomicBoolean reporteCreado = new AtomicBoolean(false);
                    mascotaID = in.nextLine().toUpperCase();

                    mascotas.forEach(animal -> {
                        if (mascotaID.equals(animal.getID())) {
                            animal.getInfo();
                            reporteCreado.set(true);
                        }
                    });
                    if (!reporteCreado.get()) {
                        System.out.println("No se encontro su mascota en el sistema");
                        System.out.println(" ");
                    }
                    break;

                case "x":
                    System.out.println("\nGracias por usar PetLocate");
                    System.out.println(" ");
                    ejecutando = false;
                    break;

                default:
                    System.out.println("Opcion Invalida");
                    System.out.println(" ");
                    break;

            }
        }
    }
}
