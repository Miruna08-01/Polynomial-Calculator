import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame extends JFrame //implements ActionListener
 {

    private JButton add=new JButton("Add");
    private JButton substract=new JButton("Substract");
    private JButton multiplication=new JButton("Multiplication");
    private JButton division=new JButton("Division");
    private JButton integration1=new JButton("Integrate P1 ");
     private JButton integration2=new JButton("Integrate P2 ");
    private JButton derivateP1=new JButton("Derivate P1");
     private JButton derivateP2=new JButton("Derivate P2");


    private JButton resetAll=new JButton("Reset All");
    private JButton reset=new JButton("Reset");

    private JPanel panelpoli1=new JPanel();
    private JPanel panelpoli2=new JPanel();
    private JPanel panelpoliresult=new JPanel();
    private JPanel panelpolirest=new JPanel();
    private JPanel operatii=new JPanel();


    private JTextField polinom1=new JTextField(30);
    private JTextField polinom2=new JTextField(30);
    private JTextField result=new JTextField(30);
    private JTextField rest=new JTextField(20);


    private Operatii model;

    public Frame(Operatii model1) {
        model=model1;
        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());
        JPanel douaPolinoame=new JPanel();
        JPanel auxiliar=new JPanel();
        JPanel aux1=new JPanel();
        aux1.setBackground(new Color(0,0,0));
        JPanel aux2=new JPanel();
        aux2.setBackground(new Color(0,0,0));
        JPanel aux3=new JPanel();
        aux3.setBackground(new Color(0,0,0));
        JPanel aux4=new JPanel();
        aux4.setBackground(new Color(0,0,0));
        auxiliar.setLayout( new BoxLayout(auxiliar,BoxLayout.Y_AXIS));
        auxiliar.setBackground(new Color(0,0,0));
        JLabel operatii1=new JLabel("Operations");
        operatii1.setForeground(Color.white);
        auxiliar.add(operatii1);
        auxiliar.setBorder(BorderFactory.createLineBorder(Color.white));

        panelpoli1.setLayout(new BoxLayout(panelpoli1, BoxLayout.X_AXIS));
        JLabel first=new JLabel("First Polynomial");
        first.setForeground(Color.white);
        panelpoli1.add(first);
        panelpoli1.add(polinom1);
        polinom1.setEditable(true);
        panelpoli1.setBackground(new Color(0,0,0));
        polinom1.setBorder(BorderFactory.createLineBorder(Color.black));
        polinom1.setBackground(new Color(193,193,193));
        polinom2.setBackground(new Color(193,193,193));

        panelpoli2.setLayout(new BoxLayout(panelpoli2, BoxLayout.X_AXIS));
        JLabel second=new JLabel("Second Polynomial");
        second.setForeground(Color.white);
        panelpoli2.add(second);
        panelpoli2.add(polinom2);
        polinom2.setEditable(true);
        panelpoli2.setBackground(new Color(0,0,0));
        polinom2.setBorder(BorderFactory.createLineBorder(Color.black));

        panelpoliresult.setLayout(new BoxLayout(panelpoliresult, BoxLayout.X_AXIS));
        JLabel result_label=new JLabel("Result Polynomial");
        result_label.setForeground(Color.white);
        panelpoliresult.add(result_label);
        panelpoliresult.add(result);
        result.setEditable(false);
        panelpoliresult.setBackground(new Color(0,0,0));
        result.setBorder(BorderFactory.createLineBorder(Color.black));


        panelpolirest.setLayout(new BoxLayout(panelpolirest, BoxLayout.X_AXIS));
        panelpolirest.setLayout(new BoxLayout(panelpolirest, BoxLayout.X_AXIS));
        JLabel remainder=new JLabel("Remainder Polynomial");
        remainder.setForeground(Color.white);
        panelpolirest.add(remainder);
        panelpolirest.add(rest);
        rest.setEditable(false);
        panelpolirest.setBackground(new Color(0,0,0));
        rest.setBorder(BorderFactory.createLineBorder(Color.black));


        operatii.setLayout(new BoxLayout(operatii, BoxLayout.PAGE_AXIS));
        JLabel operatii2=new JLabel("Operations");
        operatii2.setForeground(Color.white);
        operatii.add(operatii2);
        operatii.setBackground(new Color(0,0,0));
        operatii.setBorder(BorderFactory.createLineBorder(Color.white));

        douaPolinoame.setLayout(new BoxLayout(douaPolinoame, BoxLayout.PAGE_AXIS));
        douaPolinoame.add(panelpoli1);
        douaPolinoame.add(aux1);
        douaPolinoame.add(panelpoli2);
        douaPolinoame.add(aux2);
        douaPolinoame.add(panelpoliresult);
        douaPolinoame.add(aux3);
        douaPolinoame.add(panelpolirest);


        operatii.add(add);
        operatii.add(substract);
        operatii.add(division);
        operatii.add(multiplication);
        operatii.add(derivateP1);
        operatii.add(derivateP2);
        auxiliar.add(integration1);
        auxiliar.add(integration2);
        auxiliar.add(resetAll);
        auxiliar.add(reset);
        content.add(auxiliar);
        content.add(douaPolinoame);
        content.add(operatii);
        add.setBackground(Color.white);
        substract.setBackground(Color.white);
        division.setBackground(Color.white);
        multiplication.setBackground(Color.white);
        integration1.setBackground(Color.white);
        integration2.setBackground(Color.white);
        derivateP1.setBackground(Color.white);
        derivateP2.setBackground(Color.white);
        reset.setBackground(Color.white);
        resetAll.setBackground(Color.white);
        panelpoli1.setBackground(new Color(0, 0, 0));
        panelpoli2.setBackground(new Color(0, 0, 0));
        operatii.setBackground(new Color(0, 0, 0));
        content.setBackground(new Color(0, 0, 0));
        this.setContentPane(content);
        this.pack();
        this.setTitle("Polynomial Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


     String getUserInput1() {
         return polinom1.getText();
     }
     String getUserInput2() {
         return polinom2.getText();
     }

      void setPolinom1(String polinom11) {
          polinom1.setText(polinom11);
      }
     void setPolinom2(String polinom12) {
         polinom2.setText(polinom12);
     }

     void setTotalRezultat(String newTotal) {
         result.setText(newTotal);
     }

     void setTotalRest(String newTotal) {
         rest.setText(newTotal);
     }
     void showError(String errMessage) {
         JOptionPane.showMessageDialog(this, errMessage);
     }




     void addListener(ActionListener mal) {
         add.addActionListener(mal);
     }
    void substractListener(ActionListener mal) {substract.addActionListener(mal);}
     void multiplyListener(ActionListener mal) {multiplication.addActionListener(mal);}
     void derivateListenerP1(ActionListener mal) {derivateP1.addActionListener(mal);}
     void derivateListenerP2(ActionListener mal) {derivateP2.addActionListener(mal);}
     void integrateListenerP1(ActionListener mal) {integration1.addActionListener(mal);}
     void integrateListenerP2(ActionListener mal) {integration2.addActionListener(mal);}
     void resetListener(ActionListener mal) {reset.addActionListener(mal);}
     void resetAllListener(ActionListener mal) {resetAll.addActionListener(mal);}
     void divideListener(ActionListener mal) {division.addActionListener(mal);}

 }

