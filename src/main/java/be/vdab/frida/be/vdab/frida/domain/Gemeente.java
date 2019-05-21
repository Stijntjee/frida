package be.vdab.frida.be.vdab.frida.domain;

public class Gemeente
{
    private final String naam;
    private final int postcode;

    //CONSTRUCTORS
    public Gemeente(String naam, int postcode) {
        this.naam = naam;
        this.postcode = postcode;
    }

    //GETTERS & SETTERS
    public String getNaam() {
        return naam;
    }

    public int getPostcode() {
        return postcode;
    }
}
