package app;

import entities.*;

import java.time.LocalDate;

public class SistemaBancario {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco("Caixa Economica");

        //instanciação de clientes
        Cliente cliente1 = new Cliente("João Silva", "123456789", LocalDate.of(2000, 5, 20));
        Cliente cliente2 = new Cliente("Maria Sousa", "9876543210", LocalDate.of(2009, 7, 15));


        banco.novoCliente(cliente1);
        banco.novoCliente(cliente2);
        

        //Abrindo novas contas
        ContaBancaria contaCorrente = banco.abrirConta(cliente1, new TipoConta("Corrente"), 500.0);
        ContaBancaria contaPoupanca = banco.abrirConta(cliente2, new TipoConta("Poupança"), 80.0);

        //Listagem de clientes e contas
        banco.listaClientes();
        banco.listarContas();

        //Operações bancárias
        contaCorrente.depositar(300.0);
        ((ContaPoupanca) contaPoupanca).rendimento();

        banco.realizarTransferencia(contaCorrente, contaPoupanca, 80.0);
        System.out.println("---------------Dados Atualizados---------------");
        //Contas atualizadas após a operação
        banco.listarContas();
    }
}
