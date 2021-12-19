import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Cliente novoCliente = new Cliente();
        novoCliente.setNome("Thiago");

        Banco banco = new Banco();
        Conta cc = banco.criarConta(novoCliente, TipoConta.CORRENTE);
        Conta poupanca = banco.criarConta(novoCliente, TipoConta.POUPANCA);

        cc.depositar(100);

        cc.transferir(50, poupanca);
        cc.depositar(100);
        cc.sacar(200);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        System.out.println(banco.getContas());
        System.out.println(banco.listaClientes());
    }
}
