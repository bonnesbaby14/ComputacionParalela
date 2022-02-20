public class Hilo extends Thread{

    public String name;
    public void run(){
        this.name=this.getName();

        for(int a=0;a<4;a++) {
            try {
                System.out.println(name+" corriendo...");
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println(e.toString());

            }
        }
    }


    }




