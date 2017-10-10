import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class CrackQueue implements Runnable{

    private int queuesize = 1000000;

    public static ExecutorService service;
    public static Queue<Potential> incoming = new PriorityBlockingQueue<Potential>();

    public CrackQueue() {
        service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() - 1);
    }

    public void run(){
        // Check all passwords
        service.submit(new Crack());

        // Check only certain passwords
        // String[] passwords = {"cP3", "test", "123"};
        // service.submit(new Crack(passwords, false));

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);

        while(!Thread.currentThread().isInterrupted()) {
            while(!incoming.isEmpty() && !Thread.currentThread().isInterrupted()) {
                Potential current = incoming.poll();

                service.submit(new Crack(current.toString()));

                Core.seconds = ((int) (System.currentTimeMillis() / 1000L) - Core.startTime);

                Core.currentTextField.setText(current.toString());
                Core.testedTextField.setText(numberFormat.format(Core.attempts));
                Core.totalTextField.setText(numberFormat.format(Core.instances));
                Core.secondsTextField.setText("" + Core.seconds);
                Core.queueTextField.setText(numberFormat.format(((ThreadPoolExecutor) service).getQueue().size()));
                Core.bufferTextField.setText(numberFormat.format(incoming.size()));
                while(((ThreadPoolExecutor)service).getQueue().size() >= queuesize){ }
            }
        }
    }

    public static void add(String pw){
        //System.out.println("Queue Received Password " + pw);
        incoming.add(new Potential(pw));
    }

}
