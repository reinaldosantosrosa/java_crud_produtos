package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import entities.Produto;
import factories.ConnectionFactory;

public class ProdutoRepository {
	
	public void create(Produto produto)
	{
		try {
			
			ConnectionFactory con = new ConnectionFactory();
			Connection connection = con.getConnection();
			
			PreparedStatement statement = connection.prepareStatement
					          ("insert into produto(nome,descricao,preco,quantidade) values (?,?,?,?)");
			
			statement.setString(1,produto.getNome());
			statement.setString(2,produto.getDesricao());;
			statement.setDouble(3,produto.getPreco());
			statement.setInt(4,produto.getQuantidade());
		    
			statement.execute();
			
			connection.close();
			
			System.out.println("Produdo cadastrado com sucesso");
			
			
			
		} catch (Exception e) {
			System.out.println("ocorreu erro  " + e.getMessage());
		}
		}

	public void update(Produto produto)
	{
		try {
			
			ConnectionFactory con = new ConnectionFactory();
			Connection connection = con.getConnection();
			
			PreparedStatement statement = connection.prepareStatement
					          ("update produto set nome=?,descricao=?,preco=?,quantidade=? where id=?");
			
			statement.setString(1,produto.getNome());
			statement.setString(2,produto.getDesricao());;
			statement.setDouble(3,produto.getPreco());
			statement.setInt(4,produto.getQuantidade());
			statement.setInt(5,produto.getId());
		    
			statement.execute();
			
			connection.close();
			
			System.out.println("Produdo atualizado com sucesso");
			
			
		} catch (Exception e) {
			System.out.println("ocorreu erro  " + e.getMessage());
		}
		}
	
	public void delete(int Id)
	{
		try {
			
			ConnectionFactory con = new ConnectionFactory();
			Connection connection = con.getConnection();
			
			PreparedStatement statement = connection.prepareStatement
					          ("delete produto where id=?");
			
			statement.setInt(1,Id);
		    
			statement.execute();
			
			connection.close();
			
			System.out.println("Produdo excluido com sucesso");
			
			
		} catch (Exception e) {
			System.out.println("ocorreu erro  " + e.getMessage());
		}
		}
	
	public List<Produto> findAll() throws Exception
	{

			ConnectionFactory con = new ConnectionFactory();
			Connection connection = con.getConnection();
			
			PreparedStatement statement = connection.prepareStatement
					          ("select * from produto");
			
    
			ResultSet resultset = statement.executeQuery();
			
			List<Produto> lista = new ArrayList<>();
			
			while(resultset.next()) {
				Produto produto = new Produto();
				
				produto.setNome(resultset.getString("nome"));						
				produto.setDesricao(resultset.getString("descricao"));
				produto.setPreco(resultset.getDouble("preco"));
				produto.setQuantidade(resultset.getInt("quantidade"));
				produto.setId(resultset.getInt("id"));
				
				lista.add(produto);
				
			
			}
			
			connection.close();
			
			 return lista;			
	
		}
	
	public Produto findID(int Id) throws Exception
	{

			ConnectionFactory con = new ConnectionFactory();
			Connection connection = con.getConnection();
			
			PreparedStatement statement = connection.prepareStatement
					          ("select * from produto where id=?");
			
			statement.setInt(1,Id);
			
			ResultSet resultset = statement.executeQuery();
			
			Produto produto = null;	
		
			
			if(resultset.next()) {
								
				produto.setNome(resultset.getString("nome"));						
				produto.setDesricao(resultset.getString("descricao"));
				produto.setPreco(resultset.getDouble("preco"));
				produto.setQuantidade(resultset.getInt("quantidade"));
				produto.setId(resultset.getInt("id"));
				
							
			
			}
			
			connection.close();
			
			 return produto;			
	
		}
	
	
	
}
