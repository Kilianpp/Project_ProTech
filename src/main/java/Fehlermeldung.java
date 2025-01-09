import javax.swing.*;
import java.awt.event.WindowEvent;

public class Fehlermeldung extends JFrame {
    private JPanel panel1;
    private JPanel FensterFehlermeldung;
    private JTextField textFieldFehlermeldung;
    private JButton buttonOk;


    public Fehlermeldung() {
        setTitle("Fehler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(FensterFehlermeldung);
        buttonOk.addActionListener(e -> {setVisible(false);});

    }
    public void fehlerfenster (String fehlermeldung){
        textFieldFehlermeldung.setText(fehlermeldung);
        setVisible(true);
    }






}