package data05_03_2025;

public class ProvaEreditarieta {
    public static void main(String[] args) {
        Bici b = new Bici();
        Bici2 b2 = new Bici2();

        b.run();
        b2.run();
    }
}

class Veicolo {
    void run() {
        System.out.println("Veicolo in marcia!");
    }
}

class Bici extends Veicolo {
}

class Bici2 extends Veicolo {
    @Override
    void run() {
        System.out.println("La bici corre in sicurezza!");
    }
}