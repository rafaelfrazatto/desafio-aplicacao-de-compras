import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int operacaoSelecionada = 0;
        int selecao = 0;

        Scanner leitura = new Scanner(System.in);


        System.out.println("Informe seu nome:");
        String nome = leitura.next();
        System.out.println("Informe seu saldo:");
        double limite = leitura.nextDouble();
        Cliente cliente1 = new Cliente(nome, limite);

        while (operacaoSelecionada != 4) {
            System.out.println("""
                ************ MENU ************
                
                1 - Saldo do cliente.
                2 - Adicionar produtos.
                3 - Produtos comprados.
                4 - Encerrar aplicação.
                
                ******************************""");
            operacaoSelecionada = leitura.nextInt();

            if (operacaoSelecionada == 1) {
                cliente1.mostrarDados(cliente1.getNome(), cliente1.getSaldo());
            } else if (operacaoSelecionada == 2){
                do { selecao = 1;
                    System.out.println("Digite o nome do produto:");
                    String produto = leitura.next();
                    System.out.println("Digite o valor do produto:");
                    double valorProduto = leitura.nextDouble();

                    Compra compra = new Compra(produto, valorProduto);
                    boolean compraRealizada = cliente1.lancaCompra(compra);

                    if (compraRealizada) {
                        System.out.println("Compra cadastrada!");
                        System.out.println("Digite 1 para continuar cadastrando, ou 0 para sair.");
                        selecao = leitura.nextInt();
                    } else {
                        System.out.println("Saldo insuficiente! Tente novamente.");
                        System.out.println("Digite 1 para continuar cadastrando, ou 0 para sair.");
                        selecao = leitura.nextInt();
                    }
                } while (selecao != 0);

            } else if (operacaoSelecionada == 3){
                System.out.println("******************************");
                System.out.println("\nCOMPRAS REALIZADAS:");
                Collections.sort(cliente1.getListaCompras());

                for (Compra c : cliente1.getListaCompras()){
                    System.out.println("Produto: %s | R$ %.2f".formatted(c.getProduto(),c.getValorProduto()));
                }
                System.out.println("\n******************************");
                System.out.println("Saldo atualizado: R$ %.2f".formatted(cliente1.getSaldo()));
                System.out.println("******************************");

            } else if (operacaoSelecionada == 4) {
                System.out.println("""
                        Obrigado por fazer uso da aplicação de compras.
                        """);
            } else {
                System.out.println("""
            
            A opção selecionada é inválida, tente novamente.
            """);
            }
        }



    }
}