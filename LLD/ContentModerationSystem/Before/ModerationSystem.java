package LLD.ContentModerationSystem.Before;

import java.util.ArrayList;
import java.util.List;

public class ModerationSystem {
    //for caching
    List<Post> posts = new ArrayList<>();
    public void moderateAndPublish(Post post) {
        User user = post.getAuthor();
        // moderation
        if(post.getContent().contains("offensive")) {
            System.out.println("Offensive Word Detected!");
            return;
        }
        if(post.getContent().length()<10) {
            System.out.println("Too short post!");
            return;
        }
        if(user==null || !user.isActive()) {
            System.out.println("User Inactive!");
            return;
        }

        //publish
        posts.add(post);
        post.setPublished(true);
    }

    public Post retrivePost(int postId){
        return posts.stream().filter(post -> post.getPostId()==postId).findAny().orElse(null);
    }
}
