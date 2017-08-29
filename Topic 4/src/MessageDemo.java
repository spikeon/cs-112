public class MessageDemo {
    public static void main(String[] args){
        Message msg = new Message("This is a test");
        TextMessage txtmsg = new TextMessage("This is a test of text message.  It should truncate this string at 140 characters.  Let's see if it actually does that.  La de daaaaaaaaaaaaaaaaaaaaaaa.......................");
        StatusUpdate status = new StatusUpdate("I like cheese", 2);

        status.like();

        System.out.println(msg);
        System.out.println(txtmsg);
        System.out.println(status);

    }
}
