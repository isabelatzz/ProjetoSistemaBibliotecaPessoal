package br.ufpb.dcx.projetoUnidade3;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ProgramaBiblioteca {
    //metodo para usar a determinação de N status
    public static String metodoStatusConstante(String opcoes){
        return switch (opcoes) {
            case "2" -> (Livro.STATUS_LENDO);
            case "3" -> (Livro.STATUS_LIDO);
            default -> (Livro.STATUS_PARA_LER);
        };
    }
    public static void main(String[] args){
        ImageIcon icon = new ImageIcon("C:\\Users\\arauj\\Downloads\\iconzinho.jpg");
        ImageIcon icon2 = new ImageIcon("C:\\Users\\arauj\\Downloads\\iconPADRAO (4).jpg");

        Biblioteca sistema = new BibliotecaPessoal();
        boolean continuar = true;
        while (continuar) {
            String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opção para gerenciar sua biblioteca: \n" +
                    "\n1- Cadastrar livro" +
                    "\n2- Mostrar todos os livros da minha biblioteca" +
                    "\n3- Mostrar todos os livros por categoria" +
                    "\n4- Mostrar livros por status" +
                    "\n5- Mostrar livros por autor" +
                    "\n6- Mostrar todos os livros por status e por categoria" +
                    "\n7- Atualizar status de livro" +
                    //possivel apagar livro
                    "\n8- Salvar dados" +
                    "\n9- Sair", "Menu da Biblioteca", JOptionPane.QUESTION_MESSAGE,
                    icon, null, null);
            try {
                switch (opcao) {
                    case "1": //Cadastrar livro
                        String titulo = (String) JOptionPane.showInputDialog(null, "Bem-vindo à sua biblioteca pessoal! \n\n" +
                                "Qual é o título do seu livro que você deseja adicionar?", "Adicionar Livro", JOptionPane.QUESTION_MESSAGE, icon2, null, null);
                        String autor = (String) JOptionPane.showInputDialog(null, "Ótima escolha! \n\n" +
                                "Quem é o autor desse livro incrível?",  "Autor do Livro", JOptionPane.QUESTION_MESSAGE, icon2, null, null);
                        try {
                            int edicao = Integer.parseInt(JOptionPane.showInputDialog(null, "Perfeito! \n\n" +
                                    "Qual é a edição desse livro que você está adicionando? (Digite um número) ",
                                    "Edição do Livro", JOptionPane.QUESTION_MESSAGE, icon2, null, null).toString());
                            String categoria = (String) JOptionPane.showInputDialog(null, "Insira a categoria do livro: \n" +
                                    "(Exemplo: romance, drama, terror, etc.)",
                                    "Cadastro de Categoria", JOptionPane.QUESTION_MESSAGE, icon2, null, null);
                            String statusOpcao = (String) JOptionPane.showInputDialog(null, "Digite a opção de status:\n"+"(Opção padrão: PARA LER)"+
                                    "\n1- PARA LER" +
                                    "\n2- LENDO" +
                                    "\n3- LIDO",
                                    "Acompanhamento de Leitura", JOptionPane.QUESTION_MESSAGE, icon2, null, null);
                            String status = metodoStatusConstante(statusOpcao); //metodo da classe
                            if (!(titulo.isEmpty() && autor.isEmpty() && categoria.isEmpty())) {
                                try {
                                    sistema.cadastrarLivro(titulo, autor, edicao, categoria, status);
                                     JOptionPane.showMessageDialog(null, "Sucesso! O livro \"" + titulo + "\" foi cadastrado na sua biblioteca!", "Cadastro de Livro", JOptionPane.INFORMATION_MESSAGE,
                                             icon2);
                                } catch (LivroJaExiste l) {
                                    JOptionPane.showMessageDialog(null, l.getMessage());
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Ops! Parece que você digitou um livro que não está cadastrado! \n\n" + "Tente novamente :)");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Edição inválida\n" + "(Exemplos válidos: 1, 2, 3...)");
                        }
                        break;
                    case "2": //Mostrar todos os livros
                        try {
                            JOptionPane.showMessageDialog(null, sistema.pegarTodosOsLivros().toString());
                        } catch (LivroInexistente e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        break;
                    case "3": //Mostrar todos os livros por categoria
                        try {
                            String categoria3 = (String) JOptionPane.showInputDialog(null, "Por favor, insira a categoria de livros que você gostaria de ver.\n\nExemplos: Ficção, Tecnologia, História, Autoajuda.\n\nDigite a categoria:",
                            "Categoria Desejada", JOptionPane.QUESTION_MESSAGE, icon2, null, null);
                            JOptionPane.showMessageDialog(null, sistema.livrosPorCategoria(categoria3).toString());
                        } catch (LivroInexistente e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        break;
                    case "4"://Mostrar livros por status
                        try {
                            String statusOpcao4 = (String) JOptionPane.showInputDialog(null, "Escolha o status do livro que deseja ver:\n\nDigite um *número* correspondente!\n" +
                                    "\n1- PARA LER" +
                                    "\n2- LENDO" +
                                    "\n3- LIDO", "Mostrar Livros Por Status", JOptionPane.QUESTION_MESSAGE, icon2, null, null);
                            String status4 = metodoStatusConstante(statusOpcao4); //metodo da classe
                            JOptionPane.showMessageDialog(null, sistema.livrosPorStatus(status4).toString());
                        } catch (LivroInexistente e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }

                        break;
                    case "5": //Mostrar livros por autor
                        try {
                            String autor5 = (String) JOptionPane.showInputDialog(null, "Vamos encontrar os livros por autor!\n\n" +
                                    "Por favor, insira o nome do autor que deseja procurar:", "Buscar por Autor", JOptionPane.QUESTION_MESSAGE, icon2, null, null );
                            JOptionPane.showMessageDialog(null, sistema.livrosPorAutor(autor5).toString());
                        } catch (LivroInexistente e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        break;
                    case "6": //Mostrar todos os livros por status e por categoria
                        try {
                            String opcaoStatus6 = (String) JOptionPane.showInputDialog(null, "Deseja buscar livro por status e categoria?\n\n" +
                                    "Insira um número correspondente do status que deseja ver:\n" +
                                    "\n1- PARA LER" +
                                    "\n2- LENDO" +
                                    "\n3- LIDO", "Escolha por Status e Categoria", JOptionPane.QUESTION_MESSAGE, icon2,null, null);
                            String status6 = metodoStatusConstante(opcaoStatus6); //metodo da classe
                            String categoria6 = (String) JOptionPane.showInputDialog(null, "Por favor, insira a categoria desejada:\n", "Escolha a categoria", JOptionPane.QUESTION_MESSAGE,icon2, null, null);
                            JOptionPane.showMessageDialog(null, sistema.livrosPorStatusECategoria(status6, categoria6).toString());
                        } catch (LivroInexistente e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        break;
                    case "7"://Atualizar status de um livro
                        try {
                            String titulo7 = (String) JOptionPane.showInputDialog(null, "Insira o título do livro que deseja atualizar:\n", "Atualizar Satus do Livro", JOptionPane.QUESTION_MESSAGE, icon2, null, null);
                            sistema.existeLivroPorTitulo(titulo7);
                            try {
                                String autor7 = (String) JOptionPane.showInputDialog(null, "Insira o autor do livro que deseja atualizar:\n", "Autor do Livro", JOptionPane.QUESTION_MESSAGE
                                ,icon2, null, null);
                                sistema.existeLivroPorAutor(autor7);
                                try {
                                    int edicao7 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a edição do livro que deseja atualizar:\n","Edição do Livro", JOptionPane.QUESTION_MESSAGE, icon2, null, null).toString());
                                    sistema.existeLivroPorEdicao(edicao7);
                                    String opcaoStatus7 = (String) JOptionPane.showInputDialog(null, "Insira o novo status que você deseja atualizar:\n", "Atualizando Status do Livro", JOptionPane.QUESTION_MESSAGE, icon2, null, null +
                                            "\n1- Para ler" +
                                            "\n2- Lendo" +
                                            "\n3- Lido");
                                    String status7 = metodoStatusConstante(opcaoStatus7); //metodo da classe
                                    try {
                                        sistema.atualizarStatusDeLivro(titulo7, autor7, edicao7, status7);
                                        JOptionPane.showMessageDialog(null, "Status alterado com sucesso!", "Alteração de Status", JOptionPane.QUESTION_MESSAGE);
                                    } catch (LivroInexistente l) {
                                        JOptionPane.showMessageDialog(null, l.getMessage());
                                    }
                                } catch (LivroInexistente e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            } catch (LivroInexistente e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                        } catch (LivroInexistente e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        break;
                    case "8"://Salvar dados
                        //TODO: Aprender a fazer :D
                        break;
                    case "9":
                        continuar = false;
                        break;
                    default:
                        throw new NullPointerException();
                }
            } catch (NullPointerException e){
                JOptionPane.showMessageDialog(null, "Erro! Digite 9 para sair ou insira dados válidos.");
            }
        }
    }
}
