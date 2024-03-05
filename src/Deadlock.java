public class Deadlock{


    public static void main(String[] args) throws InterruptedException {
          final String resource1 = "first resource";
        final  String resource2 = "second resource";


        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread1: Locked resource1");

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (resource2) {
                        System.out.println("Thread1: Locked resource2");
                    }
                    ;
                };
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                synchronized (resource2){
                    System.out.println("Thread2: Locked resource2");

                try{
                    Thread.sleep(100);
                }catch(Exception e){
                    e.printStackTrace();
                }
                synchronized (resource1){
                    System.out.println("Thread2: Locked resource1");
                };
                };
            }
        };
        t1.start();
        t1.join();
        t2.start();


    }


}
