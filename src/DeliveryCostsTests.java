import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class DeliveryCostsTests {

    @Test
    public void fixedDeliveryCostsSmall() {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new Parcel(Type.Small));
        Delivery delivery = new Delivery(parcels);

        assertEquals(delivery.calculateTotalCost(), 3);
    }

    @Test
    public void fixedDeliveryCostsMultipleItems() {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new Parcel(Type.Medium));
        parcels.add(new Parcel(Type.Medium));
        parcels.add(new Parcel(Type.Large));
        parcels.add(new Parcel(Type.Medium));
        parcels.add(new Parcel(Type.XL));
        Delivery delivery = new Delivery(parcels);

        assertEquals(delivery.calculateTotalCost(), 64);
    }

    @Test
    public void fixedDeliveryCostsNoItem() {
        List<Parcel> parcels = new ArrayList<>();
        Delivery delivery = new Delivery(parcels);

        assertEquals(delivery.calculateTotalCost(), 0);
    }
}