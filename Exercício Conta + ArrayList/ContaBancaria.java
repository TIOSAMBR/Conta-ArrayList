class ContaBancaria {
    private int numeroConta;
    private String nomeTitular;
    private double saldo;
    
    public ContaBancaria(int numeroConta, String nomeTitular, double saldoInicial) {
    this.numeroConta = numeroConta;
    this.nomeTitular = nomeTitular;
    this.saldo = saldoInicial;
    }
    
    public int getNumeroConta() {
    return numeroConta;
    }
    
    public String getNomeTitular() {
    return nomeTitular;
    }
    
    public double getSaldo() {
    return saldo;
    }
    
    public void depositar(double valor) {
    saldo += valor;
    }
    
    public void sacar(double valor) {
    saldo -= valor;
    }
    
    public void transferir(double valor, ContaBancaria contaDestino) {
    sacar(valor);
    contaDestino.depositar(valor);
    }
    }