import java.io.IOException;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato da Poupança ===");
        super.imprimirInfoComuns();
    }



}
