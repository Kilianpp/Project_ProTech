import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class RessourcenLader {                                                          //nur bei Abspeichern in Textdatei nötig
    private final Gson daten = new GsonBuilder().setPrettyPrinting().create();
    private final String dateipfad = "Speicherort.txt";

    public void listeSpeichern(List<Aktivitaet> gespeicherteListe) {
        String jason = daten.toJson(gespeicherteListe);
        File datei = new File(dateipfad);
        if (!datei.exists()) {
        }
        try (FileWriter dateiSchreiber = new FileWriter(datei)) {
            dateiSchreiber.write(jason);
        } catch (IOException e) {
            System.out.println("Fehler beim speichern");
        }


    }

    public List<Aktivitaet> listeLesen() {
        File datei = new File(dateipfad);
        if (!datei.exists()) {
            System.out.println("kann Datei nicht finden");
            return Collections.emptyList();
        }
        try {
            List<String> eingeleseneWerte = Files.readAllLines(Path.of(dateipfad));
            StringBuilder bobDerStringBuilder = new StringBuilder();
            for (String s : eingeleseneWerte) {
                bobDerStringBuilder.append(s);
            }
            return List.of(daten.fromJson(bobDerStringBuilder.toString(), Aktivitaet[].class));
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei");
            return Collections.emptyList();
        }
    }
}
