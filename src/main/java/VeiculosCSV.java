import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

public class VeiculosCSV {

    private static String nomeArquivo = "src/main/dados/Veiculos.csv"; // Caminho do arquivo de backup

    // Método para exportar (backup) os veículos para o arquivo CSV
    public static void exportarBackupVeiculos(Carros[] veiculos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Carros carro : veiculos) {
                if (carro != null) {
                    writer.write(carro.getPlaca() + "," + carro.getModelo() + "," + carro.getHora_entrada());
                    writer.newLine();
                }
            }
            System.out.println("Backup realizado em: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao realizar backup: " + e.getMessage());
        }
    }

    // Método para importar (restaurar) os veículos do arquivo CSV
    public void importarBackupVeiculos(Estacionamento estacionamento) {

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            int index = 0;

            while ((linha = reader.readLine()) != null && index < 50) {
                String[] dados = linha.split(","); // Dividir a linha usando as virgulas
                String placa = dados[0];
                String modelo = dados[1];
                System.out.println(modelo);
                System.out.println(placa);
                LocalTime horaEntrada = LocalTime.parse(dados[2]);  
                estacionamento.adicionarVeiculos(placa, modelo, horaEntrada);
                index++;
            }
            System.out.println("Backup importado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao importar backup: " + e.getMessage());
        }
    }
    
    
}
