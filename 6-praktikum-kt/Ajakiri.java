package KT1;

// 6. Klass Ajakiri on klassi Teos alamklass. Klassis on konstruktor vajaliku info määramiseks ja vähemalt järgmised meetodid.
public class Ajakiri extends Teos {
    public Ajakiri(String teoseKirjeldus, String teoseTähis, String laenutaja, int päevadeArv) {
        super(teoseKirjeldus, teoseTähis, laenutaja, päevadeArv);
    }

    // 6.1. Meetod kasHoidlast, mis tagastab true, kui ajakiri ilmus aastal 2000 või varem, vastasel juhul tagastatakse false.
    public boolean kasHoidlast() {
        if(getTeoseKirjeldus().contains("/")) {
            // Tegemist on ajakirjaga.
            int aastaNumberAlgus = getTeoseKirjeldus().indexOf("/") + 1;
            int aastaNumberLõpp = getTeoseKirjeldus().indexOf(",");
            String aastaNumber = getTeoseKirjeldus().substring(aastaNumberAlgus, aastaNumberLõpp);
            if(Integer.parseInt(aastaNumber) <= 2000) {
                return true;
            }
        }
        return false;
    }

    // 6.2. Meetod toString, mille ülekatmisel on rakendatud ülemklassi meetodit toString lisades märkuse selle kohta, et tegemist on ajakirjaga.
    @Override
    public String toString() {
        return "Ajakiri{" +
                "teoseKirjeldus=" + getTeoseKirjeldus() + "; " +
                "teoseTähis=" + getTeoseTähis() + "; " +
                "laenutaja=" + getLaenutaja() + "; " +
                "päevadeArv=" + getPäevadeArv() + "; " +
                "kasHoidlast()=" + kasHoidlast() +
                "}";
    }
}
