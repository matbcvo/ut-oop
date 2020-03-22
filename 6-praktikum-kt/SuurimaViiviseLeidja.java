package KT1;

// 3. Klass SuurimaViiviseLeidja realiseerib liidest Kontrollija.
public class SuurimaViiviseLeidja implements Kontrollija {
    private String laenutaja;
    private String teoseKirjeldus;
    private double viiviseSuurus;

    // 3.1. Klassis peab olema void-tüüpi parameetriteta meetod saadaHoiatus,
    // mis prindib ekraanile kõige suurema viivisega laenutaja nime ja tema poolt laenutatud teose kirjelduse.
    public void saadaHoiatus() {
        System.out.println("laenutaja=" + laenutaja + "; " + "teoseKirjeldus=" + teoseKirjeldus + "; " + "viiviseSuurus=" + viiviseSuurus);
    }

    @Override
    public void salvestaViivis(String laenutaja, String teoseKirjeldus, double viiviseSuurus) {
        if(this.viiviseSuurus < viiviseSuurus) {
            this.laenutaja = laenutaja;
            this.teoseKirjeldus = teoseKirjeldus;
            this.viiviseSuurus = viiviseSuurus;
        }
    }

    // 3.2. Mälu kokkuhoiu mõttes ei tohiks SuurimaViiviseLeidja jätta meelde rohkem andmeid,
    // kui on tarvis suurima viivisega inimesele hoiatuse saatmiseks
    // (see tähendab, et ViiviseHoiataja ning SuurimaViiviseLeidja peaks meetodi salvestaViivis realiseerima erinevalt.)
    // (Vihje: jäta alati meelde vaid suurima viivise andmed.)


}
