import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        try {
            Random random = new Random();

            int raha = 10;
            System.out.println("Sinulla on käytettävissäsi 10 euroa.");

            while (raha > 0) {
            System.out.println("\nAnna rahamäärä, jolla haluat pelata:");
            int panos = 0;
            while (panos < 1 || panos > 5 || panos > raha) {
                panos = scanner.nextInt();
                if (panos > raha) {
                    System.out.println("Sinulla ei ole tarpeeksi rahaa panokseen. Anna pienempi panos.");
                }
            }

            scanner.nextLine();  // Enterin käsittely

            System.out.println("Panoksesi on " + panos + " euroa. Onnea peliin!");

            int[] numerot = new int[3];
            int voitot = 0;

            for (int i = 0; i < 3; i++) {
                numerot[i] = random.nextInt(10) + 1;
            }

            System.out.print("Arvotut numerot ovat: ");
            for (int numero : numerot) {
                System.out.print(numero + " ");
                if (numero == 7) {
                    voitot++;
                }
            }

            if (voitot == 1) {
                System.out.println("\nJee! Voitit 5 euroa!");
                raha += 5 - panos;
            } else if (voitot == 2) {
                System.out.println("\nVau! Voitit 10 euroa!");
                raha += 10 - panos;
            } else if (voitot == 3) {
                System.out.println("\nUpeaa! Voitit jättipotin 15 euroa!");
                raha += 15 - panos;
            } else {
                System.out.println("\nVoi ei, hävisit!");
                raha -= panos;
            }

            System.out.println("Sinulla on " + raha + " euroa jäljellä.");

            if (raha > 0) {
                System.out.println("Haluatko pelata uudestaan? Jos haluat pelata, paina 'k' ja paina Enter. Jos haluat lopettaa, kirjoita 'e' ja paina Enter.");
                String vastaus = scanner.nextLine();
                if (vastaus.equalsIgnoreCase("e")) {
                    System.out.println("Voitit yhteensä " + raha + " euroa. Kiitos pelaamisesta!");
                    break;
                } else if (!vastaus.equalsIgnoreCase("k")) {
                    return;
                }
            } else {
                System.out.println("Voi harmi! Rahasi ovat loppu. Peli päättyy.");
            }
        }
        } finally {
            scanner.close();
        }
        System.out.println("Kiitos pelaamisesta!");
    }
}   
