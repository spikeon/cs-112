public class UnitTest {

  private static int pass   = 0;
  private static int fail   = 0;
  private static int total  = 0;

  private static volatile boolean silent = true;

  protected static void silence() {
    silent = true;
  }

  protected static void verbose() {
    silent = false;
  }

  protected static void pass(String msg) {
    total++;
    pass++;
    if( ! silent) System.out.println("Passed: " + msg);
  }

  protected static void fail(String msg) {
    total++;
    fail++;
    if( ! silent) System.out.println("Failed: " + msg);
  }

  protected static void test(boolean condition, String msg){
    if(condition) pass(msg);
    else fail(msg);
  }

  protected static void summary(){
    System.out.println("Completed: " + total + " [" + pass + ":" + fail + "]");
  }

}
