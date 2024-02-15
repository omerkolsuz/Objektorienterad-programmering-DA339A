package model;

/**
 * Här product klassen vi skapar olika produkter
 * som går att beställa genom att använda
 * interface RestaurantItem.
 * Denna klass innehåller variabler som vi använder
 * för Pizzas och dryckens namn och pris
 * @author Ömer & Ibrahim
 *
 */
public class Product implements RestaurantItems{
    String name;
    double price;

    /**
     * här vi skapar en konstruktur som har 2
     * parameter som heter name och price of products
     * @param name
     * @param price
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * getter och setter methods
     * @return
     */
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    /**
     * här vi har en metod som gör att returnerar
     * en sträng för namn och priset av produkten
     * @return
     */
    public String toString(){
        return String.format("%s %s", name + ", ", price + "kr");
}
}
