public class BrowserDemo {
    public static void main(String[] args){
        WebBrowser chrome = new WebBrowser();
        WebBrowser incognito = new PrivateWebBrowser();

        chrome.visit("youtube.com");
        chrome.visit("twitter.com");

        incognito.visit("pornhub.com");
        incognito.visit("google.com/why+do+my+feet+smell+like+cheese");

        System.out.println(chrome);
        System.out.println(incognito);

        incognito.visit("twitch.tv");
        System.out.println(incognito.getHistory());
    }
}
