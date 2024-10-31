package AtividadesSemestre2.OrientaçãoObjeto.Agregação2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int nmrNota = 0;
        int id = 0;
        int qtd = 0;
        double vlrU = 0.0;
        String nmCliente = "";
        String descricao = "";

        System.out.print("Digite o número da nota fiscal: ");
        nmrNota = ler.nextInt();
        ler.nextLine();

        System.out.print("Digite o nome do cliente: ");
        nmCliente = ler.nextLine();

        NotaFiscal notaFiscal = new NotaFiscal(nmrNota, nmCliente);

        System.out.println("Adicione os Itens da Compra:");

        while (true) {
            System.out.print("Digite o ID do produto: ");
            id = ler.nextInt();
            ler.nextLine();

            System.out.print("Descrição do produto: ");
            descricao = ler.nextLine();

            System.out.print("Quantidade: ");
            qtd = ler.nextInt();

            System.out.print("Valor unitário: ");
            vlrU = ler.nextDouble();

            Produto produto = new Produto(id, descricao);
            NotaFiscalItem item = new NotaFiscalItem(notaFiscal.getItens().size() + 1, qtd, vlrU, 0, produto);
            notaFiscal.addItem(item);

            System.out.print("\nDeseja adicionar outro item? (s/n): ");
            char continuar = ler.next().charAt(0);
            ler.nextLine();

            if (continuar == 'n' || continuar == 'N') {
                break;
            }
        }

        System.out.println("--------------------------------------");
        notaFiscal.statusNotaFiscal();
        for (NotaFiscalItem item : notaFiscal.getItens()) {
            item.statusItem();
            item.getProduto().statusProduto();
        }
        System.out.println("--------------------------------------");
        ler.close();
    }
}