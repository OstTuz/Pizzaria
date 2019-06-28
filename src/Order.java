import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    final int orderCode;
    final int clientCode;
    ArrayList<Pizza> pizzas;
    double orderPrice;
    LocalDateTime time;

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
    Order(ArrayList<Pizza> pizzas)
    {
        this.orderCode = (int)(10000+Math.random()*89999);
        this.clientCode = (int)(10000+Math.random()*89999);
        this.pizzas = pizzas;
        this.time = time.now();
    }

    public void DisplayOrder()      //вивід замовлення
    {
        System.out.println("*******************************");
        System.out.println("Код замовлення: "+getOrderCode()+"\nКод клієнта: "+getClientCode()+"\nЧас замовлення: "+getTime().format(dateTimeFormatter).toString());
        System.out.println("-------------------------------");
        for (int i = 0; i<this.pizzas.size(); i++) {
            pizzas.get(i).DisplayPizza();
            System.out.println("-------------------------------");
        }
        calculateOrderPrice();
        System.out.println("Загальна вартість замовлення: ");
        System.out.printf("%.2f$\n",getOrderPrice());
        System.out.println("*******************************");
    }


    public void calculateOrderPrice() // розрахунок вартості замовлення
    {
        for (int i = 0; i < pizzas.size(); i++)
        {
            pizzas.get(i).calculatePizzaPrice();
            this.orderPrice += pizzas.get(i).getPizzaPrice();
        }
    }

    public void DeletePizza(String pizzaName)
    {
        for (int i = 0; i < pizzas.size(); i++)
        {
            if (pizzas.get(i).pizzaName.equals(pizzaName))
            {
                pizzas.remove(i);
            }
        }
    }

    public int getOrderCode() {
        return orderCode;
    }

    public int getClientCode() {
        return clientCode;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
