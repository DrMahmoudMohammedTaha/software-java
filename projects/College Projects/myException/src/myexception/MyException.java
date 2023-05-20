
package myexception;


public class MyException {

    
    public static void main(String[] args) {
    
        try (game x = new game();game xy = new game()){
               x.p =190;
          
           throw new Exception(x.p+"fdfdf");
     
        } catch (Exception e) {
            System.out.println(numberInputException.numberInputException(e.getMessage()));
        
        
        }
    
    }
    
}
