package entities;

public abstract class ContaBancaria {
    private Integer numero;
    private Double saldo;
    private Cliente cliente;
    private TipoConta tipo;

    public ContaBancaria(Integer numero, Cliente cliente, TipoConta tipoConta){
        this.numero = numero;
        this.cliente = cliente;
        this.tipo = tipoConta;
        this.saldo = 0.0;
    }

    public void depositar(Double valor){
        this.saldo += valor;
    }

    public void sacar(Double valor){
        if (valor <= this.saldo) {
            this.saldo -= valor;
        }else{
            System.out.println("Saldo insuficiente!");
        }
    }

    public double getSaldo(){
        return saldo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public Integer getNumero(){
        return numero;
    }

    public TipoConta getTipo(){
        return tipo;
    }
}
