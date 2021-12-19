import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Banco {

    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContas(Conta conta) {
        this.contas.add(conta);
    }

    public Conta criarConta(Cliente cliente, TipoConta tipoConta) {
        Conta conta = tipoConta == TipoConta.CORRENTE ?
                new ContaCorrente(cliente) : new ContaPoupanca(cliente);
        setContas(conta);
        return conta;
    }

    public List<Cliente> listaClientes() {
        List<Cliente> clientes = new ArrayList<>();
        for (Conta conta:contas) {
            clientes.add(conta.getCliente());
        }
        return clientes;
    }




}
