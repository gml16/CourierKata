public class Parcel implements Comparable<Parcel>{

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
        int cost = 0;
        switch(type){
            case Small:
                cost += 3 + Math.max(0, this.weight-1)*2;
                break;
            case Medium:
                cost += 8 + Math.max(0, this.weight-3)*2;
                break;
            case Large:
                cost += 15 + Math.max(0, this.weight-6)*2;
                break;
            case XL:
                cost += 50 + Math.max(0, this.weight-50);
                break;
            default:
                break;
        }
        return cost;
    }

    @Override
    public int compareTo(Parcel o) {
        if(this.type == o.type){
            if (this.weight > o.weight){
                return 1;
            }
            if (this.weight < o.weight){
                return -1;
            }
            if (this.weight == o.weight){
                return 0;
            }
        } else {
            if (this.type.ordinal() > o.type.ordinal()){
                return 1;
            }
            if (this.type.ordinal() < o.type.ordinal()){
                return -1;
            }
            if (this.type.ordinal() == o.type.ordinal()){
                return 0;
            }
        }
        return 0;
    }
}
