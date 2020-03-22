package KT1;

import java.lang.reflect.Array;
import java.util.ArrayList;

// 2. Klass ViiviseHoiataja realiseerib liidest Kontrollija.
public class ViiviseHoiataja implements Kontrollija {
    private ArrayList<String> laenutajad = new ArrayList<>();

    // 2.1. Klassis peab olema ühe double argumendiga konstruktor, mille abil saab määrata lubatud viivise.
    private double lubatudViivis;

    public ViiviseHoiataja(double lubatudViivis) {
        this.lubatudViivis = lubatudViivis;
    }

    // 2.2. Meetod salvestaViivis peab argumendiks saadud laenutaja nime meelde jätma, kui viivis ületab lubatud viivise piiri ja kui seda nime pole veel salvestatud.
    @Override
    public void salvestaViivis(String laenutaja, String teoseKirjeldus, double viiviseSuurus) {
        if(viiviseSuurus > lubatudViivis) {
            if(!laenutajad.contains(laenutaja)) {
                laenutajad.add(laenutaja);
            }
        }
    }

    // 2.3. Meetod getHoiatatavadLaenutajad peab tagastama listi kõigi nende laenutajate nimedega, kelle viivise suurus ületab lubatud piiri.
    public ArrayList<String> getHoiatatavadLaenutajad() {
        return laenutajad;
    }
}
