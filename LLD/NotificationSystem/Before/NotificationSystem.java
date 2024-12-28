package LLD.NotificationSystem.Before;

import java.util.ArrayList;
import java.util.List;

public class NotificationSystem {
    List<User> subscribers = new ArrayList<>();

    public void addSubscriber(User user) {
        subscribers.add(user);
    }
    public void removeSubscriber(User user) {
        subscribers.remove(user);
    }
    public void sendNotfication(User user, String msg, String channel, boolean addPromo, boolean hyperLinks){
        String finalMsg = msg;

        if(addPromo) {
            msg+= " This is promotional message";
        }
        if(hyperLinks) {
            msg += " This has some hyperLinks";
        }

        if(channel.equals("email")) {
            sendEmailNotification(msg);
        } else if( channel.equals("sms")) {
            sendSMSNotification(msg);
        }
    }

    private void sendEmailNotification(String msg) {
        System.out.println(msg+ " This is email notification");
    }
    private void sendSMSNotification(String msg) {
        System.out.println(msg + " This is SMS notification");
    }
}
