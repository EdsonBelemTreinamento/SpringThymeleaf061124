package br.com.arq.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="enderecos")
public class Endereco {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEndereco;
	
	private String bairro;
	
	private String cidade;
	
	@OneToOne
	@JoinColumn(name = "cliente-id")
	@JsonBackReference 
	private Cliente cliente;

	
	public Endereco() {
		 
	}
	
	
	public Endereco(Integer idEndereco, String bairro, String cidade, Cliente cliente) {
		super();
		this.idEndereco = idEndereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", bairro=" + bairro + ", cidade=" + cidade + ", cliente="
				+ cliente + "]";
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
	
	
	
	

}
