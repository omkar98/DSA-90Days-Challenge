package LLD.NotificationSystem.After;

import java.util.ArrayList;
import java.util.List;

public class NotificationSystem {
    List<User> subscribers = new ArrayList<>();
    private NotificationStrategy notificationChannel;

    public void addSubscriber(User user) {
        subscribers.add(user);
    }
    public void removeSubscriber(User user) {
        subscribers.remove(user);
    }

    public void setNotificationChannel(NotificationStrategy channel) {
        this.notificationChannel = channel;
    }

    public void updateInventory() {
        for(User user: subscribers) {
            sendNotification(user, "Stock Updated!");
        }
    }



    public void sendNotification(User user, String msg){
        if (notificationChannel != null) {
            notificationChannel.sendNotification(user, msg);
        }

    }
}
