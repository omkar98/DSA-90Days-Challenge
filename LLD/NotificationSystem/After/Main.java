package LLD.NotificationSystem.After;

public class Main {

    private static final String EMAIL_NOTIFICATION_CHANNEL_NAME = "email";
    private static final String SMS_NOTIFICATION_CHANNEL_NAME = "sms";

    public static void main(String args[]) {
        NotificationSystem notificationSystem = new NotificationSystem();
        User user1 = new User("Omkar", "edu.omkar@gmail.com", "1234");
        User user2 = new User("Omkar1", "edu.omkar1@gmail.com", "12345");

        notificationSystem.addSubscriber(user1);
        notificationSystem.addSubscriber(user2);

        NotificationFactory factory = new NotificationFactory();
        NotificationStrategy emailChannel = factory.createNotificationChannel(EMAIL_NOTIFICATION_CHANNEL_NAME);
        NotificationStrategy smsChannel = factory.createNotificationChannel(SMS_NOTIFICATION_CHANNEL_NAME);

        NotificationStrategy channel = new HyperLinkDecorator(new PromoDecorator(emailChannel));
        NotificationStrategy channel1 = new HyperLinkDecorator(new PromoDecorator(smsChannel));
        notificationSystem.setNotificationChannel(channel);

        notificationSystem.updateInventory();
    }
}

