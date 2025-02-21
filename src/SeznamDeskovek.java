import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeznamDeskovek {
    private List<Deskovka> seznamDeskovek = new ArrayList<>();

    public void cteniZeSouboru(){
        final String ODDELOVAC = ";";
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/deskovky.txt")))){
            while(scanner.hasNextLine()){
                String radek = scanner.nextLine();
                String[] casti = radek.split(ODDELOVAC);
                String nazev = casti[0];
                Boolean jeKoupena = Boolean.parseBoolean(casti[1]);
                int oblibenost = Integer.parseInt(casti[2]);
                seznamDeskovek.add(new Deskovka(nazev, jeKoupena, oblibenost));
            }
        }catch (FileNotFoundException e){
            System.out.println("Soubor nebyl nalezen");
        }
    }

    public List<Deskovka> getSeznamDeskovek() {
        return new ArrayList<>(seznamDeskovek);
    }

}
