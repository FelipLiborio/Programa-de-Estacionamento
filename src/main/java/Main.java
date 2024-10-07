import java.time.LocalTime;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Estacionamento estacionamento = new Estacionamento();
        Scanner sc = new Scanner(System.in);

        int m=0;
        int comand;

        while(m<1){

            System.out.println("|| MENU DE INTERAÇÃO||");
            System.out.println("1)Adcionar veículo.\n2)Remover veículo\n3)imprimir todos os veículos.\n4)Importar backup\n5)Fechar programa");
            comand = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha após o nextInt()

            if(comand==1){

                System.out.println("|Informações de cadastro|");

                System.out.println("Placa: ");
                String placa = sc.nextLine();

                System.out.println("Modelo: ");
                String modelo = sc.nextLine();

                LocalTime horaEntrada = LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS);

                estacionamento.adicionarVeiculos(placa,modelo, horaEntrada);
            }

            else if(comand==2){
                System.out.println("Digite a placa do veículo");
                String placa = sc.nextLine();

                LocalTime horarioSaida = LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS);

                estacionamento.removerVeiculo(placa,horarioSaida);
            }
            else if(comand==3){
                estacionamento.getLista();
            }
            else if(comand==4){
                VeiculosCSV backup = new VeiculosCSV();
                 backup.importarBackupVeiculos(estacionamento);
            }
            else if(comand==5){
                break;
            }

        }

    }
}
