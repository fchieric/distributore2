package model;

public class Distributore {
    private double credito;
    private Prodotto[] elencoProdotti;

    public Distributore() {
        this.credito = 0.0;
        this.elencoProdotti = new Prodotto[6];

        elencoProdotti[0] = new Bevanda("Aranciata", 1.70f, 20, true);
        elencoProdotti[1] = new Bevanda("Coca Cola", 1.50f, 15, true);
        elencoProdotti[2] = new Bevanda("Acqua Naturale", 1.00f, 25, false);
        elencoProdotti[3] = new Snack("Patatine", 1.10f, 10, 100);
        elencoProdotti[4] = new Snack("Biscotti", 0.90f, 20, 150);
        elencoProdotti[5] = new Snack("Crackers", 1.20f, 30, 120);
    }

    // isnerisci moneta
    public void inserisciMoneta(double moneta) {
        // controllo monete valide
        if (moneta == 0.10 || moneta == 0.20 || moneta == 0.50 || moneta == 1 || moneta == 2) {
            credito += moneta;
            System.out.println("Credito aggiornato: " + String.format("%.2f", credito));
        } else {
            System.out.println("Moneta non valida.");
        }
    }

    // eroga Prodotto

    public void erogaProdotto (int nrProdotto) {
        //controllo input validi
        if (nrProdotto < 0 || nrProdotto >= elencoProdotti.length) {
            System.out.println("Impossibile erogare il prodotto.");
            return;
        }

        // creo l'istanza di Prodotto p e dico che è un elemento contenuto nell array elencoProdotti
        Prodotto p = elencoProdotti[nrProdotto];

        // controllo quantità
        if (p.getQuantita() == 0) {
            System.out.println("Prodotto esaurito.");
            return;
        }

        //controllo che non costi più dei soldi
        if (credito < p.getCosto()) {
            System.out.println("Credito insufficiente.");
            return;
        }

        // quantità -1 perchè l'acquisto è andato a buon fine
        p.setQuantita(p.getQuantita() - 1);
        credito -= p.getCosto();

        // controllo che messaggio devo stampare
        if (p instanceof Bevanda) {
            Bevanda b = (Bevanda) p; //casting a Bevanda
            System.out.println("\nBevanda " + b.getNome() + " erogata correttamente - tipologia: " + (b.isZuccherata() ? "zuccherata" : "non zuccherata"));
        } else if (p instanceof Snack) {
            Snack s = (Snack) p; //castinga a Snack
            System.out.println("\nSnack " + s.getNome() + " erogato correttamente - grammi: " + s.getGrammi());
        }
    }

    // visualizza prodotti con il numero di indice (+ 1 perchè se no iniziano da 0)
    public void visualizzaProdotti() {
        System.out.println("Elenco prodotti disponibili:");
        for (int i = 0; i < elencoProdotti.length; i++) {
            System.out.println((i + 1) + ". " + elencoProdotti[i].toString());
        }
    }

    // eroga resto
    public void erogaResto() {
        System.out.println("Resto erogato: " + String.format("%.2f", credito));
        credito = 0;
    }

    // setter e getter

    public double getCredito() {

        return credito;
    }

    public void setCredito(double credito) {

        this.credito = credito;
    }

    public Prodotto[] getElencoProdotti() {

        return elencoProdotti;
    }

    public void setElencoProdotti(Prodotto[] elencoProdotti) {

        this.elencoProdotti = elencoProdotti;
    }

}
