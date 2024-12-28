package LLD.NotificationSystem.After;

public class NotificationFactory {
    public NotificationStrategy createNotificationChannel(String input) {
        switch(input){
            case "email": return new EmailNotification();
            case "sms": return new SMSNotification();
            default: throw  new IllegalArgumentException("Invalid");
        }
    }
}
