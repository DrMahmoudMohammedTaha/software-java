
package oral.exam;

public class eatable {
private String name , taste;
private int protein , vitamin , carbohyderates , cost ;

    public eatable() {
    }

    
    public eatable(String name, String taste, int protein, int vitamin, int carbohyderates, int cost) {
        this.name = name;
        this.taste = taste;
        this.protein = protein;
        this.vitamin = vitamin;
        this.carbohyderates = carbohyderates;
        this.cost = cost;
    }
   public String getFoodData() 
   {
   
   return "food name: "+ name + "\nfood taste: "+ taste + "\nprotein content: "+ protein + "\nvitamin content: "+vitamin+"\ncarbohydrates content: "+carbohyderates+ "food cost: "+cost ;
   
   
   }
    
}
