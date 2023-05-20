
package oral.exam;
public class vegetableFruit extends eatable{
private String season ;

    public vegetableFruit() {
    super();
    }

    public vegetableFruit(String season) {
    super();
        this.season = season;
    }
    
    public vegetableFruit(String name, String taste, int protein, int vitamin, int carbohyderates, int cost,String season) {
     super(name , taste , protein , vitamin , carbohyderates , cost);
        this.season = season;
    }

    @Override
    public String getFoodData() {
        return super.getFoodData() + "\nvegetables season: "+ season; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
