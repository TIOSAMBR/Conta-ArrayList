import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
    Banco banco = new Banco();
    
        // Cria um objeto Scanner para ler a entrada do usuário
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            do {
                System.out.println("\nSelecione uma opção:");
                System.out.println("1 - Consultar saldo");
                System.out.println("2 - Depositar");
                System.out.println("3 - Sacar");
                System.out.println("4 - Criar conta");
                System.out.println("5 - Transferir");
                System.out.println("0 - Sair");
    
                // Lê a opção escolhida pelo usuário
                opcao = scanner.nextInt();
    
                switch (opcao) {
                    case 1:
                        // Lê o número da conta e consulta o saldo
                        System.out.print("Digite o número da conta: ");
                        int numeroConta = scanner.nextInt();
                        ContaBancaria conta = banco.buscarConta(numeroConta);
                        if (conta != null) {
                            System.out.println("Saldo: R$" + conta.getSaldo());
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
                        break;
                    case 2:
                        // Lê o número da conta, o valor do depósito e realiza o depósito
                        System.out.print("Digite o número da conta: ");
                        numeroConta = scanner.nextInt();
                        conta = banco.buscarConta(numeroConta);
                        if (conta != null) {
                            System.out.print("Digite o valor do depósito: ");
                            double valor = scanner.nextDouble();
                            conta.depositar(valor);
                            System.out.println("Depósito realizado com sucesso.");
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
                        break;
                    case 3:
                        // Lê o número da conta, o valor do saque e realiza o saque
                        System.out.print("Digite o número da conta: ");
                        numeroConta = scanner.nextInt();
                        conta = banco.buscarConta(numeroConta);
                        if (conta != null) {
                            System.out.print("Digite o valor do saque: ");
                            double valor = scanner.nextDouble();
                            if (valor <= conta.getSaldo()) {
                                conta.sacar(valor);
                                System.out.println("Saque realizado com sucesso.");
                            } else {
                                System.out.println("Saldo insuficiente.");
                            }
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
                        break;
                    case 4:
                        // Lê o número da conta, o nome do titular e o saldo inicial e cria uma nova conta
                        System.out.print("Digite o número da conta: ");
                        numeroConta = scanner.nextInt();
                        scanner.nextLine(); // consome a nova linha após o número da conta
                        System.out.print("Digite o nome do titular da conta: ");
                        String nomeTitular = scanner.nextLine();
                        System.out.print("Digite o saldo inicial da conta: ");
                        double saldoInicial = scanner.nextDouble();
                        ContaBancaria novaConta = new ContaBancaria(numeroConta, nomeTitular, saldoInicial);
                        banco.adicionarConta(novaConta);
                        System.out.println("Conta criada com sucesso.");
                        break;
                    case 5:
                        // Lê as informações da transferência e realiza a transferência
                        System.out.print("Digite o número da conta de origem: ");
                        int numeroContaOrigem = scanner.nextInt();
                        ContaBancaria contaOrigem = banco.buscarConta(numeroContaOrigem);
                    
                        if (contaOrigem != null) {
                            System.out.print("Digite o número da conta de destino: ");
                            int numeroContaDestino = scanner.nextInt();
                            ContaBancaria contaDestino = banco.buscarConta(numeroContaDestino);
                    
                            if (contaDestino != null) {
                                System.out.print("Digite o valor da transferência: ");
                                double valorTransferencia = scanner.nextDouble();
                    
                                if (valorTransferencia <= contaOrigem.getSaldo()) {
                                    contaOrigem.transferir(valorTransferencia, contaDestino);
                                    System.out.println("Transferência realizada com sucesso.");
                                } else {
                                    System.out.println("Saldo insuficiente.");
                                }
                            } else {
                                System.out.println("Conta de destino não encontrada.");
                            }
                        } else {
                            System.out.println("Conta de origem não encontrada.");
                        }
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } while (opcao != 0);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
