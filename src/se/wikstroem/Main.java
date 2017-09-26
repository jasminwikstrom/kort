package se.wikstroem;


import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] arg) {


        //Skapar upp en array av klassen kort m. 52 platser och sparar den i variabeln korten
        Kort[] korten = new Kort[52];

        // Skapar upp alla kort, går igenom alla färger och skapar 13 kort för varje färg
        int kortNummer = 0;
        for (int färg = 0; färg < 4; färg++) {

            for (int valör = 1; valör < 14; valör++) {

                Kort kort = new Kort();
                kort.färg = färg;
                kort.valör = valör;

                korten[kortNummer] = kort;
                kortNummer++;
            }

        }
        //Skapar en ny instans av variabeln kortlek, bunten är inte privat, så variabeln nås direkt.
        Kortlek kortlek = new Kortlek();
        kortlek.bunten = korten;

         // Skickar in kortleken i en metod där korten blandas
        blandakort(kortlek);

        //Hämtar ut första kortet ifrån arrayen av kort. Sparar kortet i en ny instans av klassen kort
        Kort förstaKortet = kortlek.bunten[0];
        String färg = null;
        if (förstaKortet.färg == Kort.KLÖVER) {
            färg = "♣";
        } else if (förstaKortet.färg == Kort.RUTER) {
            färg = "♦";
        } else if (förstaKortet.färg == Kort.HJÄRTER) {
            färg = "♥";
        } else if (förstaKortet.färg == Kort.SPADER) {
            färg = "♠";
        }
        

        JOptionPane.showMessageDialog(null, "Första kortet i leken är " + färg + " " + förstaKortet.valör);

    }

    // collection är en klass med metoden shuffle. Arrays.asList används för att vi har en array med kort och shuffle metoden tar en lista
    public static void blandakort(Kortlek kortlek) {

        Collections.shuffle(Arrays.asList(kortlek.bunten));
    }


}
