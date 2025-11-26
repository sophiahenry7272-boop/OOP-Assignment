
class ServiceRecord {
    private Vehicle vehicle;
    private Service service;
    private String serviceDate;

    ServiceRecord(Vehicle vehicle, Service service, String serviceDate) {
        this.vehicle = vehicle;
        this.service = service;
        this.serviceDate = serviceDate;
    }

    void showRecord() {
        System.out.println("\n---- SERVICE RECORD ----");
        vehicle.showVehicleInfo();
        service.showServiceInfo();
        System.out.println("Service Date: " + serviceDate);
    }
}
