package LLD.NotificationSystem.After;

public abstract class NotificationDecorator implements NotificationStrategy {
    // to avoid making objects of NotificationDecorator -> abstract
    // to pass a NotificationStrategy in the constructor, create a construtor

    NotificationStrategy notification;

    NotificationDecorator(NotificationStrategy notification) {
        this.notification = notification;
    }

    // we are overriding this because when you add the same method in the child class, it expects that this method should be present in this abstract class. Try removing this method to understand why was this added.
    @Override
    public void sendNotification(User user, String message) {
        this.notification.sendNotification(user, message);
    }
}
