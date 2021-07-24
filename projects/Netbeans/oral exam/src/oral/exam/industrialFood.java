package oral.exam;

import java.text.SimpleDateFormat;

public class industrialFood extends eatable {

    private Date expireDate;
    private String type;

    public industrialFood(String type, int year, int month, int day) {
        super();
        expireDate = new Date(year, month, day);
        this.type = type;
    }

    public industrialFood(String name, String taste, int protein, int vitamin, int carbohyderates, int cost, String type, int year, int month, int day) {

        super(name, taste, protein, vitamin, carbohyderates, cost);
        expireDate = new Date(year, month, day);
        this.type = type;
    }

    @Override
    public String getFoodData() {
        return super.getFoodData() + "\nfood type: "+ type + "\nexpire date: "+ expireDate.getDate(); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean validFood(industrialFood food)
    {
        
        return false;
    }
    

}
