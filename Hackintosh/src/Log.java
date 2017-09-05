public class Log {
    public Log(){
        while(true) {

            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Core.seconds++;
            System.out.println("Checked " + Core.attempts + " ( " + Core.instances + " ) " + " passwords in " + Core.seconds + " seconds");

        }
    }
}
