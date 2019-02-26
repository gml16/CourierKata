import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Input of the form:
    // Integer k for number of parcels, f for not fast or fast respectively
    // k lines containing t for type and w for weight

    // Example:
    // 3 0
    // 0 1
    // 1 5
    // 2 7
    // Here, 3 parcels are delivered (not fast), one small weighing 1kg, 1 medium weighing 5kg and 1 large weighing 7kg

    // 2 1
    // 3 50
    // 1 35
    //Here, 2 parcels are delivered swiftly, one XL weighing 50kg, 1 medium weighing 35kg

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        List<Parcel> parcels = new ArrayList<>();
        Delivery delivery;
        int k = scn.nextInt();
        int f = scn.nextInt();
        while(k-->0){
            int t = scn.nextInt();
            int w = scn.nextInt();
            switch(t){
                case 0: parcels.add(new Parcel(TYPE.Small, w));
                case 1: parcels.add(new Parcel(TYPE.Medium, w));
                case 2: parcels.add(new Parcel(TYPE.Large, w));
                case 3: parcels.add(new Parcel(TYPE.XL, w));
                default: break;
            }
        }
        if(f==0){
            delivery = new Delivery(parcels, false);
        } else {
            delivery = new Delivery(parcels, true);
        }

        for (Parcel p : parcels){
            System.out.print(p + " - ");
        }
        System.out.println("Total delivery cost: " + delivery.calculateTotalCost());
        scn.close();
    }
}
