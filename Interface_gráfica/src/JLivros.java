import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JLivros {
    public JLivros(ArrayList<Publicacao> lista ){

        //Criando a Janela
        JFrame janela = new JFrame ();
            janela.setSize(300,200);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Criando os componentes
        JLabel livros = new JLabel("Livros");
        JLabel titulo = new JLabel("Título: ");
        JLabel autor = new JLabel("Autor: ");
        JLabel ano = new JLabel("Ano: ");

        JButton botaoInclui = new JButton("Incluir");
        JButton botaoRevista = new JButton("Revistas");
        JButton botaoLista = new JButton("Listagem");

        JTextField campoTitulo = new JTextField(10);
        JTextField campoAutor = new JTextField(10);
        JTextField campoAno = new JTextField(4);

        //Criando um painel usando GridBagLayout
        JPanel painel = new JPanel();
            painel.setLayout(new GridBagLayout()); //Usando Layout com uma grade mais flexivel
            GridBagConstraints restricao = new GridBagConstraints(); //Para especificar as restrições
            restricao.insets = new Insets (5,5,5,5); //Espaçamento entre os componentes

        // Adicionando os componentes no painel usando uma função auxiliar
        addComps(painel, livros, restricao, 0,0,3, 1,  GridBagConstraints.CENTER );

        addComps(painel, titulo, restricao, 0,1,1, 1,  GridBagConstraints.EAST);
        addComps(painel, campoTitulo, restricao, 1,1,2, 1,  GridBagConstraints.WEST );

        addComps(painel, autor, restricao, 0,2,1, 1,  GridBagConstraints.EAST );
        addComps(painel, campoAutor, restricao, 1,2,2, 1,  GridBagConstraints.WEST );

        addComps(painel, ano, restricao, 0,3,1, 1,  GridBagConstraints.EAST );
        addComps(painel, campoAno, restricao, 1,3,2, 1,  GridBagConstraints.WEST );

        //Criando um painel de botões para eles ficarem na mesma linha com FlowLayout
        JPanel botoes = new JPanel(new FlowLayout());
            botoes.add (botaoInclui);
            botoes.add (botaoRevista);
            botoes.add (botaoLista);
        //Adicionar o painel de botões no painel principal
        addComps(painel, botoes, restricao, 0, 4, 3, 1, GridBagConstraints.CENTER);

        janela.getContentPane().add(painel);

        // Para incluir um novo Livro usando o botão incluir
        botaoInclui.addActionListener (new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                String titulo = campoTitulo.getText();
                String autor = campoAutor.getText();
                String ano = campoAno.getText();

                //Para o caso de algum campo estar vazio mostra uma mensagem de erro
                if (titulo.isEmpty() || ano.isEmpty() || autor.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    Integer.parseInt(ano); // Tenta converter o ano para um número inteiro
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "O campo 'Ano' deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Adiciona o que estiver nos campos de texto na lista de publicações como um novo livro
                lista.add(new Livro(titulo, ano, autor));

                campoTitulo.setText("");
                campoAutor.setText("");
                campoAno.setText("");
            }
        });

        //Para trocar para a Janela de Revistas
        botaoRevista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                janela.dispose();
                //Usando a mesma lista que foi passada como parâmetro para a janela JLivros
                new JRevistas(lista);
            }
        });

        //Para trocar para a Janela de Listagem
        botaoLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                janela.dispose();
                new JListagem(lista);
            }
        });

        janela.setVisible(true);
    }

    // Função auxiliar para adicionar os componetes no painel com as suas restrições específicas
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
