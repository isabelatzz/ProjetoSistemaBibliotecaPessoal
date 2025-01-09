package br.ufpb.dcx.projetoUnidade3;

public class LivroJaExiste extends Exception {
    public LivroJaExiste(String msg){
        super(msg);
    }
    public LivroJaExiste(){
        super();
    }
}
