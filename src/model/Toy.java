public interface Toy {
    String displayToy();

    void setHead(ToyPart createHead);

    void setBody(ToyPart createBody);

    void setLegs(ToyPart createLegs);

    void setBackground(ToyPart createBackground);

    ToyPart getHead();

    ToyPart getBody();

    ToyPart getLegs();
    
    ToyPart getBackground();
}
