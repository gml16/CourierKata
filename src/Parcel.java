public class Parcel {

    final private Type type;
    final private int weight;

    public Parcel(Type type) {
        this.type = type;
        this.weight = 0;
    }

    public Parcel(Type type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public int getCost() {
        switch(type){
            case Small: return 3;
            case Medium: return 8;
            case Large: return 15;
            case XL: return 25;
            default: return 0;
        }
    }
}
