package LLD.NotificationSystem.After;

public class EmailNotification implements NotificationStrategy{

    @Override
    public void sendNotification(User user, String message) {
        System.out.println("This is email Notification to " + user.getEmail() + ": " + message);
    }
}
