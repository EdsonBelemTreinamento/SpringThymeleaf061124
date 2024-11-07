package br.com.arq.controller;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.arq.dto.ClienteDTO;
import br.com.arq.model.Cliente;
import br.com.arq.model.Endereco;
import br.com.arq.repository.ClienteRepository;
import br.com.arq.repository.EnderecoRepository;

@RequestMapping("/cliente")
@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping("/")
	 public String init(Model model) {
		//pode ser seu html inicial ...
		 model.addAttribute("clienteDTO", new ClienteDTO());
		 return "clienteform";
	 }
	
	
	@GetMapping("/novo")
	 public String clienteDTONovo(Model model) {
		//pode ser seu html inicial ...
		 model.addAttribute("clienteDTO", new ClienteDTO());
		 return "clienteform";
	 }
	
	
	@PostMapping("/gravar")
	public String gravarDto(@ModelAttribute("clienteDTO") ClienteDTO clienteDTO, Model model) {
		try {
			
	      Cliente  resgataCliente = clienteDTO.toEntityCliente();
			 
	       if (resgataCliente==null) {
	    	   throw new Exception ("error de relacionamento");
	       }
	       
	       //objeto do cliente (chave primaria)
	        Cliente respGravar= clienteRepository.save(resgataCliente); // chave primária gravar 
	      
	        Endereco resposta = clienteDTO.toEntityEndereco(respGravar); // ao passar cliente no set relaciona as tabelas ...
			Endereco respGravarEnd= enderecoRepository.save(resposta);
			
			  model.addAttribute("message", "Dados Gravados :" + respGravar.toString() + ", " + respGravarEnd.toString() );
	        return "clienteform";
		}catch(Exception ex) {
			model.addAttribute("message", "Error :" + ex.getMessage());
	        return "clienteform";
		}
		
	}
	
	
}
