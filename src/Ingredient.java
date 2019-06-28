public class Ingredient {
    String ingredientName; // назва інградієнта
    double ingredientPrice; //ціна інградієнта

    Ingredient(String ingredientName, double ingredientPrice) // конструктор
    {
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public double getIngredientPrice() {
        return ingredientPrice;
    }

    @Override
    public String toString() {
        return ""+ingredientName + '\t' + ingredientPrice +"$";
    }
}
