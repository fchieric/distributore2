package model;

public class Bevanda extends Prodotto {
    private boolean zuccherata;

    // costruttore
    public Bevanda(String nome, float costo, int quantita, boolean zuccherata) {
        super(nome, costo, quantita);
        this.zuccherata = zuccherata;
    }

    // getter
    public boolean isZuccherata() {

        return zuccherata;
    }

    // setter
    public void setZuccherata(boolean zuccherata) {

        this.zuccherata = zuccherata;
    }

    @Override
    public String toString() {

        return super.toString() + ", Zuccherata: " + (zuccherata ? "Sì" : "No") + ". Categoria: bevande.";
    }

}
