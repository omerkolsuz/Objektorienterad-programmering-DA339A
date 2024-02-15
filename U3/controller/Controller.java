package controller;

//only imports what is strictly necessary from view-package
/**
 * Här importerar jag bara den som är nödvändig från model och view-package
 * och några från java biblioteket!
 */
import model.*;
import view.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Syftet med Controller klassen är att skapa olika beställningar via input,
 * men också att visa de produkter som kan väljas till menyn.
 * Controller tillhandahåller också kopplingen mellan entity och boundaryklasser.
 * Entity klasser är Allorder, Orders,Pizza, Drinks, Alcoholic Bevarages
 * Product och Toppings
 * Boundary klasser är den som finns i view packagen.
 * @author Ömer & Ibrahim
 */

public class Controller {
    private MainFrame view;
    private Orders newOrder;
    private ButtonType currentLeftMenu = ButtonType.NoChoice;

    private ArrayList<Pizza> pizzas;
    private ArrayList<Drinks> drinks1;
    Pizza pizza;
    Drinks drinks;
    AllOrder allOrder;

    /**
     * Här vi skapar först ett objekt som heter allOrder vilket gör
     * att vi får informationen från Allorder klassen!
     * Sen finns det några metoder som gör att aktiverar alla knappar i Gui
     * och avaktiverar Add och View knappar.
     * Sen har vi 2 objekter som innehåller all information för meny från
     * pizza och drinks klasser.
     */
    public Controller() {
        allOrder = new AllOrder();
        newOrder = new Orders(0);
        view = new MainFrame(1000, 500, this);
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
        orderPizza();
        orderDrinks();
    }

    /**
     * Här skapar vi pizzor som användaren kan beställa genom Gui
     * vi använder en klass här som heter Pizza
     */
    public void orderPizza() {
        pizzas = new ArrayList<>();
        pizza = new Pizza("Ömers Special Pizza", 115, new ToppingsPizza[]{ToppingsPizza.Tomato_sauce,ToppingsPizza.Pizza_cheese,ToppingsPizza.Gyros,ToppingsPizza.Olives,ToppingsPizza.Mushrooms});
        pizzas.add(pizza);
        pizza = new Pizza("Ibrahims Special Pizza", 115, new ToppingsPizza[]{ToppingsPizza.Tomato_sauce,ToppingsPizza.Pizza_cheese, ToppingsPizza.Kebab});
        pizzas.add(pizza);
        pizza = new Pizza("Margerita", 85, new ToppingsPizza[]{ToppingsPizza.Tomato_sauce,ToppingsPizza.Pizza_cheese});
        pizzas.add(pizza);
        pizza = new Pizza("Vesuvio", 93, new ToppingsPizza[]{ToppingsPizza.Tomato_sauce, ToppingsPizza.Pizza_cheese, ToppingsPizza.Ham});
        pizzas.add(pizza);
        pizza = new Pizza("Hawai", 93, new ToppingsPizza[]{ToppingsPizza.Tomato_sauce, ToppingsPizza.Pizza_cheese,ToppingsPizza.Ham, ToppingsPizza.Pineapple});
        pizzas.add(pizza);
        pizza = new Pizza("Romeo & Julia", 93, new ToppingsPizza[]{ToppingsPizza.Tomato_sauce, ToppingsPizza.Pizza_cheese, ToppingsPizza.Ham, ToppingsPizza.Pepperoni, ToppingsPizza.Mushrooms});
        pizzas.add(pizza);
        pizza = new Pizza("Pepperoni", 93, new ToppingsPizza[]{ToppingsPizza.Tomato_sauce, ToppingsPizza.Pizza_cheese, ToppingsPizza.Pepperoni, ToppingsPizza.Onion});
        pizzas.add(pizza);
        pizza = new Pizza("Capricciosa", 93, new ToppingsPizza[]{ToppingsPizza.Tomato_sauce, ToppingsPizza.Pizza_cheese, ToppingsPizza.Ham, ToppingsPizza.Mushrooms});
        pizzas.add(pizza);
        pizza = new Pizza("Pesto", 99, new ToppingsPizza[]{ToppingsPizza.Tomato_sauce, ToppingsPizza.Pizza_cheese, ToppingsPizza.Pesto, ToppingsPizza.Mushrooms,ToppingsPizza.Asparagus,ToppingsPizza.Sun_dried_tomatoes});
        pizzas.add(pizza);
        pizza = new Pizza("Vegetariana", 99, new ToppingsPizza[]{ToppingsPizza.Tomato_sauce, ToppingsPizza.Pizza_cheese, ToppingsPizza.Mushrooms,ToppingsPizza.Onion,ToppingsPizza.Olives, ToppingsPizza.Artichoke});
        pizzas.add(pizza);
    }

