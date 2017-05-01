package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author Raine Rantanen
 */
public class Erotus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int arvo;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        arvo = 0;
    }

    @Override
    public void suorita() {

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.miinus(arvo);

        paivitaKentat();
    }

    @Override
    public void peru() {
        sovellus.miinus(arvo * -1);
        paivitaKentat();
    }

    private void paivitaKentat() {
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
}
