package LLD.NotificationSystem.After;

public class SMSNotification implements NotificationStrategy{

    @Override
    public void sendNotification(User user, String message) {
        System.out.println(" This is SMS Notification to " + user.getEmail() + ": " + message);
    }
}
