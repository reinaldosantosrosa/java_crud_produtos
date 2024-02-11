package entities;


public class Produto {
private Integer id;
private String nome;
private String desricao;
private Double preco;
private Integer quantidade;


public Produto(Integer id, String nome, String desricao, Double preco, Integer quantidade) {
	
	this.id = id;
	this.nome = nome;
	this.desricao = desricao;
	this.preco = preco;
	this.quantidade = quantidade;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getDesricao() {
	return desricao;
}
public void setDesricao(String desricao) {
	this.desricao = desricao;
}
public Double getPreco() {
	return preco;
}
public void setPreco(Double preco) {
	this.preco = preco;
}
public Integer getQuantidade() {
	return quantidade;
}
public void setQuantidade(Integer quantidade) {
	this.quantidade = quantidade;
}

public Produto() {
	// TODO Auto-generated constructor stub
}

}
