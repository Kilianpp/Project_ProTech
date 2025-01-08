import javax.swing.*;

public class Fehlermeldung extends JFrame {
    private JPanel panel1;
    private JPanel FensterFehlermeldung;
    private JTextField textFieldFehlermeldung;
    private JButton buttonOk;


    public Fehlermeldung(Verwaltung verwaltung) {
        setTitle("Fehler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(FensterFehlermeldung);
        setVisible(true);
    }





}