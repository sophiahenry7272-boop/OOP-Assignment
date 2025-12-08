public class Service {
    private String serviceName;
    private double serviceCost;

    public Service(String serviceName, double serviceCost) {
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
    }

    public void showServiceInfo() {
        System.out.println("Service Name : " + serviceName);
        System.out.println("Service Cost : " + serviceCost);
    }
}
