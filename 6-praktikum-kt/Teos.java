package KT1;

// 4. Abstraktsel klassil Teos peab olema konstruktor teose kirjelduse (String), teose tähise (String), laenutaja (String) ja päevade arvu (int) määramiseks.
public abstract class Teos implements Comparable<Teos> {
    private String teoseKirjeldus;
    private String teoseTähis;
    private String laenutaja;
    private int päevadeArv;

    public Teos(String teoseKirjeldus, String teoseTähis, String laenutaja, int päevadeArv) {
        this.teoseKirjeldus = teoseKirjeldus;
        this.teoseTähis = teoseTähis;
        this.laenutaja = laenutaja;
        this.päevadeArv = päevadeArv;
    }

    public String getTeoseKirjeldus() {
        return teoseKirjeldus;
    }

    public String getTeoseTähis() {
        return teoseTähis;
    }

    public String getLaenutaja() {
        return laenutaja;
    }

    public int getPäevadeArv() {
        return päevadeArv;
    }

    // 4.1. Klassis on abstraktne boolean-tüüpi meetod kasHoidlast, mis näitab, kas teost on vaja tellida hoidlast.
    public abstract boolean kasHoidlast();

    // 4.2. Samuti on parameetriteta int-tüüpi isendimeetod laenutusaeg, mis tagastab selle teose laenutusaja
    // (ehk mitmeks päevaks teost tähise järgi on lubatud laenutada).
    // Kui tähis on erinev kui roheline, kollane, sinine, puudub, siis tagastatakse 0.
    public int laenutusaeg() {
        if(teoseTähis.equals("sinine")) {
            return 60; // 60 päevaks
        }
        else if(teoseTähis.equals("kollane")) {
            return 30; // 30 päevaks
        }
        else if(teoseTähis.equals("puudub")) {
            return 14; // 14 päevaks
        }
        else if(teoseTähis.equals("roheline")) {
            return 1; // 24 tunniks ehk 1 päevaks
        }
        return 0;
    }

    // 4.3. Samuti on klassis double-tüüpi parameetriteta meetod päevaneViivis,
    // mis tagastab vastavalt tähisele sobiva viivise ühe tähtaega ületanud päeva kohta.
    public double päevaneViivis() {
        if(teoseTähis.equals("sinine") || teoseTähis.equals("kollane")) {
            return 0.05; // 30 ja 60 päeva laenutus – 0.05 eurot teose kohta iga ületatud päeva eest
        }
        else if(teoseTähis.equals("puudub")) {
            return 0.15; // 14 päeva laenutus – 0.15 eurot teose kohta iga ületatud päeva eest
        }
        else if(teoseTähis.equals("roheline")) {
            return 2; // 24 tunni laenutus – 2 eurot teose kohta iga ületatud päeva eest
        }
        return 0;
    }

    // 4.4. Samuti on klassis void-tüüpi meetod arvutaViivis, mis võtab parameetriks Kontrollija isendi.
    // Tähtaja ületanud laenutuse korral arvutab meetod viivise suuruse ja laseb kontrollijal selle salvestada (salvestaViivis).
    public void arvutaViivis(Kontrollija kontrollija) {
        if(päevadeArv > laenutusaeg()) {
            double päeviÜle = päevadeArv - laenutusaeg();
            double viivisKokku = päeviÜle * päevaneViivis();
            kontrollija.salvestaViivis(laenutaja, teoseKirjeldus, viivisKokku);
        }
    }

    // 4.5. Samuti on klassis Teos meetod toString, mis aitab kogu teadaolevat infot teose ja selle laenutamise kohta sobivalt kujundada.
    // Muuhulgas peab olema näidatud, kas teost on vaja tellida hoidlast.
    @Override
    public String toString() {
        return "Teos{" +
                "teoseKirjeldus='" + teoseKirjeldus + '\'' +
                ", teoseTähis='" + teoseTähis + '\'' +
                ", laenutaja='" + laenutaja + '\'' +
                ", päevadeArv=" + päevadeArv + '\'' +
                ", kasHoidlast()=" + kasHoidlast() +
                '}';
    }

    // 4.6. Klass Teos realiseerib liidest Comparable<Teos>, kusjuures compareTo meetod realiseeritakse nii, et teoseid võrreldakse kirjelduse alusel.
    @Override
    public int compareTo(Teos teos) {
        return teoseKirjeldus.compareTo(teos.teoseKirjeldus);
    }
}
