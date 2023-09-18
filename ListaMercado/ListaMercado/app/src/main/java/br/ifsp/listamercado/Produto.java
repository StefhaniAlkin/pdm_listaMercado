package br.ifsp.listamercado;

public class Produto {
    private String nome;
    private String marca;
    private String quantidade;
    private String comprado;

    public Produto(String nome, String marca, String quantidade) {
        this.nome = nome;
        this.marca = marca;
        this.quantidade = quantidade;
        this.comprado = ""; // Inicialmente, o produto não está marcado como comprado
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getComprado() {
        return comprado;
    }

    public void setComprado(String comprado) {
        this.comprado = comprado;
    }

    @Override
    public String toString() {
        if (comprado.isEmpty()) {
            return nome + " - " + marca + " - Quantidade: " + quantidade;
        } else {
            return "* COMPRADO * " + nome + " - " + marca + " - Quantidade: " + quantidade;
        }
    }

}
