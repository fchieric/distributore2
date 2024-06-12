import java.util.Scanner;
import model.Distributore;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Distributore distributore = new Distributore(); //crea un'istanza distributore
        int nrProdotto;
        String scelta;
        double moneta;

        do {
            System.out.println("\nStato del distributore:");
            distributore.visualizzaProdotti();
            System.out.println("\nCredito attuale: " +  String.format("%.2f", distributore.getCredito()));

            System.out.println("\nMenu:");
            System.out.println("1. Inserisci monete");
            System.out.println("2. Eroga prodotto");
            System.out.println("3. Eroga resto");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            scelta = sc.nextLine();

            switch (scelta) {

                case "1":
                    do {
                        System.out.print("Inserisci l'importo della moneta (0 per uscire): ");
                        moneta = sc.nextDouble();
                        distributore.inserisciMoneta(moneta);
                    } while (moneta != 0);
                    break;
                case "2":
                    System.out.print("Inserisci il numero del prodotto da erogare: ");
                    nrProdotto = sc.nextInt();
                    distributore.erogaProdotto(nrProdotto - 1); // Sottrae 1 per adattarsi all'indice dell'array
                    break;
                case "3":
                    distributore.erogaResto();
                    break;
                case "0":
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
                    break;
            }
            System.out.println("\nPremi invio per continuare...");
            sc.nextLine();
        } while (!scelta.equals("0"));
    }
}