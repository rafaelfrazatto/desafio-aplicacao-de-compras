public class Compra implements Comparable<Compra>{
    private String produto;
    private double valorProduto;

    public Compra(String produto, double valorProduto) {
        this.produto = produto;
        this.valorProduto = valorProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public String getProduto() {
        return produto;
    }

    @Override
    public int compareTo(Compra outraCompra) {
        return Double.valueOf(this.valorProduto).compareTo(Double.valueOf(outraCompra.valorProduto));
    }

}
