package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	// Buscar por titulo
	@Query(value = "SELECT * FROM Livro l WHERE lower(l.titulo) LIKE %:titulo%", nativeQuery = true)
	List<Livro> buscarPorTitulo(@Param("titulo") String titulo);

	// Buscar por autor
	@Query("SELECT l FROM Livro l WHERE l.autor = ?1")
	List<Livro> findByAutor(String autor);
	
	@Query(value = "SELECT l FROM Livro l WHERE l.nome = ?1")
	List<Livro> buscarPorNome(@Param("nome") String nome);

	@Query(value = "SELECT l FROM Livro l WHERE l.editora = ?1")
	List<Livro> buscarPorEditora(@Param("editora") String editora);

	@Query(value = "SELECT l FROM Livro l WHERE l.isbn = ?1")
	List<Livro> buscarPorISBN(@Param("isbn") String isbn);
}
