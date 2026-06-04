public class InterfaceDemo {

    // Interface
    interface Playable {
        void play();
    }

    // Class 1
    static class Guitar implements Playable {
        @Override
        public void play() {
            System.out.println("Guitar  : Strumming chords... 🎸");
        }
    }

    // Class 2
    static class Piano implements Playable {
        @Override
        public void play() {
            System.out.println("Piano   : Playing keys... 🎹");
        }
    }

    // Class 3
    static class Drums implements Playable {
        @Override
        public void play() {
            System.out.println("Drums   : Beating drums... 🥁");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Interface Implementation ===\n");

        Playable guitar = new Guitar();
        Playable piano  = new Piano();
        Playable drums  = new Drums();

        guitar.play();
        piano.play();
        drums.play();

        System.out.println("\nAll classes implement Playable interface!");
    }
}