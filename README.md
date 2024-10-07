 # Programa de Estacionamento

## Descrição
Este projeto é um sistema de gerenciamento de estacionamento desenvolvido em Java. Ele permite o controle de entrada e saída de veículos, cálculo de tarifas e gerenciamento de vagas.

## Funcionalidades
- Adicionar veículos ao estacionamento.
- Remover veículos do estacionamento.
- Listar todos os veículos cadastrados.
- Calcular tarifas de estacionamento com base no tempo de permanência.
- Importar dados em formato CSV para restauração do sistema da execução anterior.

## Tecnologias Utilizadas
- Java 8 ou superior
- JUnit 4.13.2 para testes unitários
- Biblioteca Apache Commons CSV (1.12.0) para manipulação de arquivos CSV

- ## Como Configurar
1. Clone o repositório.
2. Navegue até o diretório do projeto.
3. Compile o projeto usando Maven.
4. Execute o projeto a partir da classe principal.

## Como Usar
Após iniciar o programa, você verá um menu interativo que permite realizar as seguintes operações:

1. **Adicionar Veículo**: Insira a placa do veículo. A hora de entrada é registrada automaticamente pelo sistema. O backup dos dados é feito automaticamente ao adicionar um veículo.
2. **Remover Veículo**: Digite a placa do veículo que deseja remover. A hora de saída é registrada automaticamente pelo sistema. O programa calculará a tarifa com base no tempo de permanência e exibirá o valor total a pagar. O backup dos dados também é feito automaticamente ao remover um veículo.
3. **Listar Veículos**: Liste todos os veículos atualmente no estacionamento.
4. **Importar Veículos**: Permite restaurar dados a partir de um arquivo CSV.

## Cálculo de Tarifas
A tarifa base do estacionamento é de R$10,00. O sistema calcula a cobrança com base no início de cada nova hora, ou seja:
- Se o veículo estiver estacionado por menos de uma hora, será cobrada uma tarifa de R$10,00.
- A cada nova hora completa, será adicionada a tarifa de R$10,00.

- ## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para criar um fork do repositório.


- 
