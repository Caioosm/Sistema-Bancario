package entities;

public class ContaPoupanca extends ContaBancaria {
    private Double taxaRendimento;

    public ContaPoupanca(int numero, Cliente cliente, Double taxaRendimento){
        super(numero, cliente, new TipoConta("Poupança"));
        this.taxaRendimento = taxaRendimento;
    }

    public void rendimento(){
        Double rendimento = getSaldo() * (taxaRendimento / 100);
        depositar(rendimento);
    }
}
