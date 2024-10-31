package AtividadesSemestre2.OrientaçãoObjeto.Agregação2;

import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {
    private int numeroNota;
    private String nomeCliente;
    private double valorNota;
    private List<NotaFiscalItem> itens;

    public NotaFiscal(){}

    public NotaFiscal(int numeroNota, String nomeCliente){
        this.numeroNota = numeroNota;
        this.nomeCliente = nomeCliente;
        this.itens = new ArrayList<>();
    }
    public void addItem(NotaFiscalItem item){
        itens.add(item);
        attNota();
    }
    
    private void attNota(){
            valorNota = 0;
            for(NotaFiscalItem item : itens){
            valorNota += item.getValorTotalItem();
            }
    }

    public int getNmrNota() {
        return numeroNota;
    }

    public void setNmrNota(int numeroNota) {
        this.numeroNota = numeroNota;
    }

    public String getNmCliente() {
        return nomeCliente;
    }

    public void setNmCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getVlrNota() {
        return valorNota;
    }

    public void setVlrNota(double valorNota) {
        this.valorNota = valorNota;
    }

    public List<NotaFiscalItem> getItens() {
        return itens;
    }

    public void setItens(List<NotaFiscalItem> itens) {
        this.itens = itens;
    }

    public void statusNotaFiscal(){
        System.out.println("| Nota Fiscal |");
        System.out.println("Número da nota: " + this.numeroNota);
        System.out.println("Nome Cliente: " + this.nomeCliente);
        System.out.println("Valor da Nota: R$" + this.valorNota);
        System.out.println("--------------------------------------");
    }
}

class NotaFiscalItem {
    private int idItem;
    private int quantidade;
    private double valorUnitario;
    private double valorTotalItem;
    private Produto produto;

    public NotaFiscalItem(int idItem, int quantidade, double valorUnitario, double valorTotalItem, Produto produto){
        this.idItem = idItem;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.produto = produto;
        this.valorTotalItem = calcValor();
    }
    private double calcValor(){
        return quantidade * valorUnitario;
    }
    public int getIdItem() {
        return idItem;
    }
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getvalorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public double getValorTotalItem() {
        return valorTotalItem;
    }
    public void setValorTotalItem(double valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public void statusItem(){
        System.out.println("| Nota Fiscal Item |");
        System.out.println("Id item: " + this.idItem);
        System.out.println("Quantidade: " + this.quantidade);
        System.out.println("Valor Unitário: " + this.valorUnitario);
        System.out.println("Valor Total do Item: R$" + this.valorTotalItem + '\n');
    }
}

class Produto {

    private int id;
    private String descricao;

    public Produto(int id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void statusProduto(){
        System.out.println("Produto: " + this.id);
        System.out.println("Descrição: " + this.descricao + '\n');
        System.out.println("--------------------------------------");
    }
}
