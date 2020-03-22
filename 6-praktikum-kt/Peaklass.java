package KT1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 7. Peaklass peab olema nimega Peaklass.
public class Peaklass {
    public static void main(String[] args) throws Exception {
        List<Teos> teosed = loeTeosed("laenutus.txt");
        //System.out.println(teosed.toString());
        java.util.Collections.sort(teosed);
        //System.out.println(teosed);
        ViiviseHoiataja viiviseHoiataja = new ViiviseHoiataja(0.2);
        SuurimaViiviseLeidja suurimaViiviseLeidja = new SuurimaViiviseLeidja();
        for(Teos teos : teosed) {
            teos.arvutaViivis(viiviseHoiataja);
        }
        System.out.println(viiviseHoiataja.getHoiatatavadLaenutajad());
        for(Teos teos : teosed) {
            teos.arvutaViivis(suurimaViiviseLeidja);
        }
        suurimaViiviseLeidja.saadaHoiatus();
    }

    // Klassis peab olema staatiline avalik meetod loeTeosed tagastustüübiga List<Teos>, mis võtab argumendiks failinime ja tagastab selles failis olevad laenutuste andmed.
    // Meetod võib visata erindi (st. meetodi signatuuris võib olla throws Exception).
    // Teoste faili formaat on ülalpool toodud.
    // Teoste arv failis ei ole teada (programm peaks töötama suvalise (ka tühja) failiga).
    // Kui failist lugemist ei õnnestu programmeerida, siis kirjutatagu selles meetodis vastav list programmi sisse (vähendab tulemust 2 punkti võrra).
    public static List<Teos> loeTeosed(String failiNimi) {
        ArrayList<Teos> teosed = new ArrayList<>();
        File fail = new File(failiNimi);
        try (Scanner scanner = new Scanner(fail, "UTF-8")) {
            while (scanner.hasNextLine()) {
                String rida = scanner.nextLine();
                //System.out.println(rida);
                String[] tükid = rida.split("; ");
                if (tükid[0].contains("/")) {
                    // Teose kirjelduses on kaldkriips, seega tegu on ajakirjaga.
                    teosed.add(new Ajakiri(tükid[0], tükid[1], tükid[2], Integer.parseInt(tükid[3].trim())));
                } else {
                    // Teose kirjelduses puudub kaldkriips, seega tegu on raamatuga.
                    teosed.add(new Raamat(tükid[0], tükid[1], tükid[2], Integer.parseInt(tükid[3].trim())));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return teosed;
    }
}
