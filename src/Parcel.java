public class Parcel {

    private Type type;

    public Parcel(Type type) {
        this.type = type;
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
