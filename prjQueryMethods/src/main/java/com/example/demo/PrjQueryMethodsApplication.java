package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Livro;
import com.example.demo.repositories.LivroRepository;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro saveLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro getLivroById(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }
    
    // Query buscar por titulo service
    public List<Livro> buscarPorTitulo (String titulo) {
    	return livroRepository.buscarPorTitulo(titulo);
    }
    
    public List<Livro> buscaPorAutor(String autor) {
    	return livroRepository.findByAutor(autor);
    }
    public List<Livro> buscarPorNome (String nome) {
    	return livroRepository.buscarPorNome(nome);
    }
    
    public List<Livro> buscaPorEditora(String editora) {
    	return livroRepository.buscarPorEditora(editora);
    }
    public List<Livro> buscaPorISBN(String isbn) {
    	return livroRepository.buscarPorISBN(isbn);
    }
}
