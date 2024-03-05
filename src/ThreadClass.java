public class ThreadClass {

    private static boolean fileProcessed = false;
    private static Object createObj = new Object();
    public static class Process1Thread extends Thread{

        public void run(){
            while(!fileProcessed){
                synchronized (createObj) {
                    try {
                        {
                            createObj.wait();
                        }
                        System.out.println("File Processed, now upload file...");
                    } catch (InterruptedException e) {

                    }
                }
            }
        }

    }

    public static class Process2Thread extends Thread{
        @Override
        public void run() {
            System.out.println("Start Processing File...");

            fileProcessed = true;
            synchronized (createObj){
                createObj.notifyAll();
            }

        }
    }

    public static void main(String[] args) {
        new Process1Thread().start();
        new Process2Thread().start();
    }
}
