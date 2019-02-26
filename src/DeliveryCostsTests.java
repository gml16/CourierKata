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

        assertEquals(delivery.calculateTotalCost(), 89);
    }

    @Test
    public void fixedDeliveryCostsNoItem() {
        List<Parcel> parcels = new ArrayList<>();
        Delivery delivery = new Delivery(parcels);

        assertEquals(delivery.calculateTotalCost(), 0);
    }

    @Test
    public void fastDeliveryCostsSmall() {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new Parcel(Type.XL));
        Delivery delivery = new Delivery(parcels, true);

        assertEquals(delivery.calculateTotalCost(), 100);
    }

    @Test
    public void fastDeliveryCostsMultipleItems() {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new Parcel(Type.Small));
        parcels.add(new Parcel(Type.Medium));
        parcels.add(new Parcel(Type.Large));
        parcels.add(new Parcel(Type.Medium));
        parcels.add(new Parcel(Type.XL));
        Delivery delivery = new Delivery(parcels, true);

        assertEquals(delivery.calculateTotalCost(), 168);
    }

    @Test
    public void fastDeliveryCostsNoItem() {
        List<Parcel> parcels = new ArrayList<>();
        Delivery delivery = new Delivery(parcels, true);

        assertEquals(delivery.calculateTotalCost(), 0);
    }

    @Test
    public void fastDeliveryNoImpactOnItem() {
        List<Parcel> parcels = new ArrayList<>();
        Parcel large = new Parcel(Type.Large);
        Parcel medium = new Parcel(Type.Medium);
        parcels.add(large);
        parcels.add(medium);
        Delivery fastDelivery = new Delivery(parcels, true);
        Delivery delivery = new Delivery(parcels, false);
        assertEquals(delivery.calculateTotalCost(), 23);
        assertEquals(fastDelivery.calculateTotalCost(), 46);
    }

    @Test
    public void weightDeliveryCostsOverWeight() {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new Parcel(Type.Small, 3));
        Delivery delivery = new Delivery(parcels);

        assertEquals(delivery.calculateTotalCost(), 7);
    }

    @Test
    public void weightDeliveryCostsMixedWeights() {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new Parcel(Type.Small, 3));
        parcels.add(new Parcel(Type.Medium, 4));
        parcels.add(new Parcel(Type.Large, 2));
        Delivery delivery = new Delivery(parcels);

        assertEquals(delivery.calculateTotalCost(), 32);
    }

    @Test
    public void weightDeliveryCostsMixedWeightsWithXL() {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new Parcel(Type.Small, 3));
        parcels.add(new Parcel(Type.Medium, 4));
        parcels.add(new Parcel(Type.Large, 30));
        parcels.add(new Parcel(Type.XL, 60));
        Delivery delivery = new Delivery(parcels);

        assertEquals(delivery.calculateTotalCost(), 140);
    }

    @Test
    public void deliveryCostsWithManyParcels() {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new Parcel(Type.Medium, 3));
        parcels.add(new Parcel(Type.Medium, 3));
        parcels.add(new Parcel(Type.Medium, 3));
        parcels.add(new Parcel(Type.Medium, 4));
        parcels.add(new Parcel(Type.Medium, 4));
        parcels.add(new Parcel(Type.Medium, 4));
        Delivery delivery = new Delivery(parcels);

        assertEquals(delivery.calculateTotalCost(), 36);
    }

    @Test
    public void fastDeliveryCostsWithManyParcels() {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new Parcel(Type.Medium, 3));
        parcels.add(new Parcel(Type.Medium, 3));
        parcels.add(new Parcel(Type.Medium, 3));
        parcels.add(new Parcel(Type.Medium, 4));
        parcels.add(new Parcel(Type.Medium, 4));
        parcels.add(new Parcel(Type.Medium, 4));
        Delivery delivery = new Delivery(parcels, true);

        assertEquals(delivery.calculateTotalCost(), 72);
    }

    @Test
    public void multipleDeliveryCostsWithManyParcels2() {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new Parcel(Type.Medium, 3));
        parcels.add(new Parcel(Type.Medium, 3));
        parcels.add(new Parcel(Type.Medium, 3));
        parcels.add(new Parcel(Type.Medium, 3));
        parcels.add(new Parcel(Type.Medium, 4));
        parcels.add(new Parcel(Type.Medium, 4));
        parcels.add(new Parcel(Type.Medium, 4));

        parcels.add(new Parcel(Type.Small, 1));
        parcels.add(new Parcel(Type.Small, 1));
        parcels.add(new Parcel(Type.Small, 2));
        parcels.add(new Parcel(Type.Small, 2));

        Delivery delivery = new Delivery(parcels, true);
        assertEquals(delivery.calculateTotalCost(), 106);

        Delivery delivery2 = new Delivery(parcels, false);
        assertEquals(delivery.calculateTotalCost(), 53);
    }

}