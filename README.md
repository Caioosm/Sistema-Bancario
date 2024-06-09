# Sistema Bancário Simples

Este projeto é um sistema bancário simples desenvolvido em Java, com o objetivo de demonstrar os conceitos fundamentais de Programação Orientada a Objetos (POO). Ele permite gerenciar clientes e suas contas bancárias, realizar operações básicas como depósitos, saques e transferências, além de aplicar rendimentos em contas poupança.

## Funcionalidades

- **Gerenciamento de Clientes:** Adicionar, remover e listar clientes do banco.
- **Abertura de Contas:** Abrir contas correntes e poupança para clientes.
- **Operações Bancárias:** Realizar depósitos, saques e transferências entre contas.
- **Aplicação de Rendimentos:** Aplicar rendimentos em contas poupança.
- **Fechamento de Contas:** Fechar contas bancárias, garantindo que não haja saldo negativo.

## Estrutura do Projeto

O projeto está organizado nos seguintes pacotes:

- `entities`: Contém as classes que representam as entidades principais do sistema.
- `app`: Contém a classe principal responsável por executar o sistema.
- `util`: Reservado para classes utilitárias, caso necessário.

### Pacote `entities`

#### Cliente
Representa um cliente do banco.

- **Atributos:**
  - `nome`
  - `cpf`
  - `dataNascimento`
- **Métodos:**
  - `getNome()`
  - `getCpf()`
  - `getDataNascimento()`
  - `getIdade()`

#### TipoConta
Representa o tipo de conta (Corrente, Poupança, etc.).

- **Atributos:**
  - `descricao`
- **Métodos:**
  - `getDescricao()`

#### ContaBancaria (Classe Abstrata)
Classe base para diferentes tipos de contas bancárias.

- **Atributos:**
  - `numero`
  - `saldo`
  - `cliente`
  - `tipo`
- **Métodos:**
  - `depositar(double valor)`
  - `sacar(double valor)`
  - `getSaldo()`
  - `getCliente()`
  - `getNumero()`
  - `getTipo()`

#### ContaCorrente
Extende `ContaBancaria`.

- **Atributos:**
  - `limiteChequeEspecial`
- **Métodos:**
  - `sacar(double valor)` (sobrescreve método da classe base para incluir limite de cheque especial)

#### ContaPoupanca
Extende `ContaBancaria`.

- **Atributos:**
  - `taxaRendimento`
- **Métodos:**
  - `aplicarRendimento()`

#### Banco
Gerencia clientes e contas bancárias.

- **Atributos:**
  - `nome`
  - `clientes`
  - `contas`
- **Métodos:**
  - `adicionarCliente(Cliente cliente)`
  - `removerCliente(Cliente cliente)`
  - `listarClientes()`
  - `abrirConta(Cliente cliente, TipoConta tipo)`
  - `fecharConta(ContaBancaria conta)`
  - `listarContas()`
  - `realizarTransferencia(ContaBancaria contaOrigem, ContaBancaria contaDestino, double valor)`

### Pacote `app`

#### SistemaBancario
Classe principal que contém o método `main`. Demonstra a criação de clientes e contas, além de realizar operações bancárias.

## Regras de Negócio

1. **Criação de Contas:**
   - Conta Corrente: Apenas clientes com idade mínima de 18 anos podem abrir uma conta corrente.
   - Conta Poupança: Apenas clientes com idade mínima de 14 anos podem abrir uma conta poupança.
2. **Operações Bancárias:**
   - Depósitos e saques são permitidos em ambas as contas.
   - Transferências podem ser realizadas entre contas, desde que a conta de origem tenha saldo suficiente.
   - Aplicação de rendimentos é específica para contas poupança.
3. **Fechamento de Contas:**
   - Contas somente podem ser fechadas se o saldo não for negativo.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/sistema-bancario-simples.git
