public class LegoFactory implements ToyFactory{

    @Override
    public ToyPart createHead() {
        return new LegoHead();
    }

    @Override
    public ToyPart createBody() {
        return new LegoBody();
    }

    @Override
    public ToyPart createLegs() {
        return new LegoLegs();
    }

    @Override
    public ToyPart createBackground() {
        return new LegoBackground();
    }
    
}
