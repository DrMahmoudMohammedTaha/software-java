

package audacity;



public class Superhero extends Human{
    String alterEgo;
    public Superhero(String givenName, int age,String ego) {
        super(givenName, age);
        alterEgo = ego;
    }
    
    public String getAlterEgo() {
        return alterEgo;
    }
    
    @Override
     public String introduce() {
        return super.introduce()+"my ego is "+ alterEgo;
    }
   
}