import java.util.ArrayList;
import java.util.Collections;
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
        List<Parcel> orders = new ArrayList<>(this.parcels);
        Collections.sort(orders);
        Collections.reverse(orders);
        int res = 0;
        int smalls = 0;
        int mediums = 0;
        int any = 0;
        for (Parcel p : orders){
            if (p.getType() == TYPE.Small) {
                smalls++;
            } else if (p.getType() == TYPE.Medium) {
                mediums++;
            } else {
                any++;
            }
            if(smalls==4) {
                smalls = 0;
            } else if (mediums == 3) {
                mediums = 0;
            } else if (any == 5){
                any = 0;
            } else{
                res += p.getCost();
            }
        }
        if(fastShipping){
            res *= 2;
        }
        return res;
    }
}
