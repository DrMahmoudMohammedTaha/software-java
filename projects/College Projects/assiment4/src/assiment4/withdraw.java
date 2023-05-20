



package assiment4;



public class withdraw implements Runnable{

    customer c ;
    int value;

    public withdraw(customer c, int value) {
        this.c = c;
        this.value = value;
    }

    
    public  synchronized void  withdrawal ()
    {
        for (int i = 0; i < value; i++) {
            c.setBalance(c.getBalance()-1);
        }
        
    
    }
    @Override
    public void run() {
   
        withdrawal();
    }
    
    
    
    
    
}
