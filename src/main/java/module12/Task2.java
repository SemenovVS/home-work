package module12;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Task2 {

    public static void main(String[] args) throws InterruptedException {

        Starter starter = new Starter();
        starter.starter(30);
    }
}
class Numbers implements Runnable{
    private BlockingQueue<String> list;
    AtomicBoolean isHas;
        private int  i;
    public Numbers(BlockingQueue<String> list, AtomicBoolean isHas, int i) {
        this.list = list;
        this.isHas = isHas;
        this.i = i;
    }
    @Override
    public void run() {
        list.add(String.valueOf(i));
        isHas.set(false);
    }
}
class FizzBuzz implements Runnable{
    private BlockingQueue<String> list;
    AtomicBoolean isHas;
    public FizzBuzz(BlockingQueue<String> list, AtomicBoolean isHas) {
        this.list = list;
        this.isHas = isHas;
    }
    @Override
    public void run() {
        list.add("FizzBuzz");
        isHas.set(false);
    }
}
class Fizz implements Runnable{
    private BlockingQueue<String> list;
    AtomicBoolean isHas;
    public Fizz(BlockingQueue<String> list, AtomicBoolean isHas ) {
        this.list = list;
        this.isHas = isHas;
    }
    @Override
    public void run() {
        list.add("Fizz");
        isHas.set(false);
    }
}
class Buzz implements Runnable{
    private BlockingQueue<String> list;
    AtomicBoolean isHas;
    public Buzz(BlockingQueue<String> list, AtomicBoolean isHas) {
        this.list = list;
        this.isHas = isHas;
    }
    @Override
    public void run() {
        list.add("Buzz");
        isHas.set(false);
    }
}
class Starter{
    ExecutorService executor =  Executors.newFixedThreadPool(5);
     BlockingQueue<String> list = new LinkedBlockingQueue<>();
    AtomicBoolean isHas = new AtomicBoolean(false);
    public void starter(int n) {
       executor.execute(new Printer(n, list));
        int i = 1;
        while (i <= n){
                if (!isHas.get()) {
                    isHas.set(true);
                    if (i % 3 != 0 && i % 5 != 0) {
                        executor.execute(new Numbers(list, isHas, i));
                        i++;
                        continue;
                    }
                    if (i % 3 == 0 && i % 5 == 0) {
                        executor.execute(new FizzBuzz(list, isHas));
                        i++;
                        continue;
                    }
                    if (i % 3 == 0) {
                        executor.execute(new Fizz(list, isHas));
                        i++;
                        continue;
                    }
                    if (i % 5 == 0) {
                        executor.execute(new Buzz(list, isHas));
                        i++;
                        continue;
                    }
                }
        }

    }
}
class Printer implements Runnable {
   private int n;
    private BlockingQueue<String> list;
    public Printer(int n, BlockingQueue<String> list) {
            this.n = n;
            this.list = list;
    }
    @Override
    public void run() {

        while (n != 0) {
            if (!list.isEmpty()) {
                System.out.println(list.poll());
                n--;
            }
        }
    }
}