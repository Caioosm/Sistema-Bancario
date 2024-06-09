package entities;

public class ContaCorrente extends ContaBancaria {
    private Double limiteChequeEspecial;

    public ContaCorrente(int numero, Cliente cliente, double limiteChequeEspecial){
        super(numero, cliente, new TipoConta("Corrente"));
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    //@Override
    public void sacar(double valor){
        if(valor <= getSaldo() + limiteChequeEspecial){
            depositar(-valor);
        }else{
            System.out.println("Saldo e limite de cheque especial insuficiente!");
        }
    }
}
