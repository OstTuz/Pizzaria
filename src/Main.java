import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    final static Ingredient[] generalIngradients = {
            new Ingredient("Tomato paste", 1),
            new Ingredient("Cheese", 1),
            new Ingredient("Salami", 1.5),
            new Ingredient("Bacon", 1.2),
            new Ingredient("Garlic", 0.3),
            new Ingredient("Corn", 0.7),
            new Ingredient("Pepperoni", 0.6),
            new Ingredient("Olives", 0.5)};

    public static void main(String[] args)
    {
        ArrayList<Pizza> pizzas = new ArrayList<>();

        Pizza pizza = new Pizza("Margarita", Pizza.Type.Calzone, 5);
        Pizza pizza2 = new Pizza("Carlo", Pizza.Type.Simple, 4);
        pizzas.add(pizza);
        pizzas.add(pizza2);

        ArrayList<Ingredient> ingredients3 = new ArrayList<Ingredient>(Arrays.asList(generalIngradients[3],generalIngradients[6]));

        Pizza pizza3 = new Pizza("Ingredientino", Pizza.Type.Simple, 4, ingredients3);
        pizza3.addIngredient(generalIngradients[2]);
        pizza3.deleteIngradient(generalIngradients[3]);
        pizzas.add(pizza3);


        Order order = new Order(pizzas);
        order.DeletePizza("Margarita");
        order.DisplayOrder();
    }
}
