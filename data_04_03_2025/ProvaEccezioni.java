package data_04_03_2025;

public class ProvaEccezioni {
    public static void main(String[] args) {
        try {
            int[] numeri = { 1, 2, 3, 4 };
            System.out.println(numeri[12]);
        } catch (Exception e) {
            System.out.println("Si nu cazz");
        } finally {
            System.out.println("Try finito");
        }
    }
}
