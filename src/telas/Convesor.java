package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import apiConverte.Cotacao;

public class Convesor extends JFrame implements ActionListener {

    private JLabel tituto,lValor,lCon, lComVa, lcomConv;
    private JPanel panelTi, panelInfe,panelOp;
    private JButton btCon,btVol;
    private String tituloTela;
    private JTextField texValor, texConv;
    private JComboBox comValor, comConv;
    private Boolean isPais;
    private String [] moeda = {"BR","USD","CND"};
    private Integer orgPa, desPa;
    

    public Convesor(String titulo) {
        this.tituloTela = titulo;
        this.isPais = false;
        this.orgPa = 0;
        this.desPa = 0;
        
        tela();
    }
    public Convesor(String titulo,Boolean isPais,Integer org, Integer des) {
        this.tituloTela = titulo;
        this.isPais = isPais;
        this.orgPa = org;
        this.desPa = des;
        tela();
    }

    public void tela(){
        this.setLayout(new BorderLayout());
        this.setTitle("Convertor De Moeda");
        this.setSize(460, 240);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        panelTi = new JPanel(new FlowLayout());
        panelTi.setBorder(BorderFactory.createEtchedBorder());
        this.add(BorderLayout.NORTH, panelTi);

        panelOp = new JPanel(new GridLayout(2,4,4,80));
        this.add(BorderLayout.CENTER,panelOp);

        panelInfe = new JPanel();
        panelInfe.setLayout(new BoxLayout(panelInfe, BoxLayout.LINE_AXIS));
        panelInfe.setBorder(BorderFactory.createEtchedBorder());
        this.add(BorderLayout.SOUTH, panelInfe);


        tituto = new JLabel("Convertor De Moeda-"+tituloTela);
        this.panelTi.add(tituto);


        lComVa = new JLabel("DE:");
        this.panelOp.add(lComVa);
        comValor = new JComboBox(moeda);
        this.panelOp.add(comValor);

        lcomConv = new JLabel("PARA:");
        this.panelOp.add(lcomConv);
        comConv = new JComboBox(moeda);
        this.panelOp.add(comConv);

        if (isPais){
            comValor.setEnabled(false);
            comValor.setSelectedIndex(orgPa);

            comConv.setEnabled(false);
            comConv.setSelectedIndex(desPa);

        }

        lValor = new JLabel("Valor Origem:");
        this.panelOp.add(lValor);
        texValor = new JTextField();
        this.panelOp.add(texValor);

        lCon = new JLabel("Valor Convertido:");
        this.panelOp.add(lCon);
        texConv = new JTextField();
        this.panelOp.add(texConv);
        texConv.setEditable(false);


        this.panelInfe.add(Box.createHorizontalStrut(150));

        btVol = new JButton("Voltar");
        btVol.setSize(131, 33);
        this.panelInfe.add(btVol);
        btVol.addActionListener(this);


        this.panelInfe.add(Box.createHorizontalStrut(50));



        btCon = new JButton("Converter");
        this.panelInfe.add(btCon);
        btCon.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btCon) {
            if (comValor.getSelectedIndex() == comConv.getSelectedIndex()){
                JOptionPane.showMessageDialog(null,"Moeda a ser convertida não pode ser a mesma da origem");
            }else if("".equals(texValor.getText())){
                JOptionPane.showMessageDialog(null,"Valor da moeda esta em branco ou vazio");
            }else{  
            	BigDecimal valor = new BigDecimal(texValor.getText());
            	DecimalFormat formCon = new DecimalFormat("#,###.00");
            	if(comValor.getSelectedIndex() == 0 && comConv.getSelectedIndex() == 1) {
            		texConv.setText(formCon.format(Cotacao.RealDolar(valor)));
            	}
                      
            }
        } else if (e.getSource() == btVol) {
            if (isPais){
                this.dispose();
                new Pais();
            }else {
                this.dispose();
                new Principal();
            }
        }
    }
}
