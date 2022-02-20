public class Main {

    public static void main(String [] arguments) throws InterruptedException {

        Thread hilo= new Thread(new Hilo());
        Thread hilo2= new Thread(new Hilo());

        hilo.setName("hilo numero2");
        System.out.println(hilo.getName());
        System.out.println(hilo.getPriority());
        System.out.println(hilo.isAlive());
        hilo.join();

        hilo.start();
        hilo2.start();
        System.out.println(hilo.isAlive());
    }

}

