package designPatterns.decoratorDesignPattern;
interface Pizza{
    String getDescription();
    double getCost();
}

class BasicPizze implements  Pizza{
    @Override
    public String getDescription(){
        return "Basic Pizza";
    }
    @Override
    public double getCost(){
        return 5.0;
    }
}

abstract class PizzaDecorator implements Pizza{
    protected Pizza decoratedPizza;
    public PizzaDecorator(Pizza decoratedPizza){
        this.decoratedPizza = decoratedPizza;
    }
    @Override
    public String getDescription(){
        return decoratedPizza.getDescription();
    }

    @Override
    public double getCost(){
        return decoratedPizza.getCost();
    }
}

class CheeseDecorator extends PizzaDecorator{
    public CheeseDecorator(Pizza decoratedPizza){
        super(decoratedPizza);
    }

    @Override
    public String getDescription(){
        return decoratedPizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost(){
        return decoratedPizza.getCost() + 1.5;
    }
}

class VeggiesDecorator extends PizzaDecorator{
    public VeggiesDecorator(Pizza decoratedPizza){
        super(decoratedPizza);
    }

    @Override
    public String getDescription(){
        return decoratedPizza.getDescription() + ", Veggies";
    }

    @Override
    public double getCost(){
        return decoratedPizza.getCost() + 2.0;
    }
}


public class Main {
    public static void main(String[] args) {
        Pizza pizza = new BasicPizze();
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: $" + pizza.getCost());

        //Pizza with Cheese
        Pizza cheesePizza = new CheeseDecorator(new BasicPizze());
        System.out.println("\nDescription: " + cheesePizza.getDescription());
        System.out.println("Cost: $" + cheesePizza.getCost());
    }
}
