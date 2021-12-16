public class Main {

    public static void main(String[] args) {

        Cliente novoCliente = new Cliente();
        novoCliente.setNome("Thiago");

        Conta cc = new ContaCorrente(novoCliente);
        cc.depositar(100);

        Conta poupanca = new ContaPoupanca(novoCliente);

        cc.transferir(50, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
