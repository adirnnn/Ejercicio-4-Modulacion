public class Jugador {
    private String nombre;
    private String pais;
    private int faltas;
    private int golesDirectos;
    private int totalLanzamientos;

    public Jugador(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos) {
        this.nombre = nombre;
        this.pais = pais;
        this.faltas = faltas;
        this.golesDirectos = golesDirectos;
        this.totalLanzamientos = totalLanzamientos;
    }

    public double calcularEfectividad() {
        // Implementa la fórmula de efectividad común a todos los jugadores
        double efectividad = ((golesDirectos * 100.0) / totalLanzamientos);
        return efectividad;
    }

    // Getters y setters para los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getGolesDirectos() {
        return golesDirectos;
    }

    public void setGolesDirectos(int golesDirectos) {
        this.golesDirectos = golesDirectos;
    }

    public int getTotalLanzamientos() {
        return totalLanzamientos;
    }

    public void setTotalLanzamientos(int totalLanzamientos) {
        this.totalLanzamientos = totalLanzamientos;
    }
}