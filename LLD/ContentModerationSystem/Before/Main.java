package LLD.ContentModerationSystem.Before;

public class Main {
    public static void main(String args[]) {
        User user1 = new User("Omkar", true);
        User user2 = new User("OmkarInActive", false);
        Post post1 = new Post(false, false, user1, "This is offensive", 1);
        Post post2 = new Post(false, false, user2, "This is good post", 2);

        ModerationSystem ms = new ModerationSystem();
        ms.moderateAndPublish(post1);
        ms.moderateAndPublish(post2);
    }
}
