import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class CrackQueue implements Runnable {

  public static ExecutorService service;
  public static Queue<Potential> incoming = new PriorityBlockingQueue<Potential>();
  private int queuesize = 1000000;
  private static int ctr = 0;

  public CrackQueue() {
    service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() - 1);
  }

  public static void add(String pw) {
    //System.out.println("Queue Received Password " + pw);
    incoming.add(new Potential(pw));
  }

  public void run() {
    while(!Core.run){}

    // Check all passwords
    service.submit(new Crack());

    // Check only certain passwords
    // String[] passwords = {"cP3", "test", "123"};
    // service.submit(new Crack(passwords, false));

    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    while (!Thread.currentThread().isInterrupted()) {
      while (!incoming.isEmpty() && !Thread.currentThread().isInterrupted()) {

        while(!Core.run){}

        ctr++;

        Potential current = incoming.poll();

        service.submit(new Crack(current.toString()));

        if(Core.gui) {

          Core.seconds = ((int) (System.currentTimeMillis() / 1000L) - Core.startTime);
          if (ctr > 100000) {
            ctr = 0;
            Core.currentTextField.setText(current.toString());
            Core.testedTextField.setText(numberFormat.format(Core.attempts));
            Core.totalTextField.setText(numberFormat.format(Core.instances));
            Core.secondsTextField.setText("" + Core.getSeconds());
            Core.queueTextField.setText(numberFormat.format(((ThreadPoolExecutor) service).getQueue().size()));
            Core.bufferTextField.setText(numberFormat.format(incoming.size()));
          }
        }
        else {
          if (ctr > 10000000) {
            ctr = 0;
            // Status Output
            System.out.println("[length:"+ Core.length +"] [tested:" + numberFormat.format(Core.attempts) + "] [total:" + numberFormat.format(Core.instances) + "] [last:"+current.toString()+"]");
          }

        }

        while (((ThreadPoolExecutor) service).getQueue().size() >= queuesize) {}
      }
    }
  }
}