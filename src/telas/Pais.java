package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pais extends JFrame implements ActionListener {

    private JLabel titulo, texOrg,texDes;
    private JPanel panelTi, panelInfe,panelOp;
    private JButton btOk, btvol;
    private JComboBox comOrg, comDes;
    private String [] paisCon = {"BRASIL","ESTADOS UNIDOS","CANADA"};

    public Pais() {

        this.setLayout(new BorderLayout());
        this.setTitle("Conversor de Moedas - Pais");
        this.setSize(460, 240);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        panelTi = new JPanel(new FlowLayout());
        panelTi.setBorder(BorderFactory.createEtchedBorder());
        this.add(BorderLayout.NORTH, panelTi);

        panelOp = new JPanel(new GridLayout(2,5,4,80));
        this.add(BorderLayout.CENTER,panelOp);

        panelInfe = new JPanel();
        panelInfe.setLayout(new BoxLayout(panelInfe, BoxLayout.LINE_AXIS));
        panelInfe.setBorder(BorderFactory.createEtchedBorder());
        this.add(BorderLayout.SOUTH, panelInfe);


        titulo = new JLabel("Convertor De Moeda - Seleção de Pais");
        this.panelTi.add(titulo);

        texOrg = new JLabel("Pais de Origem:");
        this.panelOp.add(texOrg);
        comOrg = new JComboBox(paisCon);
        this.panelOp.add(comOrg);

        texDes = new JLabel("Pais de Destino:");
        this.panelOp.add(texDes);
        comDes = new JComboBox(paisCon);
        this.panelOp.add(comDes);

        this.panelOp.add(Box.createHorizontalBox());
        this.panelOp.add(Box.createHorizontalBox());
        this.panelOp.add(Box.createHorizontalBox());


        this.panelInfe.add(Box.createHorizontalStrut(150));

        btvol = new JButton("Voltar");
        btvol.setSize(131, 33);
        this.panelInfe.add(btvol);
        btvol.addActionListener(this);


        this.panelInfe.add(Box.createHorizontalStrut(50));



        btOk = new JButton("Ok");
        this.panelInfe.add(btOk);
        btOk.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btOk) {
            if(comOrg.getSelectedIndex() == comDes.getSelectedIndex()){
                JOptionPane.showMessageDialog(null,"Pais de origem não pode ser o mesmo de destino");
            }else {
                String tituloTela = "Origem " + comOrg.getSelectedItem() + " para " + comDes.getSelectedItem();
                this.dispose();
                new Convesor(tituloTela,true,comOrg.getSelectedIndex(),comDes.getSelectedIndex());
            }
        } else if (e.getSource() == btvol) {
            this.dispose();
            new Principal();
        }
    }
}