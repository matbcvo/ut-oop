package KT1;

// 5. Klass Raamat on klassi Teos alamklass. Klassis on konstruktor vajaliku info määramiseks ja vähemalt järgmised meetodid.
public class Raamat extends Teos {
    public Raamat(String teoseKirjeldus, String teoseTähis, String laenutaja, int päevadeArv) {
        super(teoseKirjeldus, teoseTähis, laenutaja, päevadeArv);
    }

    // 5.1. Meetod kasHoidlast, mis tagastab true, kui raamatu tähis on kollane või sinine, vastasel juhul tagastatakse false.
    @Override
    public boolean kasHoidlast() {
        if(getTeoseTähis().equals("kollane") || getTeoseTähis().equals("sinine")) {
            return true;
        }
        return false;
    }

    // 5.2. Meetod toString, mis tagastab ülemklassi toString tulemuse koos märkusega, et tegemist on raamatuga.
    @Override
    public String toString() {
        return "Raamat{" +
                "teoseKirjeldus=" + getTeoseKirjeldus() + "; " +
                "teoseTähis=" + getTeoseTähis() + "; " +
                "laenutaja=" + getLaenutaja() + "; " +
                "päevadeArv=" + getPäevadeArv() + "; " +
                "kasHoidlast()=" + kasHoidlast() +
                "}";
    }
}
