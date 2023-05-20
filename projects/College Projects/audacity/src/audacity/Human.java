/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package audacity;
/*
 * TASK: Implement the Comparable Interface using the age field
 * as the differentiator
 * 
*/
public class Human implements Comparable<Human> {
    private int age;
    private String name;
    
    public Human(String givenName, int age) {
        this.name = givenName;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String introduce() {
        return "Hey! I'm " + name + " and I'm " + age + " years old.";
    }
    
    
     @Override
    public int compareTo(Human h) {
        if (age == h.age)
            return 0;
        else if (age > h.age)
            return 1;
        else 
            return -1;
    
    }

    
    // Hint: Implement the method required by the Comparable Interface 
    // using age as the differentiator
}
