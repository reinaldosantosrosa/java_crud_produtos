package principal;

import java.util.Scanner;

import controllers.ProdutoController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Scanner scan = new Scanner(System.in);

			System.out.println("\n\n<< Manter Produto >>\n");
			System.out.println("1-Cadastrar Produto");
			System.out.println("2-Atualizar Produto");
			System.out.println("3-Excluir Produto");
			System.out.println("4-Consutar Produtos");

			System.out.println("\nEscolha uma opção:");
			Integer opcao = Integer.parseInt(scan.nextLine());

			ProdutoController produtoControler = new ProdutoController();

			switch (opcao) {
			case 1: produtoControler.cadastrarProduto();break;
			case 2: produtoControler.atualizaProduto();break;
			case 3: produtoControler.excluirProduto();break;
			case 4: produtoControler.consultarProdutos();break;
			default:
				System.out.print("erro");
				break;
			}
			
			System.out.print("\nDeseja continuar");
			String resp = scan.nextLine();
			
			if(resp.equalsIgnoreCase("S")) {
				main(args);
			}
			else {
				scan.close();	
			}
			

		} catch (Exception e) {

		}

		 
	}

}
