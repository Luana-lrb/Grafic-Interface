import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JListagem {
    public JListagem(ArrayList<Publicacao> lista){

    //Criando a Janela
    JFrame janela = new JFrame ();
        janela.setSize(400,400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Criando os componente
    JLabel listagem = new JLabel("Listagem");

    //Transformando a ArrayList em um vetor para criar a Jlist
    Publicacao[] listaPublicacao = lista.toArray(new Publicacao[0]);

    JList<Publicacao> listaFinal = new JList<>(listaPublicacao);
        listaFinal.setFont(new Font("Monospaced", Font.PLAIN, 14));

    //Adicionando a JList a uma JScrollPane
    JScrollPane scrollPane = new JScrollPane(listaFinal,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    //Criando o painel onde serão adicionados os componentes com GridBAgLayout
    JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout()); //Usando Layout com uma grade mais flexivel
        GridBagConstraints restricao = new GridBagConstraints(); //Para especificar as restrições
        restricao.insets = new Insets (5,5,5,5); //Espaçamento entre os componentes

    //Adicionandos os componentes usando uma função auxiliar
    addComps(painel, listagem, restricao, 0,0,3, 1,  GridBagConstraints.CENTER );
    addComps(painel, scrollPane, restricao, 0,1,3,3, GridBagConstraints.CENTER);

    janela.getContentPane().add(painel);
    janela.setVisible(true);
}
//Função auxiliar que especifica as restrições para adicionar o componente usando o GridBagLayout
private void addComps(JPanel painel, Component comp, GridBagConstraints restricao,
                      int x, int y, int width, int height, int anchor){
    restricao.gridx = x;
    restricao.gridy = y;
    restricao.gridwidth = width;
    restricao.gridheight = height;
    restricao.anchor = anchor;

    painel.add(comp, restricao);
}
}
