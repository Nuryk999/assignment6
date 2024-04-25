package decorator_pattern;

interface Pizza {
    double getPrice();
}
class BasicPizza implements Pizza {
    private static final double BASE_PRICE = 5.00;

    @Override
    public double getPrice() {
        return BASE_PRICE;
    }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice();
    }
}

class PepperoniTopping extends PizzaDecorator {
    private static final double PRICE = 1.50;

    public PepperoniTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRICE;
    }
}

class MushroomTopping extends PizzaDecorator {
    private static final double PRICE = 1.00;

    public MushroomTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRICE;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a basic pizza
        Pizza basicPizza = new BasicPizza();

        // Decorate the basic pizza with toppings
        Pizza pepperoniPizza = new PepperoniTopping(basicPizza);
        Pizza deluxePizza = new MushroomTopping(pepperoniPizza);

        // Print the final price of the deluxe pizza
        System.out.println("Price of the deluxe pizza: $" + deluxePizza.getPrice());
    }
}


/*
Component Interface (Pizza):
The Pizza interface defines a method getPrice() that represents the common behavior of all pizza components.
It serves as the base for both the concrete component and decorators.

Concrete Component Class (BasicPizza):
BasicPizza is a concrete implementation of the Pizza interface.
It represents the base pizza without any additional toppings.
It provides a getPrice() method that returns the base price of the pizza.

Base Decorator Class (PizzaDecorator):
PizzaDecorator is an abstract class that implements the Pizza interface.
It holds a reference to a wrapped Pizza object, allowing decorators to be stacked.
The getPrice() method delegates the call to the wrapped Pizza object.

Concrete Decorator Classes (PepperoniTopping and MushroomTopping):
PepperoniTopping and MushroomTopping are concrete decorator classes.
They extend the PizzaDecorator class and add functionality (toppings) to the pizza.
They override the getPrice() method to add the cost of the topping to the price of the wrapped pizza.

Testing the Program:
In the main method, a basic pizza object (BasicPizza) is created.
The basic pizza is then decorated with toppings (PepperoniTopping and MushroomTopping) to create a deluxe pizza.
Finally, the price of the deluxe pizza is printed to verify the correct functioning of the Decorator pattern.
 */