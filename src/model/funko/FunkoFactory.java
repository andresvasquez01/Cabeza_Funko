public class FunkoFactory implements ToyFactory{

    @Override
    public ToyPart createHead() {
        return new FunkoHead();
    }

    @Override
    public ToyPart createBody() {
        return new FunkoBody();
    }

    @Override
    public ToyPart createLegs() {
        return new FunkoLegs();
    }

    @Override
    public ToyPart createBackground() {
        return new FunkoBackground();
    }
    
}
