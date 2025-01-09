package br.ufpb.dcx.projetoUnidade3;

import java.util.Objects;

public class Livro {
    private String titulo;
    private String autor;
    private int edicao;
    private String categoria;
    private String status;
    public static final String STATUS_PARA_LER = "PARA LER";
    public static final String STATUS_LENDO = "LENDO";
    public static final String STATUS_LIDO = "LIDO";
    public Livro(String titulo, String autor, int edicao, String categoria, String status){
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.categoria = categoria;
        this.status = status;
    }
    public Livro(){
        this("","",0,"","");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Double.compare(edicao, livro.edicao) == 0 && Objects.equals(titulo, livro.titulo) && Objects.equals(autor, livro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, edicao);
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public String getAutor(){
        return this.autor;
    }
    public void setEdicao(int edicao){
        this.edicao = edicao;
    }
    public int getEdicao(){
        return this.edicao;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public String getCategoria(){
        return this.categoria;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public String toString(){
        return ("\n - Título: "+this.titulo+ " - Autor: "+this.autor+ " - Edição: "+this.edicao+"ª"+ " - Categoria: "+this.categoria+ " - Status: "+this.status+
                "");
    }

}
