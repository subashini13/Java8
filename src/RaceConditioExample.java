public class RaceConditioExample implements Runnable{

    int c=0;

    public void increment(){
        try{
            Thread.sleep(100);
        }catch(Exception e){
            e.printStackTrace();
        }
        c++;

    }

    public void decrement(){
        c--;
    }
    @Override
    public void run() {
        synchronized (this) {
            this.increment();
            System.out.println("value of c after increment" + Thread.currentThread().getName() + c);
            this.decrement();
            System.out.println("value of c after decrement" + Thread.currentThread().getName() + c);
        }
    }

    public static void main(String[] args) {
      RaceConditioExample rc = new RaceConditioExample();
      Thread t1 = new Thread(rc,"Thread1");
      Thread t2 = new Thread(rc,"Thread2");
      Thread t3 = new Thread(rc,"Thread3");
      t1.start();
      t2.start();
      t3.start();
    }
}
