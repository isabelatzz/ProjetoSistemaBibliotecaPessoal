package br.ufpb.dcx.projetoUnidade3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaPessoal implements Biblioteca {
    private List<Livro> livros;
    public BibliotecaPessoal(List<Livro> livros){
        this.livros = livros;
    }
    public BibliotecaPessoal(){
        this.livros = new ArrayList<>();
    }
    public void cadastrarLivro(String titulo, String autor, int edicao, String categoria, String status)
            throws LivroJaExiste {
        if(existeLivro(titulo, autor, edicao)){
            throw new LivroJaExiste("Esse livro já está cadastrado na biblioteca!");
        }
        Livro livro = new Livro(titulo, autor, edicao, categoria, status);
        this.livros.add(livro);
    }
    public void cadastrarLivro(Livro livro)
            throws LivroJaExiste {
        if(existeLivro(livro.getTitulo(),livro.getAutor(),livro.getEdicao())){
            throw new LivroJaExiste("Esse livro já está cadastrado na biblioteca!");
        }
        this.livros.add(livro);
    }
    public boolean existeLivro(String titulo, String autor, int edicao){
        Livro livro = new Livro(titulo,autor,edicao,"","");
        for(Livro l: this.livros){
            if(l.equals(livro)){
                return true;
            }
        }
        return false;
    }
    public boolean existeLivroPorTitulo(String titulo)
            throws LivroInexistente{
        for(Livro l: this.livros){
            if(l.getTitulo().equalsIgnoreCase(titulo)){
                return true;
            }
        }
        throw new LivroInexistente("Não há livro com esse título, tente novamente");
    }
    public boolean existeLivroPorAutor(String autor)
            throws LivroInexistente{
        for(Livro l: this.livros){
            if(l.getAutor().equalsIgnoreCase(autor)){
                return true;
            }
        }
        throw new LivroInexistente("Não há livro deste autor, tente novamente");
    }
    public boolean existeLivroPorEdicao(int edicao) throws LivroInexistente{
        for(Livro l: this.livros){
            if(l.getEdicao()==edicao){
                return true;
            }
        }
        throw new LivroInexistente("Não há livro desta edição, tente novamente");
    }
    public void atualizarStatusDeLivro(String titulo, String autor, int edicao, String status)
            throws LivroInexistente{
        //aparentemente não precisa do throw por causa do metodo "getLivro" que já retorna um exception caso o livro não exista
        for(Livro l: this.livros){
            if(l.equals(getLivro(titulo,autor,edicao))){
                l.setStatus(status);
            }
        }
    }
    public Livro getLivro(String titulo, String autor, int edicao)
            throws LivroInexistente {
        Livro livro = new Livro(titulo, autor, edicao,"","");
        for (Livro l : this.livros) {
            if (l.equals(livro)) {
                return l;
            }
        }
        throw new LivroInexistente("Livro inexistente");
    }
    //tentar emplementar com ayla esse codigo
    public Livro getLivro(){
        if(livros != null && !livros.isEmpty()){
            return livros.get(0);
        }
        return null;
    }
    public List<Livro> pegarTodosOsLivros()
            throws LivroInexistente{
        if(this.livros.isEmpty()){
            throw new LivroInexistente("Biblioteca vazia, cadastre alguns livros");
        }
        return this.livros;
    }
    public List<Livro> livrosPorCategoria(String categoria)
            throws LivroInexistente{
        List<Livro> livrosCategoria = new ArrayList<>();
        for(Livro l: this.livros){
            if((l.getCategoria().equalsIgnoreCase(categoria))){
                livrosCategoria.add(l);
            }
        }
        if(livrosCategoria.isEmpty()){
            throw new LivroInexistente("Não há livros desta categoria");
        }
        return livrosCategoria;
    }
    public List<Livro> livrosPorStatus(String status)
            throws LivroInexistente{
        List<Livro> livrosStatus = new ArrayList<>();
        for(Livro l: this.livros){
            if(l.getStatus().equals(status)){
                livrosStatus.add(l);
            }
        }
        if(livrosStatus.isEmpty()){
            throw new LivroInexistente("Não há livros cadastrados com esse status");
        }
        return livrosStatus;
    }
    public List<Livro> livrosPorAutor(String autor)
            throws LivroInexistente{
        List<Livro> livrosAutor = new ArrayList<>();
        for(Livro l: this.livros){
            if(l.getAutor().equalsIgnoreCase(autor)){
                livrosAutor.add(l);
            }
        }
        if(livrosAutor.isEmpty()){
            throw new LivroInexistente("Não há livros deste autor na biblioteca");
        }
        return livrosAutor;
    }
    public List<Livro> livrosPorStatusECategoria(String status, String categoria)
            throws LivroInexistente{
        List<Livro> livrosStatusCategoria = new ArrayList<>();
        for(Livro l: this.livros){
            if(l.getStatus().equals(status)) {
                if (l.getCategoria().equalsIgnoreCase(categoria)) {
                    livrosStatusCategoria.add(l);
                } else {
                    throw new LivroInexistente("Não há livros deste autor cadastrado no sistema");
                }
            } else {
                throw new LivroInexistente("Não há livros cadastrados com esse status");
            }
        }
        if(livrosStatusCategoria.isEmpty()){
            throw new LivroInexistente("Não há livros cadastrados");
        }
        return livrosStatusCategoria;
    }
}