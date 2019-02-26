import java.util.List;

public class Delivery {

    final private List<Parcel> parcels;

    public Delivery(List<Parcel> parcels) {
        this.parcels = parcels;
    }

    public int calculateTotalCost(){
        int res = 0;
        for (Parcel p : parcels){
            res += p.getCost();
        }
        return res;
    }
}
