package br.com.arq.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer idCliente;
	 private String nome;
	 @Column(unique=true, length=255)
	 private String email;
	 private LocalDate data;
	 private String status;
	 
	 @OneToOne(mappedBy ="cliente" ,cascade= {CascadeType.ALL})
	 @JsonManagedReference
	 private Endereco endereco;
	 
	 
	 public Cliente() {
		 
	}
	 
	 
	public Cliente(Integer idCliente, String nome, String email, LocalDate data, String status) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.data = data;
		this.status = status;
	}


	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", email=" + email + ", data=" + data
				+ ", status=" + status + "]";
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


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	 
	 
     
	 
	
	

}
