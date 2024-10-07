import java.time.LocalTime;

public class Carros {
    private String placa;
    private String modelo;
    private LocalTime horaEntrada;

    public Carros( String placa, String modelo, LocalTime horaEntrada ){

        this.placa=placa;
        this.modelo=modelo;
        this.horaEntrada=horaEntrada;
    }

    // metodos get
    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalTime getHora_entrada() {
        return horaEntrada;
    }

    // metodos set

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setHora_entrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
}
