import lego.legoFactory;

public class app {
    public static void main(String[] args) {
        // Crear un Lego
        ToyFactory legoFactory = new LegoFactory();
        Director director = new Director(legoFactory, "Lego");
        System.out.println("Creating a Lego:");
        Toy lego1 = director.getToy();
        System.out.println(lego1.displayToy());

        // Crear un Funko
        ToyFactory funkoFactory = new FunkoFactory();
        Director director1 = new Director(funkoFactory, "Funko");
        System.out.println("Creating a Funko:");
        Toy funko1 = director1.getToy();
        System.out.println(funko1.displayToy());
    }
}
