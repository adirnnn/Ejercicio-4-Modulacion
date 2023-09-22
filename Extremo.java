public class Extremo extends Jugador {
    private int pases;
    private int asistenciasEfectivas;

    public Extremo(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos, int pases, int asistenciasEfectivas) {
        super(nombre, pais, faltas, golesDirectos, totalLanzamientos);
        this.pases = pases;
        this.asistenciasEfectivas = asistenciasEfectivas;
    }

    @Override
    public double calcularEfectividad() {
        // Implementa la fórmula de efectividad para extremos
        double efectividad = ((pases + asistenciasEfectivas - getFaltas()) * 100.0) / (pases + asistenciasEfectivas + getFaltas());
        efectividad += ((getGolesDirectos() * 100.0) / getTotalLanzamientos());
        return efectividad;
    }

    // Getters y setters específicos para Extremo (pases y asistenciasEfectivas)

    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    public int getAsistenciasEfectivas() {
        return asistenciasEfectivas;
    }

    public void setAsistenciasEfectivas(int asistenciasEfectivas) {
        this.asistenciasEfectivas = asistenciasEfectivas;
    }
}