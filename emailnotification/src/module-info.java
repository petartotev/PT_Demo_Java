module emailnotification {
    /* Note that there is no need for exports! All other packages will use it through NotificationService */
    requires notificationservice;
    /* providing NotificationService with implementation EmailNotification: */
    provides com.notificationservice.NotificationService with com.emailnotification.EmailNotification;
}