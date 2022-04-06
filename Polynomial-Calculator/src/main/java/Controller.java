import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static java.lang.Boolean.FALSE;

public class Controller {
    private Operatii op;
    private Frame fr;

    Controller(Operatii op, Frame fr) {
        this.op = op;
        this.fr = fr;

        fr.addListener(new AddListener());
        fr.substractListener(new SubstractListener());
        fr.multiplyListener(new MultiplyListener());
        fr.derivateListenerP1(new DerivateListenerP1());
        fr.derivateListenerP2(new DerivateListenerP2());
        fr.integrateListenerP1(new IntegrateListenerP1());
        fr.integrateListenerP2(new IntegrateListenerP2());
        fr.resetListener(new ResetListener());
        fr.resetAllListener(new ResetAllListener());
        fr.divideListener(new DivisionListener());
    }

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Polinom> rez = op.reset();
            fr.setTotalRezultat(String.valueOf(rez.get(0)));
            fr.setTotalRest(String.valueOf(rez.get(1)));
            Polinom c = new Polinom();
            Polinom d = new Polinom();
            try {
                c.citire(fr.getUserInput1());
                d.citire(fr.getUserInput2());
                fr.setTotalRezultat(String.valueOf(op.adunarePolinom(c, d)));
                fr.setTotalRest("0.0");
            } catch (NumberFormatException n) {
                for (int i = 0; i < fr.getUserInput1().length(); i++) {
                    Boolean flag = Character.isDigit(fr.getUserInput1().charAt(i));
                    if (fr.getUserInput1().charAt(i) != '+' && fr.getUserInput1().charAt(i) != '-' && fr.getUserInput1().charAt(i) != 'x' && fr.getUserInput1().charAt(i) != '^' && flag == FALSE) {
                        fr.showError("Bad input " + fr.getUserInput1());
                    }
                }
                for (int i = 0; i < fr.getUserInput2().length(); i++) {
                    Boolean flag = Character.isDigit(fr.getUserInput2().charAt(i));
                    if (fr.getUserInput2().charAt(i) != '+' && fr.getUserInput2().charAt(i) != '-' && fr.getUserInput2().charAt(i) != 'x' && fr.getUserInput2().charAt(i) != '^' && flag == FALSE) {
                        fr.showError("Bad input " + fr.getUserInput2());
                    }
                }
            }

        }
    }

    class MultiplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Polinom> rez = op.reset();
            fr.setTotalRezultat(String.valueOf(rez.get(0)));
            fr.setTotalRest(String.valueOf(rez.get(1)));
            Polinom c = new Polinom();
            Polinom d = new Polinom();
            try {
                c.citire(fr.getUserInput1());
                d.citire(fr.getUserInput2());
                fr.setTotalRezultat(String.valueOf(op.inmultirePolinom(c, d)));
                fr.setTotalRest("0.0");
            } catch (NumberFormatException n) {
                for (int i = 0; i < fr.getUserInput1().length(); i++) {
                    Boolean flag = Character.isDigit(fr..getUserInput1().charAt(i));
                    if (fr.getUserInput1().charAt(i) != '+' && fr.getUserInput1().charAt(i) != '-' && fr.getUserInput1().charAt(i) != 'x' && fr.getUserInput1().charAt(i) != '^' && flag == FALSE) {
                        fr.showError("Bad input " + fr.getUserInput1());
                    }
                }
                for (int i = 0; i < fr.getUserInput2().length(); i++) {
                    Boolean flag = Character.isDigit(fr.getUserInput2().charAt(i));
                    if (fr.getUserInput2().charAt(i) != '+' && fr.getUserInput2().charAt(i) != '-' && fr.getUserInput2().charAt(i) != 'x' && fr.getUserInput2().charAt(i) != '^' && flag == FALSE) {
                        fr.showError("Bad input " + fr.getUserInput2());
                    }
                }
            }

        }
    }

    class DerivateListenerP1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Polinom> rez = op.reset();
            fr.setTotalRezultat(String.valueOf(rez.get(0)));
            fr.setTotalRest(String.valueOf(rez.get(1)));
            Polinom c = new Polinom();
            try {
                c.citire(fr.getUserInput1());
                fr.setTotalRezultat(String.valueOf(op.derivarePolinom(c)));
                fr.setTotalRest("0.0");
            } catch (NumberFormatException n) {
                for (int i = 0; i < fr.getUserInput1().length(); i++) {
                    Boolean flag = Character.isDigit(fr.getUserInput1().charAt(i));
                    if (fr.getUserInput1().charAt(i) != '+' && fr.getUserInput1().charAt(i) != '-' && fr.getUserInput1().charAt(i) != 'x' && fr.getUserInput1().charAt(i) != '^' && flag == FALSE) {
                        fr.showError("Bad input " + fr.getUserInput1());
                    }
                }
            }

        }
    }
    class DerivateListenerP2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Polinom> rez = op.reset();
            fr.setTotalRezultat(String.valueOf(rez.get(0)));
            fr.setTotalRest(String.valueOf(rez.get(1)));
            Polinom c = new Polinom();
            try {
                c.citire(fr.getUserInput2());
                fr.setTotalRezultat(String.valueOf(op.derivarePolinom(c)));
                fr.setTotalRest("0.0");
            } catch (NumberFormatException n) {
                for (int i = 0; i < fr.getUserInput1().length(); i++) {
                    Boolean flag = Character.isDigit(fr.getUserInput1().charAt(i));
                    if (fr.getUserInput1().charAt(i) != '+' && fr.getUserInput1().charAt(i) != '-' && fr.getUserInput1().charAt(i) != 'x' && fr.getUserInput1().charAt(i) != '^' && flag == FALSE) {
                        fr.showError("Bad input " + fr.getUserInput1());
                    }
                }
            }

        }
    }

    class IntegrateListenerP1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Polinom> rez = op.reset();
            fr.setTotalRezultat(String.valueOf(rez.get(0)));
            fr.setTotalRest(String.valueOf(rez.get(1)));
            Polinom c = new Polinom();
            try {
                c.citire(fr.getUserInput1());
                System.out.println(c);
                fr.setTotalRezultat(String.valueOf(op.integrarePolinom(c)));
                fr.setTotalRest("0.0");
            } catch (NumberFormatException n) {
                for (int i = 0; i < fr.getUserInput1().length(); i++) {
                    Boolean flag = Character.isDigit(fr.getUserInput1().charAt(i));
                    if (fr.getUserInput1().charAt(i) != '+' && fr.getUserInput1().charAt(i) != '-' && fr.getUserInput1().charAt(i) != 'x' && fr.getUserInput1().charAt(i) != '^' && flag == FALSE) {
                        fr.showError("Bad input " + fr.getUserInput1());
                    }
                }
            }

        }
    }
    class IntegrateListenerP2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Polinom> rez = op.reset();
            fr.setTotalRezultat(String.valueOf(rez.get(0)));
            fr.setTotalRest(String.valueOf(rez.get(1)));
            Polinom c = new Polinom();
            try {
                c.citire(fr.getUserInput2());
                System.out.println(c);
                fr.setTotalRezultat(String.valueOf(op.integrarePolinom(c)));
                fr.setTotalRest("0.0");
            } catch (NumberFormatException n) {
                for (int i = 0; i < fr.getUserInput1().length(); i++) {
                    Boolean flag = Character.isDigit(fr.getUserInput1().charAt(i));
                    if (fr.getUserInput1().charAt(i) != '+' && fr.getUserInput1().charAt(i) != '-' && fr.getUserInput1().charAt(i) != 'x' && fr.getUserInput1().charAt(i) != '^' && flag == FALSE) {
                        fr.showError("Bad input " + fr.getUserInput1());
                    }
                }
            }

        }
    }

    class SubstractListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Polinom> rez = op.reset();
            fr.setTotalRezultat(String.valueOf(rez.get(0)));
            fr.setTotalRest(String.valueOf(rez.get(1)));
            Polinom c = new Polinom();
            Polinom d = new Polinom();
            try {
                c.citire(fr.getUserInput1());
                d.citire(fr.getUserInput2());
                fr.setTotalRezultat(String.valueOf(op.scaderePolinom(c, d)));
                fr.setTotalRest("0.0");
            } catch (NumberFormatException n) {
                for (int i = 0; i < fr.getUserInput1().length(); i++) {
                    Boolean flag = Character.isDigit(fr.getUserInput1().charAt(i));
                    if (fr.getUserInput1().charAt(i) != '+' && fr.getUserInput1().charAt(i) != '-' && fr.getUserInput1().charAt(i) != 'x' && fr.getUserInput1().charAt(i) != '^' && flag == FALSE) {
                        fr.showError("Bad input " + fr.getUserInput1());
                    }
                }
                for (int i = 0; i < fr.getUserInput2().length(); i++) {
                    Boolean flag = Character.isDigit(fr.getUserInput2().charAt(i));
                    if (fr.getUserInput2().charAt(i) != '+' && fr.getUserInput2().charAt(i) != '-' && fr.getUserInput2().charAt(i) != 'x' && fr.getUserInput2().charAt(i) != '^' && flag == FALSE) {
                        fr.showError("Bad input " + fr.getUserInput2());
                    }
                }
            }
        }
    }

    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Polinom> rez = op.reset();
            fr.setTotalRezultat(String.valueOf(rez.get(0)));
            fr.setTotalRest(String.valueOf(rez.get(1)));
        }
    }
    class ResetAllListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Polinom> rez = op.reset();
            fr.setTotalRezultat(String.valueOf(rez.get(0)));
            fr.setTotalRest(String.valueOf(rez.get(1)));
            fr.setPolinom1(" ");
            fr.setPolinom2(null);
        }
    }
    class DivisionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Polinom> rez = op.reset();
            fr.setTotalRezultat(String.valueOf(rez.get(0)));
            fr.setTotalRest(String.valueOf(rez.get(1)));
            Polinom c = new Polinom();
            Polinom d = new Polinom();
            try {
                c.citire(fr.getUserInput1());
                d.citire(fr.getUserInput2());
                if (d.getPolinom().get(0).getCoef() == 0 && d.getPolinom().get(0).getGrad() == 0) {
                    fr.showError("Impartire la 0 ");
                }
                    List<Polinom> res = op.impartire(c, d);
                    fr.setTotalRezultat(String.valueOf(res.get(0)));
                    fr.setTotalRest(String.valueOf(res.get(1)));
                }catch(NumberFormatException n){
                    for (int i = 0; i < fr.getUserInput1().length(); i++) {
                        Boolean flag = Character.isDigit(fr.getUserInput1().charAt(i));
                        if (fr.getUserInput1().charAt(i) != '+' && fr.getUserInput1().charAt(i) != '-' && fr.getUserInput1().charAt(i) != 'x' && fr.getUserInput1().charAt(i) != '^' && flag == FALSE) {
                            fr.showError("Bad input " + fr.getUserInput1());
                        }
                    }
                    for (int i = 0; i < fr.getUserInput2().length(); i++) {
                        Boolean flag = Character.isDigit(fr.getUserInput2().charAt(i));
                        if (fr.getUserInput2().charAt(i) != '+' && fr.getUserInput2().charAt(i) != '-' && fr.getUserInput2().charAt(i) != 'x' && fr.getUserInput2().charAt(i) != '^' && flag == FALSE) {
                            fr.showError("Bad input " + fr.getUserInput2());
                        }
                    }
                    if (d.getPolinom().get(0).getCoef() == 0 && d.getPolinom().get(0).getGrad() == 0) {

                    }
                }

        }
    }
}
