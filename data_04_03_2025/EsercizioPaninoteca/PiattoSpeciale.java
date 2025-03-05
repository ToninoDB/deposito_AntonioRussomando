package data_04_03_2025.EsercizioPaninoteca;

import java.util.ArrayList;

public class PiattoSpeciale {
    private static final double PREZZO_FISSO = 1.0;

    private ArrayList<String> ingredientiDisponibili = new ArrayList<String>();
    private ArrayList<Double> prezziIngredienti = new ArrayList<Double>();
    private ArrayList<String> ingredientiScelti = new ArrayList<String>();

    public PiattoSpeciale() {
        ingredientiDisponibili.add("Panino normale");
        prezziIngredienti.add(2.0);

        ingredientiDisponibili.add("Panino al sesamo");
        prezziIngredienti.add(3.0);

        ingredientiDisponibili.add("Hamburger");
        prezziIngredienti.add(4.0);

        ingredientiDisponibili.add("Pollo");
        prezziIngredienti.add(3.5);

        ingredientiDisponibili.add("Insalata");
        prezziIngredienti.add(1.0);

        ingredientiDisponibili.add("Pomodoro");
        prezziIngredienti.add(1.0);

        ingredientiDisponibili.add("Cipolla");
        prezziIngredienti.add(1.0);
    }

    public void mostraIngredienti() {
        System.out.println("Ingredienti disponibili:");

        for (int i = 0; i < ingredientiDisponibili.size(); i++) {
            System.out.println(ingredientiDisponibili.get(i) + " - " + prezziIngredienti.get(i));
        }

    }

    public void aggiungiIngrediente(String ingr) {
        if (ingredientiDisponibili.contains(ingr)) {
            ingredientiScelti.add(ingr);
        } else {
            System.out.println("Ingrediente non disponibile");
        }
    }

    public double calcolaPrezzo() {
        double totale = 0;
        for (String ingr : ingredientiScelti) {
            // vado a prendere l'indice corrispondente all'ingrediente scelto nell'array
            // degli ingredienti disponibili e lo uso per cercare il rpezzo corrispondente
            // nell'arraylist dei prezzi
            totale += prezziIngredienti.get(ingredientiDisponibili.indexOf(ingr));
        }

        return totale + PREZZO_FISSO;
    }

    public void mostraIngredientiScelti() {
        for (String ingr : ingredientiScelti) {
            System.out.println(ingr);
        }
    }

    public ArrayList<String> getIngredientiScelti() {
        return ingredientiScelti;
    }
}
