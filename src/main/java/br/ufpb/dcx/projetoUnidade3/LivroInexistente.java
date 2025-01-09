package br.ufpb.dcx.projetoUnidade3;

public class LivroInexistente extends Exception{
    public LivroInexistente(String msg){
        super(msg);
    }
    public LivroInexistente(){
        super();
    }
}
