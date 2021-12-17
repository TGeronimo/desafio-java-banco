import lombok.Getter;
import lombok.ToString;

import java.io.File;
import java.io.FileWriter;

@Getter
@ToString
abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    private final Cliente cliente;

    public Conta(Cliente cliente) {
        agencia = AGENCIA_PADRAO;
        numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        // TODO: conferir saldo
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        // TODO: conferir saldo e conta de destino != conta de origem
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfoComuns() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agência: %d%n", this.agencia);
        System.out.printf("Número: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }
}
