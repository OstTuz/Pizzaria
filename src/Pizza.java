import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Pizza implements IForIngredient{
    enum Type {Simple, Calzone}

    final int pizzaCode;    //5-значний код піцци
    String pizzaName;       //назва піци
    Type pizzaType;         //тип піци Simple або Calzone
    int pizzaAmount;        //кількість таких піц (до 10)
    ArrayList<Ingredient>ingredients; // масив інградієнтів
    double pizzaPrice;      //ціна піци

    Pizza() // пустий конструкторо
    {
        this.pizzaCode = (int)(10000+Math.random()*89999);
    }

    Pizza(String pizzaName, Type pizzaType, int pizzaAmount) // конструктор піци без інградієнтів
    {
        this.pizzaCode = (int)(10000+Math.random()*89999);
        if (pizzaName.length()>=4 && pizzaName.length()<20)
        {
            this.pizzaName = pizzaName;
        }else
        {
            this.pizzaName = "Pizza with code "+this.pizzaCode;
        }
        this.pizzaType = pizzaType;
        this.ingredients = new ArrayList<>();
        if (pizzaAmount < 10)
        {
            this.pizzaAmount = pizzaAmount;
        }else
        {
            this.pizzaAmount = 10;
            System.out.println("Максимально дозволене замовленя одникових піц: 10 !!!");
        }
    }

    Pizza(String pizzaName, Type pizzaType, int pizzaAmount, ArrayList<Ingredient> ingredients) // конструктор піци з інградієнтами
    {
        this.pizzaCode = (int)(10000+Math.random()*89999);
        if (pizzaName.length()>=4 && pizzaName.length()<20)
        {
            this.pizzaName = pizzaName;
        }else
        {
            this.pizzaName = "Pizza with code "+this.pizzaCode;
        }
        this.pizzaType = pizzaType;
        if (pizzaAmount < 10)
        {
            this.pizzaAmount = pizzaAmount;
        }else
        {
            this.pizzaAmount = 10;
            System.out.println("Максимально дозволене замовленя піц цього типу: 10");
        }
        this.ingredients = ingredients;
    }

    public void calculatePizzaPrice()       //розрахунок вартості піц
    {
        this.pizzaPrice = 0;
        if (getPizzaType() == Type.Calzone) this.pizzaPrice = 1.5;
        else this.pizzaPrice = 1;

        if (ingredients.isEmpty())
        {
            this.pizzaPrice *= getPizzaAmount();
            return;
        }else{
            for (Ingredient i: ingredients)
            {
                this.pizzaPrice += i.getIngredientPrice();
            }
            this.pizzaPrice *= getPizzaAmount();
        }
    }


    public void DisplayPizza() // вивід інформації про піцу
    {
        calculatePizzaPrice();
        System.out.println("Назва піци: "+getPizzaName()+"\nКількість піц: "+getPizzaAmount());
        for (Ingredient i: ingredients)
        {
            System.out.println(i.toString());
        }
        System.out.printf("Ціна: %.2f$\n",getPizzaPrice());
    }

    @Override
    public void addIngredient(Ingredient ingredient) { //додавання інгредієнта
        if (this.ingredients.size() < 8) // перевірка чи піца не заповнена
        {
            for (Ingredient i: this.ingredients) {
                if (!(i.equals(ingredient)))
                {
                    continue;
                }else
                {
                    System.out.println("Інгредієнт вже додано");
                    return;
                }
            }
            this.ingredients.add(ingredient);
        }else System.out.println("Піца заповнена");
    }

    @Override
    public void deleteIngradient(Ingredient ingredient)  //видалення інгредієнта
    {
        for (int i = 0; i < this.ingredients.size(); i++)
        {
            if (ingredients.get(i).equals(ingredient))
            {
                ingredients.remove(i);
            }
        }
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public Type getPizzaType()
    {
        return this.pizzaType;
    }

    public int getPizzaAmount() {
        return pizzaAmount;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }
}
