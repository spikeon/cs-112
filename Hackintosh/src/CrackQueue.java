import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CrackQueue implements Runnable{

    volatile static boolean shutdown = false;
    private static boolean pause = false;

    public static ExecutorService service;
    private static ArrayList<String> incoming = new ArrayList<String>();

    public CrackQueue() {
        service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        //System.out.println("Queue Running");
    }

    public void run(){
        service.submit(new Crack());
        while(!shutdown){

            try {
                Thread.sleep(100);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Core.seconds+= 1;
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
            if(Core.seconds % 10 == 0)
                System.out.println("Checked " + numberFormat.format(Core.attempts) + " ( " + numberFormat.format(Core.instances) + " ) " + " passwords in " + Core.seconds/10 + " seconds [ Q : " + numberFormat.format(((ThreadPoolExecutor) service).getQueue().size()) + " ] [ B : " + numberFormat.format(incoming.size()) + "]");

            if(((ThreadPoolExecutor)service).getQueue().size() < 10000 && incoming.size() > 0) {
                //System.out.println("Processing Queue");

                // Ensure that we don't lose any items
                //pause = true;
                //List<String> current = new ArrayList<String>(incoming);
                //incoming.clear();
                //pause = false;
                looop :
                {
                    for (int i = 0; i <= 10000; i++) {
                        if (incoming.size() > i && ((ThreadPoolExecutor) service).getQueue().size() < 10000) {
                            service.submit(new Crack(incoming.get(i)));
                        } else {
                            pause = true;
                            List<String> Sublist = incoming.subList(0, i-1);
                            Sublist.clear();
                            pause = false;
                            break looop;
                        }
                    }
                }
            }
        }

    }

    public static void add(String pw){
        //System.out.println("Queue Received Password " + pw);
        while(pause){
            try {
                Thread.sleep(1);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        incoming.add(pw);
    }

}
