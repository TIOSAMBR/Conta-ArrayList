import java.util.ArrayList;
import java.util.List;

class Banco {
    private List<ContaBancaria> contas;
    
    public Banco() {
    this.contas = new ArrayList<ContaBancaria>();
    }
    
    public void adicionarConta(ContaBancaria conta) {
    contas.add(conta);
    }
    
    public ContaBancaria buscarConta(int numeroConta) {
    for (ContaBancaria conta : contas) {
    if (conta.getNumeroConta() == numeroConta) {
    return conta;
    }
    }
    return null;
    }
    }