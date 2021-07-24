




package assiment4;




public class Assiment4 {


    
    
    public static void main(String[] args) throws InterruptedException {
    
      customer client  = new customer(100000000);
        withdraw w = new withdraw(client, 4000);
        Thread th1 = new Thread(w);
        Thread th2 = new Thread(w);
       
        th1.start();
        th2.start();

   th1.join();
    th2.join();

        System.out.println(client.getBalance());
        
        
        //comment on the code 
        //1 - we notice that the value of the balance is not chanaged directly until we use join
        //2 - we notice that the value of the balance is decreaced twice be cause we started two
        //with the same runnable class object
        
        
        
    }
    
}
