import java.time.LocalTime;
import java.util.Scanner;
public class Estacionamento {

    Scanner sc = new Scanner(System.in);
    Carros[] veiculos = new Carros[50];
    private int totalVeiculos=0;
    private double tarifa=10.00;
    private double valorTotal;

    // metodo de adicionar veículo
    public void adicionarVeiculos(String placa,String modelo,LocalTime horaEntrada){
        if(totalVeiculos<50){
            
            Carros novoCarro = new Carros(placa,modelo,horaEntrada);
            
            int i =0;
            
            while(i<50){

                if(veiculos[i]==null){
                    veiculos[i]= novoCarro;
                    break;
                }
                i++;
            }

            System.out.println("Veículo Registrado as: "+veiculos[i].getHora_entrada());
            totalVeiculos++;

            // Chamada para exportar o backup após adicionar veículo
            VeiculosCSV.exportarBackupVeiculos(veiculos);

        }
        else{
            System.out.println("Sistema Cheio");
        }
    }

    //metodo de remover veículo
    public void removerVeiculo(String placa,LocalTime horarioSaida){
        
        int i=0;
        boolean sucesso=false;

        //procura o veículo pela placa
        while(i<50){

            if(veiculos[i]!=null){
                if(veiculos[i].getPlaca().equals(placa)){
                sucesso=true;
                break;
                }
            }
            i++;
        }
        //veiculo achado
        if(sucesso==true){
            
            LocalTime horaEntrada = veiculos[i].getHora_entrada();
            double valorTotal = calcularTarifa(horaEntrada, horarioSaida);

        // Retirar veículo da lista e
        
        System.out.println("--> Veículo de placa: "+veiculos[i].getPlaca()+" foi removido\nTotal a pagar:"+valorTotal);
        veiculos[i]=null;
        totalVeiculos--;

        // Chamada para exportar o backup após remover veículo
        VeiculosCSV.exportarBackupVeiculos(veiculos);
        
        }
        //nao achou o veículo
        else if(sucesso==false){
            System.out.println("Veículo de placa: "+placa+" não foi encontrado");
        }
    }
    //metodo que calcula a tarifa
    public double calcularTarifa(LocalTime horaEntrada, LocalTime horarioSaida) {

        double horasEstacionadas = (horarioSaida.getHour() - horaEntrada.getHour());
        double minutosEstacionados = (horarioSaida.getMinute() - horaEntrada.getMinute());
        
        int horasAPagar;
    
        if (horasEstacionadas <= 0 && minutosEstacionados > 0) {
            horasAPagar = 1; 
        }
        else{
            if (minutosEstacionados > 0) {
                horasAPagar = (int) horasEstacionadas + 1; 
            } else {
                horasAPagar = (int) horasEstacionadas; 
            }
        }
    
        return horasAPagar * tarifa; 
    }

    // metodo para imprimir os carros em lista
    public void getLista(){

        int i=0;
        int cont=0;

        while(i<50 && cont<=totalVeiculos){

            if(veiculos[i]!=null){
                System.out.println("--> Placa:"+veiculos[i].getPlaca()+"  Hora de entrada: "+veiculos[i].getHora_entrada());
                cont++;
            }
            i++;
        }
    }

    public int getTotalVeiculos() {
        return totalVeiculos;
    }



}
