import javax.swing.*;

public class DeskovkyFrame extends JFrame {
    private JPanel pnMain;
    private JTextArea txtUdaje;
    private JCheckBox cbKoupena;
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JButton btnDalsi;
    private JButton btnPredchozi;

    SeznamDeskovek seznam = new SeznamDeskovek();
    private int index = 0;

    public DeskovkyFrame(){
        initComponent();
    }

    private void initComponent(){
        setContentPane(pnMain);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Deskovky");
        zobrazeni();
        btnDalsi.addActionListener(e -> btnDalsi());
        btnPredchozi.addActionListener(e -> btnPredchozi());
    }

    private void zobrazeni(){
        seznam.cteniZeSouboru();
        Deskovka aktualniDeskovka = seznam.getSeznamDeskovek().get(index);
        txtUdaje.setText(aktualniDeskovka.getNazev());
        cbKoupena.setSelected(aktualniDeskovka.isJeKoupena());
        rb1.setSelected(aktualniDeskovka.getOblibenost() == 1);
        rb2.setSelected(aktualniDeskovka.getOblibenost() == 2);
        rb3.setSelected(aktualniDeskovka.getOblibenost() == 3);
    }

    private void btnDalsi(){
        index++;
        zobrazeni();

    }

    private void btnPredchozi(){
        index--;
        zobrazeni();
    }
}
