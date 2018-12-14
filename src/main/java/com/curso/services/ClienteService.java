package com.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.domain.Cliente;
import com.curso.repositories.ClienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) throws ObjectNotFoundException {
		Cliente Cliente = repo.findOne(id);
		if(Cliente == null) {
				throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
						+ ", Tipo: " + Cliente.class.getName());
		}
		return Cliente;
	}
}
