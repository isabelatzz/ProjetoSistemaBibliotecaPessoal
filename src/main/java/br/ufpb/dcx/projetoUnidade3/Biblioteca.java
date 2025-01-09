package br.ufpb.dcx.projetoUnidade3;

import java.util.List;

public interface Biblioteca {
    void cadastrarLivro(String titulo, String autor, int edicao, String categoria, String status)
            throws LivroJaExiste;
    void cadastrarLivro(Livro livro)
            throws LivroJaExiste;
    void atualizarStatusDeLivro(String titulo, String autor, int edicao, String status)
            throws LivroInexistente;
    Livro getLivro(String titulo, String autor, int edicao)
            throws LivroInexistente;
    List<Livro> pegarTodosOsLivros() throws LivroInexistente;
    List<Livro> livrosPorCategoria(String categoria)
            throws LivroInexistente;
    List<Livro> livrosPorStatus(String status) throws LivroInexistente;
    List<Livro> livrosPorAutor(String autor)
            throws LivroInexistente;
    List<Livro> livrosPorStatusECategoria(String status, String categoria) throws LivroInexistente;
    boolean  existeLivro(String titulo, String autor, int edicao);
    boolean existeLivroPorTitulo(String titulo) throws LivroInexistente;
    boolean existeLivroPorAutor(String autor) throws LivroInexistente;
    boolean existeLivroPorEdicao(int edicao) throws LivroInexistente;


}
