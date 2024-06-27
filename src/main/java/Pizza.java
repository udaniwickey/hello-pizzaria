import java.util.List;

public class Pizza {
    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public List<PizzaItems> getPizzaItems() {
        return pizzaItems;
    }

    public void setPizzaItems(List<PizzaItems> pizzaItems) {
        this.pizzaItems = pizzaItems;
    }

    public String toString(){
        return getPizzaName() + "," + getPizzaItems();
    }

    String pizzaName;
    List<PizzaItems> pizzaItems;
}
