public class Portero extends Jugador {
    private int paradasEfectivas;
    private int golesRecibidos;

    public Portero(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos, int paradasEfectivas, int golesRecibidos) {
        super(nombre, pais, faltas, golesDirectos, totalLanzamientos);
        this.paradasEfectivas = paradasEfectivas;
        this.golesRecibidos = golesRecibidos;
    }

    @Override
    public double calcularEfectividad() {
        // Implementa la fórmula de efectividad para porteros
        double efectividad = ((paradasEfectivas - golesRecibidos) * 100.0) / (paradasEfectivas + golesRecibidos);
        efectividad += ((getGolesDirectos() * 100.0) / getTotalLanzamientos());
        return efectividad;
    }

    // Getters y setters específicos para Portero (paradasEfectivas y golesRecibidos)

    public int getParadasEfectivas() {
        return paradasEfectivas;
    }

    public void setParadasEfectivas(int paradasEfectivas) {
        this.paradasEfectivas = paradasEfectivas;
    }

    public int getGolesRecibidos() {
        return golesRecibidos;
    }

    public void setGolesRecibidos(int golesRecibidos) {
        this.golesRecibidos = golesRecibidos;
    }
}