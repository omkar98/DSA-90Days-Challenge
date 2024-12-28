package LLD.NotificationSystem.After;

public class HyperLinkDecorator extends NotificationDecorator{
    public HyperLinkDecorator(NotificationStrategy notification) {
        super(notification);
    }


    @Override
    public void sendNotification(User user, String message) {
        super.sendNotification(user, "Added HyperLink to " + user.getName() + message);
    }
}
