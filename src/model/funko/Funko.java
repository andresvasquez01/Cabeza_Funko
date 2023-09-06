public class Funko implements Toy{

    ToyPart head;
    ToyPart body;
    ToyPart legs;
    ToyPart background;

    public ToyPart getHead() {
        return head;
    }

    public void setHead(ToyPart head) {
        this.head = head;
    }

    public ToyPart getBody() {
        return body;
    }

    public void setBody(ToyPart body) {
        this.body = body;
    }

    public ToyPart getLegs() {
        return legs;
    }

    public void setLegs(ToyPart legs) {
        this.legs = legs;
    }

    public ToyPart getBackground() {
        return background;
    }

    public void setBackground(ToyPart background) {
        this.background = background;
    }

    @Override
    public String displayToy() {
        return "Funko creado con las partes: " + this.head.getPath() + ", " + this.body.getPath() +
                ", " + this.legs.getPath() + " y fondo: " + this.background.getPath();
    }
    
}