    /**
     * Här skapar vi drickor som användaren kan beställa genom Gui
     * Vi använder två klass som är drinks och alcoholicbeverages
     */
    public void orderDrinks() {
        drinks1 = new ArrayList<>();
        drinks1.add(new Drinks("Water", 10));
        drinks1.add(new Drinks("Orange/Apple Juice", 25));
        drinks1.add(new Drinks("Milk", 25));
        drinks1.add(new Drinks("Coffee/Tea", 25));
        drinks1.add(new Drinks("Espresso/Cappucino/Caffe Latte", 35));
        drinks1.add(new AlcoholicBeverages("Staropramen 50cl (Czech beer)",69,5.2));
        drinks1.add(new AlcoholicBeverages("Eriksberg 50cl (Swedish beer)",65,5.2));
        drinks1.add(new AlcoholicBeverages("Falcon 50cl (Swedish beer)",65,5));
        drinks1.add(new AlcoholicBeverages("Apple Cider 33cl",55,5));
        drinks1.add(new AlcoholicBeverages("A glass of House Wine",69,20));

        }

    /**
     * Här skapar vi en metod som skapar string av andra tillgängliga pizzor
     * och returnerar genom return string;
     * @return
     */
    private String[] getPizzasStrings(){
        String[] strings = new String[pizzas.size()];
        for (int j = 0; j< strings.length; j++){
            strings[j] = pizzas.get(j).toString();
        }
        return strings;
    }

    /**Här skapar vi en metod som skapar string av andra tillgängliga drickor
     * och returnerar genom return string;
     * @return
     * @return
     */
    private String[] getDrinksString(){
        String[] strings = new String[drinks1.size()];
        for (int i = 0; i < strings.length; i++){
            strings[i] = drinks1.get(i).toString();
        }
        return strings;
    }
    /** Här skapar vi en metod som skapar string av All order History
     * och returnerar genom return string;
     * @return
     */
    private String[] allOrderstring(){
        Orders[] orders = allOrder.getorders();
        System.out.println(orders.length);
        String[] strings = new String[orders.length];
        for (int i = 0; i < orders.length; i++){
            System.out.println("heloo");
            System.out.println(orders[i].toString());
            strings[i] = orders[i].toString();
        }
        return strings;
    }

    /**
     * här har vi en switch metod för att ha kategori på Gui
     * @param button
     */
    public void buttonPressed(ButtonType button){

        switch (button) {
            case Add:
                addItemToOrder(view.getSelectionLeftPanel());
                break;

            case Food:
                setToFoodMenu();
                break;

            case Drinks:
                setToDrinkMenu();
                break;

            case Delete:
                deleteOrders();
                break;

            case OrderHistory:
                setToOrderHistoryMenu();
                break;

            case Order:
                placeOrder(view.getSelectionLeftPanel());
                break;

            case ViewOrder:
                viewSelectedOrder();
                break;
        }
    }

    /**
     * Här vi skapar en metod som användaren kan lägga till pizzor och drickor
     * genom Gui.
     * Sen vi har en kontroll med if sats när användaren vill köpa
     * alkoholdrickor så att vi kan kontrollera om användaren är under
     * 18 eller inte. Om man är under då får man ett fel meddelande genom
     * showInputDialog.
     * @param selectionIndex
     */

