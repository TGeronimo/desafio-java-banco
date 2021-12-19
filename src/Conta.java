import lombok.Getter;
import lombok.ToString;

import java.io.*;

@Getter
@ToString
abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    private final Cliente cliente;

    private final File arquivoSaldo = new File("saldo.txt");

    public Conta(Cliente cliente) {
        agencia = AGENCIA_PADRAO;
        numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    private void gravarSaldo(double saldo) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(arquivoSaldo.getName()))) {
            bufferedWriter.write(String.valueOf(saldo));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Não foi possível gravar o saldo.");
        }
    }

    private double lerSaldo() {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(arquivoSaldo.getName())
        )){
            double saldo = bufferedReader.read();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Não foi possível ler o saldo.");
        }

        return saldo;
    }

    @Override
    public void sacar(double valor) {
            this.saldo = lerSaldo();
        if (saldo >= valor) {
            this.saldo -= valor;

        } else System.out.println("Você não tem saldo suficiente.");
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        gravarSaldo(saldo);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        // TODO: conferir saldo e conta de destino != conta de origem
        if (contaDestino.numero == this.numero) {
            System.out.println("Conta de destino deve ser diferente da conta de origem");
        }
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
