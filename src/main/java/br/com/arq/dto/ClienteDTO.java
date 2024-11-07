package br.com.arq.dto;

import java.time.LocalDate;

import br.com.arq.model.Cliente;
import br.com.arq.model.Endereco;

public class ClienteDTO {

	 private Integer idCliente;
	 private String nome;
	 private String email;
	 private LocalDate data;
	 private String status;
	 
	 private Integer idEndereco;
	 private String bairro;
	 private String cidade;
	 private Cliente cliente;
	 private Endereco endereco;
	 
	 //Dica (mais forte nao tem parametro)
	 public Cliente toEntityCliente() {
		 Cliente cliente = new Cliente();
		  cliente.setNome(this.nome);
		  cliente.setEmail(this.email);
		  cliente.setStatus("CREATE");
		  cliente.setData(LocalDate.now());
				
		 return cliente;
	 }
	 
	 // recebe o mais Forte
	 public Endereco toEntityEndereco(Cliente cliente) {
		  Endereco endereco = new Endereco(); 
		      endereco.setBairro(this.bairro);
		      endereco.setCidade(this.cidade);
               endereco.setCliente(cliente); // relaciona e gera a estrangeira	
          return endereco;
	 }
	 
	//gera a tabela (alteracao) com id
	 public Cliente toEntityIdCliente() {
		 Cliente cliente = new Cliente();
		  cliente.setIdCliente(this.idCliente);
		  cliente.setNome(this.nome);
		  cliente.setEmail(this.email);
		  cliente.setStatus("CREATE");
		  cliente.setData(LocalDate.now());
		 return cliente;
	 }
	 
	

	 
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	 
	 
	 
}
