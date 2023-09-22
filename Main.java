import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Registrar jugador");
            System.out.println("2. Mostrar todos los jugadores");
            System.out.println("3. Mostrar los 3 mejores porteros");
            System.out.println("4. Mostrar la cantidad de extremos con más de 85% de efectividad");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    registrarJugador(scanner, jugadores);
                    break;
                case 2:
                    mostrarJugadores(jugadores);
                    break;
                case 3:
                    mostrarMejoresPorteros(jugadores);
                    break;
                case 4:
                    contarExtremosConEfectividad(jugadores);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void registrarJugador(Scanner scanner, ArrayList<Jugador> jugadores) {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el país del jugador: ");
        String pais = scanner.nextLine();
        System.out.print("Ingrese el número de faltas del jugador: ");
        int faltas = scanner.nextInt();
        System.out.print("Ingrese el número de goles directos del jugador: ");
        int golesDirectos = scanner.nextInt();
        System.out.print("Ingrese el total de lanzamientos del jugador: ");
        int totalLanzamientos = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.print("¿Es portero o extremo? (P/E): ");
        char tipo = scanner.nextLine().charAt(0);

        if (tipo == 'P' || tipo == 'p') {
            System.out.print("Ingrese el número de paradas efectivas del portero: ");
            int paradasEfectivas = scanner.nextInt();
            System.out.print("Ingrese el número de goles recibidos del portero: ");
            int golesRecibidos = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            Portero portero = new Portero(nombre, pais, faltas, golesDirectos, totalLanzamientos, paradasEfectivas, golesRecibidos);
            jugadores.add(portero);
            System.out.println("Portero registrado exitosamente.");
        } else if (tipo == 'E' || tipo == 'e') {
            System.out.print("Ingrese el número de pases del extremo: ");
            int pases = scanner.nextInt();
            System.out.print("Ingrese el número de asistencias efectivas del extremo: ");
            int asistenciasEfectivas = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            Extremo extremo = new Extremo(nombre, pais, faltas, golesDirectos, totalLanzamientos, pases, asistenciasEfectivas);
            jugadores.add(extremo);
            System.out.println("Extremo registrado exitosamente.");
        } else {
            System.out.println("Tipo de jugador no válido. Ingrese 'P' o 'E' para portero o extremo, respectivamente.");
        }
    }

    private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
        System.out.println("Lista de jugadores registrados:");
        for (Jugador jugador : jugadores) {
            System.out.println("Nombre: " + jugador.getNombre());
            System.out.println("País: " + jugador.getPais());
            System.out.println("Efectividad: " + jugador.calcularEfectividad());
            System.out.println("------------------------------");
        }
    }

    private static void mostrarMejoresPorteros(ArrayList<Jugador> jugadores) {
        ArrayList<Portero> porteros = new ArrayList<>();
        
        // Filtrar los jugadores que sean porteros y agregarlos a la lista de porteros
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Portero) {
                porteros.add((Portero) jugador);
            }
        }

        // Ordenar la lista de porteros por efectividad (de mayor a menor)
        porteros.sort((p1, p2) -> Double.compare(p2.calcularEfectividad(), p1.calcularEfectividad()));

        // Mostrar los 3 mejores porteros
        System.out.println("Los 3 mejores porteros:");
        int contador = 0;
        for (Portero portero : porteros) {
            if (contador < 3) {
                System.out.println("Nombre: " + portero.getNombre());
                System.out.println("Efectividad: " + portero.calcularEfectividad());
                System.out.println("------------------------------");
                contador++;
            } else {
                break; // Mostrar solo los 3 mejores porteros
            }
        }
    }

    private static void contarExtremosConEfectividad(ArrayList<Jugador> jugadores) {
        int extremosCon85Efectividad = 0;
        
        // Contar los extremos con más del 85% de efectividad
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Extremo && jugador.calcularEfectividad() > 85.0) {
                extremosCon85Efectividad++;
            }
        }

        // Mostrar la cantidad de extremos con más del 85% de efectividad
        System.out.println("Cantidad de extremos con más del 85% de efectividad: " + extremosCon85Efectividad);
    }
}