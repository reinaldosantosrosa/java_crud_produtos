package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Produto;
import repositories.ProdutoRepository;

public class ProdutoController {
	
	public void cadastrarProduto() {
		try {
			System.out.print("\nCadastro de Produtos\n");
		
			Produto produto = new Produto();
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("Nome..........: ");
			produto.setNome(scan.nextLine());
			System.out.print("Descricao.....: ");
			produto.setDesricao(scan.nextLine());
			System.out.print("Preco.........: ");
			produto.setPreco(Double.parseDouble(scan.nextLine()));
			System.out.print("Qtd...........: ");
			produto.setQuantidade(Integer.parseInt(scan.nextLine()));
			
			ProdutoRepository produtoRepository = new ProdutoRepository();
			produtoRepository.create(produto);
			
			scan.close();
			
			
			
			
		} catch (Exception e) {
		}
	};

	public void atualizaProduto() {
		try {
			System.out.print("\nAtualiza Produtos\n");
		
			Scanner scan = new Scanner(System.in);
			
			System.out.print("Id  ..........: ");
			int Id = Integer.parseInt(scan.nextLine());
			
			ProdutoRepository produtoRepository = new ProdutoRepository();
			
			Produto produto = produtoRepository.findID(Id);
			
			if (produto!=null) {
				System.out.print("Nome..........: ");
				produto.setNome(scan.nextLine());
				System.out.print("Descricao.....: ");
				produto.setDesricao(scan.nextLine());
				System.out.print("Preco.........: ");
				produto.setPreco(Double.parseDouble(scan.nextLine()));
				System.out.print("Qtd...........: ");
				produto.setQuantidade(Integer.parseInt(scan.nextLine()));
		
				produtoRepository.update(produto);
				
				scan.close();					
			
			}
			else {
				System.out.print("\nProduto nao existe\n");
				
			}
					
			

			
		} catch (Exception e) {
			System.out.print("\nFalha ao Atualizar Produtos\n");
			
		}
	};
	
	public void excluirProduto() {
		try {
			System.out.print("\nExcluir um Produtos\n");
		
			Scanner scan = new Scanner(System.in);
			
			System.out.print("Id  ..........: ");
			int Id = Integer.parseInt(scan.nextLine());
			
			ProdutoRepository produtoRepository = new ProdutoRepository();

			produtoRepository.delete(Id);
				
		    scan.close();
			
		} catch (Exception e) {
			System.out.print("\nFalha ao Atualizar Produtos\n");
			
		}
	};


	public void consultarProdutos() {
		try {
		ProdutoRepository produtoRepository = new ProdutoRepository();
		List<Produto> lista = produtoRepository.findAll();
		
		if (lista!=null) {
			for (Produto produto:lista) {
			System.out.print("Nome..........: " + produto.getNome());
			System.out.print("Descricao.....: " + produto.getDesricao());
			System.out.print("Preco.........: " + produto.getPreco());
			System.out.print("Qtd...........: " + produto.getQuantidade());
			}
		}
		
		}
		catch (Exception e) {
		}
	};


}
