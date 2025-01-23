import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JRevistas {
    public JRevistas(ArrayList<Publicacao> lista ){

        //Criando da janela
        JFrame janela = new JFrame ();
            janela.setSize(300,225);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Criando os componetes
        JLabel revistas = new JLabel("Revistas");
        JLabel titulo = new JLabel("Título: ");
        JLabel org = new JLabel("Org: ");
        JLabel vol = new JLabel("Vol.: ");
        JLabel nro = new JLabel("Nro.: ");
        JLabel ano = new JLabel("Ano: ");

        JButton botaoInclui = new JButton("Incluir");
        JButton botaoLivros= new JButton("Livros");
        JButton botaoLista = new JButton("Listagem");

        JTextField campoTitulo = new JTextField(20);
        JTextField campoOrg = new JTextField(20);
        JTextField campoVol = new JTextField(3);
        JTextField campoNro = new JTextField(2);
        JTextField campoAno = new JTextField(4);

        //Criando o Painel e definindo o tipo de Layout como GridBag
        JPanel painel = new JPanel();
            painel.setLayout(new GridBagLayout()); //Usando Layout com uma grade mais flexivel
            GridBagConstraints restricao = new GridBagConstraints(); //Para especificar as restrições
            restricao.insets = new Insets (5,5,5,5); //Espaçamento entre os componentes

        //Adicionando os componentes usando uma função auxiliar

        addComps(painel, revistas, restricao, 0,0,3, 1,  GridBagConstraints.CENTER );

        addComps(painel, titulo, restricao, 0,1,1, 1,  GridBagConstraints.EAST);
        addComps(painel, campoTitulo, restricao, 1,1,2, 1,  GridBagConstraints.WEST );

        addComps(painel, org, restricao, 0,2,1, 1,  GridBagConstraints.EAST );
        addComps(painel, campoOrg, restricao, 1,2,2, 1,  GridBagConstraints.WEST );

        //Para ficar tudo na mesma linha é mais fácil criar um Painel pequeno com FlowLayout
        JPanel painelzinho = new JPanel(new FlowLayout());
        painelzinho.add(vol);
        painelzinho.add(campoVol);
        painelzinho.add(nro);
        painelzinho.add(campoNro);
        painelzinho.add(ano);
        painelzinho.add(campoAno);

        // Depois adicionar o pequeno painel já com com os componentes no painel principal
        addComps(painel, painelzinho, restricao, 0,3,3, 1,  GridBagConstraints.CENTER );

        //Também criar um painel extra para os botões ficarem na mesma linha e adicionar no principal
        JPanel botoes = new JPanel(new FlowLayout());
        botoes.add (botaoInclui);
        botoes.add (botaoLivros);
        botoes.add (botaoLista);

        addComps(painel, botoes, restricao, 0, 4, 3, 1, GridBagConstraints.CENTER);

        janela.getContentPane().add(painel);

        // Para incluir uma nova Revista usando o botão incluir
        botaoInclui.addActionListener (new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                String titulo = campoTitulo.getText();
                String org = campoOrg.getText();
                String vol = campoVol.getText();
                String nro = campoNro.getText();
                String ano = campoAno.getText();

                //Para o caso de algum campo estar vazio mostra uma mensagem de erro
                if (titulo.isEmpty() || org.isEmpty() || vol.isEmpty() || nro.isEmpty() || ano.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //Verificação para os casos de dados que deveriam ser numéricos
                try {
                    Integer.parseInt(ano);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "O campo 'Ano' deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }try {
                    Integer.parseInt(vol);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "O campo 'Volume' deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }try {
                    Integer.parseInt(nro);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "O campo 'Número' deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Adiciona o que estiver nos campos de texto na lista de publicações como uma nova revista
                lista.add(new Revista(titulo, ano, org, vol, nro));

                campoTitulo.setText("");
                campoNro.setText("");
                campoVol.setText("");
                campoOrg.setText("");
                campoAno.setText("");
            }
        });

        //Para trocar para a Janela de Livros
        botaoLivros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                janela.dispose();
                new JLivros(lista);
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