    public void addItemToOrder(int selectionIndex) {
        if (selectionIndex != -1){ // if something is selected in the left menu list
            switch (currentLeftMenu) { //This might need to change depending on architecture
                case Food:
                    newOrder.addProduct(pizzas.get(selectionIndex));
                    break;
                case Drinks:
                   if(drinks1.get(selectionIndex) instanceof AlcoholicBeverages){
                       String message = JOptionPane.showInputDialog("Please add your age!");
                       if (Integer.parseInt(message) >= 18){
                           newOrder.addProduct(drinks1.get(selectionIndex));
                       }
                       else if(Integer.parseInt(message) < 18){
                           JOptionPane.showMessageDialog(null,"You should be 18 or older to buy a alhocolic bevarages!" );
                       }

                   }
                   else {
                       newOrder.addProduct(drinks1.get(selectionIndex));
                       break;
                   }
            }
            view.populateRightPanel(newOrder.getInfoAboutOrder()); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
            view.setTextCostLabelRightPanel("Total cost of order: " + newOrder.getPrice()); //set the text to show cost of current order
        }

    }

    /**
     * här vi skapar en metod som gör att vi kan se användarens bestälning
     * history på högre sidan av panelen
     */
    public void viewSelectedOrder(){
        int selectionIndex = view.getSelectionLeftPanel();
        view.setTextCostLabelRightPanel("Total cost of order: No order chosen");
        if ((selectionIndex != -1) && currentLeftMenu == ButtonType.OrderHistory) {
            Orders orders = allOrder.getorders()[selectionIndex];
            view.populateRightPanel(orders.getInfoAboutOrder());

            view.setTextCostLabelRightPanel("Total cost of order: " + orders.getPrice()); //set the text to show cost of current order
        }
    }

    /**
     * Här skapar vi en metod som gör att användaren kan se pizzors listan
     * när användaren trycker på "Food" knappen genom GUI.
     */
    public void setToFoodMenu() {
        currentLeftMenu = ButtonType.Food;
        view.populateLeftPanel(getPizzasStrings());
        view.populateRightPanel(newOrder.getInfoAboutOrder()); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + newOrder.getPrice()); //set the text to show cost of current order
        view.enableAllButtons();
        view.disableFoodMenuButton();
        view.disableViewSelectedOrderButton();
    }

    /**
     * Här skapar vi en metod som gör att användaren kan se drickors listan
     * när användaren trycker på "Drinks" knappen genom Gui.
     */

    public void setToDrinkMenu() {
        currentLeftMenu = ButtonType.Drinks;
        view.populateLeftPanel(getDrinksString());
        view.populateRightPanel(newOrder.getInfoAboutOrder()); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + newOrder.getPrice()); //set the text to show cost of current order
        view.enableAllButtons();
        view.disableDrinksMenuButton();
        view.disableViewSelectedOrderButton();
    }

    /**
     * Här skapar vi en metod som gör att användaren kan se en list av
     * beställningar som användaren gjorde.
     */
    public void setToOrderHistoryMenu() {
        currentLeftMenu = ButtonType.OrderHistory;
        view.clearRightPanel();
        System.out.println(Arrays.toString(allOrderstring()));
        view.populateLeftPanel(allOrderstring());
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableOrderButton();
    }

    /**
     * Här skapar vi en metod som gör att rensar högre paneln
     * när användaren vill skapa ny beställning.
     */

    public void deleteOrders() {
        newOrder = new Orders(0);
        view.clearRightPanel();
        view.enableAllButtons();
    }

    /**
     * Här vi skapar en metod som gör att användaren kan skapa en
     * ny bestälning. Metoden gör att beställning läggs till en array i
     * Allorder klassen för att spara beställning historiken.
     * Metoden uppdaterar också priset.
     * Här kontrollerar vi med metod isOk om beställningen innehåller
     * mins en pizza eller inte. Om bestälningen innehåller inte en pizza
     * då får man fel meddelande genom showMessageDialog.
     * @author Ömer
     * @param selectionLeftPanel
     */

    public void placeOrder(int selectionLeftPanel) {
        if (newOrder.isOk()){
            view.populateRightPanel(newOrder.getInfoAboutOrder());
            view.setTextCostLabelRightPanel("TOTAL COST: " + newOrder.getPrice());
          //  System.out.println(newOrder.toString());
            allOrder.addingOrder(newOrder);
            System.out.println(allOrder);
            deleteOrders();
            view.enableAllButtons();
            view.disableAddMenuButton();
            view.disableViewSelectedOrderButton();
        }
        else {
            JOptionPane.showMessageDialog(null, "You have to buy minimum one pizza!");
        }
        }
    }

