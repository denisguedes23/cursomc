package com.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.domain.Categoria;
import com.curso.domain.Cidade;
import com.curso.domain.Cliente;
import com.curso.domain.Endereco;
import com.curso.domain.Estado;
import com.curso.domain.Produto;
import com.curso.domain.enums.TipoCliente;
import com.curso.repositories.CategoriaRepository;
import com.curso.repositories.CidadeRepository;
import com.curso.repositories.ClienteRepository;
import com.curso.repositories.EnderecoRepository;
import com.curso.repositories.EstadoRepository;
import com.curso.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 300.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(produto1, produto3));
		cat1.getProdutos().addAll(Arrays.asList(produto2));
		
		produto1.getCategorias().addAll(Arrays.asList(cat1));
		produto2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		produto1.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(produto1, produto2, produto3));
		
		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", estado1);
		Cidade c2 = new Cidade(null, "São Paulo", estado2);
		Cidade c3 = new Cidade(null, "Campinas", estado2);

		estado1.getCidades().addAll(Arrays.asList(c1));
		estado2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.save(Arrays.asList(estado1, estado2));
		cidadeRepository.save(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "1234454546", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("0923-9823", "2345-5667"));
		
		Endereco end1 = new Endereco(null, "Rua Flores", "234", "Supermercado cometa", "Cambeba", "60.303-345");
		Endereco end2 = new Endereco(null, "Rua Marias", "234", "Supermercado cometa", "Aldeota", "60.303-345");
		end1.setCidade(c1);
		
		end2.setCidade(c2);
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		enderecoRepository.save(Arrays.asList(end1, end2));
		clienteRepository.save(cli1);
		
		
	}

}

