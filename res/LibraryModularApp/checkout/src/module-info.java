module checkout {
    requires inventory;
    requires notificationservice;

    exports com.checkout;

    uses com.notificationservice.NotificationService;
}
