package model;

public class Snack extends Prodotto{

    private int grammi;

    // costruttore
    public Snack(String nome, float costo, int quantita, int grammi) {
        super(nome, costo, quantita);
        this.grammi = grammi;
    }

    // setter
    public void setGrammi(int grammi) {

        this.grammi = grammi;
    }

    //getter
    public int getGrammi() {

        return grammi;
    }

    @Override
    public String toString() {

        return super.toString() + ", Grammi: " + grammi + "g. Categoria: snack.";
    }

}
