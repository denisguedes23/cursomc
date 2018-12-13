package com.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.domain.Categoria;
import com.curso.repositories.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) throws ObjectNotFoundException {
		Categoria categoria = repo.findOne(id);
		if(categoria == null) {
				throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
						+ ", Tipo: " + Categoria.class.getName());
		}
		return categoria;
	}
}
