package model;

public class Prodotto {
    private String nome;
    private float costo;
    private int quantita;

    public Prodotto(String nome, float costo, int quantita) {
        this.nome = nome;
        this.costo = costo;
        this.quantita = quantita;
    }

    // getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return nome + ", prezzo = " + costo +
                ", quantità = " + quantita;
    }
}
