package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Principal extends JFrame implements ActionListener {

    private JLabel tituto;
    private JPanel panelTi,painelCenterbt;
    private JButton btDir,btPas;
    public  Principal(){

        this.setLayout(new BorderLayout());
        this.setTitle("Conversor de Moedas");
        this.setSize(500,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        panelTi = new JPanel(new FlowLayout());
        panelTi.setBorder(BorderFactory.createEtchedBorder());
        this.add(BorderLayout.NORTH,panelTi);


        painelCenterbt = new JPanel();
        painelCenterbt.setLayout(new BoxLayout(painelCenterbt,BoxLayout.LINE_AXIS));
        painelCenterbt.setBorder(BorderFactory.createEtchedBorder());
        this.add(BorderLayout.CENTER,painelCenterbt);



        tituto = new JLabel("Convertor De Moeda");
        this.panelTi.add(tituto);

        this.painelCenterbt.add(Box.createHorizontalStrut (88));

        btDir = new JButton("Converter Direto");
        this.painelCenterbt.add(btDir);
        btDir.addActionListener(this);


        this.painelCenterbt.add(Box.createHorizontalStrut (50));

        btPas = new JButton("Selecionar Pais");
        btPas.setSize(131,33);
        this.painelCenterbt.add(btPas);
        btPas.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btDir) {
            this.dispose();
            new Convesor("Direto");
        }else if(e.getSource() == btPas){
            this.dispose();
            new Pais();
        }
    }
}
