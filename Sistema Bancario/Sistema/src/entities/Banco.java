package entities;

import java.util.ArrayList;

public class Banco {
    private String name;
    private ArrayList<Cliente> clientes;
    private ArrayList<ContaBancaria> contas;

    //Construtor principal da classe Banco
    public Banco(String name){
        this.name = name;
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    //métodos para crirar clientes novos e excluir clientes caso necessidade
    public void novoCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente){
        clientes.remove(cliente);
    }

    //método para listar todos os clientes cadastrados
    public void listaClientes(){
        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getNome() + " CPF: " + cliente.getCpf() + " Idade: " + cliente.getIdade());
        }
    }

    //Método de sobrecargas com o objetivo de abrir a conta sem um depósito inicial
    public ContaBancaria abrirConta(Cliente cliente, TipoConta tipo){
        return abrirConta(cliente, tipo, 0.0);
    }
        
    //Método de sobrecargas com o objetivo de abrir a conta com um depósito inicial
    public ContaBancaria abrirConta(Cliente cliente, TipoConta tipo, Double depositoInicial){
        int idade = cliente.getIdade();
        int numero = contas.size() + 1;
        ContaBancaria conta = null;

        if(tipo.getDescricao().equals("Corrente")){
            if(idade >= 18){
                conta = new ContaCorrente(numero, cliente, 500.0);
                conta.depositar(depositoInicial);
                contas.add(conta);
            }else{
                System.out.println("Cliente deve ter pelo menos 18 anos para abrir uma conta corrente!");
            }
        }else if(tipo.getDescricao().equals("Poupança")){
            if(idade >= 14){
                conta = new ContaPoupanca(numero, cliente, 0.5);
                conta.depositar(depositoInicial);
                contas.add(conta);
            }else{
                System.out.println("Cliente deve ter pelo menos 14 anos para abrir uma conta do tipo Poupança!");
            }
        }
        
        return conta;
    }

    //Método para fechar a conta caso necessidade 
    public void fecharConta(ContaBancaria conta){
        if(conta.getSaldo() >= 0){
            contas.remove(conta);
        }else{
            System.out.println("Não é possível fechar uma conta com saldo negativo!");
        }
    }

    //Método para listar as contas
    public void listarContas(){
        for (ContaBancaria conta : contas) {
            System.out.println("Conta: " + conta.getNumero() + "- Clientes: " + conta.getCliente().getNome() + " - Tipos: " + conta.getTipo().getDescricao() + " - Saldo: " + conta.getSaldo());
        }
    }

    //Método para realização de transferência
    public void realizarTransferencia(ContaBancaria contaOrigem, ContaBancaria contaDestino, double valor){
        if(contaOrigem.getSaldo() >= valor){
            contaOrigem.sacar(valor);
            contaDestino.depositar(valor);
        }else{
            System.out.println("Saldo insuficiente para transferência!");
        }
    }
}
