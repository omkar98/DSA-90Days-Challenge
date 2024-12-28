package LLD.NotificationSystem.Before;

public class Main {

    public static void main(String args[]) {
        NotificationSystem notificationSystem = new NotificationSystem();
        User user1 = new User("Omkar", "edu.omkar@gmail.com", "1234");
        User user2 = new User("Omkar1", "edu.omkar1@gmail.com", "12345");

        notificationSystem.addSubscriber(user1);
        notificationSystem.addSubscriber(user2);

        notificationSystem.sendNotfication(user1, "This is user1", "email", false, true);
        notificationSystem.sendNotfication(user1, "This is user2", "sms", true, false);

    }
}

