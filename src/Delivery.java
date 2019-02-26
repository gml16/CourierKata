import java.util.List;

public class Delivery {

    final private List<Parcel> parcels;
    final private boolean fastShipping;

    public Delivery(List<Parcel> parcels) {
        this.parcels = parcels;
        this.fastShipping = false;
    }

    public Delivery(List<Parcel> parcels, boolean fastShipping) {
        this.parcels = parcels;
        this.fastShipping = fastShipping;
    }

    public int calculateTotalCost(){
        int res = 0;
        for (Parcel p : parcels){
            res += p.getCost();
        }
        return res;
    }
}
