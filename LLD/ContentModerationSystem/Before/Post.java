package LLD.ContentModerationSystem.Before;

public class Post {

    int postId;
    String content;
    User author;
    boolean isSpam;
    boolean isPublished;

    public Post(boolean isPublished, boolean isSpam, User author, String content, int postId) {
        this.isPublished = isPublished;
        this.isSpam = isSpam;
        this.author = author;
        this.content = content;
        this.postId = postId;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public boolean isSpam() {
        return isSpam;
    }

    public void setSpam(boolean spam) {
        isSpam = spam;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public int getPostId() {
        return postId;
    }
}
