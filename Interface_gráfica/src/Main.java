import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Lista onde serão armazenados os livros e revistas, ambos herdam Publicacao
        ArrayList<Publicacao> lista = new ArrayList<>();

        //Passando a lista como parâmetro do construtor da Janela JLivros
        new JLivros(lista);

        //As outras janelas podem ser acessadas pela janela JLivros
        //new JRevistas(lista);
        //new JListagem(lista);
    }
}

