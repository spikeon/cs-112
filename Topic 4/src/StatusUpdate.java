public class StatusUpdate extends Message {

    private int like_count = 0;

    public StatusUpdate(String status) {
        super(status);
    }

    public StatusUpdate(String status, int likes) {
        super(status);
        like_count = likes;
    }

    public void like() {
        like_count++;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " (Likes: " + like_count + ")";
    }
}
