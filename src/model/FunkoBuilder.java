public class FunkoBuilder implements Builder{
    private ToyFactory factory;

    public FunkoBuilder(ToyFactory factory) {
        this.factory = factory;
    }

    @Override
    public ToyPart buildHead() {
        return this.factory.createHead();
    }

    @Override
    public ToyPart buildBody() {
        return this.factory.createBody();
    }

    @Override
    public ToyPart buildLegs() {
        return this.factory.createLegs();
    }

    @Override
    public ToyPart buildBackground() {
        return this.factory.createBackground();
    }

}
