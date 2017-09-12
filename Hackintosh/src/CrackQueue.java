import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CrackQueue implements Runnable{

    volatile static boolean shutdown = false;
    private static boolean pause = false;

    public static ExecutorService service;
    private static List<String> incoming = new ArrayList<String>();

    public CrackQueue() {
        service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        //System.out.println("Queue Running");
    }

    public void run(){
        service.submit(new Crack());
        while(!shutdown){

            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Core.seconds+= 1;
            System.out.println("Checked " + Core.attempts + " ( " + Core.instances + " ) " + " passwords in " + Core.seconds + " seconds");

            if(((ThreadPoolExecutor)service).getQueue().size() < 1000 && incoming.size() > 0) {
                //System.out.println("Processing Queue");

                // Ensure that we don't lose any items
                //pause = true;
                List<String> current = new ArrayList<String>(incoming);
                incoming.clear();
                //pause = false;

                for(String i : current){
                    if(((ThreadPoolExecutor)service).getQueue().size() < 1000) service.submit(new Crack(i));
                    else incoming.add(i);
                }
            }
        }

    }

    public static void add(String pw){
        //System.out.println("Queue Received Password " + pw);
        incoming.add(pw);
    }

}
