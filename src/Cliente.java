import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private double saldo;
    private double limite;
    private List<Compra> listaCompras;

    public Cliente(String nome, double limite) {
        this.nome = nome;
        this.limite = limite;
        this.saldo = limite;
        this.listaCompras = new ArrayList<>();
    }

    public boolean lancaCompra(Compra compra) {
        if (this.saldo > compra.getValorProduto()){
            this.saldo -= compra.getValorProduto();
            this.listaCompras.add(compra);
            return true;
        } else {
            return false;
        }
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void mostrarDados(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
        System.out.println("""
                
                ******************************
                
                Dados do Cliente:
                
                Nome: %s
                
                Saldo: R$ %.2f
                """.formatted(nome, saldo));
    }
}
