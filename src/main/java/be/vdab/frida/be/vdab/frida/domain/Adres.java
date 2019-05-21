package be.vdab.frida.be.vdab.frida.domain;

public class Adres
{
    private final String straat;
    private final String HuisNr;
    private final Gemeente gemeente;

    //CONSTRUCTORS
    public Adres(String straat, String huisNr, Gemeente gemeente) {
        this.straat = straat;
        HuisNr = huisNr;
        this.gemeente = gemeente;
    }
    //GETTERS & SETTERS
    public String getStraat() {
        return straat;
    }

    public String getHuisNr() {
        return HuisNr;
    }

    public Gemeente getGemeente() {
        return gemeente;
    }
}
