public class Director {
    private ToyFactory factory;
    private Toy toy;
    private String type;
    private Builder builder;

    public Director(ToyFactory factory, String type) {
        this.factory = factory;
        this.type = type;
        make();
    }
    
    public void make() {
        if (this.type.equals("Lego")){
            builder = new LegoBuilder(factory);
            toy = new Lego();
            toy.setHead(builder.buildHead());
            toy.setBody(builder.buildBody());
            toy.setLegs(builder.buildLegs());
            toy.setBackground(builder.buildBackground());
        }
        if (this.type.equals("Funko")){
            builder = new FunkoBuilder(factory);
            toy = new Funko();
            toy.setHead(builder.buildHead());
            toy.setBody(builder.buildBody());
            toy.setLegs(builder.buildLegs());
            toy.setBackground(builder.buildBackground());
        }
    }

    public Toy getToy(){
        return this.toy;
    }

}
