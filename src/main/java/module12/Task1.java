package module12;

public class Task1 {
    public static void main(String[] args) {

    MyFirstThread firstThread = new MyFirstThread();
    MySecondThread secondThread = new MySecondThread();

    firstThread.start();
    secondThread.start();

    }
}

class MyFirstThread extends Thread {
    @Override
    public void run() {
        int proshloSec = 0;

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " Is working " + proshloSec + " sec.");
            proshloSec++;
        }
    }
}
class MySecondThread extends Thread{
    @Override
    public void run() {

      while (true){
          try {
              Thread.sleep(5000);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
          System.out.println("5 seconds have passed");

      }
       
    }
}

