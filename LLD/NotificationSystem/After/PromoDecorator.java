package LLD.NotificationSystem.After;

public class PromoDecorator extends NotificationDecorator {

    public PromoDecorator(NotificationStrategy notification) {
        super(notification);
    }

    @Override
    public void sendNotification(User user, String message) {
        super.sendNotification(user, "Added PromoCode to " + user.getName() + message);
    }
}
