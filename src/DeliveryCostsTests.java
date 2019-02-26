import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class DeliveryCostsTests {

    @Test
    public void fixedDeliveryCostsSmall() {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new Parcel("Small"));
        Delivery delivery = new Delivery(parcels);

        assertEquals(delivery.calculateTotalCost(), 3);
    }

    @Test
    public void fixedDeliveryCostsMultipleItems() {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new Parcel("Medium"));
        parcels.add(new Parcel("Medium"));
        parcels.add(new Parcel("Large"));
        parcels.add(new Parcel("Medium"));
        parcels.add(new Parcel("XL"));
        Delivery delivery = new Delivery(parcels);

        assertEquals(delivery.calculateTotalCost(), 64);
    }
}