import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class JunitTest
{
    private Estacionamento estacionamento;
    LocalTime horaEntrada = LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS);
    LocalTime horarioSaida = LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS);

    @Before
    public void setUp() {
        estacionamento = new Estacionamento();
    }

    @Test
    public void testAdicionarVeiculos() {
        // Adiciona um veículo e verifica se ele foi adicionado corretamente
        estacionamento.adicionarVeiculos("ABC1234", "Fusca",horaEntrada);
        assertNotNull(estacionamento.veiculos[0]);  // Verifica se o veículo foi adicionado na primeira posição
        assertEquals("ABC1234", estacionamento.veiculos[0].getPlaca());
    }

    @Test
    public void testRemoverVeiculo() {
        // Adiciona e remove um veículo, verificando se foi removido corretamente
        estacionamento.adicionarVeiculos("ABC1234", "Fusca",horaEntrada);
        estacionamento.removerVeiculo("ABC1234",horarioSaida);
        assertNull(estacionamento.veiculos[0]);  // Verifica se o veículo foi removido
    }

        @Test
        public void testSistemaCheio() {
        // Preenche o estacionamento com 50 veículos
        for (int i = 0; i < 50; i++) {
            estacionamento.adicionarVeiculos("ABC" + i, "Modelo" + i,horaEntrada);
        }

        // Captura o total de veículos antes de tentar adicionar mais um
        int totalAntes = estacionamento.getTotalVeiculos();

        // Tenta adicionar um veículo quando o sistema já está cheio
        estacionamento.adicionarVeiculos("XYZ9999", "Sedan",horaEntrada);

        // Verifica se o total de veículos não aumentou
        assertEquals(totalAntes, estacionamento.getTotalVeiculos()); 
    }
    @Test
    public void testCalculoTarifa() {
        // Definindo os horários 
        LocalTime horaEntrada = LocalTime.of(13, 50); 
        LocalTime horarioSaida = LocalTime.of(19, 50); 
        
        // Chamando o método calcularTarifa e obtendo o valor
        double tarifa = estacionamento.calcularTarifa(horaEntrada, horarioSaida);
        
        // Verificando se a tarifa está correta
        assertEquals(60.0, tarifa, 0.01); 
    }

}
