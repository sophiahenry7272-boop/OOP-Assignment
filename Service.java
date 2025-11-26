class Service {
    private String serviceName;
    private double serviceCost;

    Service(String serviceName, double serviceCost) {
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
    }

    void showServiceInfo() {
        System.out.println("Service Name: " + serviceName);
        System.out.println("Service Cost: " + serviceCost);
    }
}
