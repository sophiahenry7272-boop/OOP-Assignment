public class Vehicle {
    private String ownerName;
    private String vehicleNumber;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleNumber, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public void showVehicleInfo() {
        System.out.println("Owner Name   : " + ownerName);
        System.out.println("Vehicle No.  : " + vehicleNumber);
        System.out.println("Vehicle Type : " + vehicleType);
    }
}
